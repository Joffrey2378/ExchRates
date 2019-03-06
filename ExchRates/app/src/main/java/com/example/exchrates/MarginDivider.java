package com.example.exchrates;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MarginDivider extends RecyclerView.ItemDecoration {
    private final int margin;

    public MarginDivider(int margin) {
        this.margin = margin;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect,
                               @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int childLayoutPosition = parent.getChildLayoutPosition(view);
        outRect.top = margin;
        if (childLayoutPosition < parent.getBottom()) {
            outRect.bottom = margin;
        }
    }
}
