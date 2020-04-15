package com.anil.task.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.anil.task.DescriptionActivity
import com.android.task.R
import com.anil.task.adapter.TaskDataAdapter.EmployeeViewHolder
import com.android.task.databinding.EmployeeListItemBinding
import com.anil.task.model.Row
import java.util.*

class TaskDataAdapter : RecyclerView.Adapter<EmployeeViewHolder>() {
    private var employees: ArrayList<Row>? = null
    var pos = 0
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EmployeeViewHolder {
        val employeeListItemBinding: EmployeeListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context),
                R.layout.employee_list_item, viewGroup, false)
        return EmployeeViewHolder(employeeListItemBinding)
    }

    override fun onBindViewHolder(employeeViewHolder: EmployeeViewHolder, i: Int) {
        val currentStudent = employees!![i]
        employeeViewHolder.employeeListItemBinding.employee = currentStudent
        employeeViewHolder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, DescriptionActivity::class.java)
            intent.putExtra("titile", employees!![i].title)
            intent.putExtra("des", employees!![i].description)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return if (employees != null) {
            employees!!.size
        } else {
            0
        }
    }

    fun setEmployeeList(employees: ArrayList<Row>?) {
        this.employees = employees
        notifyDataSetChanged()
    }

    inner class EmployeeViewHolder(val employeeListItemBinding: EmployeeListItemBinding) : ViewHolder(employeeListItemBinding.root)




}