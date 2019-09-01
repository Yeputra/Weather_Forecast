package id.geekseat.weatherforecast.api

import id.geekseat.weatherforecast.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("forecast.json")
    fun getWeather(@Query("key") apiKey: String, @Query("q") city: String, @Query("days") days: String): Call<Weather>
}