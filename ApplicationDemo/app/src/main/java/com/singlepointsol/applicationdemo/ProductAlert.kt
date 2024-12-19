package com.singlepointsol.applicationdemo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class ProductAlert:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder= AlertDialog.Builder(context)
        builder.setView(R.layout.product_alert)
        return builder.create()

    }


    }

