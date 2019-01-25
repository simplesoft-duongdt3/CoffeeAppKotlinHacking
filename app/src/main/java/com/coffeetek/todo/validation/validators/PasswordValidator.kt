package com.coffeetek.todo.validation.validators

import com.coffeetek.todo.validation.*
import com.coffeetek.todo.validation.rules.PasswordValidationRule
import com.coffeetek.todo.validation.rules.RequiredFieldRule

/**
 * Create by Mr.X on 1/25/19
 */
class PasswordValidator(var password: String) {

    private val passwordValidator = Validator(
        ValidatorFieldConstants.VALIDATOR_FIELD_PASSWORD,
        object : ValueProvider<String> {
            override fun getValue(): String? {
                return password
            }
        }
    )

    private fun validate(): List<ValidationResult> {
        initRule()
        return passwordValidator.validate()
    }

    fun isValid(): Boolean {
        return validate().all { it.isValid }
    }

    fun getMessage(): String {
        return validate().first { !it.isValid }.message
    }

    private fun initRule() {
        passwordValidator.addRuleItem(requiredFieldRuleItem())
        passwordValidator.addRuleItem(emailRuleItem())
    }

    private fun emailRuleItem(): ValidationRuleItem<String> {
        return ValidationRuleItem(PasswordValidationRule(), "Pass invalid")
    }

    private fun requiredFieldRuleItem(): ValidationRuleItem<String> {
        return ValidationRuleItem(RequiredFieldRule(), "Required field")
    }
}