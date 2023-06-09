package com.example.lasttermdemo3.Login

import android.content.Intent
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lasttermdemo3.IntroActivity.LoadingSceneActivity
import com.example.lasttermdemo3.Model.UserModel
import com.example.lasttermdemo3.config.dialog
import com.example.lasttermdemo3.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUpbtn.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passInput.text.toString()
            val confirmpass = binding.confirmpassInput.text.toString()
            val username = binding.usernameInput.text.toString()

            if(password == confirmpass)

            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        FirebaseDatabase.getInstance().getReference("users").child(FirebaseAuth.getInstance().currentUser!!.uid!!).setValue(UserModel(
                            email=email,
                        ))
                        val intent = Intent(this, SignUpPhoneActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.loginBtn.setOnClickListener{
            val LoginIntent = Intent(this, LoginActivity::class.java)
            startActivity(LoginIntent)
        }

        binding.forgotPassBtn.setOnClickListener {
            val ForgotIntent = Intent(this, ForgotPassActivity::class.java)
            startActivity(ForgotIntent)
        }
    }

}