package br.com.wmwallet.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.wmwallet.android.home.HomeScreen
import br.com.wmwallet.android.login.LoginScreen

enum class Route{
    LOGIN,
    HOME
}
@Composable
fun Navigator(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    initial: Route = Route.HOME
    ){

NavHost(navController = navHostController, startDestination = initial.name){
    composable(Route.LOGIN.name){
        LoginScreen { navHostController.navigate(Route.HOME.name) }
    }
    composable(Route.HOME.name){
        HomeScreen {
            //It returns to the last stack
            navHostController.popBackStack()
        }
    }
}
}