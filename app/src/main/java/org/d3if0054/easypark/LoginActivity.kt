package org.d3if0054.easypark

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.d3if0054.easypark.ui.theme.EasyParkTheme
import org.d3if0054.easypark.ui.theme.interType

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyParkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginPage()
                }
            }
        }
    }
}

@Composable
fun LoginPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        TopIcon()
        IntroTexts()
        PhoneNumberEntry()
        Spacer(Modifier.weight(1f))
        ActionButtons()
    }
}

@Composable
private fun IntroTexts() {
    Text("Halo Pengguna Easy Park~", style = interType.displayMedium)
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        "Masuk dapat kamu lakukan dengan mudah dan cepat hanya dalam beberapa langkah",
        style = interType.bodyLarge
    )
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
private fun PhoneNumberEntry() {
    Text("Nomor HP", style = interType.labelSmall)
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "+62", style = interType.labelSmall, modifier = Modifier.padding(end = 8.dp))
        val phoneNumber = remember { mutableStateOf("") }
        OutlinedTextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f)
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun TopIcon() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.align(Alignment.TopStart)) {
            IconButton(onClick = {
                context.startActivity(
                    Intent(
                        context,
                        MainActivity::class.java
                    )
                )
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = "Back Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Row(modifier = Modifier.align(Alignment.TopEnd)) {
            IconButton(onClick = { /* Handle Right Icon Click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_help_outline_24),
                    contentDescription = "Help Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

@Composable
private fun ActionButtons() {
    Button(
        onClick = { /* TODO: Add login action */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2955B6),
            contentColor = Color.White
        )
    ) {
        Text("Masuk")
    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(
        onClick = { /* TODO: Add navigate to register action */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(1.dp, Color(0xFF2955B6)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color(0xFF2955B6)
        )
    ) {
        Text("Pengguna Baru? Buat akun", color = Color(0xFF2955B6))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    EasyParkTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginPage()
        }
    }
}
