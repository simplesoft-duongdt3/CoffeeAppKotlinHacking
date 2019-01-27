package com.huynh.xinh.domain.repositories.user

import io.reactivex.Observable

/**
 * Create by Mr.X on 1/25/19
 */
interface UserRepository {
    fun login(loginParam: LoginParam): Observable<LoginResult>
}