package com.example.project1.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project1.R;
import com.example.project1.models.Models;
import com.example.project1.ui.favorites.FavoritesAdapter;
import com.like.LikeButton;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    List<Models> model;

    public MainAdapter(List<Models> model) {
        this.model = model;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.card_list, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(model.get(position));
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        TextView name, adress, sInfo, cost;
        ImageView image;
        LikeButton likeButton;
        RatingBar ratingBar;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.card_image);
            cost = itemView.findViewById(R.id.card_cost);
            name = itemView.findViewById(R.id.card_text_name);
            adress = itemView.findViewById(R.id.card_adress_text);
            sInfo = itemView.findViewById(R.id.card_small_info);
            likeButton = itemView.findViewById(R.id.card_likebutton);
            ratingBar = itemView.findViewById(R.id.card_rating);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        public void onBind(Models models) {
            name.setText(models.getName());
            adress.setText(models.getAdress());
            cost.setText(String.valueOf(models.getCost()));
            sInfo.setText(models.getInfo());
            ratingBar.setRating(models.getRatingBar());
            Glide.with(itemView.getContext()).load(models.getImage()).into(image);
        }
    }
}
