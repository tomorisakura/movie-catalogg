package grevi.msx.moviecatalogg.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import grevi.msx.moviecatalogg.R
import grevi.msx.moviecatalogg.model.Movies
import kotlinx.android.synthetic.main.list_item_movies.view.*
import kotlin.collections.ArrayList

class MovieAdapter(private val movies : ArrayList<Movies>) : RecyclerView.Adapter<MovieAdapter.ListViewHolder>(){

    private var onItemClickCallback : OnItemClickCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movies, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movies: Movies)
        {
            with(itemView) {
                Glide.with(itemView.context).load(movies.imgMovies).apply(RequestOptions().override(200,200)).into(img_movies)
                nama_movies.text = movies.namaMovies
                genre_movies.text = movies.genreMovies
                desc_movies.text = movies.descMovies
                itemView.setOnClickListener{onItemClickCallback?.onItemClicked(movies)}
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data : Movies)
    }

}