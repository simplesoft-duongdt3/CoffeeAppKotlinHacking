package com.huynh.xinh.domain.validation

import com.huynh.xinh.domain.validation.errors.ValidationError

/**
 * Create by Mr.X on 1/27/19
 */
interface IValidator {
    fun validate(): List<ValidationResult>
    fun isValid(): Boolean
    fun getError(): ValidationError
}
