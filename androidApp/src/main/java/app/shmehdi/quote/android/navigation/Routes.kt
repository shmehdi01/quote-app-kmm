package app.shmehdi.quote.android.navigation

import androidx.navigation.NavHostController

object Routes {
    const val LOGIN = "Login"
    const val REGISTER = "Register"
}

class Action(private val navController: NavHostController) {

    fun navigate(route: String) {
        navController.navigate(route)
    }
}
