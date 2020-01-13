package com.roniwahyu.moviedbsqlite.rev4.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roniwahyu.moviedbsqlite.rev4.R;
import com.roniwahyu.moviedbsqlite.rev4.adapter.FavoriteMovieAdapter;
import com.roniwahyu.moviedbsqlite.rev4.db.AppsHelper;
import com.roniwahyu.moviedbsqlite.rev4.model.Movie;

import java.util.ArrayList;

public class FavoriteMovieFragment extends Fragment {

    private ArrayList<Movie> movies = new ArrayList<>();
    private AppsHelper appsHelper;
    private FavoriteMovieAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appsHelper = AppsHelper.getInstance(view.getContext());
        appsHelper.open();

        RecyclerView rvFavoriteFragmentMovies = view.findViewById(R.id.rv_fragment_favorite_movie);
        rvFavoriteFragmentMovies.setHasFixedSize(true);
        rvFavoriteFragmentMovies.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapter = new FavoriteMovieAdapter(view.getContext());
        adapter.setMovies(movies);
        rvFavoriteFragmentMovies.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        movies = appsHelper.getAllMovies();
        adapter.setData(movies);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        appsHelper.close();
    }
}
