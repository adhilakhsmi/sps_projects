import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class AlertDialogFragment:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //use builder class to create dialog construction
        val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Erase media?")
            builder.setMessage("All media will be deleted")
            builder.setPositiveButton("Yes") { dialog, id ->
                Toast.makeText(context, "media deleted successfully", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("No") { dialog, id ->
                Toast.makeText(context, "cancel the alert", Toast.LENGTH_LONG).show()
            }

        return builder.create()
    }
}
