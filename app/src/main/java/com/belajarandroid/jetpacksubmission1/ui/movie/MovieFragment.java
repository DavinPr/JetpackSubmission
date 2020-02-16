package com.belajarandroid.jetpacksubmission1.ui.movie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission1.R;
import com.belajarandroid.jetpacksubmission1.data.FilmEntity;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvMovies;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        rvMovies = view.findViewById(R.id.rv_movies);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            MovieViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MovieViewModel.class);
            List<FilmEntity> movie = viewModel.getCourse();

            MovieAdapter adapter = new MovieAdapter();
            adapter.setMovie(movie);

            rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovies.setHasFixedSize(true);
            rvMovies.setAdapter(adapter);
        }
    }

}
