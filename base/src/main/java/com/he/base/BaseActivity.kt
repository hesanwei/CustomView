package com.he.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_base.*

/**
 * BaseActivity class
 *
 * @author hesanwei created on 2020/7/20
 *
 */
class BaseActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        llParent.post {
            tvOutXY.text = "外部view  getLeft === ${llParent.left}----getTop === ${llParent.top}"
        }

        viewChild.post {
            tvInXY.text = "内部view  getLeft === ${viewChild.left}----getTop === ${viewChild.top}"
        }

        viewChild.setOnTouchListener { _, p1 ->
            tvMotion.text =
                "getX----${p1?.x} === getY----${p1?.y}\n getRawX----${p1?.rawX} === getRawY----${p1?.rawY}"
            true
        }
    }
}