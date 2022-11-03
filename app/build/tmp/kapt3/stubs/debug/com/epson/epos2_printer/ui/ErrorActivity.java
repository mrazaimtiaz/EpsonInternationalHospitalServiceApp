package com.epson.epos2_printer.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0017\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0016H\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\"\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020\u00162\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0016H\u0014J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0016H\u0014J\u0010\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u000bH\u0002J\u0006\u00101\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/epson/epos2_printer/ui/ErrorActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "branchId", "", "count", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "valueEn", "getValueEn", "setValueEn", "viewModel", "Lcom/epson/epos2_printer/viewmodel/QViewModel;", "cancelTimer", "", "checkConnection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickListener", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getServerPreference", "intentToMain", "observer", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onResume", "showToastInfo", "message", "startTimer", "app_debug"})
public final class ErrorActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.epson.epos2_printer.viewmodel.QViewModel viewModel;
    private int branchId = -999;
    private int count = 0;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String value = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String valueEn = "";
    @org.jetbrains.annotations.NotNull()
    private final android.os.CountDownTimer timer = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getValue() {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getValueEn() {
        return null;
    }
    
    public final void setValueEn(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void cancelTimer() {
    }
    
    public final void startTimer() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.CountDownTimer getTimer() {
        return null;
    }
    
    @java.lang.Override()
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event) {
        return false;
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void clickListener() {
    }
    
    private final void observer() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkConnection(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    private final void showToastInfo(java.lang.String message) {
    }
    
    private final void intentToMain() {
    }
    
    private final boolean getServerPreference() {
        return false;
    }
    
    public ErrorActivity() {
        super();
    }
}