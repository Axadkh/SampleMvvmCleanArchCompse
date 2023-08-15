package com.example.sampleMvvmCleanCompose.data.local.db

import androidx.room.*
import com.example.sampleMvvmCleanCompose.data.local.db.model.UserEntity


@Dao
interface UserDao {

    @Query("SELECT * From users")
     suspend fun getUser(): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(model: UserEntity)

    @Query("DELETE FROM users")
    suspend fun deleteUser()

    @Update
    suspend fun updateUser(model: UserEntity)



}