package com.belajarandroid.jetpacksubmission3.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.belajarandroid.jetpacksubmission3.BuildConfig;
import com.belajarandroid.jetpacksubmission3.R;
import com.belajarandroid.jetpacksubmission3.data.FilmEntity;
import com.belajarandroid.jetpacksubmission3.viewmodel.ViewModelFactory;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_TYPE = "extra_type";
    private TextView tvTitle, tvDate, tvRating, tvPopularity, tvOverview;
    private TextView tvGenre, tvLang;
    private ImageView imgPoster, imgBackdrop;
    private ImageButton btnBack;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //data
        tvTitle = findViewById(R.id.detail_title);
        tvDate = findViewById(R.id.detail_date);
        tvRating = findViewById(R.id.detail_rating);
        tvPopularity = findViewById(R.id.detail_popularity);
        tvOverview = findViewById(R.id.detail_overview);
        tvGenre = findViewById(R.id.detail_genre);
        tvLang = findViewById(R.id.detail_lang);
        imgPoster = findViewById(R.id.detail_poster);
        imgBackdrop = findViewById(R.id.detail_backdrop);
        btnBack = findViewById(R.id.detail_back);
        progressBar = findViewById(R.id.progress_bar);

        String detailType = getIntent().getStringExtra(EXTRA_TYPE);
        String detailId = getIntent().getStringExtra(EXTRA_ID);
        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailViewModel viewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        if (detailType != null) {
            if (detailType.equals("movie")) {
                if (detailId != null) {
                    progressBar.setVisibility(View.VISIBLE);
                    viewModel.getDetail(detailId, detailType).observe(this, filmEntity -> {
                        progressBar.setVisibility(View.GONE);
                        setDetailData(filmEntity);
                    });
                }
            } else if (detailType.equals("tv")) {
                if (detailId != null) {
                    progressBar.setVisibility(View.VISIBLE);
                    viewModel.getDetail(detailId, detailType).observe(this, filmEntity -> {
                        progressBar.setVisibility(View.GONE);
                        setDetailData(filmEntity);
                    });
                }
            }
        }


    }

    private void setDetailData(FilmEntity filmEntity) {
        //init data
        imgPoster.setClipToOutline(true);
        imgBackdrop.setAlpha(0.8f);

        tvTitle.setText(filmEntity.getFilmTitle());
        tvDate.setText(filmEntity.getFilmDate());
        tvRating.setText(filmEntity.getFilmRate());
        tvPopularity.setText(filmEntity.getFilmPopularity());
        tvOverview.setText(filmEntity.getFilmOverview());
        tvGenre.setText(filmEntity.getFilmGenre());
        tvLang.setText(filmEntity.getFilmLang());

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
