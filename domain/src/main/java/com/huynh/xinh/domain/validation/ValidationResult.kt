package com.huynh.xinh.domain.validation

import com.huynh.xinh.domain.validation.errors.ValidationError

/**
 * Create by Mr.X on 1/25/19
 */
data class ValidationResult(var error: ValidationError, var isValid: Boolean)