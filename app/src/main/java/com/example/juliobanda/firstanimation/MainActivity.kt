package com.example.juliobanda.firstanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val seekBarListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            val progressDividedByTen = progress / 10
            textView_progress.text = progressDividedByTen.toString()

            val translationDistance = initialTextViewTranslationY + progressDividedByTen * resources.getDimension(R.dimen.text_anim) * -1
            textView_progress.animate().translationY(translationDistance)

            if(!fromUser) {
                textView_progress.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationY)
            }
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }

    }

    private val buttonResetOnClickListener = View.OnClickListener {
        seekBar.progress = 0
    }

    var initialTextViewTranslationY: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar.setOnSeekBarChangeListener(seekBarListener)
        button_reset.setOnClickListener(buttonResetOnClickListener)

    }
}
