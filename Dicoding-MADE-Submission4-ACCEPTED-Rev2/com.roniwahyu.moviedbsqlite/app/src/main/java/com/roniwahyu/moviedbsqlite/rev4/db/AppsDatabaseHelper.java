package com.roniwahyu.moviedbsqlite.rev4.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.MovieColumns;
import com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.TvShowColumns;
import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.MovieColumns.MOVIE_TABLE_NAME;
import static com.roniwahyu.moviedbsqlite.rev4.db.AppsDatabaseContract.TvShowColumns.TV_SHOW_TABLE_NAME;

public class AppsDatabaseHelper extends SQLiteOpenHelper {

    private static final String APPS_DB_NAME = "dbmovie";
    private static final int APPS_DB_VERSION = 2;

    private static final String SQL_CREATE_TABLE_MOVIE = String.format("CREATE TABLE %s" +
                    " (%s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL)",
            MOVIE_TABLE_NAME,
            MovieColumns.IDMOVIE,
            MovieColumns.TITLE,
            MovieColumns.OVERVIEW,
            MovieColumns.RELEASE_DATE,
            MovieColumns.VOTE_AVERAGE,
            MovieColumns.POSTER_PATH_STRING,
            MovieColumns.BACKDROP_PATH_STRING
    );
    private static final String SQL_CREATE_TABLE_TV_SHOW = String.format("CREATE TABLE %s" +
                    " (%s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL)",
            TV_SHOW_TABLE_NAME,
            TvShowColumns.IDTV,
            TvShowColumns.NAME,
            TvShowColumns.OVERVIEW,
            TvShowColumns.FIRST_AIR_DATE,
            TvShowColumns.VOTE_AVERAGE,
            TvShowColumns.POSTER_PATH_STRING,
            TvShowColumns.BACKDROP_PATH_STRING
    );

    AppsDatabaseHelper(Context context) {
        super(context, APPS_DB_NAME, null, APPS_DB_VERSION);
        Log.d("table_movie",SQL_CREATE_TABLE_MOVIE);
        Log.d("table_tv",SQL_CREATE_TABLE_TV_SHOW);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_TV_SHOW);
        db.execSQL(SQL_CREATE_TABLE_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MOVIE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TV_SHOW_TABLE_NAME);

        onCreate(db);
    }
}
