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
    var inputAmount by remember {
        mutableStateOf("")
    }
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
        EditTextField("Enter Amount", inputAmount) {
            inputAmount = it
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Tip is: ${calculateBasicTip(inputAmount.toFloatOrNull() ?: 0.0f)}",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

fun calculateBasicTip(amount: Float): Float {
    return 0.15f * amount
}

@Composable
fun EditTextField(hint: String, inputAmount: String, onValueChanged: (String) -> Unit) {
    TextField(
        value = inputAmount,
        onValueChange = onValueChanged,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = hint)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )
}