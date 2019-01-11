package com.coffeetek.todo.feature.main.bottommaintab

import android.graphics.Color
import android.support.v7.widget.AppCompatImageView

/**
 * Create by Mr.X on 1/6/19
 */
enum class BottomMainTabState {
    NONE {
        override fun updateUi(iView: IBottomMainTabView) {
            setNormalStyle(iView.getTabHome())
            setNormalStyle(iView.getTabLocate())
            setNormalStyle(iView.getTabCart())
            setNormalStyle(iView.getTabProfile())
        }

        override fun updateListener(iView: IBottomMainTabView) {
            setTabHomeClickListener(iView)
            setTabLocateClickListener(iView)
            setTabCartClickListener(iView)
            setTabProfileClickListener(iView)
        }
    },
    TAB_HOME_SELECTED {
        override fun updateUi(iView: IBottomMainTabView) {
            setSelectedStyle(iView.getTabHome())
            setNormalStyle(iView.getTabLocate())
            setNormalStyle(iView.getTabCart())
            setNormalStyle(iView.getTabProfile())
        }

        override fun updateListener(iView: IBottomMainTabView) {
            setTabHomeClickListener(iView)
            setTabLocateClickListener(iView)
            setTabCartClickListener(iView)
            setTabProfileClickListener(iView)
        }
    },
    TAB_LOCATE_SELECTED {
        override fun updateUi(iView: IBottomMainTabView) {
            setNormalStyle(iView.getTabHome())
            setSelectedStyle(iView.getTabLocate())
            setNormalStyle(iView.getTabCart())
            setNormalStyle(iView.getTabProfile())
        }

        override fun updateListener(iView: IBottomMainTabView) {
            setTabHomeClickListener(iView)
            setTabLocateClickListener(iView)
            setTabCartClickListener(iView)
            setTabProfileClickListener(iView)
        }
    },
    TAB_CART_SELECTED {
        override fun updateUi(iView: IBottomMainTabView) {
            setNormalStyle(iView.getTabHome())
            setNormalStyle(iView.getTabLocate())
            setSelectedStyle(iView.getTabCart())
            setNormalStyle(iView.getTabProfile())
        }

        override fun updateListener(iView: IBottomMainTabView) {
            setTabHomeClickListener(iView)
            setTabLocateClickListener(iView)
            setTabCartClickListener(iView)
            setTabProfileClickListener(iView)
        }
    },
    TAB_PROFILE_SELECTED {
        override fun updateUi(iView: IBottomMainTabView) {
            setNormalStyle(iView.getTabHome())
            setNormalStyle(iView.getTabLocate())
            setNormalStyle(iView.getTabCart())
            setSelectedStyle(iView.getTabProfile())
        }

        override fun updateListener(iView: IBottomMainTabView) {
            setTabHomeClickListener(iView)
            setTabLocateClickListener(iView)
            setTabCartClickListener(iView)
            setTabProfileClickListener(iView)
        }
    };

    fun setNormalStyle(tab: AppCompatImageView) {
        tab.alpha = 0.5f
        tab.setColorFilter(Color.parseColor("#C28E79"))
    }

    fun setSelectedStyle(tab: AppCompatImageView) {
        tab.alpha = 1f
        tab.setColorFilter(Color.parseColor("#B98068"))
    }

    fun setTabHomeClickListener(iView: IBottomMainTabView) {
        iView.getTabHome().setOnClickListener {

            TAB_HOME_SELECTED.updateUi(iView)

            iView.getOnBottomMainTabListener()?.onClickTabHome()
        }
    }

    fun setTabLocateClickListener(iView: IBottomMainTabView) {
        iView.getTabLocate().setOnClickListener {

            TAB_LOCATE_SELECTED.updateUi(iView)

            iView.getOnBottomMainTabListener()?.onClickTabLocate()
        }
    }

    fun setTabCartClickListener(iView: IBottomMainTabView) {
        iView.getTabCart().setOnClickListener {

            TAB_CART_SELECTED.updateUi(iView)

            iView.getOnBottomMainTabListener()?.onClickTabCart()
        }
    }

    fun setTabProfileClickListener(iView: IBottomMainTabView) {
        iView.getTabProfile().setOnClickListener {

            TAB_PROFILE_SELECTED.updateUi(iView)

            iView.getOnBottomMainTabListener()?.onClickTabProfile()
        }
    }

    abstract fun updateUi(view: IBottomMainTabView)

    abstract fun updateListener(view: IBottomMainTabView)
}
