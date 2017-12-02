package com.bel.guide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
       /* imageView4.setOnClickListener {
           // val i= Intent(this,QrCodeActivity::class.java)
           // startActivity(i)
        }*/
            //====== add button back =======//
            //getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            //=========== get variable from intent==============//
            val  data=intent
            val titleArticle=data.extras.getString("title")
            //val updatedAt=data.extras.getString("updated_at")
            val imgArticle=data.extras.getString("img")
            val descriptionArticle=data.extras.getString("description")
            //======setTitle(category)=====//
            title=titleArticle
            //======= set variable into view of this activity ========//
            val urls = Urls()
            Picasso.with(this).load(urls.imgUrl+imgArticle).into(img)
            //updated_at.text=updatedAt
            title_article.text=titleArticle
            description.text=descriptionArticle

    }
    //======== override fun add button back =========//
    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        val id:Int = item.itemId
        if(id==android.R.id.home) {
            this.finish()
        }

        return super.onOptionsItemSelected(item)
    }
    //==============end override fun
}
