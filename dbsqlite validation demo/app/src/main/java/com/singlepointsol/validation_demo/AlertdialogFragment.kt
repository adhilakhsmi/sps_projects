package com.singlepointsol.validation_demo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class AlertdialogFragment:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=AlertDialog.Builder(context)
        builder.setView(R.layout.activity_sign_up)
        return builder.create()
    }
}
/*se builder class to create dialog construction
       val builder = AlertDialog.Builder(requireContext())
       builder.setTitle("Login to the system")
       builder.setMessage("Enter Invalid Username and Password")

       builder.setPositiveButton("Back to  login") { dialog, id -> Toast.makeText(context, "try another way", Toast.LENGTH_LONG).show()
       }
       return builder.create()*/