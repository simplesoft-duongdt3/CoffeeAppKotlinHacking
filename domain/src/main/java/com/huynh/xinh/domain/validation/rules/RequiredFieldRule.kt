package com.huynh.xinh.domain.validation.rules

import com.huynh.xinh.domain.validation.ValidationRule
import com.huynh.xinh.domain.validation.errors.RequiredFieldError
import com.huynh.xinh.domain.validation.errors.ValidationError

/**
 * Create by Mr.X on 1/25/19
 */
class RequiredFieldRule : ValidationRule<String> {
    override fun validate(value: String?): Boolean {
        return !value.isNullOrEmpty()
    }

    override fun getError(): ValidationError {
        return RequiredFieldError()
    }
}
