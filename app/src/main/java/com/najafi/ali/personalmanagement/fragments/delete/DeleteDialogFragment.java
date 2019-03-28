package com.najafi.ali.personalmanagement.fragments.delete;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.najafi.ali.personalmanagement.R;

public class DeleteDialogFragment extends DialogFragment {

    private Button btn_delete;
    private Button btn_dismis;
    Idelete idelete;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.delete_dialog_fragment, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btn_delete = view.findViewById(R.id.btn_remove_item_dialog);
        btn_dismis = view.findViewById(R.id.btn_not_remove_item_dialog);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idelete.deleted();
                dismiss();
            }
        });
        btn_dismis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.idelete = (Idelete) activity;
        } catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }

    public interface Idelete {
        void deleted();
    }
}
