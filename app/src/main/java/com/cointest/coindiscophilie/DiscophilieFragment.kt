package com.cointest.coindiscophilie

import com.cointest.coindiscophilie.databinding.FragmentPlayerBinding
import com.cointest.coindiscophilie.mvvm.BaseFragment


class DiscophilieFragment: BaseFragment<FragmentPlayerBinding>(R.layout.fragment_player) {
    override fun onDataBinding() {
        binding.text.text = "Coucou"
    }
}