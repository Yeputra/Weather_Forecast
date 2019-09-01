package id.geekseat.weatherforecast.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import id.geekseat.weatherforecast.R
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import id.geekseat.weatherforecast.model.Forecast
import kotlinx.android.synthetic.main.item_weather.view.*
import java.util.*

class MainAdapter(var context: Context?, var list: Forecast) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    val calendar = Calendar.getInstance()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        calendar.add(Calendar.DAY_OF_YEAR, +1)
        holder.tvDay.text = calendar.time.toString().take(10)
        holder.tvTemperature.text =
            list.forecastday?.get(position)!!.day?.avgtempC.toString() + "°C"
        var icon = "https:" + list.forecastday?.get(position)!!.day?.condition?.icon

        Picasso.get()
            .load(icon)
            .fit()
            .error(R.drawable.sun)
            .into(holder.ivImage)
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context)
            .inflate(R.layout.item_weather, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.forecastday!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDay = itemView.tv_today
        val tvTemperature = itemView.tv_temperature
        val ivImage = itemView.iv_condition
    }

}