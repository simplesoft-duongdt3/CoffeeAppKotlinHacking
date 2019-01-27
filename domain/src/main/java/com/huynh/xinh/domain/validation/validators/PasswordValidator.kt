package com.huynh.xinh.domain.validation.validators

import com.huynh.xinh.domain.validation.Validator
import com.huynh.xinh.domain.validation.ValueProvider
import com.huynh.xinh.domain.validation.rules.PasswordValidationRule
import com.huynh.xinh.domain.validation.rules.RequiredFieldRule

/**
 * Create by Mr.X on 1/25/19
 */
class PasswordValidator(var password: String?) : Validator<String>(object : ValueProvider<String> {
    override fun getValue(): String? {
        return password
    }
}) {

    override fun addRules() {
        addRule(RequiredFieldRule())
        addRule(PasswordValidationRule())
    }
}