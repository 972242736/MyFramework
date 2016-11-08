package com.mmf.framework.baidu;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.mmf.framework.MyApplication;
import com.mmf.framework.R;
import com.mmf.framework.adapter.home.LawyerAdapter;
import com.mmf.framework.model.LawyerInfo;
import com.mmf.framework.presenter.home.HomePresenter;
import com.mmf.framework.view.home.IHomeView;

import java.util.List;

/**
 * Created by MMF
 * date 2016/9/24
 * Description:
 */
public class BaiduFragment extends Fragment {
    private View view;
    MapView mMapView = null;
    TextView tvCity = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.baidu_fragment, null);
        initView();
        return view;
    }

    private void initView() {
        mMapView = (MapView) view.findViewById(R.id.bmapView);
        tvCity = (TextView) view.findViewById(R.id.tv_city);

//        mBaiduMap.clear();
//        OverlayIcon ov = new OverlayIcon(null, this);
//        for (ContentModel content : list) {
//            int latitude = (int) (content.getLatitude() * 1000000);
//            int longitude = (int) (content.getLongitude() * 1000000);
//
//            Drawable d = getResources().getDrawable(R.drawable.icon_marka);
//            OverlayItem item = new OverlayItem(
//                    new GeoPoint(latitude, longitude), content.getName(),
//                    content.getAddr());
//            item.setMarker(d);
//
//            ov.addItem(item);
//        }
//        mMapView.getOverlays().add(ov);
//        mMapView.refresh();
        MyApplication.getInstance().setBaiduFragment(this);
        if (MyApplication.getInstance().getCurrlocation() != null) {
            setCity();
        }

    }

    public void setCity() {
        tvCity.setText(MyApplication.getInstance().getCurrlocation().getCity());
        String ss = MyApplication.getInstance().getCurrlocation().getCity();
        Double dfsd = MyApplication.getInstance().getCurrlocation().getLatitude();
        BaiduMap mBaiduMap = mMapView.getMap();
        //定义Maker坐标点
        LatLng point = new LatLng(MyApplication.getInstance().getCurrlocation().getLatitude(), MyApplication.getInstance().getCurrlocation().getLongitude());
//构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_marka);
//构建MarkerOption，用于在地图上添加Marker
        MarkerOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
//在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
