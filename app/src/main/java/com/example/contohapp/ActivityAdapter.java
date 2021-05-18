package com.example.contohapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(int orderId);
    }

    private HashMap<Integer, HashMap<String, Object>> activities;
    private OnItemClickListener itemListener;

    public ActivityAdapter(HashMap<Integer, HashMap<String, Object>> orders, OnItemClickListener listener) {
        activities = orders;
        itemListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView activityTitleTextView;
        private TextView activityDateTextView;
        private TextView activityStatusTextView;
        private CardView cardView;

        public ViewHolder(View view) {
            super(view);
            activityTitleTextView = view.findViewById(R.id.row_activity_title);
            activityDateTextView = view.findViewById(R.id.row_activity_date);
            activityStatusTextView = view.findViewById(R.id.row_activity_status);
            cardView = view.findViewById(R.id.row_activity_cardView);
        }

        public TextView getActivityTitleTextView() {
            return activityTitleTextView;
        }

        public TextView getActivityDateTextView() {
            return activityDateTextView;
        }

        public TextView getActivityStatusTextView() {
            return activityStatusTextView;
        }

        public CardView getCardView() {
            return cardView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_activity, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (activities.size() > 0) {
            Object[] orderIds = activities.keySet().toArray();
            viewHolder.getCardView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.onItemClick((int) activities.get(orderIds[position]).get("id_pesanan"));
                }
            });
            viewHolder.getActivityTitleTextView().setText(activities.get(orderIds[position]).get("nama_salon").toString());
            viewHolder.getActivityDateTextView().setText(activities.get(orderIds[position]).get("waktu").toString());
            if (position == 0) {
                viewHolder.getActivityStatusTextView().setText("Ongoing");
            } else {
                viewHolder.getActivityStatusTextView().setText("");
            }

        };

        }

    @Override
    public int getItemCount() {
        return activities.size();
    }
}
