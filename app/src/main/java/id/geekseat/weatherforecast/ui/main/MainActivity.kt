package id.geekseat.weatherforecast.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.geekseat.weatherforecast.R
import id.geekseat.weatherforecast.model.ForecastdayItem
import id.geekseat.weatherforecast.model.Weather
import org.jetbrains.anko.find
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), MainView {

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
    private lateinit var rvWeather: RecyclerView

    private lateinit var presenter: MainPresenter

    private val calendar = Calendar.getInstance()
    private val day = calendar.get(Calendar.DAY_OF_WEEK)

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
        rvWeather = find(R.id.rv_weather)

        presenter = MainPresenter(this)
        presenter.getCurrentWeather()
    }

    private fun initToolbar(){
        setSupportActionBar(mToolbar)
    }

    override fun showCurrentWeather(weather: Weather) {
        tvCity.text = weather.location?.name
        when (day){
            Calendar.SUNDAY ->tvToday.text = "Sunday"
            Calendar.MONDAY ->tvToday.text = "Monday"
            Calendar.TUESDAY ->tvToday.text = "Tuesday"
            Calendar.WEDNESDAY ->tvToday.text = "Wednesday"
            Calendar.THURSDAY ->tvToday.text = "Thursday"
            Calendar.FRIDAY ->tvToday.text = "Friday"
            Calendar.SATURDAY ->tvToday.text = "Saturday"
        }
        tvTemperature.text = weather.current?.tempC.toString() + "°C"
        tvWindValue.text = weather.current?.windMph.toString() + "mph"
        tvHumidityValue.text = weather.current?.humidity.toString()
        tvCloudValue.text = weather.current?.cloud.toString()
        tvUvValue.text = weather.current?.uv.toString()

        var icon = weather.current?.condition?.icon?.drop(2)

        Picasso.get()
            .load(icon)
            .placeholder(R.drawable.sun)
            .into(ivCondition)

        Log.d("gambar", weather.current?.condition?.icon?.drop(2))


    }

    override fun showForecast(forecast: ArrayList<ForecastdayItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
