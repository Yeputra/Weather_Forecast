package id.geekseat.weatherforecast.model

import com.google.gson.annotations.SerializedName

data class Day(

	@field:SerializedName("avgvis_km")
	val avgvisKm: Int? = null,

	@field:SerializedName("uv")
	val uv: Double? = null,

	@field:SerializedName("avgtemp_f")
	val avgtempF: Double? = null,

	@field:SerializedName("avgtemp_c")
	val avgtempC: Double? = null,

	@field:SerializedName("maxtemp_c")
	val maxtempC: Double? = null,

	@field:SerializedName("maxtemp_f")
	val maxtempF: Double? = null,

	@field:SerializedName("mintemp_c")
	val mintempC: Double? = null,

	@field:SerializedName("avgvis_miles")
	val avgvisMiles: Int? = null,

	@field:SerializedName("mintemp_f")
	val mintempF: Double? = null,

	@field:SerializedName("totalprecip_in")
	val totalprecipIn: Int? = null,

	@field:SerializedName("avghumidity")
	val avghumidity: Int? = null,

	@field:SerializedName("condition")
	val condition: Condition? = null,

	@field:SerializedName("maxwind_kph")
	val maxwindKph: Double? = null,

	@field:SerializedName("maxwind_mph")
	val maxwindMph: Double? = null,

	@field:SerializedName("totalprecip_mm")
	val totalprecipMm: Int? = null
)