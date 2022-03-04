package com.example.gmailClone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.gmailClone.composable.AppBar
import com.example.gmailClone.ui.theme.CbtQuizTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CbtQuizTheme {
                // A surface container using the 'background' color from the theme
                val scope = rememberCoroutineScope()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    scaffoldState= scaffoldState,
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        AppBar{
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }

                        }
                    },
                    drawerContent = {
                        Text(text = "This is text")
                    },
                    drawerShape = MaterialTheme.shapes.medium

                ){}

            }
        }
    }
}

