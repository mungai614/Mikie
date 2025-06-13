package com.jeremy.mikie.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jeremy.mikie.model.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Insert
    suspend fun insertOrder(order: Order)

    @Query("SELECT * FROM orders")
    fun getAllOrders(): Flow<List<Order>>
}
