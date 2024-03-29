package id.geekseat.weatherforecast.model

import com.google.gson.annotations.SerializedName

data class ForecastdayItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("astro")
	val astro: Astro? = null,

	@field:SerializedName("date_epoch")
	val dateEpoch: Int? = null,

	@field:SerializedName("day")
	val day: Day? = null
)