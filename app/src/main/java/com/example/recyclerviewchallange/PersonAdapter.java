package com.example.recyclerviewchallange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{
    public ArrayList<Person> people;
    public interface ItemClicked
    {
        void onItemClicked(int index);
    }
    ItemClicked activity;

    public PersonAdapter (Context context, ArrayList<Person> list)
    {
        people = list;
        activity = (ItemClicked) context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvModel, tvOwner;
        ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvOwner = itemView.findViewById(R.id.tvOwner);
            ivImage = itemView.findViewById(R.id.ivImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvOwner.setText(people.get(position).getName());
        holder.tvModel.setText(people.get(position).getModel());

        if(people.get(position).getLogo().equals("nissan"))
        {
            holder.ivImage.setImageResource(R.drawable.nissan);
        }
        else if(people.get(position).getLogo().equals("mercedes"))
        {
            holder.ivImage.setImageResource(R.drawable.mercedes);
        }
        else {
            holder.ivImage.setImageResource(R.drawable.volkswagen);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
