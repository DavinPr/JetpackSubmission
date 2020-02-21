package com.belajarandroid.jetpacksubmission3.ui.favorite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission3.R;
import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.viewmodel.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    private RecyclerView rvFavorites;
    private ProgressBar progressBar;
    private RadioButton rbMovies;
    private RadioButton rbShows;
    private FavoriteViewModel viewModel;
    private FavoritesAdapter adapter;


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFavorites = view.findViewById(R.id.rv_favorites);
        progressBar = view.findViewById(R.id.progress_bar);
        rbMovies = view.findViewById(R.id.rb_movies);
        rbShows = view.findViewById(R.id.rb_shows);
        itemTouchHelper.attachToRecyclerView(rvFavorites);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            viewModel = new ViewModelProvider(this, factory).get(FavoriteViewModel.class);
            adapter = new FavoritesAdapter();

            progressBar.setVisibility(View.VISIBLE);
            viewModel.getMovieFavorites().observe(this, filmEntities -> {
                progressBar.setVisibility(View.GONE);
                adapter.submitList(filmEntities);
                adapter.notifyDataSetChanged();
            });

            rbMovies.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    rbShows.setChecked(false);
                    getMovieData();
                }
            });

            rbShows.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    rbMovies.setChecked(false);
                    getShowData();
                }
            });

            rvFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
            rvFavorites.setHasFixedSize(true);
            rvFavorites.setAdapter(adapter);
        }
    }

    private void getMovieData() {
        progressBar.setVisibility(View.VISIBLE);
        viewModel.getMovieFavorites().observe(this, filmEntities -> {
            progressBar.setVisibility(View.GONE);
            adapter.submitList(filmEntities);
            adapter.notifyDataSetChanged();
        });
    }

    private void getShowData() {
        progressBar.setVisibility(View.VISIBLE);
        viewModel.getShowFavorites().observe(this, filmEntities -> {
            progressBar.setVisibility(View.GONE);
            adapter.submitList(filmEntities);
            adapter.notifyDataSetChanged();
        });
    }

    private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                int swipedPosition = viewHolder.getAdapterPosition();
                FilmEntity filmEntity = adapter.getSwipedData(swipedPosition);
                viewModel.setFavorite(filmEntity);
                Snackbar snackbar = Snackbar.make(getView(), "Undo", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Ok", v -> viewModel.setFavorite(filmEntity));
                snackbar.show();
            }
        }
    });

}
