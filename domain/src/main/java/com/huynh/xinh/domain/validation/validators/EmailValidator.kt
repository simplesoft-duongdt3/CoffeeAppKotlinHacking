package com.huynh.xinh.domain.validation.validators

import com.huynh.xinh.domain.validation.Validator
import com.huynh.xinh.domain.validation.ValueProvider
import com.huynh.xinh.domain.validation.rules.EmailValidationRule
import com.huynh.xinh.domain.validation.rules.RequiredFieldRule

/**
 * Create by Mr.X on 1/25/19
 */
class EmailValidator(var email: String?) : Validator<String>(object : ValueProvider<String> {
    override fun getValue(): String? {
        return email
    }
}) {

    override fun addRules() {
        addRule(RequiredFieldRule())
        addRule(EmailValidationRule())
    }
}