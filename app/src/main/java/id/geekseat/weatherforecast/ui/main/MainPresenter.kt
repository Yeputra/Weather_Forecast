package id.geekseat.weatherforecast.ui.main

import android.util.Log
import id.geekseat.weatherforecast.BuildConfig
import id.geekseat.weatherforecast.api.ApiClient
import id.geekseat.weatherforecast.api.ApiInterface
import id.geekseat.weatherforecast.model.Forecast
import id.geekseat.weatherforecast.model.ForecastdayItem
import id.geekseat.weatherforecast.model.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainView) {
    private lateinit var mWeather: Weather
    var mForecast: Forecast? = null
    var listOfForecast: ArrayList<ForecastdayItem>? = null
    private val api_key = BuildConfig.api_key
    private val city: String = "Bandung"
    private val days: String = "7"

    fun getCurrentWeather() {

        var apiServices = ApiClient.client.create(ApiInterface::class.java)

        val callWeather = apiServices.getWeather(api_key, city, days)
        callWeather.enqueue(object : Callback<Weather> {
            override fun onResponse(callEntertainment: Call<Weather>, response: Response<Weather>) {
                mWeather = response.body()!!
                mWeather.let { view.showCurrentWeather(it) }
                mForecast = mWeather.forecast
                for (i in 0 until mForecast?.forecastday!!.size) {
                    mForecast!!.forecastday!![i]?.let { listOfForecast?.add(it) }
                }

                listOfForecast.let { it?.let { it1 -> view.showForecast(it1) } }
            }

            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                var mWeather = null
                Log.d("gagal", t?.message)
            }
        })
    }
}