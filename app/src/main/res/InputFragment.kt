package edu.wtamu.cis.realestateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import edu.wtamu.cis.realestateapp.R.id.action_inputFragment_to_realtorAPIFragment
import edu.wtamu.cis.realestateapp.R.id.inputCity
import edu.wtamu.cis.realestateapp.R.layout.input_fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.input_fragment.*


@Suppress("UNREACHABLE_CODE")
class InputFragment() : Fragment() {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.input_fragment, container, false)

        return view




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val searchButton: Button? = view?.findViewById(R.id.searchButton)
        searchButton?.setOnClickListener{ v: View -> onButtonClick(v)}

    }





    //Input validation to make sure no EditTexts are blank
    private fun validate() :Boolean{
        if(inputState.text.toString().isEmpty()) {
            inputState.error = "State should be entered as a two character code"
            return false
        }else if(inputCity.text.toString().isEmpty()){
            inputCity.error = "Please enter a city"
            return false
        }else if(inputPrice.toString().isEmpty()) {
            inputPrice.error = "Please enter a maximum price"
            return false
        }else if(inputBedrooms.toString().isEmpty()) {
            inputPrice.error = "Please enter the number of bedrooms you want"
            return false
        }else if(inputBathrooms.toString().isEmpty()) {
            inputBathrooms.error = "Please enter the number of bathrooms you want"
            return false
        }

        return true
    }

    private fun onButtonClick(v: View) {


        when(v!!.id) {

            R.id.searchButton -> navController!!.navigate(R.id.action_inputFragment_to_realtorAPIFragment)

        }
    }

}