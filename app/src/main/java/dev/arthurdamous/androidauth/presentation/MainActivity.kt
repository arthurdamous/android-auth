package dev.arthurdamous.androidauth.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import dev.arthurdamous.androidauth.presentation.notes.NotesScreen
import dev.arthurdamous.androidauth.presentation.ui.theme.AndroidAuthTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAuthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scaffoldState = rememberScaffoldState()

                    Scaffold(
                        scaffoldState = scaffoldState,
                        topBar = {
                            TopAppBar {
                                Text(text = "My Notes App", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    ) {
                        //LoginScreen()
                        NotesScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val viewModel: MainViewModel = hiltViewModel()
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = state.email,
                onValueChange = {
                    viewModel.onEvent(MainEvent.OnChangeEmail(it))
                },
                placeholder = { Text(text = "Email") })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(MainEvent.OnChangePassword(it))
                },
                placeholder = { Text(text = "Senha") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(onClick = {
                viewModel.onEvent(
                    MainEvent.LoginUser(
                        state.email,
                        state.password
                    )
                )
            }) {
                Text(text = "Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidAuthTheme {
        LoginScreen()
    }
}