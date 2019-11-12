package grevi.msx.moviecatalogg.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import grevi.msx.moviecatalogg.R
import grevi.msx.moviecatalogg.model.TvShow
import kotlinx.android.synthetic.main.activity_details_tvshow.*

class DetailsTvshow : AppCompatActivity(), View.OnClickListener {

    private lateinit var namaTvshow : TextView
    companion object {
        val TV_EXTRA = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_tvshow)
        setDataTvshows()
        btn_wish_tv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(this, "Menambahkan ${namaTvshow.text}\nke Wishlist", Toast.LENGTH_SHORT).show()
    }

    private fun setDataTvshows() {
        namaTvshow = findViewById(R.id.tv_nama_tv)
        val imgTvshow : ImageView = findViewById(R.id.img_poster_tv)
        val genreTvshow : TextView = findViewById(R.id.tv_genre_tv)
        val likesTvshow : TextView = findViewById(R.id.tv_likes_tv)
        val ratingTvshow : TextView = findViewById(R.id.tv_rating_tv)
        val watchTvshow : TextView = findViewById(R.id.tv_watch_tv)
        val descTvshow : TextView = findViewById(R.id.tv_desc_tv)

        val tvShow = intent.getParcelableExtra(TV_EXTRA) as TvShow
        imgTvshow.setImageResource(tvShow.imgTv)
        namaTvshow.text = tvShow.namaTv
        genreTvshow.text = tvShow.genreTv
        likesTvshow.text = tvShow.likesTv
        ratingTvshow.text = tvShow.ratingTv
        watchTvshow.text = tvShow.watchTv
        descTvshow.text = tvShow.descTv
    }

}
