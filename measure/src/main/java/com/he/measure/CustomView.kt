package com.he.measure

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * CustomView class
 *
 * @author hesanwei created on 2020/7/20
 *
 */
class CustomView : View {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val wMode = MeasureSpec.getMode(widthMeasureSpec)
        val wSize = MeasureSpec.getSize(widthMeasureSpec)

        val hMode = MeasureSpec.getMode(heightMeasureSpec)
        val hSize = MeasureSpec.getSize(heightMeasureSpec)

        if (wMode == MeasureSpec.AT_MOST && hMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, 300)
        } else if (wMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(300, hSize)
        } else if (hMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(wSize, 300)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.e("CustomView", "w-->$w  ---  h-->$h")
    }
}