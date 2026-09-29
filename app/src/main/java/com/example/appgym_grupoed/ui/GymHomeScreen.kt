package com.example.appgym_grupoed.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appgym_grupoed.model.Rutina
import com.example.appgym_grupoed.viewmodel.GymViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GymHomeScreen(viewModel: GymViewModel = GymViewModel()) {
    val rutinas by viewModel.rutinas.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PowerGym - Rutinas del Día") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(rutinas) { rutina ->
                RutinaCard(rutina = rutina)
            }
        }
    }
}

@Composable
fun RutinaCard(rutina: Rutina) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = rutina.nombre, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Grupo Muscular: ${rutina.grupoMuscular}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Series: ${rutina.series} | Repeticiones: ${rutina.repeticiones}", style = MaterialTheme.typography.bodySmall)
        }
    }
}