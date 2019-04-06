package com.huynh.xinh.data.responses.user

import com.huynh.xinh.domain.repositories.user.UserRepository
import com.huynh.xinh.domain.repositories.user.login.LoginParam
import com.huynh.xinh.domain.repositories.user.login.LoginResult
import com.huynh.xinh.domain.repositories.user.register.RegisterParam
import com.huynh.xinh.domain.repositories.user.register.RegisterResult
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

    override fun register(param: RegisterParam?): Observable<RegisterResult> {
        return Observable.just(RegisterResult())
    }
}