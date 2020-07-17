package com.agulev.defappsflyer;

import android.app.Activity;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

public class DefAppsFlyer {

    static String conversionResult = "Pepe";

    public static void DefAppsFlyer_setAppsFlyerKey(final Activity appActivity, final String appsFlyerKey) {
        conversionResult = "PEPONETE";
        AppsFlyerConversionListener conversionDataListener =
                new AppsFlyerConversionListener() {

                    @Override
                    public void onConversionDataSuccess(Map<String, Object> conversionData) {
                        conversionResult = "conversion data success";
                        //     for (String attrName : conversionData.keySet()) {
                        //     Log.d("LOG_TAG", "attribute: " + attrName + " = " + conversionData.get(attrName));
                        // }
                    }

                    @Override
                    public void onConversionDataFail(String errorMessage) {
                        conversionResult = "conversion data error";
                        // Log.d("LOG_TAG", "error getting conversion data: " + errorMessage);
                    }

                    @Override
                    public void onAppOpenAttribution(Map<String, String> attributionData) {
                        conversionResult = "attribution data success";
                        // for (String attrName : attributionData.keySet()) {
                        //     Log.d("LOG_TAG", "attribute: " + attrName + " = " + attributionData.get(attrName));
                        // }

                    }

                    @Override
                    public void onAttributionFailure(String errorMessage) {
                        conversionResult = "attribution data error";
                        // Log.d("LOG_TAG", "error onAttributionFailure : " + errorMessage);
                    }
                };
        AppsFlyerLib.getInstance().init(appsFlyerKey, conversionDataListener, appActivity.getApplicationContext());
        AppsFlyerLib.getInstance().trackAppLaunch(appActivity.getApplicationContext(), appsFlyerKey);
        AppsFlyerLib.getInstance().startTracking(appActivity.getApplication());
    }

    public static void DefAppsFlyer_setIsDebug(boolean debugMode) {
        AppsFlyerLib.getInstance().setDebugLog(debugMode);
    }

    public static void DefAppsFlyer_trackEvent(Activity appActivity, String eventName, Map<String, Object> eventValue) {
        AppsFlyerLib.getInstance().trackEvent(appActivity, eventName, eventValue);
    }

    public static String getConversionResult(){
        return conversionResult;
    }
}
