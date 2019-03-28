package com.najafi.ali.personalmanagement.ModelForPays;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.Utils.EnglishToPersian;

import java.util.List;

public class PaysAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Pays> paysList;

    public PaysAdapter(Context context, List<Pays> paysList) {
        this.context = context;
        this.paysList = paysList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_of_pays, viewGroup, false);

        return new PaysAdapter.VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int posiiton) {
        Pays pay = paysList.get(posiiton);
        ((VH) viewHolder).bind(pay);
    }

    @Override
    public int getItemCount() {
        return paysList == null ? 0 : paysList.size();
    }

    public void addItem(String price, String duration) {
        Pays pay = new Pays(Double.parseDouble(price), Double.parseDouble(duration), "1399/12/30");
        paysList.add(pay);
        notifyItemInserted(paysList.size() - 1);

    }

    public static class VH extends RecyclerView.ViewHolder {

        TextView txtCost;
        TextView txtDate;
        TextView txtDuration;

        public VH(@NonNull View itemView) {
            super(itemView);
            txtCost = itemView.findViewById(R.id.txt_pay_cost);
            txtDate = itemView.findViewById(R.id.txt_date_pay);
            txtDuration = itemView.findViewById(R.id.txt_time_pay);
        }

        public void bind(Pays pays) {
            txtCost.setText(EnglishToPersian.englishToPersian(String.valueOf(pays.getPrice())));
            txtDate.setText(EnglishToPersian.englishToPersian(pays.getDate()));
            txtDuration.setText(EnglishToPersian.englishToPersian(String.valueOf(pays.getDuration())));
        }
    }
}
