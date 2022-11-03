package com.epson.epos2_printer.utils

object Constants {
//http://10.99.55.22/qtouch_api_Centralized/Api/GetBranches
    //Language
    const val LNG_ARABIC = "ar"
    const val LNG_ENGLISH = "en"

    const val DISPLAY_LNG_ENGLISH = "English"
    const val DISPLAY_LNG_ARABIC = "العربية"

    const val INPUT_NUMBER_LENGTH = 8

    const val ALLOW_NUMBER_5 = 5
    const val ALLOW_NUMBER_9 = 9
    const val ALLOW_NUMBER_6 = 6

    const val INT_ENGLISH = 1
    const val INT_ARABIC = 2

    //http://gickuwait-dev.com/
    //10.127.128.1
    //10.151.0.31
    //10.99.55.22
    //http://qms.kw.zain.com qurain both branches
   //   const val BASE_URL = "http://10.99.55.22/qtouch_api_Centralized/"
    const val BASE_URL = "http://192.168.201.209/Qtouch_API/" //pada
   // const val BASE_URL = "http://gickuwait-dev.com/Qtouch_API/"
    //http://10.151.0.31/qtouch_api_test
    //http://qms.kw.zain.com
    //http://10.151.0.31/
    //10.99.55.22

        //  const val BASE_URL_LOCAL = "http://10.151.0.31/Qtouch_API/"   //http://10.151.0.31/
   const val BASE_URL_LOCAL = "http://gickuwait-dev.com/Qtouch_API/"   //http://10.151.0.31/
   // adliya zain
    // const val BASE_URL_LOCAL = "http://10.99.55.22/"

    const val BRANCH_DEFAULT_VALUE = -999
    const val DELAY_CHECK_BRANCH = 10000L

    const val DELAY_SCREENSAVER = 180000L
  //const val DELAY_SCREENSAVER = 10000L

    const val DELAY_ONE_SECOND = 800L

    const val DELAY_LESS_THEN_ONE_SECOND = 550L

    const val DELAY_ONE_MINUTE = 60000L


    const val DELAY_UPDATE_APP = 200000L
    const val DELAY_BRANCH_SERVICES = 15000L
    const val DELAY_INTERNET_CONNECTION = 5000L


    //string
    const val INTERNET_CONNECTION = "No Internet Connection"
    const val SERVER_ERROR = "Error getting Data from Server"


    //branch
    const val BRANCH_AUTH = "Branch Auth"
    const val BRANCH_AUTH_ID = "Branch Auth ID"
    const val BRANCH_AUTH_NAME = "Branch Auth Name"

    const val PACKET_CONFIG_AUTH = "Packet config Auth"

    const val PREFERENCE_DISPLAY_MESSAGE_AUTH = "Preference display Message Auth"

    const  val SHOW_BLINK_INDEX_AUTH = "showblinkIndex Auth"

    const val IS_CALL_SENDDISPLAYMESSAGE = "SendDisplayMessage Auth"

    const val IS_CALL_TIMERDISPLAY = "TIMERDISPLAY Auth"

    const val BLUETOOTH_AUTH = "Bluetooth Auth"
    const val BLUETOOTH_NAME = "Bluetooth Name"

    const val LOCAL_SERVER_NAME_AUTH = "Local Server Name Auth"
    const val LOCAL_SERVER_NAME = "Local Server Name"

    const val SERVER_NAME_AUTH = "Server Name Auth"
    const val SERVER_NAME = "Server Name"

    const val SERVER_AUTH = "Server Auth"
    const val LOCAL_DATABASE = "Local Database"

    //intent extra
    const val EXTRA_ERROR = "extra error"
    const val EXTRA_ERROR_EN = "extra error en"
    const val EXTRA_BRANCH_ID = "extra branch id"
    const val EXTRA_MOBILE_NUMBER = "extra mobile number"
    const val EXTRA_CHECKED_NUMBER = "extra check number"

    //font style
    const val TYPEFACE_BOLD = "Bold"
    const val TYPEFACE_BOLD_ITALIC = "BoldItalic"
    const val TYPEFACE_ITALIC = "Italic"

    const val ERROR_PORT = "Fail to openPort...\n" +
            "    \n" +
            "    Error code: -1 (Failed)"

    //message

    const val NO_BRANCH_INFORMATION = "No Information Available for Branch"
    const val NO_BRANCH_INFORMATION_AR = "لا توجد معلومات متاحة للفرع"

    const val INTERNET_ERROR = "No Internet Connection!! Please contact to Administrator"
    const val INTERNET_ERROR_AR = "للا يوجد اتصال بالإنترنت !! يرجى الاتصال بالمسؤول"

    const val SERVER_ERROR_En = "Error getting Data from Server!! Please contact to Administrator"
    const val SERVER_ERROR_AR = "خطأ في الحصول على البيانات من الخادم !! يرجى الاتصال بالمسؤول"

    const val BRANCH_ADMIN_En = "Choose a Branch!! Please contact to Administrator"
    const val BRANCH_ADMIN_AR = "اختر الفرع !! يرجى الاتصال بالمسؤول"

    const val MSG_UPDATE_SUCCESFULL = "Application Updated Successfully - تم تحديث التطبيق بنجاح"

    const val MSG_UPDATE_FAILED = "Application Updated Failed - فشل تحديث التطبيق "


}