package com.example.androidbasic01

import android.graphics.Color
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.ITALIC
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        var option = 0

        if (boldOption.isChecked) option += BOLD
        if (italicOption.isChecked) option += ITALIC

        previewText.setTypeface(null, option)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (nameEdit.text.isBlank()) {
                    greetText.text = "이름이 없습니다."
                } else {
                    greetText.text = "${nameEdit.text}님, 안녕하세요."
                }
            }
        })

        petImage.setOnClickListener(object : View.OnClickListener {
            var isDefault = true
            override fun onClick(v: View?) {
                isDefault = !isDefault
                if (isDefault) petImage.setImageResource(R.drawable.dog)
                else petImage.setImageResource(R.drawable.cat)
            }
        })

        changeButton.setOnClickListener(object : View.OnClickListener {
            var isDefault = true
            override fun onClick(v: View?) {
                isDefault = !isDefault
                if (isDefault) petImage.scaleType = ImageView.ScaleType.CENTER_CROP
                else petImage.scaleType = ImageView.ScaleType.FIT_CENTER
            }
        })



        boldOption.setOnCheckedChangeListener(this)
        italicOption.setOnCheckedChangeListener(this)

        colorOptionGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.redOption -> previewText.setTextColor(Color.RED)
                    R.id.blueOption -> previewText.setTextColor(Color.BLUE)
                    R.id.greenOption -> previewText.setTextColor(Color.GREEN)
                }
            }
        })
    }
}
