package com.forpus.wayfindingdop

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Toast

class CustomMapView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyle) {

    private val paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    private val markers = mutableListOf<Pair<Float, Float>>()

    init {
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                markers.add(Pair(event.x, event.y))
                Toast.makeText(context, "Location: (${event.x}, ${event.y})", Toast.LENGTH_SHORT).show()
                invalidate()  // Redraw the view
                true
            } else {
                false
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (marker in markers) {
            canvas.drawCircle(marker.first, marker.second, 10f, paint)
        }
    }

    fun addMarker(x: Float, y: Float) {
        markers.add(Pair(x, y))
        invalidate()
    }
}
