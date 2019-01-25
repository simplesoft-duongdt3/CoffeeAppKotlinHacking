package com.coffeetek.todo.validation

/**
 * Create by Mr.X on 1/25/19
 */
open class Validator<ValueType>(
    var field: String,
    var valueProvider: ValueProvider<ValueType>
) {

    private val validationRuleItems: MutableList<ValidationRuleItem<ValueType>> = ArrayList()

    fun addRule(rule: ValidationRule<ValueType>, message: String) {
        validationRuleItems.add(ValidationRuleItem(rule, message))
    }

    fun addRuleItem(ruleItem: ValidationRuleItem<ValueType>) {
        validationRuleItems.add(ruleItem)
    }

    fun validate(): List<ValidationResult> {
        val results: MutableList<ValidationResult> = ArrayList()
        val value: ValueType? = valueProvider.getValue()

        validationRuleItems.forEach {
            val result = ValidationResult(field, it.message, it.validationRule.validate(value))
            results.add(result)
        }

        return results
    }
}