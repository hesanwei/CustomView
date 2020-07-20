package com.he.measure

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.forEach
import kotlin.concurrent.timer

/**
 * CustomViewGroup class
 *
 * @author hesanwei created on 2020/7/20
 *
 */
class CustomViewGroup : ViewGroup {
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
        measureChildren(widthMeasureSpec,heightMeasureSpec)
    }

    override fun onLayout(p0: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var left = 0
        var top = 0
        var right = 0
        var bottom = 0
        forEach {
            right += it.measuredWidth + 20
            bottom = top + it.measuredHeight
            it.layout(left, top, right, bottom)
            left += right
        }
    }
}