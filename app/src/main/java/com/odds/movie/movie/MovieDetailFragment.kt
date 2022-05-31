package com.odds.movie.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.odds.movie.databinding.FragmentMovieDetailBinding
import com.odds.movie.login.User

class MovieDetailFragment : Fragment() {

    private val binding by lazy { FragmentMovieDetailBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    private fun bind() {
        val user = arguments?.getParcelable<User>(MovieActivity.EXTRA_USER)
        val movie = arguments?.getParcelable<Movie>(MovieActivity.EXTRA_MOVIE)
        with(binding) {
            tvMovieName.text = movie?.name.orEmpty()
            tvDuration.text = getString(com.odds.movie.R.string.duration).format(movie?.duration)
            tvGreeting.text = getString(com.odds.movie.R.string.greeting).format(user?.username.orEmpty())
            Glide.with(binding.imageView)
                .load(movie?.image)
                .into(binding.imageView)
//            imageView.setImageResource(movie?.image?: com.odds.movie.R.drawable.endgame)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(user: User?, movie: Movie?): MovieDetailFragment {
            val fragment = MovieDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(MovieActivity.EXTRA_MOVIE, movie)
            bundle.putParcelable(MovieActivity.EXTRA_USER, user)
            fragment.arguments = bundle
            return fragment
        }
    }
}