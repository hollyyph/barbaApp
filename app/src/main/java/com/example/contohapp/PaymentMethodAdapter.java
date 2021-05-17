package com.example.contohapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(String item);
    }

    private String[] paymentMethodNames;
    private int[] paymentMethodImages;
    private OnItemClickListener itemListener;

    public PaymentMethodAdapter(String[] names, int[] images, OnItemClickListener listener) {
        paymentMethodNames = names;
        paymentMethodImages = images;
        itemListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView paymentMethodTextView;
        private ImageView paymentMethodImageView;
        private CardView cardView;

        public ViewHolder(View view) {
            super(view);
            paymentMethodTextView = view.findViewById(R.id.row_paymentmethod_methodName);
            paymentMethodImageView = view.findViewById(R.id.row_paymentmethod_methodImage);
            cardView = view.findViewById(R.id.row_paymentmethod_cardView);
        }

        public TextView getTextView() {
            return paymentMethodTextView;
        }
        public ImageView getImageView() {
            return paymentMethodImageView;
        }
        public CardView getCardView() {
            return cardView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_payment_method, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.onItemClick(paymentMethodNames[position]);
            }
        });

        viewHolder.getTextView().setText(paymentMethodNames[position]);
        viewHolder.getImageView().setImageResource(paymentMethodImages[position]);
    }

    @Override
    public int getItemCount() {
        return paymentMethodNames.length;
    }
}
