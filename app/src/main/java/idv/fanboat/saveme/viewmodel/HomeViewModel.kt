package idv.fanboat.saveme.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.socks.library.KLog
import idv.fanboat.saveme.R
import idv.fanboat.saveme.model.User

class HomeViewModel : ViewModel() {
    val TAG = HomeViewModel::class.java.simpleName
    var _user: MutableLiveData<User> = MutableLiveData()
    var navCtr: NavController? = null

    fun setUser(user: User) {
        _user.postValue(user)
    }

    fun onUserClick(user: User) {
        KLog.e(TAG, user)
        _user.postValue(user)
        val bundle = Bundle()
        bundle.putParcelableArrayList("ARG_USER_ITEM", arrayListOf<User>())
        navCtr?.navigate(R.id.action_homeFragment_to_userItemFragment)
    }

}