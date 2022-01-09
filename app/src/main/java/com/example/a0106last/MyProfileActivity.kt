package com.example.a0106last

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.a0106last.models.BasicResponse
import com.example.a0106last.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_my_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        apiList.getRequestMyInfo().enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful) {

                    val br = response.body()!!
                    val myInfo = br.data.user

                    txtMyNickname.text = myInfo.nick_name
                    Glide.with(mContext).load(myInfo.profile_img).into(imgMyProfile)
                    txtEmail.text = myInfo.email
                    txtPhoneNum.text = myInfo.phone

                }


            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }


        })

    }
}