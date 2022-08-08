package com.geekbrains.poplibs.user.list

import com.geekbrains.poplibs.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserListView : MvpView {
    fun initList(list: List<GithubUser>)
    fun onUserClicked(user: GithubUser)
}
