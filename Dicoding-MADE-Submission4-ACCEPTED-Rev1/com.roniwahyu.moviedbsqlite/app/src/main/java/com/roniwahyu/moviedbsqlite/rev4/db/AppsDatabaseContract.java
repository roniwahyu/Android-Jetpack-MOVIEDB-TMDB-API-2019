package com.roniwahyu.moviedbsqlite.rev4.db;

import android.provider.BaseColumns;

class AppsDatabaseContract {

    static final class MovieColumns implements BaseColumns {
        static final String MOVIE_TABLE_NAME = "movie";

        static final String IDMOVIE = "id";
        static final String TITLE = "title";
        static final String OVERVIEW = "overview";
        static final String RELEASE_DATE= "release_date";
        static final String VOTE_AVERAGE = "vote_average";
        static final String POSTER_PATH_STRING = "poster_path_string";
        static final String BACKDROP_PATH_STRING = "backdrop_path_string";
    }
    static final class TvShowColumns implements BaseColumns {
        static final String TV_SHOW_TABLE_NAME = "tvshow";

        static final String IDTV = "id";
        static final String NAME = "name";
        static final String OVERVIEW = "overview";
        static final String FIRST_AIR_DATE= "first_air_date";
        static final String VOTE_AVERAGE = "vote_average";
        static final String POSTER_PATH_STRING = "poster_path_string";
        static final String BACKDROP_PATH_STRING = "backdrop_path_string";
    }
}
