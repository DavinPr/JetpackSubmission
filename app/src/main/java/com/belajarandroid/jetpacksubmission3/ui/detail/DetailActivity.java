package com.belajarandroid.jetpacksubmission3.ui.detail;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
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
    private ImageView imgPoster;
    private ImageView imgBackdrop;
    private ProgressBar progressBar;
    private DetailViewModel viewModel;
    private Toolbar toolbar;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String detailType = getIntent().getStringExtra(EXTRA_TYPE);
        String detailId = getIntent().getStringExtra(EXTRA_ID);

        init();
        initViewModel();
        getData(detailType, detailId);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;
        viewModel.getDetail.observe(this, filmEntity -> {
            if (filmEntity != null) {
                switch (filmEntity.status) {
                    case LOADING:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (filmEntity.data != null) {
                            progressBar.setVisibility(View.GONE);
                            boolean state = filmEntity.data.isFavorited();
                            setFavoriteState(state);
                        }
                        break;
                    case ERROR:
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorite) {
            viewModel.setFavorite();
            Toast.makeText(this, "Added to favorite!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        tvTitle = findViewById(R.id.detail_title);
        tvDate = findViewById(R.id.detail_date);
        tvRating = findViewById(R.id.detail_rating);
        tvPopularity = findViewById(R.id.detail_popularity);
        tvOverview = findViewById(R.id.detail_overview);
        tvGenre = findViewById(R.id.detail_genre);
        tvLang = findViewById(R.id.detail_lang);
        imgPoster = findViewById(R.id.detail_poster);
        imgBackdrop = findViewById(R.id.detail_backdrop);
        progressBar = findViewById(R.id.progress_bar);
        toolbar = findViewById(R.id.toolbar);
    }

    private void getData(String type, String id) {

        if (type != null) {
            viewModel.setType(type);
            if (type.equals("movie")) {
                if (id != null) {
                    viewModel.setFilmId(id);
                    viewModel.getDetail.observe(this, filmEntity -> {
                        if (filmEntity != null) {
                            switch (filmEntity.status) {
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
                        if (filmEntity != null) {
                            switch (filmEntity.status) {
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
        tvDate.setText(filmEntity.getFilmDate());
        tvRating.setText(filmEntity.getFilmRate());
        tvPopularity.setText(filmEntity.getFilmPopularity());
        tvOverview.setText(filmEntity.getFilmOverview());
        tvGenre.setText(filmEntity.getFilmGenre());
        tvLang.setText(filmEntity.getFilmLang());
        setSupportActionBar(toolbar);
        toolbar.setTitle(null);

        Glide.with(DetailActivity.this).
                load(BuildConfig.TMDB_POSTER + filmEntity.getFilmPoster()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                .into(imgPoster);

        Glide.with(DetailActivity.this).
                load(BuildConfig.TMDB_BACKDROP + filmEntity.getFilmBackdrop()).
                apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                .into(imgBackdrop);
    }

    private void setFavoriteState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_favorite);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorited));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite));
        }
    }

    private void initViewModel() {
        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);
    }
}
