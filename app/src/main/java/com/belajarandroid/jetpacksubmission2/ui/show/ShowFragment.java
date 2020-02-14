package com.belajarandroid.jetpacksubmission2.ui.show;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission2.R;
import com.belajarandroid.jetpacksubmission2.viewmodel.ViewModelFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {
    private RecyclerView rvShow;
    private ProgressBar progressBar;

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
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(Bundle savedStateInstance) {
        super.onActivityCreated(savedStateInstance);
        ShowAdapter showAdapter = new ShowAdapter();

        //load data from viewmodel
        ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
        ShowViewModel viewModel = new ViewModelProvider(this, factory).get(ShowViewModel.class);
        progressBar.setVisibility(View.VISIBLE);
        viewModel.getShow().observe(this, filmEntities -> {
            progressBar.setVisibility(View.GONE);
            showAdapter.setShow(filmEntities);
            showAdapter.notifyDataSetChanged();
        });

        rvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        rvShow.setHasFixedSize(true);
        rvShow.setAdapter(showAdapter);
    }

}
