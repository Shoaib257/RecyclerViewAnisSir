package com.example.recyclerviewanissir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    String[] title,desc;
    int[] countryImages;
    private static ClickListener clickListener;

    public MyAdapter(Context context, String[] title, String[] desc, int[] countryImages) {
        this.context = context;
        this.title = title;
        this.desc = desc;
        this.countryImages = countryImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleTextView.setText(title[position]);
        holder.descTextView.setText(desc[position]);
        holder.imageView.setImageResource(countryImages[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView titleTextView,descTextView;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView=itemView.findViewById(R.id.titleTextViewId);
            descTextView=itemView.findViewById(R.id.descTextViewId);
            imageView=itemView.findViewById(R.id.imageId);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return false;
        }
    }

    public interface ClickListener{
        void onItemClick(int position,View view);
        void onItemLongClick(int position,View view);
    }
    public void setOnItemClickListener(ClickListener clickListener){

        MyAdapter.clickListener=clickListener;
    }
}
