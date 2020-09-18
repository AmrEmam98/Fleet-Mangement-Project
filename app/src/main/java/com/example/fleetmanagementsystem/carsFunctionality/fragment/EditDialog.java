package com.example.fleetmanagementsystem.carsFunctionality.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fleetmanagementsystem.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class EditDialog extends AppCompatDialogFragment {

    EditText carEt;
    Button applyBtn , CanelBtn;
    private EditeDialogListner editeDialogListner;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_edit, null);
        builder.setView(view);

        setCancelable(false);

        carEt = view.findViewById(R.id.car_Et);
        applyBtn = view.findViewById(R.id.apply_et);

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subTitle = carEt.getText().toString();
                editeDialogListner.applyText(subTitle);

                dismiss();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            editeDialogListner = (EditeDialogListner) context;
        } catch (ClassCastException e) {
           throw new ClassCastException(context.toString() +
                   "must Implement EditDialogListener"
                   );
        }
    }

    public interface EditeDialogListner{
        void applyText(String subTitle);
    }
}
