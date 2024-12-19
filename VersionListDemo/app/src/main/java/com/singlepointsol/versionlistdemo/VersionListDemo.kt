package com.singlepointsol.versionlistdemo

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VersionListDemo(modifier: Modifier=Modifier) {
    LazyColumnDemo()
}

@Composable
fun LazyColumnDemo() {
    val context= LocalContext.current
    LazyColumn {
        itemsIndexed(items= getAllVersions(context), itemContent = {index, item -> VersionItem(item=item) })
    }

}


@Composable
fun VersionItem(item:Version,modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.DarkGray)
            .size(96.dp)) {
        Image(
            painter = painterResource(item.versionImage), contentDescription = item.versionName,
            Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically).size(40.dp))

        Column(
            Modifier
                .fillMaxSize()
                .padding(8.dp)
                .align(Alignment.CenterVertically),Arrangement.Center) {
            Text(text=item.versionName, style = TextStyle(color = Color.Cyan, fontSize = 22.sp, fontStyle = FontStyle.Italic))
            Text(text=item.versionDetails, style = TextStyle(color = Color.Cyan, fontSize = 20.sp, fontStyle = FontStyle.Italic))

        }


    }

}