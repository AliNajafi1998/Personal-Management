package com.najafi.ali.personalmanagement.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.najafi.ali.personalmanagement.Activities.Activity.Activity;
import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.Utils.EnglishToPersian;
import com.najafi.ali.personalmanagement.fragments.home.delete.DeleteDialogFragment;

import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.VH>   {

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
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_of_jobs, viewGroup, false);

        return new VH(view);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull final VH vh, final int position) {
        final Jobs job = jobs.get(position);

        vh.bind(job);

        listeners(vh.btnRemove, position);
    }


    @Override
    public int getItemCount() {
        return jobs.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull JobsAdapter.VH holder) {

    }



    public class VH extends RecyclerView.ViewHolder {

        AppCompatImageView imgJob;
        TextView txtDuration;
        TextView txtPrice;
        TextView txtName;
        TextView txtId;
        Button btnRemove;

        public VH(@NonNull View itemView) {
            super(itemView);
            imgJob = itemView.findViewById(R.id.img_job);
            txtDuration = itemView.findViewById(R.id.txt_duration_job);
            txtPrice = itemView.findViewById(R.id.txt_price_job);
            txtName = itemView.findViewById(R.id.txt_name_job);
            txtId = itemView.findViewById(R.id.txt_id_job);
            btnRemove = itemView.findViewById(R.id.btn_remove_item);
        }

        private void bind(Jobs job) {
            txtPrice.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getPrice())));
            txtDuration.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getDuration())));
            imgJob.setImageResource(job.getImage());
            txtId.setText(EnglishToPersian.englishToPersian(String.valueOf(job.getId())));
            txtName.setText(job.getName());

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

}
