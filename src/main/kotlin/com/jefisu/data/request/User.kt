package com.jefisu.data.request

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class User(
    val nickname: String,
    val name: String,
    val age: Int,
    val email: String,
    @BsonId val id: String = ObjectId().toString()
)