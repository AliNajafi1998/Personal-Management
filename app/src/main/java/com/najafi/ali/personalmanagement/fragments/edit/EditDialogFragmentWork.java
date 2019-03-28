package com.najafi.ali.personalmanagement.fragments.edit;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.najafi.ali.personalmanagement.R;


public class EditDialogFragmentWork extends DialogFragment {

    private SaveChangeInterFace isaveChange;
    private Button btnSave;
    private Button btnDismiss;

    TextInputEditText txtName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_dialog_fragment_work, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnDismiss = view.findViewById(R.id.btn_not_save_edits);
        btnSave = view.findViewById(R.id.btn_save_edits);
        txtName = view.findViewById(R.id.txt_name_edit_work_2);

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
                isaveChange.changeIt(txtName.getText().toString());
            }
        });


        return view;
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
        void changeIt(String txtName);
    }
}
