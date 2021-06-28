package com.cointest.coindiscophilie.views.bindings

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.cointest.coindiscophilie.viewmodels.DiscItemViewModel
import com.cointest.coindiscophilie.views.lists.DiscAdapter


//region - RecyclerView Bindings

@BindingAdapter("discItems")
fun RecyclerView.setDiscItems(
    discItems: ObservableList<DiscItemViewModel>?
) {
    val discs = discItems ?: return
    if (adapter != null) {
        adapter!!.notifyDataSetChanged()
        return
    }

    adapter = DiscAdapter(discs)

}

//endregion

//region - View Bindings

@BindingAdapter("visible")
fun View.visible(isVisible: Boolean) {
    this.isVisible = isVisible
}

//endregion
