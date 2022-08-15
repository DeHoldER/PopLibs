package com.geekbrains.poplibs.user.list

import android.os.Bundle
import com.geekbrains.poplibs.core.nav.AppScreens
import com.geekbrains.poplibs.model.GithubUser
import com.geekbrains.poplibs.repository.GithubRepository
import com.geekbrains.poplibs.user.details.UserDetailsFragment
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserListPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        viewState.initList(repository.getUsers())
        //ДЗ В ПРОЦЕССЕ
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun onUserClicked(user: GithubUser) {
        router.navigateTo(
            AppScreens.userDetailsScreen(
                Bundle().apply {
                    putParcelable(
                        UserDetailsFragment.BUNDLE_EXTRA,
                        user
                    )
                })
        )
    }
}
