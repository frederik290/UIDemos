package com.example.uidemos;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by frederik290 on 23/04/2017.
 */

public class SearchDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        final Activity callerActivity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(callerActivity);
        builder.setView(R.layout.dialog_search)
                .setPositiveButton(R.string.search, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Dialog dialog = (Dialog) dialogInterface;
                        EditText editText = (EditText) dialog.findViewById(R.id.editText_searchField);
                        String text = getText(R.string.now_searching) + " " + '"' + editText.getText().toString() + '"';
                        Toast.makeText(callerActivity.getApplicationContext(), text, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }
}
