package com.huynh.xinh.domain.validation.rules.repassword

import com.huynh.xinh.domain.validation.ValidationRule
import com.huynh.xinh.domain.validation.errors.RePasswordNotMatchError
import com.huynh.xinh.domain.validation.errors.ValidationError

/**
 * Create by Mr.X on 1/28/19
 */
class RePasswordValidationRule : ValidationRule<RePassword> {
    override fun validate(value: RePassword?): Boolean {
        val password = value?.password
        val rePassword = value?.rePassword

        return !password.isNullOrEmpty() && !rePassword.isNullOrEmpty() && password == rePassword
    }

    override fun getError(): ValidationError {
        return RePasswordNotMatchError()
    }
}