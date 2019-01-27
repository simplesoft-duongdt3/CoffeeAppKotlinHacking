package com.huynh.xinh.data.responses.user

import com.huynh.xinh.domain.repositories.user.LoginParam
import com.huynh.xinh.domain.repositories.user.LoginResult
import com.huynh.xinh.domain.repositories.user.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Create by Mr.X on 1/25/19
 */
class UserRepositoryImpl
@Inject constructor() : UserRepository {
    override fun login(loginParam: LoginParam): Observable<LoginResult> {
        return Observable.just(LoginResult())
    }
}