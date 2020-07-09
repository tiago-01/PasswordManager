package com.ipca.passwordmanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class DeleteActivity :AppCompatActivity() {

    private lateinit var editAppView: EditText



    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        editAppView = findViewById(R.id.edit_appname)



        val button = findViewById<Button>(R.id.button_delete)
        button.setOnClickListener {
            val intentResult = Intent()
            if (TextUtils.isEmpty(editAppView.text)) {
                setResult(Activity.RESULT_CANCELED, intentResult)
            } else {
                val app = editAppView.text.toString()
                val email = ""
                val password = ""
                intentResult.putExtra(APP_NAME, app)
                intentResult.putExtra(APP_EMAIL, email)
                intentResult.putExtra(APP_PASSWORD, password)
                setResult(Activity.RESULT_OK, intentResult)
            }
            finish()
        }
    }

    companion object {

        val APP_NAME="appname"
        val APP_EMAIL="email"
        val APP_PASSWORD="password"

    }
}
