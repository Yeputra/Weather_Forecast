package id.geekseat.weatherforecast.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{

companion object {

    val BASE_URL = "http://api.apixu.com/v1/"
    private var retrofit: Retrofit? = null
    var retofit: Retrofit? = null

    val client: Retrofit
        get() {

            if (retofit == null) {
                retofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retofit!!
        }

}
}