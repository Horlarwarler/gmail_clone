package com.example.gmailClone.ui.Screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import com.example.gmailClone.util.GmailItem


//Creating a list of gmail items
val dataItems:List<GmailItem> = listOf(
    GmailItem.divider,
    GmailItem.inboxType(name ="All inboxes", Icons.Outlined.AllInbox),
    GmailItem.divider,
    GmailItem.inboxType("Primary",Icons.Outlined.Inbox),
    GmailItem.inboxType("Social",Icons.Outlined.People),
    GmailItem.inboxType("Promotions",Icons.Outlined.Shop),
    GmailItem.header("ALL LABELS"),
    GmailItem.inboxType("Starred",Icons.Outlined.Star),
    GmailItem.inboxType("Snoozed",Icons.Outlined.Alarm),
    GmailItem.inboxType("Sent",Icons.Outlined.Send),
    GmailItem.inboxType("Scheduled",Icons.Outlined.ScheduleSend),
    GmailItem.inboxType("Outbox",Icons.Outlined.Outbox),
    GmailItem.inboxType("Drafts",Icons.Outlined.Drafts),
    GmailItem.inboxType("All mail",Icons.Outlined.Mail),
    GmailItem.inboxType("Spam",Icons.Outlined.Dangerous),
    GmailItem.inboxType("Trash",Icons.Outlined.ShoppingBasket),
    GmailItem.inboxType("Junk",Icons.Default.ShoppingBasket)

)

@Composable
fun DrawerContent(){

}