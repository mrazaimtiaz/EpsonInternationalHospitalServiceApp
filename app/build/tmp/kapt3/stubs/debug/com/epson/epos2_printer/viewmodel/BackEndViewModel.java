package com.epson.epos2_printer.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J(\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\t2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0!H\u0002J(\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001e0\t2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001e0!H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0014H\u0002J\u000e\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\nJ\u000e\u0010\'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\nJ\u0010\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0018J\u0006\u0010-\u001a\u00020\u0011J&\u0010.\u001a\u00020\u00112\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\u0006\u0010$\u001a\u00020\u00142\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020\u0011J\b\u00103\u001a\u00020\u0011H\u0002J\u0006\u00104\u001a\u00020\u0011R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/epson/epos2_printer/viewmodel/BackEndViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "qRepository", "Lcom/epson/epos2_printer/repository/QRepository;", "(Landroid/app/Application;Lcom/epson/epos2_printer/repository/QRepository;)V", "changeImage", "Landroidx/lifecycle/MutableLiveData;", "Lcom/epson/epos2_printer/utils/Resource;", "", "getChangeImage", "()Landroidx/lifecycle/MutableLiveData;", "mContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "callChangeImage", "", "getCounter", "getDispenserConfigurationPreference", "Lcom/epson/epos2_printer/models/DispenserSettings;", "getISCallSendDisplayMessage", "getIsCallTIMERDISPLAY", "getPreference", "", "getPreferenceDisplayMessage", "Lcom/epson/epos2_printer/models/PreferenceDisplayMessage;", "getServerPreference", "getShowBlinkIndexPreference", "handleGetCounterStatusResponse", "", "Lcom/epson/epos2_printer/models/CounterStatus;", "response", "Lretrofit2/Response;", "handleGetDispenserSettingResponse", "saveDispenserSettingsPreference", "dispenserSetting", "saveISCallSendDisplayMessage", "isCallSendMessage", "saveIsCallTIMERDISPLAY", "isCallTIMERDISPLAY", "savePreferenceDisplayMessage", "preferenceDisplayMessage", "saveShowBlinkIndexPreference", "showBlinkIndex", "sendDisplayMessage", "sendPackets", "list", "message", "", "setDispenserSettings", "showToastInfo", "timerDisplay", "app_debug"})
public final class BackEndViewModel extends androidx.lifecycle.AndroidViewModel {
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.lang.Boolean>> changeImage = null;
    private final com.epson.epos2_printer.repository.QRepository qRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.lang.Boolean>> getChangeImage() {
        return null;
    }
    
    public final void callChangeImage() {
    }
    
    public final void timerDisplay() {
    }
    
    public final void sendDisplayMessage() {
    }
    
    public final void getCounter() {
    }
    
    public final void setDispenserSettings() {
    }
    
    private final com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.CounterStatus>> handleGetCounterStatusResponse(retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>> response) {
        return null;
    }
    
    private final com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.DispenserSettings>> handleGetDispenserSettingResponse(retrofit2.Response<java.util.List<com.epson.epos2_printer.models.DispenserSettings>> response) {
        return null;
    }
    
    public final void sendPackets(@org.jetbrains.annotations.NotNull()
    java.util.List<com.epson.epos2_printer.models.CounterStatus> list, @org.jetbrains.annotations.NotNull()
    com.epson.epos2_printer.models.DispenserSettings dispenserSetting, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void saveDispenserSettingsPreference(com.epson.epos2_printer.models.DispenserSettings dispenserSetting) {
    }
    
    public final void savePreferenceDisplayMessage(@org.jetbrains.annotations.Nullable()
    com.epson.epos2_printer.models.PreferenceDisplayMessage preferenceDisplayMessage) {
    }
    
    private final com.epson.epos2_printer.models.PreferenceDisplayMessage getPreferenceDisplayMessage() {
        return null;
    }
    
    private final com.epson.epos2_printer.models.DispenserSettings getDispenserConfigurationPreference() {
        return null;
    }
    
    public final void saveShowBlinkIndexPreference(int showBlinkIndex) {
    }
    
    private final int getShowBlinkIndexPreference() {
        return 0;
    }
    
    private final int getPreference() {
        return 0;
    }
    
    public final void saveISCallSendDisplayMessage(boolean isCallSendMessage) {
    }
    
    public final void saveIsCallTIMERDISPLAY(boolean isCallTIMERDISPLAY) {
    }
    
    private final boolean getISCallSendDisplayMessage() {
        return false;
    }
    
    private final boolean getIsCallTIMERDISPLAY() {
        return false;
    }
    
    private final boolean getServerPreference() {
        return false;
    }
    
    private final void showToastInfo() {
    }
    
    public BackEndViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.epson.epos2_printer.repository.QRepository qRepository) {
        super(null);
    }
}