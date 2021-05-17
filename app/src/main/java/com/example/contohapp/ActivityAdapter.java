package com.example.contohapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(String item);
    }

    private String[] activityIds;
    private String[] activityNames;
    private String[] activityDates;
    private String[] activityStatuses;
    private OnItemClickListener itemListener;

    public ActivityAdapter(String[] ids, String[] names, String[] dates, String[] statuses, OnItemClickListener listener) {
        activityIds = ids;
        activityNames = names;
        activityDates = dates;
        activityStatuses = statuses;
        itemListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView activityTitleTextView;
        private TextView activityDateTextView;
        private TextView activityStatusTextView;

        public ViewHolder(View view) {
            super(view);
            activityTitleTextView = view.findViewById(R.id.row_activity_title);
            activityDateTextView = view.findViewById(R.id.row_activity_date);
            activityStatusTextView = view.findViewById(R.id.row_activity_status);
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

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_activity, parent, false);

        return new ViewHolder(view);
    }

    // ini jg apa :(
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.onItemClick(activityNames[position]);
            }
        });

        viewHolder.getTextView().setText(activityNames[position]);
//        viewHolder.getImageView().setImageResource(paymentMethodImages[position]);
    }

    // ini apa :(
    @Override
    public int getItemCount() {
//        return paymentMethodNames.length;
        return activityIds.length;
    };
}
