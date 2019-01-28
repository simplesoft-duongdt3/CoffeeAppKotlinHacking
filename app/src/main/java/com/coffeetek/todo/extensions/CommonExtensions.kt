package com.coffeetek.todo.extensions

import android.support.design.widget.TextInputEditText
import android.text.Editable

/**
 * Create by Mr.X on 1/28/19
 */
fun TextInputEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : SimpleTextWatcher() {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}
