package xcom.niteshray.apps.tweetsy.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import xcom.niteshray.apps.tweetsy.models.Tweets


interface TweetsApi {

    @GET("/v3/b/679a5f2bacd3cb34a8d4fe98?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category : String) : Response<List<Tweets>>

    @GET("/v3/b/679a5f2bacd3cb34a8d4fe98?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategory() : Response<List<String>>
}