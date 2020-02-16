package com.belajarandroid.jetpacksubmission1.ui.movie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission1.BuildConfig;
import com.belajarandroid.jetpacksubmission1.R;
import com.belajarandroid.jetpacksubmission1.data.FilmEntity;
import com.belajarandroid.jetpacksubmission1.ui.detail.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<FilmEntity> listMovie = new ArrayList<>();

    void setMovie(List<FilmEntity> list) {
        if (listMovie == null) return;
        listMovie.clear();
        listMovie.addAll(list);
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        FilmEntity entity = listMovie.get(position);
        holder.bind(entity);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView titleMovie, dateMovie, rateMovie, genreMovie;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.list_image);
            titleMovie = itemView.findViewById(R.id.list_title);
            dateMovie = itemView.findViewById(R.id.list_date);
            rateMovie = itemView.findViewById(R.id.list_rating);
            genreMovie = itemView.findViewById(R.id.list_genre);
        }

        void bind(FilmEntity filmEntity) {
            titleMovie.setText(filmEntity.getFilmTitle());
            dateMovie.setText(filmEntity.getFilmDate());
            rateMovie.setText(filmEntity.getFilmRate());
            genreMovie.setText(filmEntity.getFilmGenre());

            Glide.with(itemView.getContext())
                    .load(BuildConfig.TMDB_POSTER + filmEntity.getFilmPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                    .into(imgMovie);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, filmEntity.getFilmId());
                intent.putExtra(DetailActivity.EXTRA_TYPE, filmEntity.getFilmType());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
