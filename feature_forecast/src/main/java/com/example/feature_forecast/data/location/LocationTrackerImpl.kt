package com.example.feature_forecast.data.location

import android.Manifest
import android.app.Application
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.weatherapp.R
import com.example.feature_forecast.data.exceptions.LocationException
import com.example.feature_forecast.domain.location.LocationTracker
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class LocationTrackerImpl @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val application: Application
) : LocationTracker {

    //todo improve error handling
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getCurrentLocation(): Location? {


        val locationManager = application.getSystemService(LOCATION_SERVICE) as LocationManager

        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (!isGpsEnabled) {
            return null
        }

        return suspendCancellableCoroutine { continuation ->
            if (ActivityCompat.checkSelfPermission(
                    application,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    application,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                locationClient.lastLocation.apply {
                    if (isComplete) {
                        if (isSuccessful) {
                            continuation.resume(
                                value = result
                            ) { throwable ->
                                throw LocationException(
                                    message = application.resources.getString(R.string.location_error) +
                                            " ${throwable.message}"
                                )
                            }
                        } else {
                            continuation.resume(value = null)
                        }
                    }
                    // если получили позицию
                    addOnSuccessListener { location ->
                        continuation.resume(value = location)
                    }
                    // если не получили позицию
                    addOnFailureListener {
                        continuation.resume(
                            value = null
                        ) { throwable ->
                            throw LocationException(
                                message = application.resources.getString(R.string.location_error) +
                                        " ${throwable.message}"
                            )
                        }
                    }
                    // если всё закрылось
                    addOnCanceledListener {
                        continuation.cancel(
                            cause = LocationException(application.resources.getString(R.string.location_error_unknown))
                        )
                    }
                }
            } else {
                return@suspendCancellableCoroutine
            }
        }

    }

    private fun getPermissionStatus(type: String) =
        ContextCompat.checkSelfPermission(
            application,
            type
        ) == PackageManager.PERMISSION_GRANTED

}