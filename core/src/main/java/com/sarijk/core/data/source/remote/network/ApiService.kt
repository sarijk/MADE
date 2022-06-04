package com.sarijk.core.data.source.remote.network

import com.sarijk.core.data.source.remote.response.ListDrinkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/json/v1/1/search.php")
    suspend fun getList(
        @Query("s") query: String
    ): ListDrinkResponse
}
