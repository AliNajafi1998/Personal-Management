package com.najafi.ali.personalmanagement.fragments.edit;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.Utils.SpinnerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class EditDialogFragment extends DialogFragment {
    private AppCompatSpinner spinner;
    private ArrayList<String> spinnerArray = new ArrayList<>(Arrays.asList("", "PeakiBlinders", "The GodFather"));

    private SaveChangeInterFace isaveChange;
    private Button btnSave;
    private Button btnDismiss;

    TextInputEditText txtDuration;
    TextInputEditText txtPaid;
    EditText editTextNote;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_dialog_fragment, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        spinner = view.findViewById(R.id.spinner1);
        btnDismiss = view.findViewById(R.id.btn_not_save_edits);
        btnSave = view.findViewById(R.id.btn_save_edits);
        txtDuration = view.findViewById(R.id.txt_duration_edit);
        txtPaid = view.findViewById(R.id.txt_paid_edit);
        editTextNote = view.findViewById(R.id.txt_note_edit);


        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                isaveChange.changeIt(txtDuration.getText().toString(),
                        txtPaid.getText().toString(),
                        spinner.getSelectedItem().toString(),
                        editTextNote.getText().toString());
            }
        });


        spinnerAdapter();
        return view;
    }

    public void spinnerAdapter() {
        SpinnerAdapter adapter = new SpinnerAdapter(getContext(), spinnerArray);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.isaveChange = (SaveChangeInterFace) activity;
        } catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }

    public interface SaveChangeInterFace {
        void changeIt(String txtDuration, String txtPaid, String txtType, String note);
    }
}
