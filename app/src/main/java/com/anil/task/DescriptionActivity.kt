package com.anil.task

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.android.task.R
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val `in` = intent
        val titile = `in`.getStringExtra("titile")
        supportActionBar!!.setTitle(titile)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val des = `in`.getStringExtra("des")
        textView.text=""+des;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }
}