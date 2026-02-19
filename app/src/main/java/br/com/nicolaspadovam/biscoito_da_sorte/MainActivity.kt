package br.com.nicolaspadovam.biscoito_da_sorte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nicolaspadovam.biscoito_da_sorte.ui.theme.Biscoito_da_sorteTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Biscoito_da_sorteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppBiscoitoDaSorteScreen();
                }
            }
        }
    }
}

@Composable
fun AppBiscoitoDaSorteScreen() {
    val frases = listOf(
        "A vida trará coisas boas se tiveres paciência.",
        "Um encontro inesperado trará um sorriso ao seu dia.",
        "Grandes jornadas começam com pequenos ajustes na rota.",
        "Sua criatividade será a chave para um novo caminho.",
        "A paciência é a raiz de todas as soluções que você busca."
    )


    var phrase by remember { mutableStateOf("") }
    var showPhrase by remember { mutableStateOf(false) }

    fun showFrase() {
        val randomIndex = Random.nextInt(frases.size)
        showPhrase = true
        phrase = frases[randomIndex]
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_biscoito),
            contentDescription = "background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showPhrase) {

                Spacer(
                    modifier = Modifier.height(180.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(
                            Color.Black.copy(alpha = 0.80F),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "\"$phrase\"",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { showFrase() },
                modifier = Modifier
                    .width(280.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) {
                Text(text = "Abrir Biscoito!")
            }

            Spacer(
                modifier = Modifier.height(45.dp)
            )
        }
    }
}

@Preview
@Composable
fun AppBiscoitoDaSorteScreenPreview() {
    Biscoito_da_sorteTheme {
        AppBiscoitoDaSorteScreen()
    }
}