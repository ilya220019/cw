package vef.ter.cw.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vef.ter.cw.model.MovieApi
import vef.ter.cw.model.MovieModel
import vef.ter.cw.view.FirstView
import vef.ter.cw.view.MovieView
import javax.inject.Inject

class Presenter @Inject constructor(private val movieApi: MovieApi) {

    lateinit var firstView: FirstView


    fun getMovieDetails(name: String){
        movieApi.getMovie(name).enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                response.body()?.let {
                    firstView.navigateToResultScreen(it)}


        }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                firstView.showError(t.message.toString())
            }
        })

}


fun attachView(firstView: FirstView){
    this.firstView = firstView
}}