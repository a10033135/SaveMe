package idv.fanboat.saveme.util

import androidx.fragment.app.FragmentActivity
import idv.fanboat.saveme.view.MainActivity

object NavigatorUtils {
    private var navigator: Navigator? = null

    fun getNavigator(activity: FragmentActivity): Navigator? {
        if (navigator == null && activity is MainActivity) {
            navigator = Navigator.newInstance(activity.navHostFragment.navController)
        }
        return navigator
    }



}