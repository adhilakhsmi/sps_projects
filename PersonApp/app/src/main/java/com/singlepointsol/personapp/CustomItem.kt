import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun CustomItem(person: Person) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Load image dynamically using Coil
        AsyncImage(
            model = person.imageUrl, // URL from the JSON
            contentDescription = "${person.firstName} ${person.lastName}",
            modifier = Modifier
                .size(64.dp)
                .padding(end = 16.dp),
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = "${person.firstName} ${person.lastName}",
                style = TextStyle(fontSize = 20.sp, color = Color.Black)
            )
        }
    }
}


