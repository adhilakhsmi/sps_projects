package com.singlepointsol.fruitslistdemo

data class Fruits(val fruitImage:Int,val fruitName:String,val fruitColor:String)
fun getAllFruits():ArrayList<Fruits>{
    return arrayListOf(
        Fruits(R.drawable.apple,"Apple","Red"),
        Fruits(R.drawable.avacado,"Avacado","Green"),
        Fruits(R.drawable.blackberry,"BlackBerry","Black"),
        Fruits(R.drawable.blueberry,"Blueberry","Violet"),
        Fruits(R.drawable.cherry,"Cherry","Red"),
        Fruits(R.drawable.mango,"Mango","Yellow"),

    )
}
