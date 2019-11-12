package grevi.msx.moviecatalogg.ui


import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import grevi.msx.moviecatalogg.R
import grevi.msx.moviecatalogg.model.Movies
import grevi.msx.moviecatalogg.ui.activity.DetailsMovieAct
import kotlinx.android.synthetic.main.activity_details_movie.*
import kotlinx.android.synthetic.main.fragment_movies_fragments.*

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragments : Fragment() {

    private val movie = arrayListOf<Movies>()

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_movies_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_item_movies.setHasFixedSize(true)
        movie.addAll(getListMovies())
        createRecyclerView()
    }

    fun getListMovies() : ArrayList<Movies> {
        val dataNama = resources.getStringArray(R.array.data_nama_movies)
        val dataGenre = resources.getStringArray(R.array.data_genre_movies)
        val dataLikes = resources.getStringArray(R.array.data_likes_movies)
        val dataRating = resources.getStringArray(R.array.data_rating_movies)
        val dataSales = resources.getStringArray(R.array.data_kontent_movies)
        val dataDesc = resources.getStringArray(R.array.data_desc_movies)
        val dataImg = resources.obtainTypedArray(R.array.data_img_movies)

        val listMovie = ArrayList<Movies>()
        for (i in dataNama.indices) {
            val movies = Movies(
                dataImg.getResourceId(i,-1),
                dataNama[i],
                dataGenre[i],
                dataLikes[i],
                dataRating[i],
                dataSales[i],
                dataDesc[i]
            )
            listMovie.add(movies)
        }
        return listMovie
    }

    private fun createRecyclerView() {
        rv_item_movies.layoutManager = LinearLayoutManager(this.context)
        val movieAdapter = MovieAdapter(movie)
        rv_item_movies.adapter = movieAdapter
        movieAdapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Movies) {
                showDetailsMovies(data)
            }
        })
    }

    private fun showDetailsMovies(movies: Movies) {
        val mIntent = Intent(activity, DetailsMovieAct::class.java)
        mIntent.putExtra(DetailsMovieAct.MOVIE_OBJECT, movies)
        startActivity(mIntent)
    }

}
