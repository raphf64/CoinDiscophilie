package com.cointest.coindiscophilie.fragments

import androidx.fragment.app.viewModels
import com.cointest.coindiscophilie.R
import com.cointest.coindiscophilie.databinding.FragmentDiscophilieBinding
import com.cointest.coindiscophilie.mvvm.BaseFragment
import com.cointest.coindiscophilie.viewmodels.DiscophilieViewModel


class DiscophilieFragment: BaseFragment<FragmentDiscophilieBinding>(R.layout.fragment_discophilie) {

    //Private Member

    private val viewModel:DiscophilieViewModel by viewModels()

    //end

    //BaseFragment Implementation

    override fun onDataBinding() {
        binding.viewModel = viewModel
        viewModel.initialize()
    }

    //end
}