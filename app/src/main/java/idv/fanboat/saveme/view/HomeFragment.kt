package idv.fanboat.saveme.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import idv.fanboat.saveme.R
import idv.fanboat.saveme.UserAdapter
import idv.fanboat.saveme.databinding.FragmentHomeBinding
import idv.fanboat.saveme.model.User
import idv.fanboat.saveme.viewmodel.HomeViewModel

class HomeFragment : BaseFragment() {

    var binding: FragmentHomeBinding? = null
    var viewmodel: HomeViewModel? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding?.lifecycleOwner = viewLifecycleOwner
        viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding?.viewmodel = viewmodel
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding?.rvList?.layoutManager = LinearLayoutManager(context)
        binding?.rvList?.adapter = UserAdapter(viewmodel!!, mutableListOf(User("a"), User("b"), User("c")))
        binding?.btAction?.setOnClickListener {
            activity?.let {
                getNavigator()?.pushPage(R.id.action_homeFragment_to_signUpFragment)
            }
        }

    }

}