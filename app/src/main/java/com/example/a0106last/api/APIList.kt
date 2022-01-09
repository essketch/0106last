package com.example.a0106last.api

import com.example.a0106last.models.BasicResponse
import retrofit2.Call
import retrofit2.http.*

interface APIList {

    @FormUrlEncoded
    @POST("/user")
    fun postRequestLogin(
        @Field("email") email: String,
        @Field("password") pw: String,
    ) : Call<BasicResponse>

    @FormUrlEncoded
    @PUT("/user")
    fun putRequestSignUp(
        @Field("email") email: String,
        @Field("password") pw: String,
        @Field("nick_name") nick: String,
        @Field("phone") phone: String,
    ) : Call<BasicResponse>

    @GET("/user/check")
    fun getRequestDuplCheck(
        @Query("type") type: String,
        @Query("value") value: String,
    ) : Call<BasicResponse>

    @GET("/review")
    fun getRequestAllReview() : Call<BasicResponse>

    @GET("/user")
    fun getRequestMyInfo() : Call<BasicResponse>

    @GET("/product")
    fun getRequestAllProduct() : Call<BasicResponse>

    @FormUrlEncoded
    @POST("/review")
    fun postRequestSubmitReview(
        @Field("product_id") productIDL: Int,
        @Field("title") title: String,
        @Field("content") content: String,
        @Field("score") score: Float,
        @Field("tag_list") tagStr: String,
    ) : Call<BasicResponse>


    @GET("/review/{review_id}")
    fun getRequestReviewDetail(
        @Path("review_id") id: Int,
    ) : Call<BasicResponse>


}