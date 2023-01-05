package com.uc.alpvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.uc.alpvp.R
import com.uc.alpvp.databinding.ActivityRegisterPageBinding
import com.uc.alpvp.model.DataX
import com.uc.alpvp.model.GetInputRegister
import com.uc.alpvp.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class register_page : AppCompatActivity() {

    private lateinit var bain: ActivityRegisterPageBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bain = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(bain.root)
        supportActionBar?.hide()

        getToLog()
        checkForm()
    }

    private fun checkForm(){
        var iscompeted: Boolean = true

        val email = bain.iptEmail.text.toString().trim()
        val username = bain.iptUname.text.toString().trim()
        val pass = bain.iptPass.text.toString().trim()

        val users = GetInputRegister(
            email,
            pass,
            username
        )

        if (users.email!!.isEmpty()){
            bain.iptEmail.error = "Email required"
            iscompeted = false
        }else{
            bain.iptEmail.error = ""
        }

        if (users.password!!.isEmpty()){
            bain.iptPass.error = "Password Required"
            iscompeted = false
        }else{
            bain.iptPass.error = ""
        }

        if (users.username!!.isEmpty()){
            bain.iptUname.error = "Username required"
            iscompeted = false
        }else{
            bain.iptUname.error = ""
        }

        if (iscompeted){
            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewModel.createUser(users)
        }

        pindah()

    }

    private fun getToLog(){
        bain.lnkLogin.setOnClickListener(){
            startActivity(Intent(this, LoginPage::class.java))
        }
    }

    private fun pindah(){
        startActivity(Intent(this, homepage::class.java))
    }
}