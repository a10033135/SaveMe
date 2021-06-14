package idv.fanboat.saveme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.socks.library.KLog
import idv.fanboat.saveme.databinding.AdapterUserBinding
import idv.fanboat.saveme.model.User
import idv.fanboat.saveme.viewmodel.HomeViewModel

class UserAdapter(viewmodel: HomeViewModel, alUser: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    val mAlUser = alUser
    val mViewmodel = viewmodel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = DataBindingUtil.inflate<AdapterUserBinding>(
            LayoutInflater.from(parent.context), R.layout.adapter_user, parent, false
        )
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        KLog.e("TAG", "getItemCount: ${mAlUser.size}")
        return mAlUser.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.user = mAlUser[position]
        holder.binding.viewmodel = mViewmodel
        holder.binding.notifyChange()
    }

    class UserViewHolder(var binding: AdapterUserBinding) : RecyclerView.ViewHolder(binding.root)
}
