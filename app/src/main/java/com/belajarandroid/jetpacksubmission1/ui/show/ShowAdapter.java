package com.belajarandroid.jetpacksubmission1.ui.show;

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

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder> {
    private List<FilmEntity> list = new ArrayList<>();

    void setShow(List<FilmEntity> listShow) {
        if (listShow == null) return;
        list.clear();
        list.addAll(listShow);
    }

    @NonNull
    @Override
    public ShowAdapter.ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ShowViewHolder holder, int position) {
        FilmEntity showEntity = list.get(position);
        holder.bind(showEntity);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ShowViewHolder extends RecyclerView.ViewHolder {
        ImageView posterShow;
        TextView titleShow, dateShow, genreShow, rateShow;

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
                intent.putExtra(DetailActivity.EXTRA_TYPE, entity.getFilmType());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
