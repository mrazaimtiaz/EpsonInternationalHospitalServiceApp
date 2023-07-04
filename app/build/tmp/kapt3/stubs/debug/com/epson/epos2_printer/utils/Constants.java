package com.epson.epos2_printer.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b-\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/epson/epos2_printer/utils/Constants;", "", "()V", "ALLOW_NUMBER_5", "", "ALLOW_NUMBER_6", "ALLOW_NUMBER_9", "BASE_URL", "", "BASE_URL_LOCAL", "BLUETOOTH_AUTH", "BLUETOOTH_NAME", "BRANCH_ADMIN_AR", "BRANCH_ADMIN_En", "BRANCH_AUTH", "BRANCH_AUTH_ID", "BRANCH_AUTH_NAME", "BRANCH_DEFAULT_VALUE", "DELAY_BRANCH_SERVICES", "", "DELAY_CHECK_BRANCH", "DELAY_INTERNET_CONNECTION", "DELAY_LESS_THEN_ONE_SECOND", "DELAY_ONE_MINUTE", "DELAY_ONE_SECOND", "DELAY_SCREENSAVER", "DELAY_UPDATE_APP", "DISPLAY_LNG_ARABIC", "DISPLAY_LNG_ENGLISH", "ERROR_PORT", "EXTRA_BRANCH_ID", "EXTRA_CHECKED_NUMBER", "EXTRA_ERROR", "EXTRA_ERROR_EN", "EXTRA_MOBILE_NUMBER", "INPUT_NUMBER_LENGTH", "INTERNET_CONNECTION", "INTERNET_ERROR", "INTERNET_ERROR_AR", "INT_ARABIC", "INT_ENGLISH", "IS_CALL_SENDDISPLAYMESSAGE", "IS_CALL_TIMERDISPLAY", "LNG_ARABIC", "LNG_ENGLISH", "LOCAL_DATABASE", "LOCAL_SERVER_NAME", "LOCAL_SERVER_NAME_AUTH", "MSG_UPDATE_FAILED", "MSG_UPDATE_SUCCESFULL", "NO_BRANCH_INFORMATION", "NO_BRANCH_INFORMATION_AR", "PACKET_CONFIG_AUTH", "PREFERENCE_DISPLAY_MESSAGE_AUTH", "SERVER_AUTH", "SERVER_ERROR", "SERVER_ERROR_AR", "SERVER_ERROR_En", "SERVER_NAME", "SERVER_NAME_AUTH", "SHOW_BLINK_INDEX_AUTH", "TYPEFACE_BOLD", "TYPEFACE_BOLD_ITALIC", "TYPEFACE_ITALIC", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LNG_ARABIC = "ar";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LNG_ENGLISH = "en";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISPLAY_LNG_ENGLISH = "English";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISPLAY_LNG_ARABIC = "\u0627\u0644\u0639\u0631\u0628\u064a\u0629";
    public static final int INPUT_NUMBER_LENGTH = 8;
    public static final int ALLOW_NUMBER_5 = 5;
    public static final int ALLOW_NUMBER_9 = 9;
    public static final int ALLOW_NUMBER_6 = 6;
    public static final int INT_ENGLISH = 1;
    public static final int INT_ARABIC = 2;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "http://10.10.5.60/APIQ/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL_LOCAL = "http://10.10.5.60/APIQ/";
    public static final int BRANCH_DEFAULT_VALUE = -999;
    public static final long DELAY_CHECK_BRANCH = 10000L;
    public static final long DELAY_SCREENSAVER = 180000L;
    public static final long DELAY_ONE_SECOND = 800L;
    public static final long DELAY_LESS_THEN_ONE_SECOND = 550L;
    public static final long DELAY_ONE_MINUTE = 60000L;
    public static final long DELAY_UPDATE_APP = 200000L;
    public static final long DELAY_BRANCH_SERVICES = 15000L;
    public static final long DELAY_INTERNET_CONNECTION = 5000L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTERNET_CONNECTION = "No Internet Connection";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVER_ERROR = "Error getting Data from Server";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BRANCH_AUTH = "Branch Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BRANCH_AUTH_ID = "Branch Auth ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BRANCH_AUTH_NAME = "Branch Auth Name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PACKET_CONFIG_AUTH = "Packet config Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREFERENCE_DISPLAY_MESSAGE_AUTH = "Preference display Message Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SHOW_BLINK_INDEX_AUTH = "showblinkIndex Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_CALL_SENDDISPLAYMESSAGE = "SendDisplayMessage Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_CALL_TIMERDISPLAY = "TIMERDISPLAY Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BLUETOOTH_AUTH = "Bluetooth Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BLUETOOTH_NAME = "Bluetooth Name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOCAL_SERVER_NAME_AUTH = "Local Server Name Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOCAL_SERVER_NAME = "Local Server Name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVER_NAME_AUTH = "Server Name Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVER_NAME = "Server Name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVER_AUTH = "Server Auth";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOCAL_DATABASE = "Local Database";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ERROR = "extra error";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ERROR_EN = "extra error en";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_BRANCH_ID = "extra branch id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_MOBILE_NUMBER = "extra mobile number";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CHECKED_NUMBER = "extra check number";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TYPEFACE_BOLD = "Bold";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TYPEFACE_BOLD_ITALIC = "BoldItalic";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TYPEFACE_ITALIC = "Italic";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERROR_PORT = "Fail to openPort...\n    \n    Error code: -1 (Failed)";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NO_BRANCH_INFORMATION = "No Information Available for Branch";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NO_BRANCH_INFORMATION_AR = "\u0644\u0627 \u062a\u0648\u062c\u062f \u0645\u0639\u0644\u0648\u0645\u0627\u062a \u0645\u062a\u0627\u062d\u0629 \u0644\u0644\u0641\u0631\u0639";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTERNET_ERROR = "No Internet Connection!! Please contact to Administrator";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTERNET_ERROR_AR = "\u0644\u0644\u0627 \u064a\u0648\u062c\u062f \u0627\u062a\u0635\u0627\u0644 \u0628\u0627\u0644\u0625\u0646\u062a\u0631\u0646\u062a !! \u064a\u0631\u062c\u0649 \u0627\u0644\u0627\u062a\u0635\u0627\u0644 \u0628\u0627\u0644\u0645\u0633\u0624\u0648\u0644";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVER_ERROR_En = "Error getting Data from Server!! Please contact to Administrator";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVER_ERROR_AR = "\u062e\u0637\u0623 \u0641\u064a \u0627\u0644\u062d\u0635\u0648\u0644 \u0639\u0644\u0649 \u0627\u0644\u0628\u064a\u0627\u0646\u0627\u062a \u0645\u0646 \u0627\u0644\u062e\u0627\u062f\u0645 !! \u064a\u0631\u062c\u0649 \u0627\u0644\u0627\u062a\u0635\u0627\u0644 \u0628\u0627\u0644\u0645\u0633\u0624\u0648\u0644";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BRANCH_ADMIN_En = "Choose a Branch!! Please contact to Administrator";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BRANCH_ADMIN_AR = "\u0627\u062e\u062a\u0631 \u0627\u0644\u0641\u0631\u0639 !! \u064a\u0631\u062c\u0649 \u0627\u0644\u0627\u062a\u0635\u0627\u0644 \u0628\u0627\u0644\u0645\u0633\u0624\u0648\u0644";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MSG_UPDATE_SUCCESFULL = "Application Updated Successfully - \u062a\u0645 \u062a\u062d\u062f\u064a\u062b \u0627\u0644\u062a\u0637\u0628\u064a\u0642 \u0628\u0646\u062c\u0627\u062d";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MSG_UPDATE_FAILED = "Application Updated Failed - \u0641\u0634\u0644 \u062a\u062d\u062f\u064a\u062b \u0627\u0644\u062a\u0637\u0628\u064a\u0642 ";
    @org.jetbrains.annotations.NotNull()
    public static final com.epson.epos2_printer.utils.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
}