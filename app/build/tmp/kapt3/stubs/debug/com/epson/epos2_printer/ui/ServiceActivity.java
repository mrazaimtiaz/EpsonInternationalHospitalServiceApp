package com.epson.epos2_printer.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0003J\u0011\u00108\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109J\u001b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=J\u001b\u0010>\u001a\u0004\u0018\u00010;2\u0006\u0010?\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=J%\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\t2\b\u0010C\u001a\u0004\u0018\u00010DH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ\b\u0010F\u001a\u000206H\u0002J\u0010\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0002J\b\u0010L\u001a\u000206H\u0002J\n\u0010M\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010N\u001a\u00020\u0016H\u0002J\b\u0010O\u001a\u000206H\u0002J\b\u0010P\u001a\u00020\u0016H\u0002J\b\u0010Q\u001a\u000206H\u0002J\u0012\u0010R\u001a\u0004\u0018\u00010\t2\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u000206H\u0002J\"\u0010V\u001a\u0002062\u0006\u0010W\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u00062\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0014J\u0012\u0010[\u001a\u0002062\b\u0010\\\u001a\u0004\u0018\u00010]H\u0014J\b\u0010^\u001a\u000206H\u0014J\u0018\u0010_\u001a\u00020\u00162\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020bH\u0016J.\u0010c\u001a\u0002062\b\u0010d\u001a\u0004\u0018\u00010%2\u0006\u0010e\u001a\u00020\u00062\b\u0010f\u001a\u0004\u0018\u00010T2\b\u0010g\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010h\u001a\u0002062\b\u0010d\u001a\u0004\u0018\u00010%2\u0006\u0010i\u001a\u00020\u0006H\u0016J+\u0010j\u001a\u0002062\u0006\u0010W\u001a\u00020\u00062\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\t0l2\u0006\u0010m\u001a\u00020nH\u0016\u00a2\u0006\u0002\u0010oJ\b\u0010p\u001a\u000206H\u0014J\u0010\u0010q\u001a\u0002062\u0006\u0010r\u001a\u00020\u0016H\u0016J\u0010\u0010s\u001a\u0002062\u0006\u0010B\u001a\u00020\tH\u0002J\u0011\u0010t\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109J\b\u0010u\u001a\u000206H\u0002J\u0006\u0010v\u001a\u000206J\u0010\u0010w\u001a\u0002062\u0006\u0010x\u001a\u00020\tH\u0002J\b\u0010y\u001a\u000206H\u0002J\b\u0010z\u001a\u000206H\u0002J\u0010\u0010{\u001a\u0002062\u0006\u0010x\u001a\u00020\tH\u0002J\u0010\u0010|\u001a\u0002062\u0006\u0010}\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\"\u0010*\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0,\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u000e\u00103\u001a\u000204X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006~"}, d2 = {"Lcom/epson/epos2_printer/ui/ServiceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/epson/epos2/printer/ReceiveListener;", "Lcom/epson/epos2/printer/StatusChangeListener;", "()V", "DISCONNECT_INTERVAL", "", "REQUEST_PERMISSION", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "branchId", "branchTimer", "", "getBranchTimer", "()J", "setBranchTimer", "(J)V", "checkedNumber", "", "count", "getCount", "()I", "setCount", "(I)V", "ledControlUtil", "Landroid_serialport_api/LedControlUtil;", "getLedControlUtil", "()Landroid_serialport_api/LedControlUtil;", "setLedControlUtil", "(Landroid_serialport_api/LedControlUtil;)V", "mFilterOption", "Lcom/epson/epos2/discovery/FilterOption;", "mPrinter", "Lcom/epson/epos2/printer/Printer;", "getMPrinter", "()Lcom/epson/epos2/printer/Printer;", "setMPrinter", "(Lcom/epson/epos2/printer/Printer;)V", "mPrinterList", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "mobileNumber", "serviceAdapter", "Lcom/epson/epos2_printer/adapter/ServiceAdapter;", "serviceTimer", "getServiceTimer", "setServiceTimer", "viewModel", "Lcom/epson/epos2_printer/viewmodel/QViewModel;", "callRecursionServices", "", "clickListener", "connectPrinter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertBase64ToBitmap", "Landroid/graphics/Bitmap;", "b64", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertImageUrlToBitmap", "src", "createRasterReceiptData", "", "text", "emulation", "Lcom/starmicronics/starioextension/StarIoExt$Emulation;", "(Ljava/lang/String;Lcom/starmicronics/starioextension/StarIoExt$Emulation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectPrinter", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dpToPx", "dp", "finalizeObject", "getAddressNamePreference", "getServerPreference", "hideProgress", "initializeObject", "intentToMain", "makeErrorMessage", "status", "Lcom/epson/epos2/printer/PrinterStatusInfo;", "observer", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPtrReceive", "p0", "code", "PrinterStatusInfo", "printJobId", "onPtrStatusChange", "p1", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "print", "printData", "requestRuntimePermission", "sendVersion", "setIntentError", "message", "setupRecyclerView", "showProgress", "showToastInfo", "updateBluetoothPreference", "name", "app_debug"})
public final class ServiceActivity extends androidx.appcompat.app.AppCompatActivity implements com.epson.epos2.printer.ReceiveListener, com.epson.epos2.printer.StatusChangeListener {
    private int count = 0;
    private com.epson.epos2_printer.viewmodel.QViewModel viewModel;
    private com.epson.epos2_printer.adapter.ServiceAdapter serviceAdapter;
    private int branchId = -999;
    private boolean checkedNumber = false;
    private java.lang.String mobileNumber = "";
    private long serviceTimer = 0L;
    private long branchTimer = 0L;
    private final int REQUEST_PERMISSION = 100;
    private final int DISCONNECT_INTERVAL = 500;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String address = "-999";
    @org.jetbrains.annotations.Nullable()
    private com.epson.epos2.printer.Printer mPrinter;
    private com.epson.epos2.discovery.FilterOption mFilterOption;
    private java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> mPrinterList;
    @org.jetbrains.annotations.NotNull()
    private android_serialport_api.LedControlUtil ledControlUtil;
    private java.util.HashMap _$_findViewCache;
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    public final long getServiceTimer() {
        return 0L;
    }
    
    public final void setServiceTimer(long p0) {
    }
    
    public final long getBranchTimer() {
        return 0L;
    }
    
    public final void setBranchTimer(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAddress() {
        return null;
    }
    
    public final void setAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.epson.epos2.printer.Printer getMPrinter() {
        return null;
    }
    
    public final void setMPrinter(@org.jetbrains.annotations.Nullable()
    com.epson.epos2.printer.Printer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android_serialport_api.LedControlUtil getLedControlUtil() {
        return null;
    }
    
    public final void setLedControlUtil(@org.jetbrains.annotations.NotNull()
    android_serialport_api.LedControlUtil p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    public final void sendVersion() {
    }
    
    private final void updateBluetoothPreference(java.lang.String name) {
    }
    
    private final boolean initializeObject() {
        return false;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void finalizeObject() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    private final void setupRecyclerView() {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void clickListener() {
    }
    
    private final void observer() {
    }
    
    private final void callRecursionServices() {
    }
    
    private final void setIntentError(java.lang.String message) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createRasterReceiptData(@org.jetbrains.annotations.Nullable()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    com.starmicronics.starioextension.StarIoExt.Emulation emulation, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super byte[]> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object convertImageUrlToBitmap(@org.jetbrains.annotations.NotNull()
    java.lang.String src, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object convertBase64ToBitmap(@org.jetbrains.annotations.NotNull()
    java.lang.String b64, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> p1) {
        return null;
    }
    
    private final int dpToPx(int dp) {
        return 0;
    }
    
    private final java.lang.String getAddressNamePreference() {
        return null;
    }
    
    private final void print(java.lang.String text) {
    }
    
    private final void intentToMain() {
    }
    
    private final void showToastInfo(java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onPtrReceive(@org.jetbrains.annotations.Nullable()
    com.epson.epos2.printer.Printer p0, int code, @org.jetbrains.annotations.Nullable()
    com.epson.epos2.printer.PrinterStatusInfo PrinterStatusInfo, @org.jetbrains.annotations.Nullable()
    java.lang.String printJobId) {
    }
    
    private final java.lang.String makeErrorMessage(com.epson.epos2.printer.PrinterStatusInfo status) {
        return null;
    }
    
    private final void disconnectPrinter() {
    }
    
    private final void showProgress() {
    }
    
    private final void hideProgress() {
    }
    
    private final boolean getServerPreference() {
        return false;
    }
    
    private final void requestRuntimePermission() {
    }
    
    @java.lang.Override()
    public void onPtrStatusChange(@org.jetbrains.annotations.Nullable()
    com.epson.epos2.printer.Printer p0, int p1) {
    }
    
    public ServiceActivity() {
        super();
    }
}