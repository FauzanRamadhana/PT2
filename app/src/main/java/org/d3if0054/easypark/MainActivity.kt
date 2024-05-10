package org.d3if0054.easypark

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.d3if0054.easypark.ui.theme.EasyParkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyParkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OnBoardingPage()
                }
            }
        }
    }
}

@Composable
fun OnBoardingPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.logo1),
                contentDescription = "Logo EasyPark",
                modifier = Modifier.align(Alignment.TopStart)
            )
        }
        Spacer(Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.car),
            contentDescription = "Car Illustration",
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        )
        Spacer(Modifier.weight(1f))
        ActionButtons()
    }
}


@Composable
private fun ActionButtons() {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(Intent(context, LoginActivity::class.java))
        },
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
        onClick = {
            context.startActivity(Intent(context, RegisterActivity::class.java))
        },
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
fun OnBoardingPagePreview() {
    EasyParkTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            OnBoardingPage()
        }
    }
}
