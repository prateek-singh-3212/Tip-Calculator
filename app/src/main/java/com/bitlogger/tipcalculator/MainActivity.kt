package com.bitlogger.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorUI()
        }
    }
}

@Preview
@Composable
fun TipCalculatorUI() {
    TipCalculator()
}

@Composable
fun TipCalculator() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
            .padding(20.dp)
    ) {
        Text(
            text = "Basic Tip Calculator",
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(50.dp))
        EditTextField()
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Tip is: ",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun EditTextField() {
    var data by remember {
        mutableStateOf("")
    }
    TextField(
        value = data,
        onValueChange = { data = it },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Enter Amount")
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )
}