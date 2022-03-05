package com.example.gmailClone.ui.Screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailClone.util.GmailItem


//Creating a list of gmail items
val dataItems:List<GmailItem> = listOf(
    GmailItem.divider,
    GmailItem.inboxType(name ="All inboxes", Icons.Outlined.AllInbox),
    GmailItem.divider,
    GmailItem.inboxType("Primary",Icons.Outlined.Inbox,"1 new"),
    GmailItem.inboxType("Social",Icons.Outlined.Person),
    GmailItem.inboxType("Promotions",Icons.Outlined.Tag,"91 new"),
    GmailItem.header("ALL LABELS"),
    GmailItem.inboxType("Starred",Icons.Outlined.StarOutline,"6"),
    GmailItem.inboxType("Snoozed",Icons.Outlined.Snooze),
    GmailItem.inboxType("Important",Icons.Outlined.Label,"32"),
    GmailItem.inboxType("Sent",Icons.Outlined.Send),
    GmailItem.inboxType("Scheduled",Icons.Outlined.ScheduleSend),
    GmailItem.inboxType("Outbox",Icons.Outlined.Outbox,"6"),
    GmailItem.inboxType("Drafts",Icons.Outlined.Drafts,"99+"),
    GmailItem.inboxType("All mail",Icons.Outlined.Mail),
    GmailItem.inboxType("Spam",Icons.Outlined.Dangerous,"8"),
    GmailItem.inboxType("Trash",Icons.Outlined.ShoppingBasket),
    GmailItem.inboxType("Junk",Icons.Default.ShoppingBasket),
    GmailItem.header("GOOGLE APPS"),
    GmailItem.inboxType("Calender",Icons.Outlined.CalendarToday),
    GmailItem.inboxType("Contacts",Icons.Outlined.Contacts),
    GmailItem.divider,
    GmailItem.inboxType("Settings",Icons.Outlined.Settings),
    GmailItem.inboxType("Help & feedback",Icons.Outlined.Help)


)

@Composable
fun DrawerContent(
    scrollState: ScrollState
){
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Gmail",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Red,
            modifier=Modifier.padding(start= 20.dp,end= 5.dp,top = 20.dp,bottom= 20.dp)
        )

        // Looping through every items
        dataItems.forEach {
            item ->
            when{
                // Check if the item is inbox type
                item is GmailItem.inboxType ->{
                    InboxType(inboxType = item)
                }
                item is GmailItem.header -> {
                    HeaderType(headerItem = item)
                }
                item is GmailItem.divider -> {
                    Divider(Modifier.padding(5.dp))
                }
        }

        }
    }

}

/// Creating a compoasble for inbox type
@Composable
fun InboxType(
    inboxType:GmailItem.inboxType
){
    // The box will contains our row elements
    Box(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .padding(start = 15.dp, end = 10.dp, bottom = 10.dp, top = 10.dp),

        // Setting the content in center
        contentAlignment = Alignment.Center,

    )
    {
        Row(
            modifier = Modifier

                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            
            Box(modifier = Modifier
                //To take the 20 percent of available space
                .fillMaxWidth()
                .weight(0.15f),
            contentAlignment = Alignment.CenterStart)
            {
                Icon(
                   imageVector = inboxType.icon,
                    contentDescription = inboxType.name,
                    Modifier.size(32.dp)


                    )
            }

            Text(
                text = inboxType.name,
                fontSize = 15.sp,

                fontWeight = FontWeight.SemiBold,
                //To take the  rest  of the available space

                modifier = Modifier
                    .weight(if (inboxType.messageCount == null) 0.85f else 0.7f)
                    .fillMaxWidth(),

                )
            inboxType.messageCount?.let {

                messageCount ->
                Box(
                    modifier = Modifier.weight(0.15f),
                    contentAlignment = Alignment.CenterEnd
                ){
                    Text(
                        text = messageCount,
                        fontSize = 10.sp,
                        maxLines = 1,
                        fontWeight = FontWeight.SemiBold,


                        )
                }

            }
        }
    }
}

// Composable for header type
@Composable
fun HeaderType(
    headerItem:GmailItem.header
){
    Text(
        text = headerItem.name,
        fontSize = 14.sp,
        fontWeight = FontWeight.Thin,
        modifier = Modifier.padding(start = 20.dp,bottom= 10.dp,top = 10.dp)
    )
}

@Preview
@Composable
fun InboxTye(){
//    InboxType(inboxType =    GmailItem.inboxType("Primary",Icons.Outlined.Inbox,"1 new"),
//    )

    DrawerContent(scrollState = rememberScrollState() )
}