package com.jeremy.mikie.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OrderViewModel : ViewModel() {

    private val _selectedItems = MutableStateFlow<List<FoodItem>>(emptyList())
    val selectedItems: StateFlow<List<FoodItem>> = _selectedItems

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders

    fun addItem(foodItem: FoodItem) {
        _selectedItems.value = _selectedItems.value + foodItem
    }

    fun saveOrder(name: String, contact: String, location: String) {
        val newOrder = Order(name = name, contact = contact, location = location)
        _orders.value = _orders.value + newOrder
    }

    fun clearOrders() {
        _orders.value = emptyList()
        _selectedItems.value = emptyList()
    }
}
