package com.belajarandroid.jetpacksubmission3.ui.favorite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    private RecyclerView rvFavorites;
    private ProgressBar progressBar;
    private ToggleButton tgMovie, tgShow;


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
        tgMovie = view.findViewById(R.id.toggle_movies);
        tgShow = view.findViewById(R.id.toggle_show);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tgMovie.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                tgShow.setChecked(false);
            }
        });

        tgShow.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                tgMovie.setChecked(false);
            }
        });
    }


}
