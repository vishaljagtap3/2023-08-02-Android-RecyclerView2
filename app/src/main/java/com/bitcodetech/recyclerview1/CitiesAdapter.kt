package com.bitcodetech.recyclerview1

import android.util.Log
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CitiesAdapter(
    private val cities : ArrayList<String>
) : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    inner class CityViewHolder(val txtCity : TextView) : ViewHolder(txtCity) {
        init {
            //Way 3 - Perfecto
            txtCity.setOnClickListener {
                Toast.makeText(it.context, "${cities[adapterPosition]} $adapterPosition", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        Log.e("bit", "getItemCount")
        return cities.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        Log.e("bit", "onCreateViewHolder")

        val txtCity = TextView(parent.context)
        txtCity.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT
        )
        txtCity.textSize = 30f
        txtCity.setPadding(40, 60, 20, 60)

        //way 1 Handling click events //not good
        /*txtCity.setOnClickListener {
            Toast.makeText(it.context, "City Clicked", Toast.LENGTH_SHORT).show()
        }*/

        return CityViewHolder(txtCity)

    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        Log.e("bit", "onBindViewHolder : $position")
        holder.txtCity.text = "${cities[position]}"

        //way 2 -- works, however it is still not good
        /*holder.txtCity.setOnClickListener {
            Toast.makeText(it.context, cities[position], Toast.LENGTH_SHORT).show()
        }*/
    }

}