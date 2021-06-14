package idv.fanboat.saveme.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import idv.fanboat.saveme.R
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_action.setOnClickListener {
            getNavigator()?.pushPage(R.id.action_signUpFragment_to_homeFragment)
        }
    }
}