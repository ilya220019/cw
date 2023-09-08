package vef.ter.cw.view

import vef.ter.cw.model.MovieModel

interface FirstView {

    fun navigateToResultScreen(model: MovieModel)
    fun showError(massage: String)


}