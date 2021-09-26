package app.shmehdi.quote.android.ui.auth.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import app.shmehdi.quote.android.navigation.Action
import app.shmehdi.quote.android.navigation.Routes
import app.shmehdi.quote.android.ui.auth.AuthViewModel
import app.shmehdi.quote.models.dto.LoginRequest

@OptIn(ExperimentalUnitApi::class)
@Composable
fun LoginScreen(action: Action, viewModel: AuthViewModel) {

    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {

        LoginHeader()

        LoginForm(email, password, passwordVisibility)

        LoginButton {
            viewModel.login(LoginRequest(email.value, password.value))
        }

        RegisterButton(Modifier.align(Alignment.CenterHorizontally)) {
            action.navigate(Routes.REGISTER)
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Made ❤️ with Kotlin",
            modifier = Modifier
                .padding(start = 12.dp, top = 10.dp)
                .align(Alignment.CenterHorizontally),
            style = TextStyle(
                fontSize = TextUnit(14f, TextUnitType.Sp),
                fontWeight = FontWeight.Normal
            )
        )

    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun LoginHeader() {
    Column {
        Text(
            text = "Login",
            modifier = Modifier.padding(start = 12.dp, top = 30.dp),
            style = TextStyle(
                fontSize = TextUnit(24f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Lots of quote waiting for you",
            modifier = Modifier.padding(start = 12.dp, top = 10.dp),
            style = TextStyle(
                fontSize = TextUnit(14f, TextUnitType.Sp),
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
private fun LoginForm(
    email: MutableState<String>,
    password: MutableState<String>,
    passwordVisibility: MutableState<Boolean>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        TextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            placeholder = {
                Text("Email")
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )

        TextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            placeholder = {
                Text("Password")
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val text = if (passwordVisibility.value)
                    "Hide"
                else "Show"

                TextButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Text(text)
                }
            }
        )
    }

}

@Composable
private fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick, modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Text("Login")
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun RegisterButton(modifier: Modifier, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = "New User? Create Account",
            modifier = Modifier.padding(start = 12.dp, top = 10.dp),

            style = TextStyle(
                fontSize = TextUnit(14f, TextUnitType.Sp),
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline
            )
        )
    }
}