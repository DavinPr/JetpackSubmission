package com.belajarandroid.jetpacksubmission3.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;
import com.belajarandroid.jetpacksubmission3.data.FilmRepository;
import com.belajarandroid.jetpacksubmission3.vo.Resource;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<String> filmId = new MutableLiveData<>();
    private String type;
    private FilmRepository filmRepository;

    public DetailViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public LiveData<Resource<FilmEntity>> getDetail = Transformations.switchMap(filmId,
            mFilmId -> {
                LiveData<Resource<FilmEntity>> filmEntity;
                if (type.equals("movie")) {
                    filmEntity = filmRepository.getDetailMovie(getFilmId());
                } else {
                    filmEntity = filmRepository.getDetailShow(getFilmId());
                }
                return filmEntity;
            });

    public String getFilmId() {
        return this.filmId.getValue();
    }

    public void setFilmId(String filmId) {
        this.filmId.setValue(filmId);
    }

    public void setType(String type) {
        this.type = type;
    }

    void setFavorite(){
        Resource<FilmEntity> detailResource = getDetail.getValue();
        if (detailResource != null){
            FilmEntity filmEntity = detailResource.data;
            final boolean newState = !filmEntity.isFavorited();
            filmRepository.setFilmFavorite(filmEntity, newState);
        }
    }

}
