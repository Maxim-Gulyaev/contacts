package android.maxim.contacts.fragments


import android.maxim.contacts.databinding.FragmentAddBinding
import android.maxim.contacts.model.database.ContactDao
import android.maxim.contacts.model.database.ContactDaoImpl
import android.maxim.contacts.model.repository.Repository
import android.maxim.contacts.navigator.navigator
import android.maxim.contacts.viewmodels.AddViewModel
import android.maxim.contacts.viewmodels.AddViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AddFragment: Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val repository = Repository(ContactDaoImpl())
    //private val addViewModel: AddViewModel by viewModels()
    //private val addViewModel: AddViewModel by viewModels { AddViewModelFactory(repository) }
    private lateinit var addViewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val factory = AddViewModelFactory(repository)
        addViewModel = ViewModelProvider(this, factory)[AddViewModel::class.java]

        binding = FragmentAddBinding.inflate(layoutInflater)

        binding.btnCancel.setOnClickListener { cancelAddition() }
        binding.btnSave.setOnClickListener { saveContact() }
        return binding.root
    }

    private fun saveContact() {
        //navigator().saveNewContact()
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