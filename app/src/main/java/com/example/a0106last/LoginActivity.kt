package com.example.a0106last

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a0106last.api.APIList
import com.example.a0106last.api.ServerAPI
import com.example.a0106last.models.BasicResponse
import com.example.a0106last.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_login.*

import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btnSignUp
import kotlinx.android.synthetic.main.activity_sign_up.edtEmail
import kotlinx.android.synthetic.main.activity_sign_up.edtPassword
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()


            apiList.postRequestLogin(inputEmail, inputPw).enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {

                    if (response.isSuccessful){

                        val br = response.body()!!
                        val loginUserNick = br.data.user.nick_name
                        Toast.makeText(this@LoginActivity, "${loginUserNick}님, 환영합니다.",Toast.LENGTH_SHORT).show()

                        ContextUtil.setToken(mContext, br.data.token)

                        val myIntent = Intent(mContext, MainActivity::class.java)
                        startActivity(myIntent)

                        finish()

                    }
                    else {
                        Toast.makeText(this@LoginActivity, "로그인 실패",Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }


            })
        }

        btnSignUp.setOnClickListener {
            val myIntent = Intent(this,SignUpActivity::class.java)
            startActivity(myIntent)
        }









    }
}