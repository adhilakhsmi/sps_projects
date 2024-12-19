package com.singlepointsol.customalertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class custom_alert_fragmennt: DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //create builder interface for dialog construction
        val builder=AlertDialog.Builder(context)
        //to open alert layout
        builder.setView(R.layout.curtom_signin_layout)
       return builder.create()

    }
}