package com.jeremy.mikie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val customerName: String,
    val contactNumber: String,
    val deliveryLocation: String
)

