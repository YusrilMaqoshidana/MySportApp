package id.usereal.mysportapp.core.data.remote.retrofit

import id.usereal.mysportapp.core.data.remote.response.SportResponse
import retrofit2.http.GET

interface ApiService {
    @GET
    fun getList(): SportResponse
}