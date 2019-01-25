package com.coffeetek.todo.validation.rules

import com.coffeetek.todo.validation.ValidationRule
import java.util.regex.Pattern

/**
 * Create by Mr.X on 1/25/19
 */
class EmailValidationRule : ValidationRule<String> {
    val EMAIL = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    override fun validate(value: String?): Boolean {
        return !value.isNullOrEmpty() && EMAIL.matcher(value).matches()
    }

}