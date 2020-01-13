package com.roniwahyu.moviedbsqlite.rev4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.roniwahyu.moviedbsqlite.rev4.db.AppsHelper;
import com.roniwahyu.moviedbsqlite.rev4.model.TvShow;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TvShowDetailActivity extends AppCompatActivity {

    public static String DETAIL_TV_SHOW_EXTRA = "detail tv show extra";

    private TvShow tvShow;
    @BindView(R.id.text_detail_title_tv_show) TextView txtTitle;
    @BindView(R.id.text_detail_rating_tv_show) TextView txtVoteAverage;
    @BindView(R.id.text_detail_calendar_tv_show) TextView txtDate;
    @BindView(R.id.text_detail_description_tv_show) TextView txtOverview;
    @BindView(R.id.image_detail_tv_show) ImageView imgPoster;

    private Menu menu;
    private boolean isFavorite = false;
    private AppsHelper appsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);
        ButterKnife.bind(this);

        tvShow = getIntent().getParcelableExtra(DETAIL_TV_SHOW_EXTRA);
        setDetailMovieView();

        appsHelper = AppsHelper.getInstance(getApplicationContext());
        appsHelper.open();

        isFavorite = false;
        checkFavorite();
    }

    private void setDetailMovieView() {
        if (tvShow != null){
            setTitle(R.string.title_detail_tv_show);
            txtTitle.setText(tvShow.getName());
            txtVoteAverage.setText(String.valueOf(tvShow.getVote_average()));
            txtDate.setText(tvShow.getFirst_air_date());
            txtOverview.setText(tvShow.getOverview());
            Glide.with(getApplicationContext()).load(tvShow.getPoster_path_string()).into(imgPoster);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;

        setIconFavorite();

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_add_favorite_menu_detail) {
            favoriteButtonPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void checkFavorite() {
        ArrayList<TvShow> tvShowsInDatabase = appsHelper.getAllTvseries();

        for (TvShow tvShow: tvShowsInDatabase){

            if (this.tvShow.getId() == tvShow.getId()){
                isFavorite = true;
            }

            if (isFavorite) {
                break;
            }
        }
    }

    private void setIconFavorite(){
        if (isFavorite) {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_added_to_favorites));
        } else {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_add_to_favorites));
        }
    }

    private void favoriteButtonPressed(){
        if (isFavorite) {
            appsHelper.deleteTv(tvShow.getId());

        } else {
            appsHelper.insertTv(tvShow);
        }
        isFavorite = !isFavorite;
        setIconFavorite();
    }
}