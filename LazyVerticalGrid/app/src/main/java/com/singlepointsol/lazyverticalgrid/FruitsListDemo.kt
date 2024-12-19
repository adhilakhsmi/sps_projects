import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.singlepointsol.fruitslistdemo.Fruits
import com.singlepointsol.fruitslistdemo.getAllFruits

@Composable
fun FruitListDemo(modifier: Modifier=Modifier){
    LazyColumsDem0()

}
@Composable
fun LazyColumsDem0(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(2.dp),
        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        itemsIndexed(items= getAllFruits(), itemContent ={index, item ->FruitItem(item=item)  })

    }

}


@Composable
fun FruitItem(item: Fruits, modifier: Modifier = Modifier) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),



    ) {


        Column(
            Modifier
                .fillMaxSize()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            // Image
            Image(
                painter = painterResource(item.fruitImage),
                contentDescription = "fruits",
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp),
            )


         }
        }
    }


