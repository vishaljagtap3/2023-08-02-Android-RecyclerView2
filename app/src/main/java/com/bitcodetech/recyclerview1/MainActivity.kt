package com.bitcodetech.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerCities : RecyclerView
    private val cities = ArrayList<String>()
    private lateinit var citiesAdapter: CitiesAdapter
    private lateinit var edtCity : EditText
    private lateinit var btnAddCity : Button
    private lateinit var btnRemoveCity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initDataSource()
        initViews()
        setUpListeners()
    }

    private fun setUpListeners() {
        btnAddCity.setOnClickListener {
            cities.add(edtCity.text.toString())
            //citiesAdapter.notifyDataSetChanged()
            citiesAdapter.notifyItemInserted(cities.size-1)
        }

        btnRemoveCity.setOnClickListener {

            val city = edtCity.text.toString()
            if(cities.contains(city)) {
                val indexOfCity = cities.indexOf(city)
                cities.remove(city)
                //citiesAdapter.notifyDataSetChanged()
                citiesAdapter.notifyItemRemoved(indexOfCity)
            }
        }
    }

    private fun initDataSource() {
        cities.add("Pune")
        cities.add("Mumbai")
        cities.add("Chennai")
    }

    private fun initViews() {

        edtCity = findViewById(R.id.edtCity)
        btnAddCity = findViewById(R.id.btnAddCity)
        btnRemoveCity = findViewById(R.id.btnRemoveCity)

        recyclerCities = findViewById(R.id.recyclerCities)
        citiesAdapter = CitiesAdapter(cities)
        recyclerCities.adapter = citiesAdapter
        recyclerCities.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}