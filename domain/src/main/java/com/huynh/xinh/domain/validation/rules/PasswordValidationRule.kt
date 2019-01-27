package com.huynh.xinh.domain.validation.rules

import com.huynh.xinh.domain.validation.ValidationRule
import com.huynh.xinh.domain.validation.errors.PasswordInvalidError
import com.huynh.xinh.domain.validation.errors.ValidationError
import java.util.regex.Pattern

/**
 * Create by Mr.X on 1/25/19
 */
class PasswordValidationRule : ValidationRule<String> {
    var PASSWORD = Pattern.compile("^.{5,}$")

    override fun validate(value: String?): Boolean {
        return !value.isNullOrEmpty() && PASSWORD.matcher(value).matches()
    }


    override fun getError(): ValidationError {
        return PasswordInvalidError()
    }
}