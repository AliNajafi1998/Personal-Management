package com.najafi.ali.personalmanagement.fragments.add;

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

public class AddDialogFragment extends DialogFragment {

    private AddItemInterface iadd;
    private AppCompatSpinner spinner;
    private Button btnAdd;
    private Button btnNotAdd;
    private ArrayList<String> spinnerArray = new ArrayList<>(Arrays.asList("", "PeakiBlinders", "The GodFather"));

    private TextInputEditText txt_duration;
    private TextInputEditText txt_paid;
    private EditText txt_note;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_dialog_fragment, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        spinner = v.findViewById(R.id.spinner);
        btnAdd = v.findViewById(R.id.btn_add_item_dialog);
        btnNotAdd = v.findViewById(R.id.btn_not_add_item_dialog);

        txt_duration = v.findViewById(R.id.txt_duration);
        txt_paid = v.findViewById(R.id.txt_paid);
        txt_note = v.findViewById(R.id.txt_note);


        spinnerAdapter();

        btnNotAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iadd.add(txt_duration.getText().toString(),txt_paid.getText().toString(),spinner.getSelectedItem().toString(),txt_note.getText().toString());
                dismiss();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.iadd = (AddItemInterface) activity;
        } catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }

    public void spinnerAdapter() {
        SpinnerAdapter adapter = new SpinnerAdapter(getContext(), spinnerArray);
        spinner.setAdapter(adapter);
    }

   public interface AddItemInterface {
        void add(String duration,String paid,String name,String note);
    }


}
