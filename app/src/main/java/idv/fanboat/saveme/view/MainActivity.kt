package idv.fanboat.saveme.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.socks.library.KLog
import idv.fanboat.saveme.R
import idv.fanboat.saveme.util.setVisible
import idv.fanboat.saveme.util.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    val TAG = MainActivity::class.java.simpleName
    val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment }
    var isBackable = false

    private val naviInterface = object : NavigatorInterface {
        @SuppressLint("RestrictedApi")
        override fun createNewPage(actionId: Int) {
            navHostFragment.navController.navigate(actionId)
            btn_nav.setVisible(false)
            isBackable = false
        }

        override fun pushPage(actionId: Int) {
            navHostFragment.navController.navigate(actionId)
            btn_nav.setVisible(false)
            isBackable = true
        }

        override fun popPage() {
            onBackPressed()
        }
    }

    fun getNaviInterface(): NavigatorInterface {
        return naviInterface
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_nav.setupWithNavController(navHostFragment.navController)
    }

    override fun onBackPressed() {
        KLog.e(TAG, "onBackPressed")
        if (getBackStackIndext() <= 1 || !isBackable) {
            toast("此為最後一頁")
        } else {
            super.onBackPressed()
        }
        if (getBackStackIndext() == 1) {
            btn_nav.setVisible(true)
        }
    }

    @SuppressLint("RestrictedApi")
    fun getBackStackIndext(): Int {
        KLog.e(TAG, "getBackStackIndex ${navHostFragment.navController.backStack.size - 1}")
        return navHostFragment.navController.backStack.size - 1
    }

}