import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singlepointsol.fruitslistdemo.Fruits
import com.singlepointsol.fruitslistdemo.getAllFruits

@Composable
fun FruitListDemo(modifier: Modifier=Modifier){
    LazyColumsDem0()

}
@Composable
fun LazyColumsDem0(){
    LazyColumn {
        itemsIndexed(items= getAllFruits(), itemContent = { index, item -> FruitItem(item=item) })
    }

}


@Composable
fun FruitItem(item: Fruits, modifier: Modifier = Modifier) {
    val borderWidth=2.dp
    val rainbowColorsBrush=Brush.sweepGradient(
        colors = listOf(Color.Red, Color.Yellow, Color.Green, Color.Cyan, Color.Blue, Color.Magenta)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),

        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
      border=BorderStroke(borderWidth,rainbowColorsBrush)


    ) {


        Row(
            modifier = Modifier
                .padding(16.dp) // Inner padding for card content

        ) {
            // Image
            val borderWidth=2.dp
            val rainbowColorsBrush = Brush.sweepGradient(
                colors = listOf(Color.Red, Color.Yellow, Color.Green, Color.Cyan, Color.Blue, Color.Magenta)
            )

            Image(
                painter = painterResource(item.fruitImage),
                contentDescription = item.fruitName,
                modifier = Modifier


                    .size(72.dp)
                    .border(
                        BorderStroke(borderWidth, rainbowColorsBrush),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)

            )

            // Text Column
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)

            ) {
                Text(
                    text = item.fruitName,
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = Color.Magenta,
                        fontStyle = FontStyle.Italic
                    )
                )
                Text(
                    text = item.fruitColor,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Magenta,
                        fontStyle = FontStyle.Italic
                    )
                )
            }
        }
    }
}

