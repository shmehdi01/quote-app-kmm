package app.shmehdi.quote.android.ui.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.shmehdi.quote.android.navigation.Action
import app.shmehdi.quote.android.navigation.Routes
import app.shmehdi.quote.android.ui.auth.screens.LoginScreen
import app.shmehdi.quote.android.ui.auth.screens.RegisterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity: ComponentActivity() {

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Scaffold {
                AuthNavigation(navHostController = navController)
            }
        }
    }

    @Composable
    fun AuthNavigation(navHostController: NavHostController) {

        val action = Action(navHostController)

        NavHost(navController = navHostController, startDestination = Routes.LOGIN) {
            composable(route = Routes.LOGIN) {
                LoginScreen(action, viewModel)
            }
            composable(route = Routes.REGISTER) {
                RegisterScreen(action, viewModel)
            }
        }
    }
}