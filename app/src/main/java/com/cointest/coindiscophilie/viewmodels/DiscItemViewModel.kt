package com.cointest.coindiscophilie.viewmodels

import com.cointest.coindiscophilie.mvvm.BaseViewModel

data class DiscItemViewModel(
        val title: String = "",
        val id: Int = 0,
        val albumId: Int = 0,
        val thumbnailUrl: String = "",
        val url: String = ""
): BaseViewModel()
