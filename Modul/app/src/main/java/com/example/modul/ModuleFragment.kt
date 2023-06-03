package com.example.modul

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import kotlinx.android.synthetic.main.fragment_module.*
import java.util.*

const val DIALOG_DATE = "DialogDate"
const val REQUEST_DATE = 0

class ModuleFragment : Fragment(),DatePickerFragment.Callbacks {

    private lateinit var database: FirebaseFirestore

    private lateinit var searchText : TextView

    private lateinit var comm: Communicator

    private lateinit var moduleNumberText: TextView
    private lateinit var module: Module
    private lateinit var moduleNumber: EditText
    private lateinit var dateInButton : Button
    private lateinit var dateInText: TextView
    private lateinit var editButton: Button
    private lateinit var searchButton: Button
    private lateinit var previewButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        module = Module()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_module, container, false)
        moduleNumber = rootView.findViewById(R.id.module_number1) as EditText
        moduleNumberText = rootView.findViewById(R.id.moduleNumberText1) as TextView
        dateInText = rootView.findViewById(R.id.dateInText) as TextView
        dateInButton = rootView.findViewById(R.id.dateIn) as Button

        editButton = rootView.findViewById(R.id.Edit) as Button
        searchButton = rootView.findViewById(R.id.Search) as Button
        previewButton =rootView.findViewById(R.id.Preview) as Button

        searchText = rootView.findViewById(R.id.searchText) as TextView

        comm = requireActivity() as Communicator

        editButton.setOnClickListener(){
            if (moduleNumber.text.isNotEmpty() && dateInText.text !="date of delivery") {
                moduleNumberText.text = moduleNumber.text

                comm.passDataCom(moduleNumber.text.toString(),dateInText.text.toString())

            }
        }

        previewButton.setOnClickListener(){
            if (moduleNumberText.text != "Number") {
                moduleNumberText.text = moduleNumber.text

            }
        }

        searchButton.setOnClickListener(){
            if (moduleNumber.text.isNotEmpty()) {
                moduleNumberText.text = moduleNumber.text

                val docRef = database.collection(
                    "modul").document(
                    "${moduleNumber.text}")


                docRef.get().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val document = task.result
                        searchText.text = document?.data.toString()
                    }  else {
                        searchText.text = "no data"
                    }
                }
            }
        }

        return rootView
    }

    override fun onStart() {
        super.onStart()

        dateInButton.setOnClickListener(){
            DatePickerFragment.newInstance(module.dateOFDelivery).apply {
                setTargetFragment(this@ModuleFragment, REQUEST_DATE)
                show(this@ModuleFragment.requireFragmentManager(), DIALOG_DATE)
            }
        }
    }

    override fun onDateSelected(date: Date) {
        module.dateOFDelivery = date
        dateInText.text = android.text.format.DateFormat.format("yyyy-MM-dd ", date)
    }
}