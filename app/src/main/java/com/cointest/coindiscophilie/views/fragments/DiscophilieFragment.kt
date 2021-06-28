package com.cointest.coindiscophilie.views.fragments

import android.content.res.Configuration
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.cointest.coindiscophilie.R
import com.cointest.coindiscophilie.databinding.FragmentDiscophilieBinding
import com.cointest.coindiscophilie.mvvm.BaseFragment
import com.cointest.coindiscophilie.viewmodels.DiscophilieViewModel
import com.cointest.coindiscophilie.views.lists.DiscAdapter


class DiscophilieFragment: BaseFragment<FragmentDiscophilieBinding>(R.layout.fragment_discophilie) {

    //region - Private Member

    private val viewModel:DiscophilieViewModel by viewModels()

    //endregion

    //region - BaseFragment Lifecycle

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            binding.discsRecyclerView.adapter = DiscAdapter(viewModel.items)
            (binding.discsRecyclerView.layoutManager as? GridLayoutManager)?.spanCount = 1
            binding.discsRecyclerView.layoutManager = LinearLayoutManager(context, VERTICAL, false)
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.discsRecyclerView.adapter = DiscAdapter(viewModel.items)
            binding.discsRecyclerView.layoutManager = GridLayoutManager(context,3)
        }
    }

    override fun initDataBinding() {
        binding.viewModel = viewModel
        viewModel.onInitialize()
    }

    //endregion
}