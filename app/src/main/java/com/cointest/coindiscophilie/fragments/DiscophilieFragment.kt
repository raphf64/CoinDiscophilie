package com.cointest.coindiscophilie.fragments

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.cointest.coindiscophilie.R
import com.cointest.coindiscophilie.databinding.FragmentDiscophilieBinding
import com.cointest.coindiscophilie.mvvm.BaseFragment
import com.cointest.coindiscophilie.viewmodels.DiscophilieViewModel


class DiscophilieFragment: BaseFragment<FragmentDiscophilieBinding>(R.layout.fragment_discophilie) {

    //Private Member

    private lateinit var viewModel:DiscophilieViewModel

    //end

    //BaseFragment Implementation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: DiscophilieViewModel by viewModels()
        this.viewModel = viewModel
    }

    override fun onDataBinding() {
        binding.viewModel = viewModel
        viewModel.initialize()
    }

    //end
}