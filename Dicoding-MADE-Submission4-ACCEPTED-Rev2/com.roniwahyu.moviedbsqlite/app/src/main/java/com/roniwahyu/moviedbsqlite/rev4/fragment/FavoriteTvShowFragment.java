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
import com.roniwahyu.moviedbsqlite.rev4.adapter.FavoriteTvShowAdapter;
import com.roniwahyu.moviedbsqlite.rev4.db.AppsHelper;
import com.roniwahyu.moviedbsqlite.rev4.model.TvShow;

import java.util.ArrayList;

public class FavoriteTvShowFragment extends Fragment {

    private ArrayList<TvShow> tvShows = new ArrayList<>();
    private AppsHelper appsHelper;
    private FavoriteTvShowAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appsHelper = AppsHelper.getInstance(view.getContext());
        appsHelper.open();

        RecyclerView rvFavoriteFragmentTvShows = view.findViewById(R.id.rv_fragment_favorite_tv_show);
        rvFavoriteFragmentTvShows.setHasFixedSize(true);
        rvFavoriteFragmentTvShows.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapter = new FavoriteTvShowAdapter(view.getContext());
        adapter.setTvShows(tvShows);
        rvFavoriteFragmentTvShows.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        tvShows = appsHelper.getAllTvseries();
        adapter.setData(tvShows);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        appsHelper.close();
    }
}
