package grevi.msx.moviecatalogg.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
    var imgTv : Int,
    var namaTv : String,
    var genreTv : String,
    var likesTv : String,
    var ratingTv : String,
    var watchTv : String,
    var descTv : String
) : Parcelable