package com.bsu.lab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

public class ExitDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.exit_dialog_message)
                .setPositiveButton(R.string.yes_exit, new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    public void onClick(DialogInterface dialog, int which) {
                        if(getActivity() != null){
                            Objects.requireNonNull(getActivity()).finishAndRemoveTask();
                        }
                    }
                })
                .setNegativeButton(R.string.no_exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

}
