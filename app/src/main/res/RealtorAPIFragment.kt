package edu.wtamu.cis.realestateapp

import android.app.DownloadManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.JsonObjectRequest
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.UiSettings
import edu.wtamu.cis.realestateapp.R.id.inputCity
import edu.wtamu.cis.realestateapp.R.layout.input_fragment
import kotlinx.android.synthetic.main.input_fragment.*
import kotlinx.android.synthetic.main.realtor_api_fragment.*
import org.json.JSONObject

class RealtorAPIFragment() : Fragment() {

    //private lateinit var fusedLocationClient: FusedLocationProviderInfo
    private lateinit var geocoder: Geocoder
    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    private lateinit var uiSettings: UiSettings

    private var lat : Double = 0.0
    private var lon : Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.realtor_api_fragment, container, false)

        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val searchButton: Button? = view?.findViewById(R.id.homeButton)
        homeButton?.setOnClickListener{ v: View -> onButtonClick(v)}

    }

    val url = "https://realtor.p.rapidapi.com/properties/v2/list-for-sale"
    val apiKey = "API_KEY"

    val jasonObjectRequest = object : JsonObjectRequest(Request.Method.GET, url, null,
        Response.Listener<JSONObject> { response ->

            val properties = response.getJSONArray("properties")

            val total = response.getString("total")
            textViewResult.text = total + " properties found"

            for (i in 0 until properties.length()) {

                val city = properties.getJSONObject(i).getJSONObject("adress").get("City")
                val state = properties.getJSONObject(i).getJSONObject("address").get("state_code")
                val price = properties.getJSONObject(i).getJSONObject("address").get("price")
                val

            }

        })



//    override fun getHeaders(): Map<String, String> {
//        val params: MutableMap<String, String> = HashMap()
//        params["x-rapidapi-host"] =  "realtor.p.rapidapi.com"
//        params["x-rapidapi-key"] = "API_KEY"
//
//        return params
//    }


}

