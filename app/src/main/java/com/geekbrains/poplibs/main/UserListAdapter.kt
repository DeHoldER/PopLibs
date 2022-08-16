package com.geekbrains.poplibs.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.poplibs.R
import com.geekbrains.poplibs.model.GithubUser
import com.geekbrains.poplibs.user.list.UserListFragment

class UserListAdapter(
    private var onItemViewClickListener: UserListFragment.OnItemViewClickListener?
) :
    ListAdapter<GithubUser, UserListAdapter.GithubUserViewHolder>(GithubUserItemCallback) {

    var users: List<GithubUser> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        return GithubUserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.tvUserLogin) }
        private val userCard by lazy { itemView.findViewById<CardView>(R.id.itemUserCardView) }

        fun bind(item: GithubUser) = with(item) {
            tvLogin.text = login
            userCard.setOnClickListener { onItemViewClickListener?.onItemViewClick(item) }
        }
    }
}

object GithubUserItemCallback : DiffUtil.ItemCallback<GithubUser>() {
    override fun areContentsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
        return oldItem == newItem
    }
}

