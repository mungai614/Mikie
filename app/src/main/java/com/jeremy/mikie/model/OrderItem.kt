package com.jeremy.mikie.model



import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order_items")  // <-- Add this annotation
data class OrderItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,  // primary key is required
    val name: String,
    val price: String
)


