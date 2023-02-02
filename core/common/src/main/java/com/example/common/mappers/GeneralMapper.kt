package com.example.common.mappers

interface GeneralMapper<InitialModel: Any, ResultingModel: Any > {
    fun toModel(model: InitialModel): ResultingModel
    fun fromModel(model: ResultingModel): InitialModel?
}