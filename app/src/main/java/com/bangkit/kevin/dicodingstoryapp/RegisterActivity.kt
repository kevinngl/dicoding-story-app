package com.bangkit.kevin.dicodingstoryapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usernameEditText = findViewById(R.id.editTextUsername)
        passwordEditText = findViewById(R.id.editTextPassword)
        emailEditText = findViewById(R.id.editTextEmail)
        registerButton = findViewById(R.id.buttonRegister)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val email = emailEditText.text.toString()

            // Call the register API
            val call = ApiClient.apiService.register(username, password, email)
            call.enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        // Registration successful
                        Toast.makeText(
                            this@RegisterActivity,
                            "Registration successful.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // Registration failed
                        Toast.makeText(
                            this@RegisterActivity,
                            "Registration failed. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    // Network request failed
                    Toast.makeText(
                        this@RegisterActivity,
                        "Network request failed. Please check your internet connection.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }
}
