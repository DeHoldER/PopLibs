package com.geekbrains.poplibs.repository.impl

import com.geekbrains.poplibs.model.GithubUser
import com.geekbrains.poplibs.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("MrFox"),
        GithubUser("VictorMelnik"),
        GithubUser("Denix"),
        GithubUser("DmitryWb"),
        GithubUser("Larisa")
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }
}
