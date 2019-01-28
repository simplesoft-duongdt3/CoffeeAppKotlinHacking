package com.huynh.xinh.domain.interactor.register

import com.huynh.xinh.domain.validation.errors.ValidationError

/**
 * Create by Mr.X on 1/25/19
 */
class RegisterValidationException(
    var emailValidationErrors: List<ValidationError>,
    var passwordValidationErrors: List<ValidationError>,
    var rePasswordValidationErrors: List<ValidationError>
) : RuntimeException()
