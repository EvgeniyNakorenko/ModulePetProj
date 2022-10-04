package com.example.modul

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class RepairFragment: Fragment() {

    private var inputText: String? = ""

    private lateinit var module: Module
    private lateinit var moduleNumberText2: TextView
    private lateinit var dateIn: Button
    private lateinit var moduleStation: EditText
    private lateinit var isMilitary: CheckBox
    private lateinit var inputControl: EditText
    private lateinit var filter: Spinner
    private lateinit var powerSupply: Spinner
    private lateinit var amplifierA3: Spinner
    private lateinit var ALC: Spinner
    private lateinit var controlBoard: Spinner
    private lateinit var amplifierA6: Spinner
    private lateinit var capacitorBank: Spinner
    private lateinit var preAmplifier:Spinner
    private lateinit var indicationUnit: Spinner
    private lateinit var sockets_plugs_connectors: Spinner
    private lateinit var comments: TextView
    private lateinit var write: Button
    private lateinit var deleteButton: Button
    private lateinit var clearButton :Button
    private var filterList = "Changed elements:"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        module = Module()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(
            R.layout.fragment_repair,container, false)

        inputText = arguments?.getString("input_txt")

        moduleNumberText2 = rootView.findViewById(R.id.moduleNumberText2) as TextView

        moduleNumberText2.text = inputText

        dateIn = rootView.findViewById(R.id.dateIn) as Button
        dateIn.apply {
            text = module.dateIn.toString()
            isEnabled = false
        }
        moduleStation = rootView.findViewById(R.id.module_station) as EditText
        inputControl = rootView.findViewById(R.id.inputControl) as EditText
        isMilitary = rootView.findViewById(R.id.isMilitary) as CheckBox
        filter = rootView.findViewById(R.id.filterSpinner) as Spinner
        powerSupply = rootView.findViewById(R.id.powerSupplySpinner) as Spinner
        amplifierA3 = rootView.findViewById(R.id.amplifier_A3Spinner) as Spinner
        ALC = rootView.findViewById(R.id.ALCSpinner) as Spinner
        controlBoard = rootView.findViewById(R.id.control_board) as Spinner
        amplifierA6 = rootView.findViewById(R.id.amplifier_A6) as Spinner
        capacitorBank = rootView.findViewById(R.id.capacitor_bank) as Spinner
        preAmplifier = rootView.findViewById(R.id.preAmplifier) as Spinner
        indicationUnit = rootView.findViewById(R.id.indicationUnit) as Spinner
        sockets_plugs_connectors = rootView.findViewById(R.id.sockets_plugs_connectors) as Spinner
        comments = rootView.findViewById(R.id.comments) as TextView
        write = rootView.findViewById(R.id.write) as Button
        deleteButton = rootView.findViewById(R.id.delete) as Button
        clearButton = rootView.findViewById(R.id.clear) as Button

        return rootView
    }

    override fun onStart() {
        super.onStart()

        isMilitary.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked){
                moduleNumberText2.setBackgroundColor(
                    resources.getColor(R.color.yellow))
            }else{
                moduleNumberText2.setBackgroundColor(
                    resources.getColor(android.R.color.primary_text_dark))
            }
        }

        filterA1Spinner()
        powerSupplyA2Spinner()
        amplifierA3Spinner()
        ALCA4Spinner()
        controlBoardA5Spinner()
        amplifierA6Spinner()
        capacitorBankA7Spinner()
        preAmplifierA8Spinner()
        indicationUnitA9Spinner()
        socketsPlugsA10Spinner()

        deleteButton.setOnClickListener(){
            val fragment = ModuleFragment()
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container,fragment)?.
            addToBackStack(null)?.
            commit()
        }

        clearButton.setOnClickListener {
            if (filterList.length > 17) {
                filterList = "Changed elements:"
                comments.text = filterList.dropLast(1)
            }
        }
    }

    private fun filterA1Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.filterComponents,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        filter.adapter = adapter
        filter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = filter.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                filter.setSelection(0)

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun powerSupplyA2Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.PSComponents,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        powerSupply.adapter = adapter
        powerSupply.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = powerSupply.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                powerSupply.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun amplifierA3Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.amplifierA3Components,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        amplifierA3.adapter = adapter
        amplifierA3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = amplifierA3.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                amplifierA3.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun ALCA4Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.ALCA4components,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ALC.adapter = adapter
        ALC.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = ALC.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                ALC.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun controlBoardA5Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.ControlBoardA5Components,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        controlBoard.adapter = adapter
        controlBoard.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = controlBoard.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                controlBoard.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun amplifierA6Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.AmplifierA6Components,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        amplifierA6.adapter = adapter
        amplifierA6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = amplifierA6.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                amplifierA6.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun capacitorBankA7Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.CapacitorBankA7Components,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        capacitorBank.adapter = adapter
        capacitorBank.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = capacitorBank.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                capacitorBank.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun preAmplifierA8Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.PreAmplifierA8Components,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        preAmplifier.adapter = adapter
        preAmplifier.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = preAmplifier.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                preAmplifier.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun indicationUnitA9Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.IndicationUnitA9Components,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        indicationUnit.adapter = adapter
        indicationUnit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = indicationUnit.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                indicationUnit.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun socketsPlugsA10Spinner(){
        val adapter =ArrayAdapter.createFromResource(
            requireContext(),
            R.array.SocketsPlugsComponents,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sockets_plugs_connectors.adapter = adapter
        sockets_plugs_connectors.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val new = sockets_plugs_connectors.selectedItem.toString()
                if (new != "+") filterList += " $new,"
                comments.text = filterList.dropLast(1)
                sockets_plugs_connectors.setSelection(0)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}
