package idv.fanboat.saveme.util

import android.os.Bundle
import androidx.navigation.NavController

class Navigator private constructor() {

    companion object {
        fun newInstance(navController: NavController): Navigator {
            val navigator = Navigator()
            navigator.mNavController = navController
            return navigator
        }
    }

    private var mNavController: NavController? = null

    fun pushToFragment(actionId: Int, bundle: Bundle) {
        mNavController?.navigate(actionId, bundle)
    }

    fun pushToFragment(actionId: Int) {
        pushToFragment(actionId, Bundle())
    }

}