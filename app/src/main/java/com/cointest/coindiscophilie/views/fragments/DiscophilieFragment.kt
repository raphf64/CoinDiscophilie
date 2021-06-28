package com.cointest.coindiscophilie.views.fragments

import androidx.fragment.app.viewModels
import com.cointest.coindiscophilie.R
import com.cointest.coindiscophilie.databinding.FragmentDiscophilieBinding
import com.cointest.coindiscophilie.mvvm.BaseFragment
import com.cointest.coindiscophilie.viewmodels.DiscophilieViewModel


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

    //endregion
}