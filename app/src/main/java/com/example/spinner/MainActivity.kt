package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewParent
import android.view.WindowId
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provincias = arrayOf(
            "Ávila",
            "Burgos",
            "León",
            "Palencia",
            "Salamanca",
            "Segovia",
            "Soria",
            "Valladolid",
            "Zamora"
        )

        val spinner:Spinner = findViewById(R.id.spinner)
        //val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, provincias)
        //spinner.adapter = adapter2
        ArrayAdapter.createFromResource(this, R.array.planets_array,android.R.layout.simple_spinner_item)
            .also { adapter ->
                // Specify the layout to use when the list of choices appears.
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner.
                spinner.adapter = adapter
            }


        spinner.onItemSelectedListener = this


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //val text: String = parent?.getItemAtPosition(position).toString()
        val spinner:Spinner = findViewById(R.id.spinner)
        val text: String = spinner.selectedItem.toString()

        val textView:TextView = findViewById(R.id.textView)
        textView.text = "Provincia seleccionada: $text"
    }
}