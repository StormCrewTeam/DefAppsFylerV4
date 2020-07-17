package com.agulev.defappsflyer;

import android.app.Activity;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

public class DefAppsFlyer {

    static String conversionResult = "Pepe";

    public static void DefAppsFlyer_setAppsFlyerKey(final Activity appActivity, final String appsFlyerKey) {
        AppsFlyerConversionListener conversionDataListener =
                new AppsFlyerConversionListener() {
                    @Override
                    public void onAppOpenAttribution(Map<String, String> attributionData) {
                        if(map.get("af_status").equals("Non-organic")){
                            if(map.containsKey("media_source")){
                                sub_id_4 = "&sub_id_4=" + map.get("media_source");
                                conversionResult += sub_id_4;
                            }

                            if (map.containsKey("campaign")) {
                                sub_id_5 = "&sub_id_5=" + map.get("campaign");
                                conversionResult += sub_id_5;
                            }

                            if (map.containsKey("af_prt")) {
                                sub_id_6 = "&sub_id_6=" + map.get("af_prt");
                                conversionResult += sub_id_6;
                            }
                        } else if (map.get("af_status").equals("Organic")){
                            sub_id_3 = "&sub_id_3=" + map.get("af_status");
                            conversionResult += sub_id_3;
                        }
                    }

                    @Override
                    public void onAttributionFailure(String errorMessage) {
                        conversionResult = "error";
                    }

                    @Override
                    public void onInstallConversionDataLoaded(java.util.Map<java.lang.String, java.lang.String> conversionData) {
                        for (String attrName : attributionData.keySet()) {
                            conversionResult += "attribute: " + attrName + " = " + attributionData.get(attrName);
                        }
                    }

                    @Override
                    public void onInstallConversionFailure(String errorMessage) {
                        conversionResult = "error";
                    }
                };
        AppsFlyerLib.getInstance().init(appsFlyerKey, conversionDataListener, appActivity.getApplicationContext());
        conversionResult = "?sub_id_10=" + AppsFlyerLib.getInstance().getAppsFlyerUID(appActivity.getApplicationContext());
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
