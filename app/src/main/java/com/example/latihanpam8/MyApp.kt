package com.example.latihanpam8

import android.app.Application
import androidx.room.Room

class MyApp : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this, AppDatabase::class.java, "my_database")
            .build()

        // Isi data dummy ke dalam database
        Thread {
            val userDao = database.userDao()
            userDao.insertUser(User(
                username = "mras11", email = "mras11@example.com"))
            userDao.insertUser(User(
                username = "mras25", email = "mras25@example.com"))
            userDao.insertUser(User(
                username = "mras21", email = "mras21@example.com"))
        }.start()
    }
}