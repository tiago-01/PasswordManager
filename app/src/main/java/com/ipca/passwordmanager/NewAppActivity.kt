package com.ipca.passwordmanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewAppActivity :AppCompatActivity() {
    private lateinit var editAppView: EditText
    private lateinit var editEmailView: EditText
    private lateinit var editPasswordView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_app)
        editAppView = findViewById(R.id.edit_appname)
        editEmailView = findViewById(R.id.edit_email)
        editPasswordView = findViewById(R.id.edit_pw)


        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val intentResult = Intent()
            if (TextUtils.isEmpty(editAppView.text)) {
                setResult(Activity.RESULT_CANCELED, intentResult)
            } else {
                val app = editAppView.text.toString()
                val email = editEmailView.text.toString()
                val password = editPasswordView.text.toString()

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
