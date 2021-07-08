package org.pbreakers.mobile.androidtest.udacity.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.data.source.local.dao.UserDao
import com.example.cleanarchitecture.domain.model.GithubUser

@Database(entities = [GithubUser::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}