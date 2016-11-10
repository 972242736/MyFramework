package com.mmf.framework.baidu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.mmf.framework.MyApplication;
import com.mmf.framework.R;

/**
 * Created by MMF
 * date 2016/9/24
 * Description:
 */
public class BaiduFragment extends Fragment {
    private View view;
    MapView mMapView = null;
    TextView tvCity = null;
    PoiSearch mKSearch;
    private BaiduMap mBaiduMap;

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

        mKSearch = PoiSearch.newInstance();
        mKSearch.setOnGetPoiSearchResultListener(new OnGetPoiSearchResultListener() {
            @Override
            public void onGetPoiResult(PoiResult poiResult) {
                System.out.print("poiResult------------"+poiResult);
//                LatLng point = new LatLng(poiResult.getAllPoi().get(0).getgetLatitude(), poiResult.getLongitude());

//                MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(point, 16);
                //设置地图中心点以及缩放级别
//              MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
//                mBaiduMap.animateMapStatus(u);
            }

            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

            }

            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

            }
        });
        view.findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                PoiCitySearchOption poiCitySearchOption = new PoiCitySearchOption()
                        .city("厦门")
                        .keyword("厦门");
                mKSearch.searchInCity(poiCitySearchOption);
            }
        });
    }

    public void setCity() {
        tvCity.setText(MyApplication.getInstance().getCurrlocation().getCity());
        String ss = MyApplication.getInstance().getCurrlocation().getCity();
        Double dfsd = MyApplication.getInstance().getCurrlocation().getLatitude();
        mBaiduMap = mMapView.getMap();
        //定义Maker坐标点
        LatLng point = new LatLng(MyApplication.getInstance().getCurrlocation().getLatitude(), MyApplication.getInstance().getCurrlocation().getLongitude());

        MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(point, 16);
         //设置地图中心点以及缩放级别
//              MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
        mBaiduMap.animateMapStatus(u);
// /构建Marker图标
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
