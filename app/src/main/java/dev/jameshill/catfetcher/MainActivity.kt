package dev.jameshill.catfetcher
// Exercises For Programmers by Brian P. Hogan
// Exercise 49: Cat Photo API
// James Hill, Houston, Texas, 2022
// GitHub: jhill1971 Twitter: @count_BASIC
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import dev.jameshill.catfetcher.MainActivity.ApiCallData.baseUrl
import dev.jameshill.catfetcher.network.CatApiService
import dev.jameshill.catfetcher.network.CatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fetchCat = findViewById<Button>(R.id.fetch_cat_button)

        fetchCat.setOnClickListener{
        fetchCat()
        //  }
    }
}

fun fetchCat() {
    val kittyView = findViewById<ImageView>(R.id.kitty_iv)
    /* Creating a retrofit object */
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /*  Creating a service object that will be used to make the API call */
    val service = retrofit.create(CatApiService::class.java)

    /* Creating a call object that will be used to place the API call */
    val call = service.fetchCat()
    Log.d("NETWORK", "STARTING CALL")
    /* Creating an anonymous class that implements the Callback interface */
    call.enqueue(object : Callback<CatResponse> {
        override fun onResponse(call: Call<CatResponse>, response: Response<CatResponse>) {
            Log.d("NETWORK", "RESPONSE INCOMING")
            if (response.isSuccessful){
                Log.d("A-Okay ", "$response.code()")
                val catResponse = response.body()!!
                val catData = baseUrl+catResponse.url
                Log.d("RESULT", "$catData")
                kittyView.load(catData)
                //System.exit(0)
            }
        }

        override fun onFailure(call: Call<CatResponse>, t: Throwable) {
            println("FAILURE" + t.message)
        }

    })
}

/** Data needed for making the API Call*/
object ApiCallData {
    val baseUrl: String = "https://cataas.com/"}}