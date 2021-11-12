package br.com.babyssister.Crud

import retrofit2.Call
import retrofit2.http.*

interface UsersEndpoint {
    @GET("/cadastro")
    fun getUsers(): Call<ArrayList<User>>

    @GET("/cadastro/{id}")
    fun getUserById(@Path("id")id: String): Call<User>

    @PUT("/cadastro/{id}")
    fun putUserById(@Path("id")id: String, @Body body: User): Call<User>

    @POST("/cadastro")
    fun postUser(@Body body: User): Call<User>

    @DELETE("/cadastro/{id}")
    fun deleteUser(@Path("id") id: String): Call<User>
}