package com.example.a0106last

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a0106last.api.APIList
import com.example.a0106last.api.ServerAPI
import com.example.a0106last.models.BasicResponse
import kotlinx.android.synthetic.main.activity_sign_up.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSignUp.setOnClickListener {

            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()
            val inputNickname = edtNickname.text.toString()
            val inputPhone = edtPhone.text.toString()


            apiList.putRequestSignUp(
                inputEmail,inputPw,inputNickname,inputPhone
            ).enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful){
                        val br = response.body()!!
                        val signUpNickname = br.data.user.nick_name
                        Toast.makeText(this@SignUpActivity, "${signUpNickname}님 가입을 축하합니다.",Toast.LENGTH_SHORT).show()
                    }
                    else {
                        val testStr= response.errorBody()!!.string()
                        Log.d("문제응답", testStr)
                    }
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }

            })

        }

        btnEmailCheck.setOnClickListener {
            val inputEmail = edtEmail.text.toString()

            apiList.getRequestDuplCheck("EMAIL", inputEmail).enqueue( object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful) {
                        txtEmailCheckResult.text = "사용해도 좋은 이메일입니다."
                    }
                    else {
                        txtEmailCheckResult.text= "중복된 이메일입니다. 다른 이메일로 다시 확인해주세요."
                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }


            })
        }

    }
}