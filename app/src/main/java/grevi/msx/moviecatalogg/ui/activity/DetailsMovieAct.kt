package grevi.msx.moviecatalogg.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import grevi.msx.moviecatalogg.R
import grevi.msx.moviecatalogg.model.Movies
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovieAct : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvNamaMovies : TextView

    companion object {
        const val MOVIE_OBJECT = "movie_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        setDatasMovie()
        btn_wish_movies.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(this, "Menambahkan ${tvNamaMovies.text}\nke Wishlist", Toast.LENGTH_SHORT).show()
    }

    private fun setDatasMovie() {
        tvNamaMovies = findViewById(R.id.tv_nama_movies)
        val imgMovies : ImageView = findViewById(R.id.img_poster)
        val tvGenreMovies : TextView = findViewById(R.id.tv_genre_movies)
        val tvLikesMovies : TextView = findViewById(R.id.tv_likes_movies)
        val tvRatingMovies : TextView = findViewById(R.id.tv_rating_movies)
        val tvSalesMovies : TextView = findViewById(R.id.tv_sales_movies)
        val tvDescMovies : TextView = findViewById(R.id.tv_desc_movies)

        val movie = intent.getParcelableExtra(MOVIE_OBJECT) as Movies
        imgMovies.setImageResource(movie.imgMovies)
        tvNamaMovies.text = movie.namaMovies
        tvGenreMovies.text = movie.genreMovies
        tvLikesMovies.text = movie.likesMovies
        tvRatingMovies.text = movie.ratingMovies
        tvSalesMovies.text = movie.salesMovies
        tvDescMovies.text = movie.descMovies
    }
}
