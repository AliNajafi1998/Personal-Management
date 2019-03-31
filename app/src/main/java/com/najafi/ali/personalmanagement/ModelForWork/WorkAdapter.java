package com.najafi.ali.personalmanagement.ModelForWork;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.najafi.ali.personalmanagement.Activities.Work.WorkActivity;
import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.fragments.delete.DeleteDialogFragment;
import com.najafi.ali.personalmanagement.fragments.edit.EditDialogFragmentWork;

import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int position;
    private Context context;
    private List<Work> workList;
    WorkActivity activity;

    public WorkAdapter(Context context, List<Work> workList, WorkActivity activity) {
        this.context = context;
        this.workList = workList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_of_works, viewGroup, false);

        return new WorkAdapter.VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Work work = workList.get(position);
        ((VH) viewHolder).bind(work);
        listenerDelete(((VH) viewHolder).btnDeleteWork, position);
        listenerEdit(((VH) viewHolder).btnEditWork, position);
    }

    @Override
    public int getItemCount() {
        return workList == null ? 0 : workList.size();
    }


    public static class VH extends RecyclerView.ViewHolder {

        ImageView img_work;
        TextView txtName;
        Button btnActiveState;
        Button btnDeleteWork;
        Button btnEditWork;

        public VH(@NonNull View itemView) {
            super(itemView);
            img_work = itemView.findViewById(R.id.img_work);
            txtName = itemView.findViewById(R.id.txt_name_work);
            btnActiveState = itemView.findViewById(R.id.btn_activation_toggle_work);
            btnDeleteWork = itemView.findViewById(R.id.btn_remove_item_work);
            btnEditWork = itemView.findViewById(R.id.btn_edit_work);
        }

        public void bind(final Work work) {
            img_work.setImageResource(work.getImg());
            txtName.setText(work.getName());
            btnActiveState.setText(!work.isActive() ? "فعال کزدن" : "غیرفعال کردن");
            btnActiveState.setTextColor(Color.parseColor("#FFFFFF"));

            btnActiveState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    work.setActive(!work.isActive());
                    btnActiveState.setText(!work.isActive() ? "فعال کردن" : "غیرفعال کردن");
                    btnActiveState.setBackgroundResource(work.isActive() ? R.drawable.btn_bg_4 : R.drawable.btn_bg_5);
                }
            });
        }
    }

    private void listenerEdit(Button button, final int position) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkAdapter.position = position;
                EditDialogFragmentWork fragment = new EditDialogFragmentWork();
                fragment.show(activity.getSupportFragmentManager(), "edit");
            }
        });


    }

    private void listenerDelete(Button button, final int position) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkAdapter.position = position;
                DeleteDialogFragment fragment = new DeleteDialogFragment();
                fragment.show(activity.getSupportFragmentManager(), "delete");
            }
        });
    }

    public void removeAt() {
        workList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, workList.size());
    }

    public void editItem(String txtName) {
        Work work = workList.get(position);
        work.setName(txtName);
        workList.set(position, work);
        notifyItemChanged(position, work);
    }

    public void addItem(String name) {
        Work work = new Work(name, R.drawable.f, false);
        workList.add(work);
        notifyItemInserted(workList.size() - 1);
    }

}
