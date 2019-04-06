package com.coffeetek.todo.base.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coffeetek.todo.R

/**
 * Create by Mr.X on 1/23/19
 */
abstract class BaseBottomSheet : BottomSheetDialogFragment() {
    protected abstract val contentView: Int

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = view
        if (view == null) {
            view = inflater.inflate(contentView, container, false)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        initEvent()
    }

    protected abstract fun initView(view: View?)

    protected abstract fun initEvent()
}
