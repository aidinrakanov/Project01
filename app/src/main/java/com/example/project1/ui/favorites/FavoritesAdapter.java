package com.example.project1.ui.favorites;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.models.Models;
import com.example.project1.R;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolderFavorites> {

    List<Models> models;

    public Click_Interface onItemClick;

    public FavoritesAdapter(List<Models> models) {
        this.models = models;
    }


    @NonNull
    @Override
    public ViewHolderFavorites onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.favor_list, parent, false);
        return new ViewHolderFavorites(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavorites holder, int position) {

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolderFavorites extends RecyclerView.ViewHolder{
        public ViewHolderFavorites(@NonNull View itemView) {
            super(itemView);

        }
    }
}
