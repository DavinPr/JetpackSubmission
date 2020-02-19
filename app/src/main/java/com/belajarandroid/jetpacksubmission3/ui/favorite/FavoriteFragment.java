package com.belajarandroid.jetpacksubmission3.ui.favorite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission3.R;
import com.belajarandroid.jetpacksubmission3.viewmodel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment implements FavoriteFragmentCallback{
    private RecyclerView rvFavorites;
    private ProgressBar progressBar;
    private RadioButton rbMovies;
    private RadioButton rbShows;


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
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFavorites = view.findViewById(R.id.rv_favorites);
        progressBar = view.findViewById(R.id.progress_bar);
        rbMovies = view.findViewById(R.id.rb_movies);
        rbShows = view.findViewById(R.id.rb_shows);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            FavoriteViewModel viewModel = new ViewModelProvider(this, factory).get(FavoriteViewModel.class);

            FavoritesAdapter adapter = new FavoritesAdapter(this);
            progressBar.setVisibility(View.VISIBLE);
            viewModel.getMovieFavorites().observe(this, filmEntities -> {
                progressBar.setVisibility(View.GONE);
                adapter.submitList(filmEntities);
                adapter.notifyDataSetChanged();
            });

            rbMovies.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    rbShows.setChecked(false);
                    viewModel.getMovieFavorites().observe(this, filmEntities -> {
                        progressBar.setVisibility(View.GONE);
                        adapter.submitList(filmEntities);
                        adapter.notifyDataSetChanged();
                    });
                }
            });

            rbShows.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    rbMovies.setChecked(false);
                    viewModel.getShowFavorites().observe(this, filmEntities -> {
                        progressBar.setVisibility(View.GONE);
                        adapter.submitList(filmEntities);
                        adapter.notifyDataSetChanged();
                    });
                }
            });

            rvFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
            rvFavorites.setHasFixedSize(true);
            rvFavorites.setAdapter(adapter);
        }
    }


}
