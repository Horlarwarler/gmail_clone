package com.example.gmailClone.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
// Creating the top AppBar
fun AppBar(
    // Menu Icon CLicked
    onMenuClicked:()->Unit
){
    Card(

        modifier = Modifier
            //Adding a space around the card
            .padding(10.dp)
            // Specifying the height of the card
            .requiredHeight(50.dp)
        ,
        // The shape of the card
        shape = RoundedCornerShape(5.dp),
        //Adding elevation to the card
        elevation = 5.dp,
    ) {
        Row(
            //Adding a vertical allingment
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                // fill the maximum size available
                .fillMaxSize()
                //Add a content padding
                .padding(8.dp),

        ) {
            // Setting the dafault value of the search field
            var text by remember {
                mutableStateOf("")
            }
            // Adding the menu icon button
            IconButton(onClick = {
                onMenuClicked()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription ="Menu Icon" )
            }

            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.1.dp)
                    .weight(2f),
                // Setting the value to text
                value = text,
                // Changing the value to user input
                onValueChange = { text = it },
                decorationBox = {
                    innerTextField ->
                    Row() {
                        // Check if the text is empty
                        if (text.isEmpty()){
                            Text(text = "Search Gmail", fontSize = MaterialTheme.typography.subtitle1.fontSize)
                        }
                    }
                    //REMOVING The  inner text field
                    innerTextField()
                },
                //To show search keyboard type
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions {

                },
                //To enable single line
                singleLine = true,
                // Set the max line
                maxLines = 1

            )

            // Adding the logo

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(Color.Blue,CircleShape)
                    .align(Alignment.CenterVertically),
                contentAlignment = Alignment.Center,

            ){
                Text(
                    text = "M",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    textAlign = TextAlign.Center


                )
            }


        }
    }
}

@Preview
@Composable
fun PreviewCompose(){
    Text(
        modifier = Modifier
            .clickable { }
            .aspectRatio(1f, )
            .background(
                Color.Blue,
                CircleShape
            )
            .size(24.dp)

         //   .padding(1.dp)

        ,
        text = "M",
        fontSize = 15.sp,
        fontWeight = FontWeight.Light,
        color = Color.White,
        textAlign = TextAlign.Center


    )
}