package br.com.wmwallet.android.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wmwallet.android.MyApplicationTheme
import br.com.wmwallet.android.componet.AlertaGeral
import br.com.wmwallet.model.Login

@Composable
fun LoginScreen(onHomeNavigate: () -> Unit) {
    MyApplicationTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val login = remember { mutableStateOf(TextFieldValue()) }
                val senha = remember { mutableStateOf(TextFieldValue()) }
                val senhaVisivel = remember { mutableStateOf(false) }
                val showDialog = remember { mutableStateOf(false) }
//                val mensagem = remember { mutableStateOf("") }
                Text(
                    text = "Login",
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = login.value,
                    onValueChange = { login.value = it },
                    label = { Text(text = "E-mail") }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = senha.value,
                    onValueChange = { senha.value = it },
                    label = { Text(text = "Senha") },
                    visualTransformation = if (senhaVisivel.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val icone =
                            if (senhaVisivel.value.not()) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        val description = if (senhaVisivel.value.not()) "Invisivel" else "Visível"

                        IconButton(onClick = { senhaVisivel.value = !senhaVisivel.value }) {
                            Icon(imageVector = icone, contentDescription = description)
                        }

                    }
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Esqueci minha senha", modifier = Modifier.fillMaxWidth())
                }

                Spacer(modifier = Modifier.height(80.dp))
                Button(onClick = {
                    val loginUser = Login(email = login.value.text, senha = senha.value.text)

                    if (loginUser.validador()) {
                        onHomeNavigate.invoke()
                    } else {
                        showDialog.value = true

                    }

                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Entrar")

                }
                AlertaGeral(showDialog = showDialog.value,
                    usuario = "Olá ${login.value.text} verifique senha e/ou e-mail",

                    onDismissRequest = { showDialog.value = false })
            }

        }

    }


}

@Preview
@Composable
fun DefaultPreview() {
    LoginScreen {

    }
}

