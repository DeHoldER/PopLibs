package com.geekbrains.poplibs.repository.impl

import com.geekbrains.poplibs.model.GithubUser
import com.geekbrains.poplibs.repository.GithubRepository
import io.reactivex.rxjava3.core.Observable

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("MrFox"),
        GithubUser("VictorMelnik"),
        GithubUser("Denix"),
        GithubUser("DmitryWb"),
        GithubUser("Larisa")
    )

    override fun getUsers(): Observable<List<GithubUser>> = Observable.just(repositories)
}