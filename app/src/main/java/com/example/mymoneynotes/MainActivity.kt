package com.example.mymoneynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymoneynotes.ui.AddTransactionScreen
import com.example.mymoneynotes.ui.HomeScreen
import com.example.mymoneynotes.ui.theme.MyMoneyNotesTheme
import com.example.mymoneynotes.viewmodel.TransactionViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: TransactionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoneyNotesTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MyApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(viewModel: TransactionViewModel) {
    var isDarkMode by rememberSaveable { mutableStateOf(false) }

    MyMoneyNotesTheme(darkTheme = isDarkMode) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(
                    viewModel = viewModel,
                    onAddClick = { navController.navigate("add") },
                    isDarkMode = isDarkMode,
                    onToggleTheme = { isDarkMode = !isDarkMode }
                )
            }
            composable("add") {
                AddTransactionScreen(
                    viewModel = viewModel,
                    onTransactionAdded = { navController.popBackStack() }
                )
            }
        }
    }
}

