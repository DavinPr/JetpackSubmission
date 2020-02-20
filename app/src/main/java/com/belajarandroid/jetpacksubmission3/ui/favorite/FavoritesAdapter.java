package com.belajarandroid.jetpacksubmission3.ui.favorite;

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

public class FavoritesAdapter extends PagedListAdapter<FilmEntity, FavoritesAdapter.FavoritesViewHolder> {

    private final FavoriteFragmentCallback callback;

    FavoritesAdapter(FavoriteFragmentCallback callback) {
        super(DIFF_CALLBACK);
        this.callback = callback;
    }

    public FilmEntity getSwipedData(int swipedPosition) {
        return getItem(swipedPosition);
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
    public FavoritesAdapter.FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.FavoritesViewHolder holder, int position) {
        FilmEntity filmEntity = getItem(position);
        if (filmEntity != null) {
            holder.bind(filmEntity);
        }
    }

    class FavoritesViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvGenre;
        final TextView tvDate;
        final TextView tvRate;
        final ImageView imgPoster;

        FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.list_title);
            tvGenre = itemView.findViewById(R.id.list_genre);
            tvDate = itemView.findViewById(R.id.list_date);
            tvRate = itemView.findViewById(R.id.list_rating);
            imgPoster = itemView.findViewById(R.id.list_image);
        }

        void bind(FilmEntity entity) {
            tvTitle.setText(entity.getFilmTitle());
            tvGenre.setText(entity.getFilmGenre());
            tvDate.setText(entity.getFilmDate());
            tvRate.setText(entity.getFilmRate());

            Glide.with(itemView.getContext())
                    .load(BuildConfig.TMDB_POSTER + entity.getFilmPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                    .into(imgPoster);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, entity.getFilmId());
                intent.putExtra(DetailActivity.EXTRA_TYPE, entity.getFilmType());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
