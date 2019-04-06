package com.huynh.xinh.domain.validation

import com.huynh.xinh.domain.validation.errors.ValidationError

/**
 * Create by Mr.X on 1/25/19
 */
interface ValidationRule<ValueType> {
    fun validate(value: ValueType?): Boolean

    fun getError(): ValidationError
}