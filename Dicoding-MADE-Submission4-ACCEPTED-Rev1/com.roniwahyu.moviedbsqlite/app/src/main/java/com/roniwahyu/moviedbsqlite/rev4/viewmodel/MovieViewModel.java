package com.roniwahyu.moviedbsqlite.rev4.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.roniwahyu.moviedbsqlite.rev4.BuildConfig;
import com.roniwahyu.moviedbsqlite.rev4.model.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MovieViewModel extends ViewModel {
//    private final String API_KEY= BuildConfig.TMDB_API_KEY;

    private static final String URLFULL = BuildConfig.URL_MOVIE_AND_TV_SHOW_BASE
            + BuildConfig.URL_MOVIE_DISCOVER
            + "?api_key="
            + BuildConfig.TMDB_API_KEY +
            "&language=en-US";

    private MutableLiveData<ArrayList<Movie>> listMovies = new MutableLiveData<>();

    public void setMovies() {
        final ArrayList<Movie> listItems = new ArrayList<>();

        AsyncHttpClient client = new AsyncHttpClient();
        String url = URLFULL;
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject movie = list.getJSONObject(i);
                        Movie movieItem = new Movie(movie);
                        listItems.add(movieItem);
                    }

                    listMovies.postValue(listItems);

                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<Movie>> getMovies() {
        return listMovies;
    }
}
