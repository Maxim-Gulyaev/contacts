package android.maxim.contacts.ui.activity

import android.maxim.contacts.R
import android.maxim.contacts.databinding.ActivityMainBinding
import android.maxim.contacts.ui.addscreen.AddFragment
import android.maxim.contacts.ui.listscreen.ListFragment
import android.maxim.contacts.navigator.Navigator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, ListFragment())
                .commit()
        }
    }

    override fun showContactDetails() {
        TODO("Not yet implemented")
    }

    override fun addContact() {
        launchFragment(AddFragment())
    }

    override fun cancel() {
        launchFragment(ListFragment())
    }

   /* override fun saveNewContact() {
        TODO("Not yet implemented")
    }*/

    override fun backToContactList() {
        TODO("Not yet implemented")
    }

    override fun editContact() {
        TODO("Not yet implemented")
    }

    override fun deleteContact() {
        TODO("Not yet implemented")
    }

    override fun call() {
        TODO("Not yet implemented")
    }

    override fun sendSms() {
        TODO("Not yet implemented")
    }

    override fun saveEditedContact() {
        TODO("Not yet implemented")
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}