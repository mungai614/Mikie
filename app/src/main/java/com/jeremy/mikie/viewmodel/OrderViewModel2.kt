package com.jeremy.mikie.viewmodel

import androidx.lifecycle.ViewModel
import com.jeremy.mikie.model.FoodItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OrderViewModel2 : ViewModel() {
    private val _selectedItems = MutableStateFlow<List<FoodItem>>(emptyList())
    val selectedItems: StateFlow<List<FoodItem>> = _selectedItems

    fun addItem(item: FoodItem) {
        _selectedItems.value = _selectedItems.value + item
    }

    fun clearOrder() {
        _selectedItems.value = emptyList()
    }
}
