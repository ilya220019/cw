package vef.ter.cw.model

import java.io.Serializable

data class MovieModel(
    var Title: String,
    var Year: String,
    var Genre: String,
    var Awards: String,
    var Poster: String,
    var Ratings: ArrayList<RatingModule>

):Serializable

data class RatingModule (
    var Value:String,
    var Source:String,
)