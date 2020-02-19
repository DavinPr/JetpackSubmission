package com.belajarandroid.jetpacksubmission3.ui.show;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.belajarandroid.jetpacksubmission3.R;
import com.belajarandroid.jetpacksubmission3.viewmodel.ViewModelFactory;


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
        viewModel.getShow().observe(this, filmEntities -> {
            if (filmEntities != null) {
                switch (filmEntities.status) {
                    case LOADING:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        progressBar.setVisibility(View.GONE);
                        showAdapter.submitList(filmEntities.data);
                        showAdapter.notifyDataSetChanged();
                        break;
                    case ERROR:
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getContext(), "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        rvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        rvShow.setHasFixedSize(true);
        rvShow.setAdapter(showAdapter);
    }

}
