package com.arno.cslibrary;

import android.view.View;


public interface IClearRootView {
    //清楚方向
    void setClearSide(Constants.Orientation orientation);

    void setIPositionCallBack(IPositionCallBack l);

    void setIClearEvent(AClearEvent l);

    void addView(View child, int index);
}
