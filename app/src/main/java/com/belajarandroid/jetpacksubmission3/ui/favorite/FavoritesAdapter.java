package com.belajarandroid.jetpacksubmission3.ui.favorite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission3.R;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {
    @NonNull
    @Override
    public FavoritesAdapter.FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.FavoritesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FavoritesViewHolder extends RecyclerView.ViewHolder{
        FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
