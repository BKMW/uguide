package com.bel.guide

import android.support.v7.widget.RecyclerView
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyAdapter (private var mosques:ArrayList<Mosque>): RecyclerView.Adapter<MyAdapter.MosqueViewHolder>() {

    override fun getItemCount(): Int {
        return mosques.size
    }

    override fun onBindViewHolder(holder: MosqueViewHolder, position: Int) {

        val mosque:Mosque=mosques[position]
        //=== call fun bind in object holder instance of class AritcleViewHolder ===*/
        holder.bind(mosque)

        /* holder.img.loadUrl(urls.imgUrl+article.img)
             var urls=Urls()
             Picasso.with(holder.img.context).load(urls.imgUrl+article.img).into(holder.img);
             holder.title.text=article.title*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MosqueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false )
        return MosqueViewHolder(view)
    }
    /* === class AritcleViewHolder extend class RecyclerView.ViewHolder(item)
      and extends View.OnClickListene === */
    class MosqueViewHolder(item: View): RecyclerView.ViewHolder(item), View.OnClickListener {

        private var img = item.findViewById<ImageView>(R.id.img)
        private var nom = item.findViewById<TextView>(R.id.nom)
        private var mosque: Mosque? = null

        init {
            item.setOnClickListener(this)
        }
        //=== fun bind set data from object article into card_view by item ===/
        fun bind(mosque: Mosque) {
            this.mosque=mosque
            //== setText
            nom.text = mosque.nom
            //== holder.img.loadUrl(urls.imgUrl+article.img)
            val urls=Urls()
            Picasso.with(img.context).load(urls.imgUrl+mosque.photo).into(img)
        }
        //=== end fun
        //=== override fun onClick of class View.OnClickListene ===/
        override fun onClick(view: View) {
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra("title",mosque!!.nom)
            intent.putExtra("description",mosque!!.description)
            intent.putExtra("img",mosque!!.photo)

            view.context.startActivity(intent)
        }
        //=== end override fun
    }
    //=== end class AritcleViewHolder
}