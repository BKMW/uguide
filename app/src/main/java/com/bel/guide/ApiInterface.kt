package com.bel.guide

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    //======== method get All by category ========//
    @GET("mosquee/{id}")
    fun getMosques(
            @Path("id") id: Int): Call<ArrayList<Mosque>>
    //======== method get All by category ========//
    @GET("musee/{id}")
    fun getMusee(
            @Path("id") id: Int): Call<ArrayList<Mosque>>
    //======== method post to insert token to data base =======//
    @POST("register")
    fun insertToken(@Body user: User): Call<User>
}