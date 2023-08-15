package com.example.sampleMvvmCleanCompose.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sampleMvvmCleanCompose.common.utls.etension.LocalDb
import com.example.sampleMvvmCleanCompose.data.local.db.model.UserEntity

@Database(entities = [UserEntity::class], version = LocalDb.DB_VERSION)
abstract class AppDb: RoomDatabase() {

    abstract fun userDao(): UserDao
}
