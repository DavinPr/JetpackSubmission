package com.belajarandroid.jetpacksubmission3.ui.movie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission3.BuildConfig;
import com.belajarandroid.jetpacksubmission3.R;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.ui.detail.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieAdapter extends PagedListAdapter<FilmEntity, MovieAdapter.MovieViewHolder> {

    MovieAdapter() {
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<FilmEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FilmEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull FilmEntity oldItem, @NonNull FilmEntity newItem) {
                    return oldItem.getFilmId().equals(newItem.getFilmDate());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FilmEntity oldItem, @NonNull FilmEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        FilmEntity entity = getItem(position);
        if (entity != null) {
            holder.bind(entity);
        }
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView titleMovie;
        TextView dateMovie;
        TextView rateMovie;
        TextView genreMovie;

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
                intent.putExtra(DetailActivity.EXTRA_TYPE, "movie");
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
