package com.coffeetek.todo.feature.map

import android.os.Bundle
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.base.bottomsheet.BaseBottomSheet
import kotlinx.android.synthetic.main.bottom_sheet_fragment_map.*

/**
 * Create by Mr.X on 1/23/19
 */
class BottomSheetStoreInfo : BaseBottomSheet() {

    companion object {
        private const val ARG_BOTTOM_SHEET_STORE = "arg_bottom_sheet_store"

        fun newInstance(storeViewModel: StoreViewModel): BottomSheetStoreInfo {
            val args = Bundle()
            args.putParcelable(ARG_BOTTOM_SHEET_STORE, storeViewModel)
            val fragment = BottomSheetStoreInfo()
            fragment.arguments = args
            return fragment
        }
    }

    override val contentView: Int
        get() = R.layout.bottom_sheet_fragment_map

    override fun initView(view: View?) {
        val storeViewModel = arguments?.get(ARG_BOTTOM_SHEET_STORE) as StoreViewModel

        tvBottomSheetMapStoreName.text = storeViewModel.name
        tvBottomSheetFragmentMapDistance.text = """${storeViewModel.minDistance} mi"""
        tvBottomSheetFragmentMapTime.text = """${storeViewModel.minTime} min"""
        tvBottomSheetFragmentMapAddressName.text = storeViewModel.addressName
    }

    override fun initEvent() {

    }
}
