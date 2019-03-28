package com.najafi.ali.personalmanagement.Model;

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
            listeners(((VH0) vh).btnRemove, position);
        } else {
            ((VH1) vh).bind1(job);
            listeners(((VH1) vh).btnRemove, position);
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

        public VH0(@NonNull View itemView) {
            super(itemView);
            imgJob = itemView.findViewById(R.id.img_job);
            txtDuration = itemView.findViewById(R.id.txt_duration_job);
            txtPrice = itemView.findViewById(R.id.txt_price_job);
            txtName = itemView.findViewById(R.id.txt_name_job);
            txtId = itemView.findViewById(R.id.txt_id_job);
            btnRemove = itemView.findViewById(R.id.btn_remove_item);
        }

        private void bind0(Jobs job) {
            txtPrice.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getPrice())));
            txtDuration.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getDuration())));
            imgJob.setImageResource(job.getImage());
            txtId.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getId())));
            txtName.setText(job.getName());

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

    private void listeners(Button button, final int position) {
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

    public void addItem(String duration, String paid, String name, String note, int c) {
        Jobs job = new Jobs(1, c, name, Double.parseDouble(duration), Double.parseDouble(paid), 12313, !note.isEmpty());
        jobs.add(job);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, jobs.size());
    }

}
