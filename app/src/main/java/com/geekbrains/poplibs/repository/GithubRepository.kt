package com.geekbrains.poplibs.repository

import com.geekbrains.poplibs.model.GithubUser
import io.reactivex.rxjava3.core.Observable

interface GithubRepository {
    fun getUsers(): Observable<List<GithubUser>>
}
