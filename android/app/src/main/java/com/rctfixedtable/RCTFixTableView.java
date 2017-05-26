package com.rctfixedtable;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.react.uimanager.ThemedReactContext;
import com.rmondjone.locktableview.DisplayUtil;
import com.rmondjone.locktableview.LockTableView;

import java.util.ArrayList;

/**
 * Created by AresPan on 2017/5/26.
 */

public class RCTFixTableView extends LinearLayout {

    private ThemedReactContext context;
    private LockTableView mLockTableView;
    private Activity activity;

    public RCTFixTableView(ThemedReactContext _context, Activity _activity) {
        super(_context);
        context = _context;
        activity = _activity;
        initDisplayOpinion();
        // 初始化table
        init();
    }

    public void init() {
        this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        // 构造假数据
        ArrayList<ArrayList<String>> mTableDatas=new ArrayList<ArrayList<String>>();
        ArrayList<String> mfristData=new ArrayList<String>();
        mfristData.add("标题");
        for (int i=0;i<2;i++){
            mfristData.add("数据"+i);
        }
        mTableDatas.add(mfristData);
        for (int i=0;i<22;i++){
            ArrayList<String> mRowDatas=new ArrayList<String>();
            mRowDatas.add("标题"+i);
            mRowDatas.add("数据11111111111"+i);
            for (int j=0;j<10;j++){
                mRowDatas.add("数据"+j);
            }
            mTableDatas.add(mRowDatas);
        }

        mLockTableView=new LockTableView(context,linearLayout,mTableDatas);
        mLockTableView.setLockFristColumn(true) //是否锁定第一列
                .setLockFristRow(true) //是否锁定第一行
                .setMaxColumnWidth(100) //列最大宽度
                .setMinColumnWidth(60) //列最小宽度
                .setMinRowHeight(20)//行最小高度
                .setMaxRowHeight(60)//行最大高度
                .setTextViewSize(16) //单元格字体大小
                .setFristRowBackGroudColor(R.color.table_head)//表头背景色
                .setTableHeadTextColor(R.color.beijin)//表头字体颜色
                .setTableContentTextColor(R.color.border_color)//单元格字体颜色
                .setNullableString("N/A") //空值替换值
                .setTableViewListener(new LockTableView.OnTableViewListener() {
                    @Override
                    public void onTableViewScrollChange(int x, int y) {
                        Log.e("滚动值","["+x+"]"+"["+y+"]");
                    }
                }).show();//设置滚动回调监听
        this.addView(linearLayout);
    }

    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(context, dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(context, dm.heightPixels);
    }
}
