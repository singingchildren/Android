package com.wangzijie.nutrition_user.utils;

import android.content.Context;

import com.github.mikephil.charting.components.MarkerView;
import com.wangzijie.nutrition_user.R;

public class PositionMarker extends MarkerView {
    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     */
    public PositionMarker(Context context) {
        super(context, R.layout.item_chart_post);
    }


}
