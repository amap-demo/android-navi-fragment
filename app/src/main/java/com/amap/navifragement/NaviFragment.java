package com.amap.navifragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;

/**
 * 自定义Fragment 操作AMapNaviView
 */
public class NaviFragment extends Fragment implements AMapNaviViewListener {
    private AMapNaviView mAMapNaviView;


    public NaviFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navi, container, false);
        mAMapNaviView = (AMapNaviView) view.findViewById(R.id.navi_view);
        mAMapNaviView.onCreate(savedInstanceState);
        mAMapNaviView.setAMapNaviViewListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAMapNaviView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mAMapNaviView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAMapNaviView.onDestroy();
    }


    @Override
    public void onNaviSetting() {

    }

    @Override
    public void onNaviCancel() {
        this.getActivity().finish();
    }

    @Override
    public boolean onNaviBackClick() {
        return false;
    }

    @Override
    public void onNaviMapMode(int i) {

    }

    @Override
    public void onNaviTurnClick() {

    }

    @Override
    public void onNextRoadClick() {

    }

    @Override
    public void onScanViewButtonClick() {

    }

    @Override
    public void onLockMap(boolean b) {

    }

    @Override
    public void onNaviViewLoaded() {

    }
}
