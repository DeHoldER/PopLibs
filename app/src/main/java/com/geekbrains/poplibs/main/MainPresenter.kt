package com.geekbrains.poplibs.main

import com.geekbrains.poplibs.core.nav.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AppScreens)
    }

    fun onBackPressed() {
        router.exit()
    }
}
