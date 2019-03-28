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

public class AddDialogFragmentWork extends DialogFragment {

    private AddItemInterface iadd;
    private Button btnAdd;
    private Button btnNotAdd;

    private TextInputEditText txtName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_dialog_fragment_work, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnAdd = v.findViewById(R.id.btn_add_item_dialog);
        btnNotAdd = v.findViewById(R.id.btn_not_add_item_dialog);
        txtName = v.findViewById(R.id.txt_name);



        btnNotAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iadd.add(txtName.getText().toString());
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



   public interface AddItemInterface {
        void add(String name);
    }


}
