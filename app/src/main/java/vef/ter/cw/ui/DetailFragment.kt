package vef.ter.cw.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import vef.ter.cw.presenter.ResultPresenter
import vef.ter.cw.databinding.FragmentDetailBinding
import vef.ter.cw.model.MovieModel
import vef.ter.cw.view.MovieView
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment(), MovieView {

    private lateinit var binding: FragmentDetailBinding
    lateinit var presenter: ResultPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()


    }

    private fun initClickers() {
       arguments?.let {
           val navArgs = DetailFragmentArgs.fromBundle(it)
           presenter.getData(navArgs.model)
       }
    }

    override fun showMovie(model: MovieModel)= with(binding) {

        Glide
            .with(requireActivity())
            .load(model.Poster.toString())
            .into(tvPoster);
        tvTitle.text = model.Title
        tvYear.text = model.Year
        tvGenre.text = model.Genre
        tvAwards.text = model.Awards
        model.Ratings.forEach {
            tvRatings.append("Source: ${it.Source}\n Value: ${it.Value}\n\n")
        }


    }



}