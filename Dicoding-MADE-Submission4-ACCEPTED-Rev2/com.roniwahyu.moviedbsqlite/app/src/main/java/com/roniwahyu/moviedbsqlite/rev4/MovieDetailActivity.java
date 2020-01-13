package com.roniwahyu.moviedbsqlite.rev4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.roniwahyu.moviedbsqlite.rev4.db.AppsHelper;
import com.roniwahyu.moviedbsqlite.rev4.model.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    public static String DETAIL_MOVIE_EXTRA = "detail tv show extra";
    private Movie movie;
    @BindView(R.id.text_detail_title_movie)  TextView txtTitle;
    @BindView(R.id.text_detail_rating_movie)  TextView txtVoteAverage;
    @BindView(R.id.text_detail_calendar_movie)  TextView txtDate;
    @BindView(R.id.text_detail_description_movie)  TextView txtOverview;
    @BindView(R.id.image_detail_movie)  ImageView imgPoster;

    private Menu menu;
    private boolean isFavorite;

    private AppsHelper appsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);


        movie = getIntent().getParcelableExtra(DETAIL_MOVIE_EXTRA);

        appsHelper = AppsHelper.getInstance(getApplicationContext());
        appsHelper.open();

        setDetailMovieView();

        isFavorite = false;
        checkFavorite();

       
    }

    private void checkFavorite() {
        ArrayList<Movie> moviesInDatabase = appsHelper.getAllMovies();

        for (Movie movie: moviesInDatabase){

            if (this.movie.getId() == movie.getId()){
                isFavorite = true;
            }

            if (isFavorite == true) {
                break;
            }
        }
    }

    private void setDetailMovieView() {
        if (movie != null){
            setTitle(R.string.title_detail_movie);
            txtTitle.setText(movie.getTitle());
            txtVoteAverage.setText(String.valueOf(movie.getVote_average()));
            txtDate.setText(movie.getRelease_date());
            txtOverview.setText(movie.getOverview());
            Glide.with(getApplicationContext()).load(movie.getPoster_path_string()).into(imgPoster);
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

    private void favoriteButtonPressed(){
        if (isFavorite) {
            appsHelper.deleteMovie(movie.getId());

        } else {
            appsHelper.insertMovie(movie);
        }
        isFavorite = !isFavorite;
        setIconFavorite();
    }

    private void setIconFavorite(){
        if (isFavorite) {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_added_to_favorites));
        } else {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_add_to_favorites));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appsHelper.close();
    }
}
