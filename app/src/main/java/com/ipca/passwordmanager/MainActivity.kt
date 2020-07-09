package com.ipca.passwordmanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.recyclerview_item.*

class MainActivity : AppCompatActivity() {

    private val newAppActivityRequestCode = 1
    private lateinit var appViewModel: AppViewModel
    private val deleteActivityRequestCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = AppListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        appViewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        appViewModel.allApps.observe(this, Observer { apps ->
            apps?.let { adapter.setApps(it) }
        })


        val add = findViewById<Button>(R.id.buttonadd)
        add.setOnClickListener {
            val intent = Intent(this@MainActivity, NewAppActivity::class.java)
            startActivityForResult(intent, newAppActivityRequestCode)
        }
        val delete = findViewById<Button>(R.id.buttondelete)
        delete.setOnClickListener {
            val intent = Intent(this@MainActivity, DeleteActivity::class.java)
            startActivityForResult(intent, deleteActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newAppActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val app = App(data.getStringExtra(NewAppActivity.APP_NAME),
                    data.getStringExtra(NewAppActivity.APP_EMAIL),
                    data.getStringExtra(NewAppActivity.APP_PASSWORD))
                appViewModel.insert(app)
                Unit
            }
        }
        if (requestCode == deleteActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val app = App(data.getStringExtra(DeleteActivity.APP_NAME),
                    data.getStringExtra(DeleteActivity.APP_EMAIL),
                    data.getStringExtra(DeleteActivity.APP_PASSWORD))
                appViewModel.delete(app)
                Unit
            }
        }
    }
}
