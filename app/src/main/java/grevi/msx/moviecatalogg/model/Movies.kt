package grevi.msx.moviecatalogg.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    var imgMovies : Int,
    var namaMovies : String?,
    var genreMovies : String?,
    var likesMovies : String,
    var ratingMovies : String,
    var salesMovies : String,
    var descMovies : String?
) : Parcelable