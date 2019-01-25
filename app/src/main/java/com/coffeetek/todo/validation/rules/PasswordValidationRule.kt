package com.coffeetek.todo.validation.rules

import com.coffeetek.todo.validation.ValidationRule
import java.util.regex.Pattern

/**
 * Create by Mr.X on 1/25/19
 */
class PasswordValidationRule : ValidationRule<String> {
    var PASSWORD = Pattern.compile("^.{5,}$")

    override fun validate(value: String?): Boolean {
        return !value.isNullOrEmpty() && PASSWORD.matcher(value).matches()
    }
}