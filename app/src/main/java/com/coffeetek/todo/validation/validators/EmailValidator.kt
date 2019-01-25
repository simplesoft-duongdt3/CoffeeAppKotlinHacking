package com.coffeetek.todo.validation.validators

import com.coffeetek.todo.validation.*
import com.coffeetek.todo.validation.rules.EmailValidationRule
import com.coffeetek.todo.validation.rules.RequiredFieldRule

/**
 * Create by Mr.X on 1/25/19
 */
class EmailValidator(var email: String?) {

    private val emailValidator = Validator(
        ValidatorFieldConstants.VALIDATOR_FIELD_EMAIL,
        object : ValueProvider<String> {
            override fun getValue(): String? {
                return email
            }

        }
    )

    private fun validate(): List<ValidationResult> {
        initRule()
        return emailValidator.validate()
    }

    fun isValid(): Boolean {
        return validate().all { it.isValid }
    }

    fun getMessage(): String {
        return validate().first { !it.isValid }.message
    }

    private fun initRule() {
        emailValidator.addRuleItem(requiredFieldRuleItem())
        emailValidator.addRuleItem(emailRuleItem())
    }

    private fun emailRuleItem(): ValidationRuleItem<String> {
        return ValidationRuleItem(EmailValidationRule(), "Email invalid")
    }

    private fun requiredFieldRuleItem(): ValidationRuleItem<String> {
        return ValidationRuleItem(RequiredFieldRule(), "Required field")
    }
}