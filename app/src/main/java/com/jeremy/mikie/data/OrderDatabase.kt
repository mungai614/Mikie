package com.jeremy.mikie.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jeremy.mikie.model.Order

@Database(entities = [Order::class], version = 1, exportSchema = false)
abstract class OrderDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
}
