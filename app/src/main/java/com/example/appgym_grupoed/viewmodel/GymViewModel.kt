package com.example.appgym_grupoed.viewmodel

import androidx.lifecycle.ViewModel
import com.example.appgym_grupoed.model.Rutina
import com.example.appgym_grupoed.repository.GymRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GymViewModel(
    private val repository: GymRepository = GymRepository()
) : ViewModel() {

    private val _rutinas = MutableStateFlow<List<Rutina>>(emptyList())
    val rutinas: StateFlow<List<Rutina>> = _rutinas

    init {
        cargarRutinas()
    }

    private fun cargarRutinas() {
        _rutinas.value = repository.obtenerRutinas()
    }
}