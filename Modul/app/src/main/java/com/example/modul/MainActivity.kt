package com.example.modul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), Communicator, Communicator2 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = ModuleFragment()
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, fragment1).commit()

    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("input_txt", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = RepairFragment()
        frag2.arguments = bundle

        transaction.replace(R.id.fragment_container, frag2)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }

    override fun passDataCom2(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("input_txt2", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = RepairFragment()
        frag2.arguments = bundle

        transaction.replace(R.id.fragment_container, frag2)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }

}




