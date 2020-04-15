package com.anil.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.android.task.R
import com.anil.task.adapter.TaskDataAdapter
import com.android.task.databinding.ActivityMainBinding
import com.anil.task.model.Row
import com.anil.task.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private var mainViewModel: MainViewModel? = null
    private var taskDataAdapter: TaskDataAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // bind RecyclerView
        val recyclerView = activityMainBinding.viewEmployees
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        taskDataAdapter = TaskDataAdapter()
        recyclerView.adapter = taskDataAdapter
        allEmployee

        swipe_refresh_layout.setOnRefreshListener(OnRefreshListener {
            val recyclerView = activityMainBinding.viewEmployees
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
            taskDataAdapter = TaskDataAdapter()
            recyclerView.adapter = taskDataAdapter
            allEmployee
        })

    }

    private val allEmployee: Unit

        private get() {

            mainViewModel!!.allEmployee.observe(this, Observer {
                employees -> taskDataAdapter!!.setEmployeeList(employees as ArrayList<Row>) })
            swipe_refresh_layout.setRefreshing(false);

        }


}