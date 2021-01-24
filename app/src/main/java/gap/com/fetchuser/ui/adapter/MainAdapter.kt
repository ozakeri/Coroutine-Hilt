package gap.com.fetchuser.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gap.com.fetchuser.R
import gap.com.fetchuser.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(val userList: ArrayList<User>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {


    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {

            itemView.textViewUserName.setText(user.name)
            itemView.textViewUserEmail.setText(user.email)
            Glide.with(itemView.imageViewAvatar.context).load(user.avatar)
                .into(itemView.imageViewAvatar)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(userList.get(position))
    }

    override fun getItemCount(): Int = userList.size

    fun addData(list: List<User>) {
        userList.addAll(list)
    }
}