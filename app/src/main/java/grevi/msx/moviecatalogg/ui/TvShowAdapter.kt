package grevi.msx.moviecatalogg.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import grevi.msx.moviecatalogg.R
import grevi.msx.moviecatalogg.model.TvShow
import kotlinx.android.synthetic.main.list_item_tvshow.view.*

class TvShowAdapter(val tvshow: ArrayList<TvShow>) : RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {

    private var onItemClickCallback : OnItemClickCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_tvshow, parent, false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int = tvshow.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(tvshow[position])
    }

    fun setOnItemClickCallback(onItemClickCallback : OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(tvShow: TvShow) {
            with(itemView) {
                Glide.with(itemView.context).load(tvShow.imgTv).apply(RequestOptions()).override(200, 200).into(img_tvshow)
                nama_tvshow.text = tvShow.namaTv
                genre_tvshow.text = tvShow.genreTv
                desc_tvshow.text = tvShow.descTv

                itemView.setOnClickListener{onItemClickCallback?.onItemClicked(tvShow)}
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data : TvShow)
    }
}