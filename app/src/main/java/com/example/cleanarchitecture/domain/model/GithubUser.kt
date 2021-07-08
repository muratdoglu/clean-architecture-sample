package com.example.cleanarchitecture.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class GithubUser(
    @PrimaryKey val id: Long,
    val login: String,
    val avatar_url: String
)