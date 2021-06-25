package com.cointest.coindiscophilie.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseFragment<Binding : ViewDataBinding>(@LayoutRes private val layout: Int) :
    Fragment() {

    //Protected Members

    internal lateinit var binding: Binding

    //end

    //Protected Methods

    protected abstract fun onDataBinding()

    //end

    //Fragment Implementation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onDataBinding()
    }

    //end

}
