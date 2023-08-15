package com.example.sampleMvvmCleanCompose.data.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sampleMvvmCleanCompose.domain.model.User

@Entity(tableName = "users")
data class UserEntity(@PrimaryKey val id:Int,val userName:String)

  fun UserEntity.toUser(){
     User(id = id,
      userName = userName)
  }