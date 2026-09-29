package com.example.appgym_grupoed.repository

import com.example.appgym_grupoed.model.Rutina

class GymRepository {
    fun obtenerRutinas(): List<Rutina> {
        return listOf(
            Rutina(1, "Press de Banca", "Pecho", 4, 10),
            Rutina(2, "Sentadilla Trasera", "Pierna", 4, 12),
            Rutina(3, "Dominadas", "Espalda", 3, 8),
            Rutina(4, "Press Militar", "Hombros", 3, 10)
        )
    }
}