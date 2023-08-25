package com.bitcodetech.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerCities : RecyclerView
    private val cities = arrayOf(
        "Pune0", "Mumbai0", "Chennai0", "Delhi0",
        "Pune1", "Mumbai1", "Chennai1", "Delhi1",
        "Pune2", "Mumbai2", "Chennai2", "Delhi2",
        "Pune3", "Mumbai3", "Chennai3", "Delhi3",
        "Pune4", "Mumbai4", "Chennai4", "Delhi4",
        "Pune5", "Mumbai5", "Chennai5", "Delhi5",
        "Pune6", "Mumbai6", "Chennai6", "Delhi6",
        "Pune7", "Mumbai7", "Chennai7", "Delhi7",
        "Pune8", "Mumbai8", "Chennai8", "Delhi8"
    )
    private lateinit var citiesAdapter: CitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerCities = findViewById(R.id.recyclerCities)
        citiesAdapter = CitiesAdapter(cities)
        recyclerCities.adapter = citiesAdapter
        recyclerCities.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}