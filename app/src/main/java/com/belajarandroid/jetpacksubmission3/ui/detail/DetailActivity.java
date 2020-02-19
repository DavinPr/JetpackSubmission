package com.belajarandroid.jetpacksubmission3.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.belajarandroid.jetpacksubmission3.BuildConfig;
import com.belajarandroid.jetpacksubmission3.R;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.viewmodel.ViewModelFactory;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_TYPE = "extra_type";
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvRating;
    private TextView tvPopularity;
    private TextView tvOverview;
    private TextView tvGenre;
    private TextView tvLang;
    private TextView tvToolbarTitle;
    private ImageView imgPoster;
    private ImageView imgBackdrop;
    private ImageButton btnBack;
    private ToggleButton toggleFavorite;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
        String detailType = getIntent().getStringExtra(EXTRA_TYPE);
        String detailId = getIntent().getStringExtra(EXTRA_ID);
        getData(detailType, detailId);

        toggleFavorite.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setFavoriteState(true);
            } else {
                setFavoriteState(false);
            }
        });
    }

    private void init() {
        tvTitle = findViewById(R.id.detail_title);
        tvDate = findViewById(R.id.detail_date);
        tvRating = findViewById(R.id.detail_rating);
        tvPopularity = findViewById(R.id.detail_popularity);
        tvOverview = findViewById(R.id.detail_overview);
        tvGenre = findViewById(R.id.detail_genre);
        tvLang = findViewById(R.id.detail_lang);
        tvToolbarTitle = findViewById(R.id.toolbar_title);
        imgPoster = findViewById(R.id.detail_poster);
        imgBackdrop = findViewById(R.id.detail_backdrop);
        btnBack = findViewById(R.id.detail_back);
        toggleFavorite = findViewById(R.id.favorite);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void getData(String type, String id) {
        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailViewModel viewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        if (type != null) {
            viewModel.setType(type);
            if (type.equals("movie")) {
                if (id != null) {
                    viewModel.setFilmId(id);
                    viewModel.getDetail.observe(this, filmEntity -> {
                        if (filmEntity != null){
                            switch (filmEntity.status){
                                case LOADING:
                                    progressBar.setVisibility(View.VISIBLE);
                                    break;
                                case SUCCESS:
                                    if (filmEntity.data != null) {
                                        progressBar.setVisibility(View.GONE);
                                        setDetailData(filmEntity.data);
                                    }
                                    break;
                                case ERROR:
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
                }
            } else if (type.equals("tv")) {
                if (id != null) {
                    viewModel.setFilmId(id);
                    viewModel.getDetail.observe(this, filmEntity -> {
                        if (filmEntity != null){
                            switch (filmEntity.status){
                                case LOADING:
                                    progressBar.setVisibility(View.VISIBLE);
                                    break;
                                case SUCCESS:
                                    if (filmEntity.data != null) {
                                        progressBar.setVisibility(View.GONE);
                                        setDetailData(filmEntity.data);
                                    }
                                    break;
                                case ERROR:
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
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
        tvToolbarTitle.setText(filmEntity.getFilmTitle());
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

    private void setFavoriteState(boolean state){
        if (state){
            toggleFavorite.setChecked(true);
            Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show();
        }else {
            toggleFavorite.setChecked(false);
            Toast.makeText(this, "Removed from favorites", Toast.LENGTH_SHORT).show();
        }
    }
}
