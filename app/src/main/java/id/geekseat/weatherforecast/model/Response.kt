package id.geekseat.weatherforecast.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("current")
	val current: Current? = null,

	@field:SerializedName("alert")
	val alert: Alert? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("forecast")
	val forecast: Forecast? = null
)