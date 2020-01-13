package com.roniwahyu.moviedbsqlite.rev4.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.roniwahyu.moviedbsqlite.rev4.model.movie.Movie;
import com.roniwahyu.moviedbsqlite.rev4.model.tvShow.TvShow;

import java.util.ArrayList;

import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.MovieColumns.IDMOVIE;
import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.MovieColumns.MOVIE_TABLE_NAME;
import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.MovieColumns.RELEASE_DATE;
import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.MovieColumns.TITLE;


import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.TvShowColumns.NAME;
import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.TvShowColumns.TV_SHOW_TABLE_NAME;
import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.TvShowColumns.IDTV;



public class AppsHelper {
    private static final String MOVIETABLE = MOVIE_TABLE_NAME;
    private static final String TVSHOWTABLE = TV_SHOW_TABLE_NAME;

    private static AppsHelper INSTANCE;
    private static AppsDatabaseHelper appsDatabaseHelper;
    private static SQLiteDatabase database;

    private AppsHelper(Context context){
        appsDatabaseHelper= new AppsDatabaseHelper(context);
    };
    public static AppsHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppsHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database=appsDatabaseHelper.getWritableDatabase();

    }
    public void close(){
        appsDatabaseHelper.close();
        if (database.isOpen()){
            database.close();
        }

    }

    public ArrayList<Movie> getAllMovies(){
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        Cursor movieCursor = database.query(MOVIETABLE,
                null,
                null,
                null,
                null,
                null,
                  IDMOVIE + "ASC",
                null
        );
        movieCursor.moveToFirst();
        Movie movie;
        if(movieCursor.getCount()>0){
            do{
                movie = new Movie();
                movie.setId(movieCursor.getInt(movieCursor.getColumnIndexOrThrow(IDMOVIE)));
                movie.setPoster_path_string(movieCursor.getString(movieCursor.getColumnIndexOrThrow(AppsDatabaseContract.MovieColumns.POSTER_PATH_STRING)));
                movie.setVote_average(movieCursor.getDouble(movieCursor.getColumnIndexOrThrow(AppsDatabaseContract.MovieColumns.VOTE_AVERAGE)));
                movie.setOverview(movieCursor.getString(movieCursor.getColumnIndexOrThrow(AppsDatabaseContract.MovieColumns.OVERVIEW)));
                movie.setRelease_date(movieCursor.getString(movieCursor.getColumnIndexOrThrow(RELEASE_DATE)));
                movie.setTitle(movieCursor.getString(movieCursor.getColumnIndexOrThrow(TITLE)));
                movie.setBackdrop_path_string(movieCursor.getString(movieCursor.getColumnIndexOrThrow(AppsDatabaseContract.MovieColumns.BACKDROP_PATH_STRING)));

                movieArrayList.add(movie);
                movieCursor.moveToNext();
            } while (!movieCursor.isAfterLast());
        }
        movieCursor.close();
        return movieArrayList;
    }
    public long insertMovie(Movie movie) {
        ContentValues args = new ContentValues();
        args.put(IDMOVIE, movie.getId());
        args.put(AppsDatabaseContract.MovieColumns.TITLE, movie.getTitle());
        args.put(AppsDatabaseContract.MovieColumns.OVERVIEW, movie.getOverview());
        args.put(AppsDatabaseContract.MovieColumns.RELEASE_DATE, movie.getRelease_date());
        args.put(AppsDatabaseContract.MovieColumns.VOTE_AVERAGE, movie.getVote_average());
        args.put(AppsDatabaseContract.MovieColumns.POSTER_PATH_STRING, movie.getPoster_path_string());
        args.put(AppsDatabaseContract.MovieColumns.BACKDROP_PATH_STRING, movie.getBackdrop_path_string());

        return database.insert(MOVIETABLE, null, args);
    }
    public int deleteMovie(int id) {
        return database.delete(MOVIETABLE, IDMOVIE + " = '" + id + "'", null);
    }


    public ArrayList<TvShow> getAllTvseries(){
        ArrayList<TvShow> tvShowArrayList = new ArrayList<>();
        Cursor tvshowCursor = database.query(TVSHOWTABLE,
                null,
                null,
                null,
                null,
                null,
                IDTV + "ASC",
                null
        );
        tvshowCursor.moveToFirst();
        TvShow tvshow;
        if (tvshowCursor.getCount() > 0) {
            do {
                tvshow = new TvShow();
                tvshow.setId(tvshowCursor.getInt(tvshowCursor.getColumnIndexOrThrow(IDTV)));
                tvshow.setName(tvshowCursor.getString(tvshowCursor.getColumnIndexOrThrow(NAME)));
                tvshow.setOverview(tvshowCursor.getString(tvshowCursor.getColumnIndexOrThrow(AppsDatabaseContract.TvShowColumns.OVERVIEW)));
                tvshow.setFirst_air_date(tvshowCursor.getString(tvshowCursor.getColumnIndexOrThrow(AppsDatabaseContract.TvShowColumns.FIRST_AIR_DATE)));
                tvshow.setVote_average(tvshowCursor.getDouble(tvshowCursor.getColumnIndexOrThrow(AppsDatabaseContract.TvShowColumns.VOTE_AVERAGE)));
                tvshow.setPoster_path_string(tvshowCursor.getString(tvshowCursor.getColumnIndexOrThrow(AppsDatabaseContract.TvShowColumns.POSTER_PATH_STRING)));
                tvshow.setBackdrop_path_string(tvshowCursor.getString(tvshowCursor.getColumnIndexOrThrow(AppsDatabaseContract.TvShowColumns.BACKDROP_PATH_STRING)));

                tvShowArrayList.add(tvshow);
                tvshowCursor.moveToNext();

            } while (!tvshowCursor.isAfterLast());
        }
        tvshowCursor.close();
        return tvShowArrayList;


    }
    public long insertTv(TvShow tvshow) {
        ContentValues args = new ContentValues();
        args.put(IDTV, tvshow.getId());
        args.put(NAME, tvshow.getName());
        args.put(AppsDatabaseContract.TvShowColumns.OVERVIEW, tvshow.getOverview());
        args.put(AppsDatabaseContract.TvShowColumns.FIRST_AIR_DATE, tvshow.getFirst_air_date());
        args.put(AppsDatabaseContract.TvShowColumns.VOTE_AVERAGE, tvshow.getVote_average());
        args.put(AppsDatabaseContract.TvShowColumns.POSTER_PATH_STRING, tvshow.getPoster_path_string());
        args.put(AppsDatabaseContract.TvShowColumns.BACKDROP_PATH_STRING, tvshow.getBackdrop_path_string());

        return database.insert(TVSHOWTABLE, null, args);
    }

    public int deleteTv(int id) {
        return database.delete(TVSHOWTABLE, IDTV + " = '" + id + "'", null);
    }

}
