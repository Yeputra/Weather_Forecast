package id.geekseat.weatherforecast.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import id.geekseat.weatherforecast.R
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    private lateinit var tvCity: TextView
    private lateinit var tvToday: TextView
    private lateinit var tvTemperature: TextView
    private lateinit var tvWindValue: TextView
    private lateinit var tvHumidityValue: TextView
    private lateinit var tvCloudValue: TextView
    private lateinit var tvUvValue: TextView
    private lateinit var ivCondition: ImageView
    private lateinit var mToolbar: Toolbar
    private lateinit var cvWeather: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initToolbar()
    }

    private fun initViews(){
        tvCity = find(R.id.tv_city)
        tvToday = find(R.id.tv_today)
        tvTemperature = find(R.id.tv_temperature)
        tvWindValue = find(R.id.tv_wind_value)
        tvHumidityValue = find(R.id.tv_humidity_value)
        tvCloudValue = find(R.id.tv_cloud_value)
        tvUvValue = find(R.id.tv_uv_value)
        ivCondition = find(R.id.iv_condition)
        mToolbar = find(R.id.toolbar)
    }

    private fun initToolbar(){
        setSupportActionBar(mToolbar)
    }
}
