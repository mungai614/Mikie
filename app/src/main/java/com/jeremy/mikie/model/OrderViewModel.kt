package com.jeremy.mikie.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {

    private val _selectedItems = MutableStateFlow<List<FoodItem>>(emptyList())
    val selectedItems: StateFlow<List<FoodItem>> = _selectedItems

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders

    // SharedFlow to notify about new orders (for admin notification)
    private val _newOrderEvent = MutableSharedFlow<Order>()
    val newOrderEvent = _newOrderEvent.asSharedFlow()

    fun addItem(foodItem: FoodItem) {
        _selectedItems.value = _selectedItems.value + foodItem
    }

    // Option 1: Use the foodOrdered parameter passed from UI (don't overwrite)
    fun saveOrder(name: String, contact: String, location: String, foodOrdered: String) {
        val newOrder = Order(
            name = name,
            contact = contact,
            location = location,
            foodOrdered = foodOrdered
        )
        _orders.value = _orders.value + newOrder

        // Clear selected items after saving order
        _selectedItems.value = emptyList()

        // Emit new order event to notify admin screen
        viewModelScope.launch {
            _newOrderEvent.emit(newOrder)
        }
    }

    // If you want to use selectedItems as the foodOrdered string,
    // you could add a different method like this:

    /*
    fun saveOrderFromSelectedItems(name: String, contact: String, location: String) {
        val foodOrdered = _selectedItems.value.joinToString(", ") { it.name }
        val newOrder = Order(
            name = name,
            contact = contact,
            location = location,
            foodOrdered = foodOrdered
        )
        _orders.value = _orders.value + newOrder
        _selectedItems.value = emptyList()
        viewModelScope.launch {
            _newOrderEvent.emit(newOrder)
        }
    }
    */

    fun clearOrders() {
        _orders.value = emptyList()
        _selectedItems.value = emptyList()
    }
}
