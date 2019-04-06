package com.huynh.xinh.domain.interactor.login

import com.huynh.xinh.domain.validation.errors.ValidationError

/**
 * Create by Mr.X on 1/25/19
 */
class LoginValidationException(
    var emailValidationErrors: List<ValidationError>,
    var passwordValidationErrors: List<ValidationError>
) : RuntimeException()
