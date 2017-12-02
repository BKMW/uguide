package com.bel.guide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_home.*
import android.content.Intent
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val adapter = ArrayAdapter.createFromResource(this, R.array.villes, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // ce ligne pour ajouter le radio bouton devant chaque item
        spinner.adapter = adapter// ici charger le spinner par le tableau créer
        //=== call fun firebase ====//
        tokenFireBase()
        //=== webView in sh Allah  to update to kotlin codes  ==//
        webView.loadUrl("https://www.google.tn/maps/@35.6742692,10.1011564,13")
        search.setOnClickListener{
                // TODO Auto-generated method stub

                val ville = spinner.selectedItem.toString()
                            val i = Intent(this, MosqueeActivity::class.java)
                i.putExtra("ville",ville)
                startActivity(i)

            }
        }
    //============function to operation with FireBase FCM ==============//
    private fun tokenFireBase(){
        FirebaseMessaging.getInstance().subscribeToTopic("uguide")
        FirebaseInstanceId.getInstance().token
    }

    }


