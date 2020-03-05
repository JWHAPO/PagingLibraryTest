package com.example.paginglibrarytest.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paginglibrarytest.R
import com.example.paginglibrarytest.model.Item

/**
 * PagingLibraryTest
 * Class: ItemViewHolder
 * Created by JEONGWOOKIM on 2020-03-05.
 * Description:
 */
class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val itemName: TextView = view.findViewById(R.id.item_name_tv)
    private val repositoryName: TextView = view.findViewById(R.id.repository_name_tv)
    private val ownerAvatarImage: ImageView = view.findViewById(R.id.owner_avatar_iv)

    private var item: Item? = null

    init {
        view.setOnClickListener {
            item?.git_url?.let {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                view.context.startActivity(intent)
            }
        }
    }

    fun bind(item: Item?) {
        if (item == null) {
            val resources = itemView.resources
            repositoryName.text = resources.getString(R.string.loading)
            itemName.text = resources.getString(R.string.loading)
        } else {
            showItemData(item)
        }
    }

    private fun showItemData(item: Item) {
        this.item = item
        itemName.text = item.name
        repositoryName.text = item.repository.name

        Glide.with(view.context)
            .load(item.repository.owner.avatar_url)
            .into(ownerAvatarImage)
    }

    companion object {
        fun create(parent: ViewGroup): ItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
            return ItemViewHolder(view)
        }
    }

}