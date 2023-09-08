package vef.ter.cw.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import vef.ter.cw.R
import vef.ter.cw.databinding.FragmentFirstBinding
import vef.ter.cw.model.MovieModel
import vef.ter.cw.presenter.Presenter
import vef.ter.cw.view.FirstView
import vef.ter.cw.view.MovieView
import javax.inject.Inject
@AndroidEntryPoint
class FirstFragment : Fragment(), FirstView {
    private lateinit var binding: FragmentFirstBinding
    @Inject
     lateinit var presenter: Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initClickers()

    }

    private fun initClickers() {
        binding.btnFind.setOnClickListener{
            presenter.getMovieDetails(binding.etTitle.text.toString())
        }
    }

//    binding.tvTitle.text = model.Title
//    binding.tvYear.text = model.Year
//    binding.tvGenre.text = model.Genre
//    binding.tvAwards.text = model.Awards
//    binding.tvPoster.text = model.Poster
//    binding.tvRatings.text = model.Ratings.toString()
    override fun navigateToResultScreen(model: MovieModel) {
        binding.btnFind.setOnClickListener{
         findNavController().navigate(FirstFragmentDirections.actionMainFragmentToDetailFragment(model))

    }
    }

    override fun showError(massage: String) {
        Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
    }


}