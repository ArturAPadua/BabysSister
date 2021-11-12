package br.com.babyssister.Crud

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class UsersServices(val baseUrl: String = "https://6153a4743f4c4300171593c6.mockapi.io/BabySiter/api/1/") {
    private var retrotifClient: Retrofit
    private var endpoint: UsersEndpoint


    init {
        retrotifClient = RetrofitUtils.getRetrofitInstance(baseUrl)
        endpoint = retrotifClient.create(UsersEndpoint::class.java)
    }

    fun getUsers(res: (ArrayList<User>?) -> Unit) {
        endpoint.getUsers().enqueue(object: Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                val list = ArrayList<User>()

                if (response?.body() != null && response.body()!!.size > 0)
                    list.addAll(response.body()!!.toList())

                res(list)
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                res(null)
            }

        })
    }

    fun getUserById(id: String, res: (User?) -> Unit) {
        endpoint.getUserById(id).enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                if (response?.body() != null)
                    res(response?.body())
                else {
                    res(null)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                res(null)
            }

        })
    }

    fun putUserById(id: String, body: User, res: (User?) -> Unit) {
        endpoint.putUserById(id, body).enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                if (response?.body() != null)
                    res(response?.body())
                else {
                    res(null)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                res(null)
            }

        })
    }

    fun postUser(body: User, res: (User?) -> Unit) {
        endpoint.postUser(body).enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                if (response?.body() != null)
                    res(response?.body())
                else {
                    res(null)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                res(null)
            }

        })
    }

    fun deleteUser(id: String, res: (User?) -> Unit) {
        endpoint.deleteUser(id).enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                if (response?.body() != null)
                    res(response?.body())
                else {
                    res(null)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                res(null)
            }

        })
    }
}