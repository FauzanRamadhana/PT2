package org.d3if0054.easypark

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyParkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterPage()
                }
            }
        }
    }
}

@Composable
fun RegisterPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopIcons()
        Spacer(modifier = Modifier.height(20.dp))
        IntroTexts()
        PhoneNumberEntry()
        UserName()
        Nik()
        RoleDropdown()
        Spacer(Modifier.weight(1f))
        ActionButtons()
    }
}

@Composable
fun Nik() {
    Text(text = "NIK", style = interType.labelSmall)
    val nik = remember { mutableStateOf("") }
    OutlinedTextField(
        value = nik.value,
        onValueChange = { nik.value = it },
        singleLine = true,
        label = { Text("Masukkan nik pengguna") },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(20.dp))
}
@Composable
fun UserName() {
    Text(text = "Nama Pengguna", style = interType.labelSmall)
    val username = remember { mutableStateOf("") }
    OutlinedTextField(
        value = username.value,
        onValueChange = { username.value = it },
        singleLine = true,
        label = { Text("Masukkan nama pengguna") },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(20.dp))
}
@Composable
private fun IntroTexts() {
    Text("Halo Pengguna Easy Park~", style = interType.displayMedium)
    Spacer(modifier = Modifier.height(20.dp))
    Text("Daftar dapat kamu lakukan dengan mudah dan cepat hanya dalam beberapa langkah", style = interType.bodyLarge)
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
        Text("Daftar")
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
        Text("Sudah punya akun? Masuk", color = Color(0xFF2955B6))
    }
}
@Composable
fun TopIcons() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            IconButton(onClick = { context.startActivity(Intent(context, MainActivity::class.java)) }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = "Back Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
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

@Preview(showBackground = true)
@Composable
fun RegisterPagePreview() {
    EasyParkTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RegisterPage()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleDropdown() {
    var expanded by remember { mutableStateOf(false) }
    val roles = listOf("Pengendara", "User", "Visitor")
    var selectedRole by remember { mutableStateOf(roles.first()) }

    Text(text = "Peran", style = interType.labelSmall)
    Spacer(modifier = Modifier.height(10.dp))
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        OutlinedTextField(
            value = selectedRole,
            onValueChange = { },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Dropdown Arrow",
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            roles.forEach { role ->
                DropdownMenuItem(
                    onClick = {
                        selectedRole = role
                        expanded = false
                    },
                    text = { Text(role) }
                )
            }
        }
    }
}