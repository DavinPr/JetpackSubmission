package com.belajarandroid.jetpacksubmission1.ui.show;


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
public class ShowFragment extends Fragment {
    private RecyclerView rvShow;

    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedStateInstance) {
        super.onViewCreated(view, savedStateInstance);

        rvShow = view.findViewById(R.id.rv_shows);
    }

    @Override
    public void onActivityCreated(Bundle savedStateInstance) {
        super.onActivityCreated(savedStateInstance);
        ShowAdapter showAdapter = new ShowAdapter();

        //load data from viewmodel
        ShowViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ShowViewModel.class);
        List<FilmEntity> show = viewModel.getShow();
        showAdapter.setShow(show);

        rvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        rvShow.setHasFixedSize(true);
        rvShow.setAdapter(showAdapter);
    }

}
