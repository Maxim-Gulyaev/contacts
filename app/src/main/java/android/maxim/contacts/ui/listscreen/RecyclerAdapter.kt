package android.maxim.contacts.ui.listscreen

import android.maxim.contacts.R
import android.maxim.contacts.model.database.Contact
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerAdapter(private val contacts: List<Contact>):
    RecyclerView.Adapter<RecyclerAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): ViewHolder(itemView) {
        val contactView = itemView.findViewById<TextView>(R.id.tv_contact_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val contact = contacts[position]
        holder.contactView.text = contact.firstName
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}
