package grevi.msx.moviecatalogg.ui


import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import grevi.msx.moviecatalogg.R
import grevi.msx.moviecatalogg.model.TvShow
import grevi.msx.moviecatalogg.ui.activity.DetailsTvshow
import kotlinx.android.synthetic.main.fragment_tv_show_fragments.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragments : Fragment() {

    private val tvShow = arrayListOf<TvShow>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_item_tvshow.setHasFixedSize(true)
        tvShow.addAll(getListItem())
        createRecyclerView()
    }

    private fun getListItem() : ArrayList<TvShow> {
        val imgTv = resources.obtainTypedArray(R.array.data_img_tv)
        val namaTv = resources.getStringArray(R.array.data_nama_tv)
        val genreTv = resources.getStringArray(R.array.data_genre_tv)
        val likesTv = resources.getStringArray(R.array.data_likes_tv)
        val ratingTv = resources.getStringArray(R.array.data_rating_tv)
        val watchTv = resources.getStringArray(R.array.data_kontent_tv)
        val descTv = resources.getStringArray(R.array.data_desc_tv)

        val listTv = ArrayList<TvShow>()
        for (i in namaTv.indices) {
            val tvShows = TvShow(
                imgTv.getResourceId(i, -1),
                namaTv[i],
                genreTv[i],
                likesTv[i],
                ratingTv[i],
                watchTv[i],
                descTv[i]
            )
            listTv.add(tvShows)
        }
        return listTv
    }

    private fun createRecyclerView() {
        rv_item_tvshow.layoutManager = LinearLayoutManager(activity)
        val tvShowAdapter = TvShowAdapter(tvShow)
        rv_item_tvshow.adapter = tvShowAdapter

        tvShowAdapter.setOnItemClickCallback(object : TvShowAdapter.OnItemClickCallback{
            override fun onItemClicked(data: TvShow) {
                showDetailsTv(data)
            }

        })
    }

    private fun showDetailsTv(tvShow: TvShow) {
        val mIntent = Intent(activity, DetailsTvshow::class.java)
        mIntent.putExtra(DetailsTvshow.TV_EXTRA, tvShow)
        startActivity(mIntent)
    }

}
