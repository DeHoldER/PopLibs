package com.geekbrains.poplibs.repository

import com.geekbrains.poplibs.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}
