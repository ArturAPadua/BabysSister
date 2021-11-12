package br.com.babyssister.Crud

import com.google.gson.annotations.SerializedName

class User () {
    @SerializedName("name")
    var nome: String = ""

    @SerializedName("email")
    var email: String = ""

    @SerializedName("senha")
    var senha: String = ""

    @SerializedName("temExBaba")
    var temExBaba: String = ""

    @SerializedName("habilidadesBaba")
    var habilidadesBaba: String = ""

    @SerializedName("valorBaba")
    var valorBaba: Float? = null

    @SerializedName("id")
    var id: Int? = null
}
