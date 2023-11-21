package com.ramawidi.panicbuttonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.google.firebase.auth.FirebaseAuth
import com.ramawidi.panicbuttonapp.databinding.ActivityLoginotpBinding
import papaya.`in`.sendmail.SendMail
import kotlin.random.Random
import kotlin.random.nextInt

class loginotpActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityLoginotpBinding
    // edit text
    private val editTexts = mutableListOf<EditText>()
    lateinit var auth: FirebaseAuth
    var email : String=""
    var pass : String=""
    var random : Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginotpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        email=intent.getStringExtra("email").toString()
        pass=intent.getStringExtra("pass").toString()
        auth=FirebaseAuth.getInstance()

        random()

        binding.showEmail.setText(email.toString())

        binding.tvResend.setOnClickListener {
            random()
        }

        binding.edtOtp1.doOnTextChanged { text, start, before, count ->
            if(!binding.edtOtp1.text.toString().isEmpty()){
                binding.edtOtp2.requestFocus()
            }
            if(!binding.edtOtp2.text.toString().isEmpty()){
                binding.edtOtp2.requestFocus()
            }
        }

        binding.edtOtp2.doOnTextChanged { text, start, before, count ->
            if(!binding.edtOtp2.text.toString().isEmpty()){
                binding.edtOtp3.requestFocus()
            }
            else{
                binding.edtOtp1.requestFocus()
            }

        }
        binding.edtOtp3.doOnTextChanged { text, start, before, count ->
            if(!binding.edtOtp3.text.toString().isEmpty()){
                binding.edtOtp4.requestFocus()
            }
            else{
                binding.edtOtp2.requestFocus()
            }

        }
        binding.edtOtp4.doOnTextChanged { text, start, before, count ->
            if(!binding.edtOtp4.text.toString().isEmpty()){
                binding.edtOtp5.requestFocus()
            }
            else{
                binding.edtOtp3.requestFocus()
            }

        }
        binding.edtOtp5.doOnTextChanged { text, start, before, count ->
            if(!binding.edtOtp5.text.toString().isEmpty()){
                binding.edtOtp6.requestFocus()
            }
            else{
                binding.edtOtp4.requestFocus()
            }

        }
        binding.edtOtp6.doOnTextChanged { text, start, before, count ->
            if(binding.edtOtp6.text.toString().isEmpty()){
                binding.edtOtp5.requestFocus()
            }

            binding.btnKirim.setOnClickListener {
                var otp1=binding.edtOtp1.text.toString()
                var otp2=binding.edtOtp2.text.toString()
                var otp3=binding.edtOtp3.text.toString()
                var otp4=binding.edtOtp4.text.toString()
                var otp5=binding.edtOtp5.text.toString()
                var otp6=binding.edtOtp6.text.toString()

                var otp="$otp1$otp2$otp3$otp4$otp5$otp6"

                if(binding.edtOtp1.text.toString().isEmpty()||
                    binding.edtOtp2.text.toString().isEmpty()||
                    binding.edtOtp3.text.toString().isEmpty()||
                    binding.edtOtp4.text.toString().isEmpty()||
                    binding.edtOtp5.text.toString().isEmpty()||
                    binding.edtOtp6.text.toString().isEmpty()){
                    Toast.makeText(this@loginotpActivity, "Enter OTP", Toast.LENGTH_SHORT).show()
                }
                else if(!otp.equals(random.toString())){
                    Toast.makeText(this@loginotpActivity, "Wrong OTP", Toast.LENGTH_SHORT).show()
                }
                else{
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if(it.isSuccessful){
                            var intent=Intent(this@loginotpActivity,loginotp2Activity::class.java)
                            startActivity(intent)
                        }
                        else {
                            Toast.makeText(this@loginotpActivity, it.exception?.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }

        }

    }
    fun random(){
        random= Random.nextInt(100000..999999)
        var mail= SendMail("yourlightnovember@gmail.com","tujd ybmj yqrh csod\n",email,"Login Signup app's OTP",
            "Your OTP is -> $random")
        mail.execute()
    }

}