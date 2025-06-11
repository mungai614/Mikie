package com.jeremy.mikie.model


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OrderViewModel : ViewModel() {
    private val _selectedItems = MutableStateFlow<List<FoodItem>>(emptyList())
    val selectedItems: StateFlow<List<FoodItem>> = _selectedItems

    fun addItem(item: FoodItem) {
        if (!_selectedItems.value.contains(item)) {
            _selectedItems.value = _selectedItems.value + item
        }
    }

    fun clearOrder() {
        _selectedItems.value = emptyList()
    }
}
