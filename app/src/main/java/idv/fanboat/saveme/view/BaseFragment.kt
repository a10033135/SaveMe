package idv.fanboat.saveme.view

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    fun getNavigator(): NavigatorInterface? {
        if (activity is MainActivity) {
            return (activity as MainActivity).getNaviInterface()
        }
        return null
    }
}