package com.coffeetek.todo.validation

/**
 * Create by Mr.X on 1/25/19
 */
interface ValidationRule<ValueType> {
    fun validate(value: ValueType?): Boolean
}