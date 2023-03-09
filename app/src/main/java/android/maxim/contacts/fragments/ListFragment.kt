package android.maxim.contacts.fragments

import android.maxim.contacts.databinding.FragmentListBinding
import android.maxim.contacts.navigator.navigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListFragment: Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)

        binding.btnAddContact.setOnClickListener { addContact() }

        return binding.root
    }

    private fun addContact() {
        navigator().addContact()
    }

    private fun showDetails() {
        navigator().showContactDetails()
    }
}