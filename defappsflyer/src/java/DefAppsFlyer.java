package com.agulev.defappsflyer;

import android.app.Activity;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

public class DefAppsFlyer {

    public static void DefAppsFlyer_setAppsFlyerKey(final Activity appActivity, final String appsFlyerKey) {
        AppsFlyerConversionListener conversionDataListener =
                new AppsFlyerConversionListener() {

                    @Override
                    public void onAppOpenAttribution(Map<String, String> map) {
                    }

                    @Override
                    public void onAttributionFailure(String s) {
                    }

                    public void onInstallConversionDataLoaded(java.util.Map<java.lang.String, java.lang.String> conversionData) {
                    }

                    public void onInstallConversionFailure(String errorMessage) {
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
}
