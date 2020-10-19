package com.example.evaluacionintermediamoduloiv

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_third.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ThirdFragment : Fragment() {
    private var globalContext :Context?=null


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        globalContext=this.getActivity()

        nameShow.text.toString()
        lastShow.text.toString()
        phoneShow.text.toString()
        mailShow.text.toString()
        companyShow.text.toString()




        phoneShow.setOnClickListener {
           dialPhoneNumber()
        }
        mailShow.setOnClickListener {

            val recipient=mailShow.text.toString()
            sendEmail(recipient)

        }
        volverAgenda2.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)
        }



        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



    fun dialPhoneNumber() {
        val intent = Intent(Intent.ACTION_DIAL)
        startActivity(intent)

    }
    fun sendEmail(recipient: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.data= Uri.parse("mailto:")
        intent.type="text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))

        try {
            startActivity(intent)
        }catch (e:Exception){
                Toast.makeText(globalContext, "e.message", Toast.LENGTH_LONG).show()
        }

    }



}