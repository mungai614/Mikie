package com.jeremy.mikie.repository

import com.jeremy.mikie.data.OrderDao
import com.jeremy.mikie.model.Order
import kotlinx.coroutines.flow.Flow

class OrderRepository(private val orderDao: OrderDao) {
    suspend fun insertOrder(order: Order) {
        orderDao.insertOrder(order)
    }

    fun getAllOrders(): Flow<List<Order>> = orderDao.getAllOrders()
}
