package org.csuf.cpsc411.simplehttpclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CustomActivity : AppCompatActivity() {
    lateinit var cList : MutableList<Claim>
    lateinit var cService : ClaimService

    fun refreshScreen(cObj : Claim) {

        Log.d("Claim Service", "Refreshing the Screen. ")
        val claimTitleView : EditText = findViewById(R.id.claim_title)
        val dateView : EditText = findViewById(R.id.date_value)

        claimTitleView.setText(cObj.title)
        dateView.setText(cObj.date)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)

        val addButtonView : Button = findViewById(R.id.add_button)

        cService = ClaimService.getInstance(this)

        val claimTitle : EditText = findViewById(R.id.claim_title)
        val claimDate : EditText = findViewById(R.id.date_value)
        val statusMessage : TextView = findViewById(R.id.status_message)

        addButtonView.setOnClickListener{

            if (statusMessage.text == "Status Message: Nil") {
                var inputClaim = Claim(claimTitle.text.toString(), claimDate.text.toString())
                cService.addClaim(inputClaim)

                statusMessage.text = claimTitle.text

                claimTitle.text.clear()
                claimDate.text.clear()

                statusMessage.text = "Status Message: Added Successfully"
            }
        }
    }
}