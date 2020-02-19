package com.belajarandroid.jetpacksubmission3.ui.show;

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

public class ShowAdapter extends PagedListAdapter<FilmEntity, ShowAdapter.ShowViewHolder> {

    ShowAdapter() {
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<FilmEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FilmEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull FilmEntity oldItem, @NonNull FilmEntity newItem) {
                    return oldItem.getFilmId().equals(newItem.getFilmId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FilmEntity oldItem, @NonNull FilmEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public ShowAdapter.ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ShowViewHolder holder, int position) {
        FilmEntity showEntity = getItem(position);
        if (showEntity != null) {
            holder.bind(showEntity);
        }
    }

    class ShowViewHolder extends RecyclerView.ViewHolder {
        ImageView posterShow;
        TextView titleShow;
        TextView dateShow;
        TextView genreShow;
        TextView rateShow;

        ShowViewHolder(@NonNull View itemView) {
            super(itemView);
            posterShow = itemView.findViewById(R.id.list_image);
            titleShow = itemView.findViewById(R.id.list_title);
            dateShow = itemView.findViewById(R.id.list_date);
            genreShow = itemView.findViewById(R.id.list_genre);
            rateShow = itemView.findViewById(R.id.list_rating);
        }

        void bind(FilmEntity entity) {
            titleShow.setText(entity.getFilmTitle());
            dateShow.setText(entity.getFilmDate());
            genreShow.setText(entity.getFilmGenre());
            rateShow.setText(entity.getFilmRate());

            Glide.with(itemView.getContext())
                    .load(BuildConfig.TMDB_POSTER + entity.getFilmPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                    .into(posterShow);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, entity.getFilmId());
                intent.putExtra(DetailActivity.EXTRA_TYPE, "tv");
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
