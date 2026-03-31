package com.example.nailah_cookie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nailah_cookie.ui.theme.NailahcookieTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NailahcookieTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
// State data
    var alas by remember { mutableStateOf("") }
    var tinggi by remember { mutableStateOf("") }
    var hasilSegitiga by remember { mutableStateOf("0") }
    var sisi by remember { mutableStateOf("") }
    var hasilKubus by remember { mutableStateOf("0") }

// Warna Tema Cookie
    val Choco = Color(0xFF6D4C41)
    val Cream = Color(0xFFFFF8E1)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Cookie Calculator 🍪", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Choco)
        Spacer(modifier = Modifier.height(20.dp))

// --- SEKSI SEGITIGA ---
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Cream),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Add, contentDescription = null, tint = Choco)
                    Spacer(Modifier.width(8.dp))
                    Text("Luas Segitiga", fontWeight = FontWeight.Bold, color = Choco)
                }

                OutlinedTextField(
                    value = alas,
                    onValueChange = { alas = it },
                    label = { Text("Alas") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                OutlinedTextField(
                    value = tinggi,
                    onValueChange = { tinggi = it },
                    label = { Text("Tinggi") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Row(modifier = Modifier.padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        onClick = {
                            val a = alas.toDoubleOrNull() ?: 0.0
                            val t = tinggi.toDoubleOrNull() ?: 0.0
                            val hitung = 0.5 * a * t
                            hasilSegitiga = if (hitung % 1 == 0.0) hitung.toInt().toString() else "%.2f".format(hitung)
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Choco)
                    ) {
                        Text("Hitung")
                    }

                    IconButton(onClick = { alas = ""; tinggi = ""; hasilSegitiga = "0" }) {
                        Icon(Icons.Default.Delete, contentDescription = null, tint = Choco)
                    }
                }
                Text("Hasil: $hasilSegitiga", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Choco)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

// --- SEKSI KUBUS ---
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Add, contentDescription = null, tint = Choco)
                    Spacer(Modifier.width(8.dp))
                    Text("Volume Kubus", fontWeight = FontWeight.Bold, color = Choco)
                }

                OutlinedTextField(
                    value = sisi,
                    onValueChange = { sisi = it },
                    label = { Text("Sisi") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Row(modifier = Modifier.padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        onClick = {
                            val s = sisi.toDoubleOrNull() ?: 0.0
                            hasilKubus = (s * s * s).toString()

                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Choco)
                    ) {
                        Text("Hitung")
                    }

                    IconButton(onClick = { sisi = ""; hasilKubus = "0" }) {
                        Icon(Icons.Default.Delete, contentDescription = null, tint = Choco)
                    }
                }
                Text("Hasil: $hasilKubus", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Choco)
            }
        }
    }
}