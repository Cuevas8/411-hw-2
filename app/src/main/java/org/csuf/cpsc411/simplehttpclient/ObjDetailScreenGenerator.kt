package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {

//        // 1. add title LinearLayout
//        val tLayout = LinearLayout(ctx)
//        val tParams = LinearLayout.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT)
//        // only applied to height now
//        tParams.gravity = Gravity.CENTER
//        tLayout.layoutParams = tParams
//        tLayout.orientation = LinearLayout.HORIZONTAL
//        tLayout.setBackgroundColor(Color.GRAY)
//        val tlabel = TextView(ctx)
//        tlabel.text = "Please Enter Claim Information"
//        tlabel.setBackgroundColor(Color.RED)
//        tLayout.addView(tlabel, tParams)
//        layoutObj.addView(tLayout, tParams)

        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.GRAY)



        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)


        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)


        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.GRAY)
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setId(R.id.add_button)
        nButton.setBackgroundColor(Color.CYAN)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)
        layoutObj.addView(nLayout, nParams)

        var lbl = TextView(ctx)
        lbl.text = "Status Message: Nil"
        lbl.gravity = Gravity.CENTER
        lbl.setTextColor(Color.BLACK)
        lbl.setBackgroundColor(Color.YELLOW)
        lbl.id = R.id.status_message

        layoutObj.addView(lbl, nParams)

        return layoutObj
    }
}