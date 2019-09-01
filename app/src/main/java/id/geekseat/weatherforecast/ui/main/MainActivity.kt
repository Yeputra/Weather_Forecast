package id.geekseat.weatherforecast.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.geekseat.weatherforecast.R
import id.geekseat.weatherforecast.model.Forecast
import id.geekseat.weatherforecast.model.Weather
import org.jetbrains.anko.find
import java.util.*

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
    private lateinit var rvWeather: RecyclerView
    private lateinit var mSwipe: SwipeRefreshLayout

    private lateinit var presenter: MainPresenter
    private lateinit var mAdapter: MainAdapter

    var mForecast: Forecast? = null
    private val calendar = Calendar.getInstance()
    private val day = calendar.get(Calendar.DAY_OF_WEEK)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initToolbar()
    }

    private fun initViews() {
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
        mSwipe = find(R.id.swipe)

        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.setHasFixedSize(true)

        presenter = MainPresenter(this)
        presenter.getCurrentWeather()
        mSwipe.setOnRefreshListener {
            presenter.getCurrentWeather()
        }
    }

    private fun initToolbar() {
        setSupportActionBar(mToolbar)
    }

    override fun showCurrentWeather(weather: Weather) {
        tvCity.text = weather.location?.name
        when (day) {
            Calendar.SUNDAY -> tvToday.text = "Sunday"
            Calendar.MONDAY -> tvToday.text = "Monday"
            Calendar.TUESDAY -> tvToday.text = "Tuesday"
            Calendar.WEDNESDAY -> tvToday.text = "Wednesday"
            Calendar.THURSDAY -> tvToday.text = "Thursday"
            Calendar.FRIDAY -> tvToday.text = "Friday"
            Calendar.SATURDAY -> tvToday.text = "Saturday"
        }
        tvTemperature.text = weather.current?.tempC.toString() + "°C"
        tvWindValue.text = weather.current?.windMph.toString() + "mph"
        tvHumidityValue.text = weather.current?.humidity.toString()
        tvCloudValue.text = weather.current?.cloud.toString()
        tvUvValue.text = weather.current?.uv.toString()

        var icon = "https:" + weather.current?.condition?.icon

        Picasso.get()
            .load(icon)
            .fit()
            .error(R.drawable.sun)
            .into(ivCondition)

        mForecast = weather.forecast

        mAdapter = MainAdapter(this, mForecast!!)
        rvWeather.adapter = mAdapter

        mAdapter.notifyDataSetChanged()
        mSwipe.isRefreshing =false
    }
}
