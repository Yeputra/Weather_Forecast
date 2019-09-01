package id.geekseat.weatherforecast.ui.main

import id.geekseat.weatherforecast.model.Weather

interface MainView {
    fun showCurrentWeather(weather: Weather)
}