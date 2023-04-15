package android.maxim.contacts.ui.listscreen

import android.maxim.contacts.app.App
import android.maxim.contacts.databinding.FragmentListBinding
import android.maxim.contacts.navigator.navigator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var recyclerView: RecyclerView
    private val listViewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)

        (requireActivity().application as App).appComponent.injectListFragment(this)

        recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerAdapter(listViewModel.getContactList())

        binding.btnAddContact.setOnClickListener { addContact() }

        Log.d("tag", "fragment")

        return binding.root
    }

    private fun addContact() {
        navigator().addContact()
    }

    private fun showDetails() {
        navigator().showContactDetails()
    }
}