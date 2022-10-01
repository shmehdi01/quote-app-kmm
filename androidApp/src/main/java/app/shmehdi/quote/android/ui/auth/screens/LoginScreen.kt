package app.shmehdi.quote.android.ui.auth.screens

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.shmehdi.quote.android.navigation.Action
import app.shmehdi.quote.android.navigation.Routes
import app.shmehdi.quote.android.ui.auth.AuthViewModel
import app.shmehdi.quote.android.ui.components.ErrorDialog
import app.shmehdi.quote.android.ui.states.UIState
import app.shmehdi.quote.models.dto.LoginRequest

@Composable
fun LoginScreen(action: Action, viewModel: AuthViewModel) {

    var email by rememberSaveable { mutableStateOf("mehdi@gmail.com") }
    var password by rememberSaveable { mutableStateOf("password") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val uiState = viewModel.state

    ErrorDialog(state = uiState)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F2FA))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LoginHeader()
        Spacer(modifier = Modifier.height(32.dp))
        LoginForm(
            email = email,
            password = password,
            passwordVisibility = passwordVisibility,
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onPasswordVisibility = { passwordVisibility = !passwordVisibility },
        )
        Spacer(modifier = Modifier.height(32.dp))
        LoadingButton(
            text = "Login",
            isLoading = uiState.value is UIState.Loading,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            logD("Login Clicked")
            viewModel.login(LoginRequest(email, password))
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "New User? Create Account",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    viewModel.appPreference.getToken("token")?.let {
                        logD("TOKEN $it")
                    }
                    action.navigate(Routes.REGISTER)
                },
            color = Color(0xFF555555)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Made ❤️ with Kotlin",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color(0xFF555555)
        )
    }
}

@Composable
private fun LoginHeader() {
    Text(
        text = "Login",
        color = Color(0xFF614F91),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Lots of quote waiting for you", color = Color(0xFF555555))
}

@Composable
private fun LoginForm(
    email: String,
    password: String,
    passwordVisibility: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibility: () -> Unit,
) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        placeholder = { Text(text = "Email") },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = onPasswordVisibility) {
                Icon(
                    imageVector = if (passwordVisibility) {
                        Icons.Outlined.Visibility
                    } else {
                        Icons.Outlined.VisibilityOff
                    },
                    contentDescription = null
                )
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun LoadingButton(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    text: String,
    onClick: () -> Unit
) {
    val width by animateDpAsState(targetValue = if (isLoading) 46.dp else 224.dp)
    Button(
        shape = RoundedCornerShape(if (isLoading) 100.dp else 24.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF89C8A5),
            disabledBackgroundColor = Color(0xFF89C8A5),
            disabledContentColor = contentColorFor(Color(0xFF89C8A5))
        ),
        enabled = !isLoading,
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .height(46.dp)
            .width(width)
            .then(modifier)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(36.dp),
                color = Color.White,
                strokeWidth = 3.dp
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.button,
                color = Color.White
            )
        }
    }
}

fun logD(text: String) {
    Log.d("SYED", text)
}
