package com.geekbrains.poplibs.user.details

import android.os.Bundle
import android.view.View
import com.geekbrains.poplibs.app.GeekBrainsApp
import com.geekbrains.poplibs.core.OnBackPressedListener
import com.geekbrains.poplibs.databinding.FragmentUserDetailsBinding
import com.geekbrains.poplibs.model.GithubUser
import com.geekbrains.poplibs.utils.ViewBindingFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment :
    ViewBindingFragment<FragmentUserDetailsBinding>(FragmentUserDetailsBinding::inflate),
    UserDetailsView, OnBackPressedListener {

    private lateinit var userBundle: GithubUser

    companion object {
        const val BUNDLE_EXTRA = "BUNDLE_EXTRA"
        fun newInstance(bundle: Bundle): UserDetailsFragment =
            UserDetailsFragment().apply { arguments = bundle }
    }

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(GeekBrainsApp.instance.router)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let { it?.getParcelable<GithubUser>(BUNDLE_EXTRA) ?: GithubUser(login = "error") }
            .also { userBundle = it }
    }

    override fun initUser() = with(binding) {
        txtUserDetailsName.text = userBundle.login
    }

    override fun onBackPressed() = presenter.onBackPressed()
}