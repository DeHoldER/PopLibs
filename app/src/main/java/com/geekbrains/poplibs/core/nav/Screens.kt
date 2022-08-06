package com.geekbrains.poplibs.core.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.geekbrains.poplibs.user.UserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}
