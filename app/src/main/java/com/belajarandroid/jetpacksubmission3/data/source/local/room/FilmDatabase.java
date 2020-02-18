package com.belajarandroid.jetpacksubmission3.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.belajarandroid.jetpacksubmission3.data.source.local.entity.FilmEntity;

@Database(entities = FilmEntity.class,
        version = 1,
        exportSchema = false)
public abstract class FilmDatabase extends RoomDatabase {
    public abstract FilmDao filmDao();

    private static volatile FilmDatabase INSTANCE;

    public static FilmDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (FilmDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FilmDatabase.class, "Films.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
