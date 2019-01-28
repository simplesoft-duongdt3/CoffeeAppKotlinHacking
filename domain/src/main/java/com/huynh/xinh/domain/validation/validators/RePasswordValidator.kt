package com.huynh.xinh.domain.validation.validators

import com.huynh.xinh.domain.validation.ValidationRule
import com.huynh.xinh.domain.validation.Validator
import com.huynh.xinh.domain.validation.ValueProvider
import com.huynh.xinh.domain.validation.errors.RequiredFieldError
import com.huynh.xinh.domain.validation.errors.ValidationError
import com.huynh.xinh.domain.validation.rules.repassword.RePassword
import com.huynh.xinh.domain.validation.rules.repassword.RePasswordValidationRule

/**
 * Create by Mr.X on 1/25/19
 */
class RePasswordValidator(var rePassword: RePassword?) : Validator<RePassword>(object : ValueProvider<RePassword> {
    override fun getValue(): RePassword? {
        return rePassword
    }
}) {

    override fun addRules() {
        addRule(RePasswordValidationRequiredFieldRule())
        addRule(RePasswordValidationRule())
    }

    inner class RePasswordValidationRequiredFieldRule : ValidationRule<RePassword> {
        override fun validate(value: RePassword?): Boolean {
            return !value?.rePassword.isNullOrEmpty()
        }

        override fun getError(): ValidationError {
            return RequiredFieldError()
        }

    }
}