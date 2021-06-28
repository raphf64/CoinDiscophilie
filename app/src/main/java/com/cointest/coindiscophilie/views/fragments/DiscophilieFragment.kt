package com.cointest.coindiscophilie.views.fragments

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.cointest.coindiscophilie.R
import com.cointest.coindiscophilie.databinding.FragmentDiscophilieBinding
import com.cointest.coindiscophilie.mvvm.BaseFragment
import com.cointest.coindiscophilie.viewmodels.DiscophilieViewModel
import com.cointest.coindiscophilie.views.lists.DiscAdapter


class DiscophilieFragment :
    BaseFragment<FragmentDiscophilieBinding>(R.layout.fragment_discophilie) {

    //region - Private Member

    private val viewModel: DiscophilieViewModel by viewModels()

    //endregion

    //region - BaseFragment Lifecycle

    override fun initDataBinding() {
        binding.viewModel = viewModel
        viewModel.onInitialize()
    }

    override fun onLandscapeDetected() {
        binding.discsRecyclerView.adapter = DiscAdapter(viewModel.items)
        binding.discsRecyclerView.layoutManager = GridLayoutManager(
            context,
            resources.getInteger(R.integer.disc_recycler_span_count_land)
        )
    }

    override fun onPortraitDetected() {
        binding.discsRecyclerView.adapter = DiscAdapter(viewModel.items)
        (binding.discsRecyclerView.layoutManager as? GridLayoutManager)?.spanCount =
            resources.getInteger(R.integer.disc_recycler_span_count_port)
        binding.discsRecyclerView.layoutManager = LinearLayoutManager(context, VERTICAL, false)
    }

    //endregion
}