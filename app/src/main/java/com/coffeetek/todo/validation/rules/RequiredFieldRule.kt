package com.coffeetek.todo.validation.rules

import com.coffeetek.todo.validation.ValidationRule

/**
 * Create by Mr.X on 1/25/19
 */
class RequiredFieldRule : ValidationRule<String> {
    override fun validate(value: String?): Boolean {
        return !value.isNullOrEmpty()
    }
}
