package com.odds.movie.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.odds.movie.R
import com.odds.movie.data.MovieAPIFactory
import com.odds.movie.databinding.FragmentHomeMovieBinding
import com.odds.movie.login.User

class HomeMovieFragment : Fragment(), HomeMoviePresenter.HomeMovieView{

    private val binding by lazy { FragmentHomeMovieBinding.inflate(layoutInflater) }
    private val presenter by lazy { HomeMoviePresenter(MovieAPIFactory.createAPI()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        presenter.fetchMovie()
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        presenter.attachView(this)
//        presenter.fetchMovie()
//        }

//    private fun createMovie() = listOf(
//        Movie(1, "Avenger Endgame", R.drawable.endgame, 1),
//        Movie(2, "Dr.strange", R.drawable.strange, 1),
//        Movie(3, "Iron man", R.drawable.tony, 1),
//        Movie(4, "Thor", R.drawable.thor, 1),
//    )

    companion object {
        @JvmStatic
        fun newInstance(user: User?): HomeMovieFragment {
            val fragment = HomeMovieFragment()
            val bundle = Bundle()
            bundle.putParcelable(MovieActivity.EXTRA_USER,user)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun showMovie(movie: List<Movie>) {
        val user = arguments?.getParcelable<User>(MovieActivity.EXTRA_USER)
        val adapter = HomeMovieAdapter(movie) { movies ->

            findNavController().apply {
                navigate(
                    R.id.action_homeMovieFragment_to_movieDetailFragment,
                    bundleOf(
                        MovieActivity.EXTRA_MOVIE to movies,
                        MovieActivity.EXTRA_USER to user
                    )
                )
            }
        }
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

    }
}