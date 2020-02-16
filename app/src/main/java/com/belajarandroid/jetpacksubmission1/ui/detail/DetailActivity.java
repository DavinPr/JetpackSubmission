package com.belajarandroid.jetpacksubmission1.ui.detail;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.belajarandroid.jetpacksubmission1.BuildConfig;
import com.belajarandroid.jetpacksubmission1.R;
import com.belajarandroid.jetpacksubmission1.data.FilmEntity;
import com.belajarandroid.jetpacksubmission1.utils.DataDummy;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_TYPE = "extra_type";
    private TextView tvTitle, tvDate, tvRuntime, tvStatus, tvAdult, tvRating, tvPopularity, tvOverview;
    private TextView tvBudgetSeason, tvEpisodeRevenue, tvGenre;
    private ImageView imgPoster, imgBackdrop;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //data
        tvTitle = findViewById(R.id.detail_title);
        tvDate = findViewById(R.id.detail_date);
        tvRuntime = findViewById(R.id.detail_runtime);
        tvStatus = findViewById(R.id.detail_status);
        tvAdult = findViewById(R.id.detail_extra);
        tvRating = findViewById(R.id.detail_rating);
        tvPopularity = findViewById(R.id.detail_popularity);
        tvOverview = findViewById(R.id.detail_overview);
        tvBudgetSeason = findViewById(R.id.detail_seasons_budget);
        tvEpisodeRevenue = findViewById(R.id.detail_episode_revenue);
        tvGenre = findViewById(R.id.detail_genre);
        imgPoster = findViewById(R.id.detail_poster);
        imgBackdrop = findViewById(R.id.detail_backdrop);
        btnBack = findViewById(R.id.detail_back);

        //field
        TextView tvAdultField = findViewById(R.id.tv_extra);
        TextView tvEpisodeField = findViewById(R.id.tv_episode_revenue);
        TextView tvSeasonField = findViewById(R.id.tv_seasons_budget);

        String detailType = getIntent().getStringExtra(EXTRA_TYPE);
        String detailId = getIntent().getStringExtra(EXTRA_ID);

        if (detailType != null) {
            if (detailType.equals("movie")) {
                tvAdultField.setText(getResources().getString(R.string.adult));
                tvSeasonField.setText(getResources().getString(R.string.budget));
                tvEpisodeField.setText(getResources().getString(R.string.revenue));

                if (detailId != null) {
                    for (int i = 0; i < DataDummy.generateDummyMovie().size(); i++) {
                        FilmEntity movie = DataDummy.generateDummyMovie().get(i);
                        if (movie.getFilmId().equals(detailId)) {
                            setDetailData(movie);
                        }
                    }
                }
            } else if (detailType.equals("tv")) {
                tvAdultField.setText(getResources().getString(R.string.in_production));
                tvSeasonField.setText(getResources().getString(R.string.seasons));
                tvEpisodeField.setText(getResources().getString(R.string.episode));

                if (detailId != null) {
                    for (int i = 0; i < DataDummy.generateDummyShow().size(); i++) {
                        FilmEntity filmEntity = DataDummy.generateDummyShow().get(i);
                        if (filmEntity.getFilmId().equals(detailId)) {
                            setDetailData(filmEntity);
                        }
                    }
                }
            }
        }


    }

    private void setDetailData(FilmEntity filmEntity) {

        imgPoster.setClipToOutline(true);
        imgBackdrop.setAlpha(0.8f);

        tvTitle.setText(filmEntity.getFilmTitle());
        tvDate.setText(filmEntity.getFilmDate());
        tvRuntime.setText(filmEntity.getFilmRuntime());
        tvStatus.setText(filmEntity.getFilmStatus());
        tvAdult.setText(filmEntity.getFilmAdult());
        tvRating.setText(filmEntity.getFilmRate());
        tvPopularity.setText(filmEntity.getFilmPopularity());
        tvOverview.setText(filmEntity.getFilmOverview());
        tvBudgetSeason.setText(filmEntity.getFilmBudget());
        tvEpisodeRevenue.setText(filmEntity.getFilmRevenue());
        tvGenre.setText(filmEntity.getFilmGenre());

        Glide.with(DetailActivity.this).
                load(BuildConfig.TMDB_POSTER + filmEntity.getFilmPoster()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                .into(imgPoster);

        Glide.with(DetailActivity.this).
                load(BuildConfig.TMDB_BACKDROP + filmEntity.getFilmBackdrop()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                .into(imgBackdrop);

        btnBack.setOnClickListener(v -> finish());
    }
}
