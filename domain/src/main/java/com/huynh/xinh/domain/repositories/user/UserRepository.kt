package com.huynh.xinh.domain.repositories.user

import com.huynh.xinh.domain.repositories.user.login.LoginParam
import com.huynh.xinh.domain.repositories.user.login.LoginResult
import com.huynh.xinh.domain.repositories.user.register.RegisterParam
import com.huynh.xinh.domain.repositories.user.register.RegisterResult
import io.reactivex.Observable

/**
 * Create by Mr.X on 1/25/19
 */
interface UserRepository {
    fun login(loginParam: LoginParam): Observable<LoginResult>
    fun register(param: RegisterParam?): Observable<RegisterResult>
}