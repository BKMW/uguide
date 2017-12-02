package com.bel.guide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mosquee.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MosqueeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mosquee)
        val  data=intent
        val ville=data.extras.getString("ville")
        //// ==== ville we add it in strings array and will update it to get from DataBase
        var id=1

        getMosquesVille(id)
    }//==== end onCreate

    private fun getMosquesVille(id:Int){
        // must be change access modifier  to correct :) in class Urls of var baseUrl
        val urls=Urls()
        Retrofit.Builder().baseUrl(urls.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
                .getMosques(id)
                .enqueue(object : Callback<ArrayList<Mosque>> {
                    override fun onFailure(call: Call<ArrayList<Mosque>>?, t: Throwable?) {
                        Toast.makeText(this@MosqueeActivity,"تاكد من اعدادات الانترنت", Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<ArrayList<Mosque>>?, response: Response<ArrayList<Mosque>>?) {



                        rec.layoutManager= LinearLayoutManager(this@MosqueeActivity, LinearLayout.VERTICAL,false)
                        val mosques:ArrayList<Mosque> = response!!.body()!!
                        val adapter = MyAdapter(mosques)
                        rec.adapter= adapter

                    }


                })

    }
    //=========== end fun
}
