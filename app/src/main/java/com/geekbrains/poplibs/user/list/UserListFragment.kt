package com.geekbrains.poplibs.user.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.poplibs.app.GeekBrainsApp
import com.geekbrains.poplibs.core.OnBackPressedListener
import com.geekbrains.poplibs.databinding.FragmentUserListBinding
import com.geekbrains.poplibs.main.UserListAdapter
import com.geekbrains.poplibs.model.GithubUser
import com.geekbrains.poplibs.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserListFragment : MvpAppCompatFragment(), UserListView, OnBackPressedListener {

    companion object {
        fun getInstance(): UserListFragment {
            return UserListFragment()
        }
    }

    private lateinit var viewBinding: FragmentUserListBinding

    private val adapter = UserListAdapter(object : OnItemViewClickListener {
        override fun onItemViewClick(user: GithubUser) {
            onUserClicked(user)
        }
    })
    private val presenter: UserListPresenter by moxyPresenter {
        UserListPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(user: GithubUser)
    }

    override fun onUserClicked(user: GithubUser) {
        presenter.onUserClicked(user)
    }

    override fun onBackPressed() = presenter.onBackPressed()
}

