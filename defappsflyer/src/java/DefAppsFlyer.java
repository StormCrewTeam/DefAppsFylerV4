package com.agulev.defappsflyer;

import android.app.Activity;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

public class DefAppsFlyer {

    static String conversionResult = "Pepe";

    static String sub_id_3 = "";
    static String sub_id_4 = "";
    static String sub_id_5 = "";
    static String sub_id_6 = "";

    public static void DefAppsFlyer_setAppsFlyerKey(final Activity appActivity, final String appsFlyerKey) {
        AppsFlyerConversionListener conversionDataListener =
                new AppsFlyerConversionListener() {
                    @Override
                    public void onAppOpenAttribution(Map<String, String> attributionData) {
                        if(attributionData.get("af_status").equals("Non-organic")){
                            if(attributionData.containsKey("media_source")){
                                sub_id_4 = "&sub_id_4=" + attributionData.get("media_source");
                                conversionResult += sub_id_4;
                            }

                            if (attributionData.containsKey("campaign")) {
                                sub_id_5 = "&sub_id_5=" + attributionData.get("campaign");
                                conversionResult += sub_id_5;
                            }

                            if (attributionData.containsKey("af_prt")) {
                                sub_id_6 = "&sub_id_6=" + attributionData.get("af_prt");
                                conversionResult += sub_id_6;
                            }
                        } else if (attributionData.get("af_status").equals("Organic")){
                            sub_id_3 = "&sub_id_3=" + attributionData.get("af_status");
                            conversionResult += sub_id_3;
                        }
                    }

                    @Override
                    public void onAttributionFailure(String errorMessage) {
                        conversionResult = "error";
                    }

                    @Override
                    public void onInstallConversionDataLoaded(java.util.Map<java.lang.String, java.lang.String> conversionData) {
                        if(conversionData.get("af_status").equals("Non-organic")){
                            if(conversionData.containsKey("media_source")){
                                sub_id_4 = "&sub_id_4=" + conversionData.get("media_source");
                                conversionResult += sub_id_4;
                            }

                            if (conversionData.containsKey("campaign")) {
                                sub_id_5 = "&sub_id_5=" + conversionData.get("campaign");
                                conversionResult += sub_id_5;
                            }

                            if (conversionData.containsKey("af_prt")) {
                                sub_id_6 = "&sub_id_6=" + conversionData.get("af_prt");
                                conversionResult += sub_id_6;
                            }
                        } else if (conversionData.get("af_status").equals("Organic")){
                            sub_id_3 = "&sub_id_3=" + conversionData.get("af_status");
                            conversionResult += sub_id_3;
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
