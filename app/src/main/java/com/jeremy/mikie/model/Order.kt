package com.jeremy.mikie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Primary key with auto-generation
    val name: String,
    val contact: String,
    val location: String
)
