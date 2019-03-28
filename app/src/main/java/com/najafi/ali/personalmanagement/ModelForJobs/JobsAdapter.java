package com.najafi.ali.personalmanagement.ModelForJobs;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.najafi.ali.personalmanagement.Activities.Activity.Activity;
import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.Utils.EnglishToPersian;
import com.najafi.ali.personalmanagement.fragments.delete.DeleteDialogFragment;
import com.najafi.ali.personalmanagement.fragments.edit.EditDialogFragment;

import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int position;
    private List<Jobs> jobs;
    private Context context;
    private Activity activity;

    public JobsAdapter(List<Jobs> jobs, Context context, Activity activity) {
        this.jobs = jobs;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 0) {
            return new VH0(LayoutInflater.from(context).inflate(R.layout.item_list_of_jobs, viewGroup, false));
        } else {
            return new VH1(LayoutInflater.from(context).inflate(R.layout.item_list_of_jobs_2, viewGroup, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (!jobs.get(position).isHasNote()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder vh, final int position) {
        final Jobs job = jobs.get(position);
        if (vh.getItemViewType() == 0) {
            ((VH0) vh).bind0(job);
            listenerDelete(((VH0) vh).btnRemove, position);
            listenerEdit(((VH0) vh).btnEdit, position);
        } else {
            ((VH1) vh).bind1(job);
            listenerDelete(((VH1) vh).btnRemove, position);
            listenerEdit(((VH1) vh).btnEdit, position);
        }
    }


    @Override
    public int getItemCount() {
        return jobs.size();
    }


    public class VH0 extends RecyclerView.ViewHolder {

        AppCompatImageView imgJob;
        TextView txtDuration;
        TextView txtPrice;
        TextView txtName;
        TextView txtId;
        Button btnRemove;
        Button btnEdit;


        public VH0(@NonNull View itemView) {
            super(itemView);
            imgJob = itemView.findViewById(R.id.img_job);
            txtDuration = itemView.findViewById(R.id.txt_duration_job);
            txtPrice = itemView.findViewById(R.id.txt_price_job);
            txtName = itemView.findViewById(R.id.txt_name_job);
            txtId = itemView.findViewById(R.id.txt_id_job);
            btnRemove = itemView.findViewById(R.id.btn_remove_item);
            btnEdit = itemView.findViewById(R.id.btn_edit_job);
        }

        private void bind0(Jobs job) {
            txtPrice.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getPrice())));
            txtDuration.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getDuration())));
            imgJob.setImageResource(job.getImage());
            txtId.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getId())));
            txtName.setText(job.getName());
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditDialogFragment fragment = new EditDialogFragment();
                    fragment.show(activity.getSupportFragmentManager(), "edit");
                }
            });
        }
    }

    public class VH1 extends RecyclerView.ViewHolder {

        AppCompatImageView imgJob;
        TextView txtDuration;
        TextView txtPrice;
        TextView txtName;
        TextView txtId;
        TextView txtNote;
        Button btnRemove;
        ImageView imgNote;
        Button btnEdit;

        public VH1(@NonNull View itemView) {
            super(itemView);
            imgJob = itemView.findViewById(R.id.img_job);
            txtDuration = itemView.findViewById(R.id.txt_duration_job);
            txtPrice = itemView.findViewById(R.id.txt_price_job);
            txtName = itemView.findViewById(R.id.txt_name_job);
            txtId = itemView.findViewById(R.id.txt_id_job);
            btnRemove = itemView.findViewById(R.id.btn_remove_item);
            imgNote = itemView.findViewById(R.id.img_note);
            txtNote = itemView.findViewById(R.id.txt_note);
        }

        private void bind1(final Jobs job) {
            txtPrice.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getPrice())));
            txtDuration.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getDuration())));
            imgJob.setImageResource(job.getImage());
            txtId.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getId())));
            txtName.setText(job.getName());
            btnEdit = itemView.findViewById(R.id.btn_edit_job);


            txtNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(activity).setMessage(job.getNote() + "ggvgvgvghvgvghvghvh vghvgvgvgvg").show();
                }
            });

            imgNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(activity).setMessage(job.getNote() + "ggvgvgvghvgvghvghvh vghvgvgvgvg").show();
                }
            });

        }

    }

    private void listenerEdit(Button button, final int position) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobsAdapter.position = position;
                EditDialogFragment fragment = new EditDialogFragment();
                fragment.show(activity.getSupportFragmentManager(), "edit");
            }
        });


    }

    private void listenerDelete(Button button, final int position) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobsAdapter.position = position;
                DeleteDialogFragment fragment = new DeleteDialogFragment();
                fragment.show(activity.getSupportFragmentManager(), "delete");
            }
        });
    }

    public void removeAt() {
        jobs.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, jobs.size());
    }

    public void editItem(String txtDuration, String txtPaid, String txtType, String note) {
        Jobs job = jobs.get(position);
        job.setDuration(Double.parseDouble(txtDuration));
        job.setPaid(Double.parseDouble(txtPaid));
        job.setName(txtType);
        if (!note.isEmpty()) {
            job.setHasNote(true);
        }else{
            job.setHasNote(false);
        }
        jobs.set(position, job);
        notifyItemChanged(position, job);
    }

    public void addItem(String duration, String paid, String name, String note, int c) {
        Jobs job = new Jobs(1, c, name, Double.parseDouble(duration), Double.parseDouble(paid), 12313, !note.isEmpty());
        jobs.add(job);
        notifyItemInserted(jobs.size() - 1);
    }
}
