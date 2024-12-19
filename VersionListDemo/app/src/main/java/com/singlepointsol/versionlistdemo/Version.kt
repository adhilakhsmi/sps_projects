package com.singlepointsol.versionlistdemo

import android.content.Context
import androidx.compose.ui.res.stringResource
import androidx.core.graphics.convertTo


data class Version(val versionImage:Int,val versionName:String,val versionDetails:String)
fun getAllVersions(context: Context):ArrayList<Version>{
    return arrayListOf(
        Version(R.drawable.img,"Cupcake",context.getString(R.string.cupcake)),
        Version(R.drawable.img_1,"Donut",context.getString(R.string.donut)),
        Version(R.drawable.img_2,"Froyo",context.getString(R.string.froyo)),
        Version(R.drawable.img_3,"Ginger Bread",context.getString(R.string.gingerbread)),
        Version(R.drawable.img_4,"Honey Comb",context.getString(R.string.honeycomb)),
        Version(R.drawable.img_5,"Jelly Bean",context.getString(R.string.jellybean)),
        Version(R.drawable.img_6,"Kitkat",context.getString(R.string.kitkat)),
        Version(R.drawable.img_7,"lollipop",context.getString(R.string.lolloipop)),
        Version(R.drawable.img_8,"Oreo","Oreo")

    )
}
