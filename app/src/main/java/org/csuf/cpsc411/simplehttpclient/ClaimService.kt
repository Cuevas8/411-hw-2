package org.csuf.cpsc411.simplehttpclient

import android.util.Log
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type




class ClaimService(val ctx : CustomActivity) {
    lateinit var claimsList : MutableList<Claim>
    var currentIndx : Int = 0

    companion object {
        private var cService : ClaimService? = null
        fun getInstance(activity: CustomActivity) : ClaimService {
            if (cService == null) {
                cService = ClaimService(activity)
            }
            return cService!!
        }
    }

    inner class GetAllServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            // JSON string
            if (responseBody != null) {
                Log.d("Claim Service", "The response JSON string is ${String(responseBody)}")
                val gson = Gson()
                val claimListType: Type = object : TypeToken<List<Claim>>() {}.type
                claimsList = gson.fromJson(String(responseBody), claimListType)
                //
                ctx.refreshScreen(claimsList[currentIndx])
                //
                //act.runOnUiThread {
                //    cbLambdaFunction()
                //}
                Log.d("Claim Service", "The Claim List: ${claimsList}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {

        }
    }

    inner class addServiceRespHandler : AsyncHttpResponseHandler() {

        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Claim Service", "The add Service response : ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {

           // TODO("Not yet implemented")
        }
    }

    fun addClaim(cObj : Claim) {

        val client = AsyncHttpClient()
        //192.168.86.22 --> My Mac IP
        val requestUrl = "http://192.168.86.22:8010/ClaimService/add"

        // 1. Convert the cObj into JSON string
        val pJsonString= Gson().toJson(cObj)
        // 2. Send the post request
        val entity = StringEntity(pJsonString)
        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
    }
}

