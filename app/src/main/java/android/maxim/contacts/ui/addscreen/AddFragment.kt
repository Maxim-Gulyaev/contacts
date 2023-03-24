package android.maxim.contacts.ui.addscreen

import android.maxim.contacts.app.App
import android.maxim.contacts.databinding.FragmentAddBinding
import android.maxim.contacts.navigator.navigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class AddFragment: Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var addViewModel: AddViewModel

    @Inject
    lateinit var factory: AddViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (requireActivity().application as App).appComponent.injectAddFragment(this)

        addViewModel = ViewModelProvider(this, factory)[AddViewModel::class.java]

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
    }

    private fun cancelAddition() {
        navigator().cancel()
    }
}