package com.jefisu.data.response

import kotlinx.serialization.Serializable

@Serializable
data class SimpleResponse<T>(
    val data: T?,
    val errorMsg: String? = null
)
