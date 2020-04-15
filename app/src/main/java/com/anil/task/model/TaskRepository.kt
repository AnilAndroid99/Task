package com.anil.task.model

import androidx.lifecycle.MutableLiveData
import com.anil.task.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class TaskRepository {
    private var employees: ArrayList<Row?>? = ArrayList()
    private val mutableLiveData = MutableLiveData<List<Row?>?>()
    fun getMutableLiveData(): MutableLiveData<List<Row?>?> {
        val userDataService = RetrofitClient.service
        val call = userDataService.employees
        call!!.enqueue(object : Callback<Country?> {
            override fun onResponse(call: Call<Country?>, response: Response<Country?>) {
                val employeeDBResponse = response.body()
                if (employeeDBResponse != null && employeeDBResponse.rows != null) {
                    employees = employeeDBResponse.rows as ArrayList<Row?>
                    mutableLiveData.value = employees
                }
            }

            override fun onFailure(call: Call<Country?>, t: Throwable) {}
        })
        return mutableLiveData
    }

    companion object {
        private const val TAG = "EmployeeRepository"
    }
}