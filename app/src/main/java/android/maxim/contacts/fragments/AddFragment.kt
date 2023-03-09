package android.maxim.contacts.fragments

import android.maxim.contacts.databinding.FragmentAddBinding
import android.maxim.contacts.navigator.navigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class AddFragment: Fragment() {

    private lateinit var binding: FragmentAddBinding

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
        navigator().saveNewContact()
    }

    private fun cancelAddition() {
        navigator().cancel()
    }
}