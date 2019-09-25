package com.example.rickandmortyapp;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.rickandmortyapp.DetailActivity.EXTRA_GENDER;
import static com.example.rickandmortyapp.DetailActivity.EXTRA_NAME;
import static com.example.rickandmortyapp.DetailActivity.EXTRA_SPECIES;
import static com.example.rickandmortyapp.DetailActivity.EXTRA_STATUS;
import static com.example.rickandmortyapp.DetailActivity.EXTRA_TYPE;
import static com.example.rickandmortyapp.DetailActivity.EXTRA_URL;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private ArrayList<Modelo> modeloArrayList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Modelo model = modeloArrayList.get(position);
        holder.textView.setText(model.getName());
        Picasso.with(context).load(model.getImageURL()).fit().centerInside().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modeloArrayList.size();
    }

    public Adapter(Context context, ArrayList<Modelo> modeloArrayList) {
        this.context = context;
        this.modeloArrayList = modeloArrayList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view_name);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION) {
                Modelo model = modeloArrayList.get(position);
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(EXTRA_URL, model.getImageURL());
                intent.putExtra(EXTRA_NAME, model.getName());
                intent.putExtra(EXTRA_STATUS, model.getStatus());
                intent.putExtra(EXTRA_SPECIES, model.getSpecies());
                intent.putExtra(EXTRA_TYPE, model.getType());
                intent.putExtra(EXTRA_GENDER, model.getGender());
                context.startActivity(intent);
            }
        }
    }
}
