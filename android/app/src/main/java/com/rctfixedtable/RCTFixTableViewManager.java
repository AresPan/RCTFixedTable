package com.rctfixedtable;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

/**
 * Created by AresPan on 2017/5/26.
 */

public class RCTFixTableViewManager extends SimpleViewManager<RCTFixTableView>{
    @Override
    public String getName() {
        return "RCTFixedTableView";
    }

    @Override
    protected RCTFixTableView createViewInstance(ThemedReactContext reactContext) {
        return new RCTFixTableView(reactContext, reactContext.getCurrentActivity());
    }
}
