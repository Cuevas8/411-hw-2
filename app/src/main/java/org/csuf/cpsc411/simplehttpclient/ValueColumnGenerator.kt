package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout

class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.DKGRAY)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.topMargin = 5
        var claimTitleValue = EditText(ctx)

        claimTitleValue.id = R.id.claim_title
        claimTitleValue.setHint("Enter Claim Title")
        claimTitleValue.setBackgroundColor(Color.WHITE)
        layoutObj.addView(claimTitleValue, vParams)

        var dateValue = EditText(ctx)
        dateValue.id = R.id.date_value
        dateValue.setHint("DD/MM/YYYY")
        dateValue.setBackgroundColor(Color.WHITE)
        layoutObj.addView(dateValue, vParams)

        return layoutObj
    }
}