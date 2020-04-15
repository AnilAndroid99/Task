package com.anil.task.network

import com.anil.task.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface TaskDataService {
    // @GET("users/?per_page=12&amp;page=1")
    @get:GET("s/2iodh4vg0eortkl/facts.json")
    val employees: Call<Country?>?
}