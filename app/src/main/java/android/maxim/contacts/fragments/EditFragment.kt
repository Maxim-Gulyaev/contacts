package android.maxim.contacts.fragments

import android.maxim.contacts.databinding.FragmentEditBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class EditFragment: Fragment() {

    private lateinit var binding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(layoutInflater)
        return binding.root
    }
}