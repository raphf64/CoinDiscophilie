package com.cointest.coindiscophilie.views.lists

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cointest.coindiscophilie.R
import com.cointest.coindiscophilie.databinding.ItemDiscBinding
import com.cointest.coindiscophilie.viewmodels.DiscItemViewModel
import com.squareup.picasso.Picasso


class DiscAdapter(
        private val mDiscs: List<DiscItemViewModel>
) : RecyclerView.Adapter<DiscAdapter.ViewHolder>()
{
    //region - Private Members

    var context: Context? = null

    //endregion

    //region - Recycler.Adapter Lifecycle

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscAdapter.ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemDiscBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(mDiscs[position])

    override fun getItemCount(): Int {
        return mDiscs.size
    }

    //endregion

    //region - Inner Class ViewHolder

    inner class ViewHolder(val binding: ItemDiscBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: DiscItemViewModel) {

            binding.viewModel = viewModel

            if (viewModel.url.isNotBlank()) {
                Picasso.get()
                    .load(viewModel.url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.discImg)
            }

            binding.executePendingBindings()
        }
    }

    //endregion

}