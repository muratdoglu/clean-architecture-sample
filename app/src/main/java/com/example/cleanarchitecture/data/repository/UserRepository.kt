package com.example.cleanarchitecture.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.cleanarchitecture.data.source.remote.UserApi
import com.example.cleanarchitecture.data.source.local.dao.UserDao

class UserRepository(private val userApi: UserApi, private val userDao: UserDao) {

    val data = userDao.findAll()

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val users = userApi.getAllAsync().await()
            userDao.add(users)
        }
    }
}