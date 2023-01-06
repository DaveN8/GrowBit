package com.uc.alpvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.uc.alpvp.R
import com.uc.alpvp.databinding.ActivityLoginPageBinding
import com.uc.alpvp.model.GetInputLogin
import com.uc.alpvp.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response

@AndroidEntryPoint
class LoginPage : AppCompatActivity() {

    private lateinit var bain: ActivityLoginPageBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bain = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(bain.root)

        checkLogin()
        goToReg()
    }
    private fun checkLogin(){
        bain.btnLogin.setOnClickListener(){
            var uname = bain.iptUsername.text.toString().trim()
            var passw = bain.iptPass.text.toString().trim()

            var iscompeted: Boolean = true

            if (bain.iptUsername.text.isEmpty()){
                bain.iptUsername.error = "Username Required"
                iscompeted = false
            }else{
                bain.iptUsername.error = ""
            }

            if (bain.iptPass.text.isEmpty()){
                bain.iptPass.error = "Password Required"
                iscompeted = false
            }else{
                bain.iptPass.error = ""
            }

            if (iscompeted) {

                viewModel = ViewModelProvider(this@LoginPage).get(UserViewModel::class.java)
                viewModel.Login(uname, passw).enqueue(object : retrofit2.Callback<GetInputLogin> {
                    override fun onResponse(
                        call: Call<GetInputLogin>,
                        response: Response<GetInputLogin>
                    ) {
                        if (response.isSuccessful) {
                            val intent = Intent(this@LoginPage, homepage::class.java)
//                            Toast.makeText(this@LoginPage, response.body()?.id, Toast.LENGTH_SHORT)
//                                .show()
                            intent.putExtra("user_id", response.body()?.id?.toInt())
                            startActivity(intent)
                            Toast.makeText(this@LoginPage, "Login Successful", Toast.LENGTH_SHORT)
                                .show()
                            finish()
                        } else {
                            Toast.makeText(
                                this@LoginPage,
                                "Username/Password is Wrong!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<GetInputLogin>, t: Throwable) {

                    }
                })
            }
        }
    }

    private fun goToReg(){
        bain.lnkRegister.setOnClickListener(){
        startActivity(Intent(this, register_page::class.java))
        }
    }
}