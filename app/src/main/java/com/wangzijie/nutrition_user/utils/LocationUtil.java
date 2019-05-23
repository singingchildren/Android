package com.wangzijie.nutrition_user.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.List;

/**
 * @author WangZequan
 * @time 2019/5/6 22:41
 * @describe
 */
public class LocationUtil {

    private static volatile LocationUtil locationUtil;

    public static synchronized LocationUtil getInstance(Activity activity){
        if (locationUtil==null) {
            synchronized (LocationUtil.class) {
                if (locationUtil==null)
                locationUtil = new LocationUtil();
            }
        }
        return locationUtil;
    }



    public String judgeProvider(LocationManager locationManager,Activity activity) {
        List<String> prodiverlist = locationManager.getProviders(true);
        if(prodiverlist.contains(LocationManager.NETWORK_PROVIDER)){
            return LocationManager.NETWORK_PROVIDER;//网络定位
        }else if(prodiverlist.contains(LocationManager.GPS_PROVIDER)) {
            return LocationManager.GPS_PROVIDER;//GPS定位
        }else{
            Log.d("LocationUtil", "没有可用的位置提供器");
        }
        return null;
    }

    private Location beginLocation(Activity activity) {
        LocationManager lm= (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        //获得位置服务
        String provider = judgeProvider(lm,activity);
        //有位置提供器的情况
        if (provider != null) {
            //为了压制getLastKnownLocation方法的警告
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                return null;
            }

            return lm.getLastKnownLocation(provider);
        }else{
            //不存在位置提供器的情况
            Log.e("LocationUtil", "定位失败,不存在位置提供器的情况");
        }
        return null;
    }

    public String getAreaName(Activity activity) {
        Location location=beginLocation(activity);
        if (location==null){
            return null;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        String addressString = null;
        List<Address> addressList = null;
        Geocoder ge = new Geocoder(activity);
        try {
            addressList = ge.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            Log.e("LocationUtil", "定位异常" + e.getMessage());
            e.printStackTrace();
        }
        if (addressList != null && addressList.size() > 0) {
            for (int i = 0; i < addressList.size(); i++) {
                Address ad = addressList.get(i);
                addressString = ad.getLocality();
                /*if (addressString.length()>2&&addressString.contains("市")){//去掉后面的市字
                    addressString = addressString.substring(0,addressString.length()-1);//拿到城市
                }*/
                Log.d("LocationUtil,城市定位:", ad.getLocality());
            }
        }
        return addressString;
    }
}
