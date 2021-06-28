package com.cointest.coindiscophilie.views.fragments

import androidx.fragment.app.viewModels
import com.cointest.coindiscophilie.R
import com.cointest.coindiscophilie.databinding.FragmentDiscophilieBinding
import com.cointest.coindiscophilie.mvvm.BaseFragment
import com.cointest.coindiscophilie.mvvm.IoC
import com.cointest.coindiscophilie.services.ContextService
import com.cointest.coindiscophilie.viewmodels.DiscophilieViewModel
import java.lang.ref.WeakReference


class DiscophilieFragment :
    BaseFragment<FragmentDiscophilieBinding>(R.layout.fragment_discophilie) {

    //region - Services Injection

    private val contextService: ContextService
        get() = IoC.injection()

    //endregion

    //region - Private Member

    private val viewModel: DiscophilieViewModel by viewModels()

    //endregion

    //region - BaseFragment Lifecycle

    override fun initDataBinding() {
        binding.viewModel = viewModel
        viewModel.onInitialize()
        contextService.rootView = WeakReference(binding.root)
    }

    //endregion
}