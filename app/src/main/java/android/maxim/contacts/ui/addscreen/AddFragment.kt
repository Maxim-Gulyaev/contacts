package android.maxim.contacts.ui.addscreen

import android.maxim.contacts.databinding.FragmentAddBinding
import android.maxim.contacts.navigator.navigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class AddFragment: Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val addViewModel: AddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddBinding.inflate(layoutInflater)

        binding.btnCancel.setOnClickListener { cancelAddition() }
        binding.btnSave.setOnClickListener { saveContact() }
        return binding.root
    }

    private fun saveContact() {
        addViewModel.contact.firstName = binding.etFirstName.text.toString()
        addViewModel.contact.lastName = binding.etLastName.text.toString()
        addViewModel.contact.phoneNumber = binding.etPhoneNumber.text.toString()
        addViewModel.contact.email = binding.etMail.text.toString()

        addViewModel.addContact()
        navigator().cancel()
    }

    private fun cancelAddition() {
        navigator().cancel()
    }
}