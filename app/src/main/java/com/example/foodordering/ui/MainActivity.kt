package com.example.foodordering.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodordering.ui.screen.authentication.login.LoginScreen
import com.example.foodordering.ui.screen.authentication.register.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginScreen(onLoginSuccess = {
                        Toast.makeText(this@MainActivity, "Login Success", Toast.LENGTH_SHORT)
                            .show()
                        navController.popBackStack()
                        navController.navigate("home")
                    }, navigateRegister = {
                        navController.navigate("register")
                    })
                }
                composable("register") {
                    RegisterScreen(onRegisterSuccess = {
                        navController.popBackStack()
                        navController.navigate("login")
                    })
                }
                composable("home") {
                    com.example.foodordering.ui.screen.customer.home.HomeScreen({})
                }
            }
        }
    }
}
