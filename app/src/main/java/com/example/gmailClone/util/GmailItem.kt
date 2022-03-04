package com.example.gmailClone.util


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.ui.graphics.vector.ImageVector


// Defining a sealed class for containing Gmail items
sealed class GmailItem(
    // Some have icons
    open val icon:ImageVector?,
    // Some have a name
    open val name: String?,
    //Some is a divider
    val isDivider:Boolean = false,
    // Some is a header
    val isHeader:Boolean = false,
    open val messageCount:Int? = null
){
    // Creating a inbox type
    class inboxType(
        override val name:String,
        override val icon :ImageVector,
        override val messageCount: Int? = null
    ):GmailItem(
        icon = Icons.Outlined.AllInbox,
        name = name,
        messageCount = messageCount
    )
    //Defining a divider
    object divider:GmailItem(
        icon =null,
        name = null,
        isDivider = true
    )
    //Defining a header

    class header(override val name:String, ):GmailItem(
        icon = null,
        name = name,
        isHeader =true
    )


}
