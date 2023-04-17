package android.maxim.contacts.ui.listscreen

import android.maxim.contacts.R
import android.maxim.contacts.model.database.Contact
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerAdapter (private val contacts: List<Contact>):
    RecyclerView.Adapter<RecyclerAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): ViewHolder(itemView) {
        val contactFirstNameView = itemView.findViewById<TextView>(R.id.tv_contact_first_name)
        val contactLastNameView = itemView.findViewById<TextView>(R.id.tv_contact_last_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val contact = contacts[position]
        holder.contactFirstNameView.text = contact.firstName
        holder.contactLastNameView.text = contact.lastName

    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}
