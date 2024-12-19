package com.singlepointsol.fruitslistdemo

import com.singlepointsol.lazygrid.R

data class Fruits(
    val fruitImage: Int, // Image resource ID
    val fruitName: String, // Fruit name
    val fruitColor: String // Fruit color
)

fun getAllFruits(): ArrayList<Fruits> {
    return arrayListOf(
        Fruits(R.drawable.apple, "Apple", "Red"),
        Fruits(R.drawable.avacado, "Avocado", "Green"),
        Fruits(R.drawable.blackberry, "BlackBerry", "Black"),
        Fruits(R.drawable.blueberry, "Blueberry", "Violet"),
        Fruits(R.drawable.cherry, "Cherry", "Red"),
        Fruits(R.drawable.mango, "Mango", "Yellow")
    )
}
