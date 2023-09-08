package vef.ter.cw.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vef.ter.cw.model.MovieModel
import vef.ter.cw.view.MovieView
import javax.inject.Inject

class ResultPresenter (private val movieView: MovieView) {

    fun getData(model: MovieModel){
        movieView.showMovie(model)
    }

}