package com.example.recyclerviewapp

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Adds equal spacing around RecyclerView items.
 */
class SpacingItemDecoration(private val spacingPx: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(spacingPx, spacingPx, spacingPx, spacingPx)
    }
}
