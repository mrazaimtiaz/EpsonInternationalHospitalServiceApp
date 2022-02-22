package com.epson.epos2_printer.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\"H\u0003J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020%H\u0002J\u000e\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-J\"\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0012\u00103\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020\"H\u0014J\u0018\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020\"H\u0016J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\"H\u0014J\b\u0010?\u001a\u00020\"H\u0016J\u0012\u0010@\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\'H\u0016J\u0010\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020%H\u0016J\u000e\u0010C\u001a\u00020\"2\u0006\u0010,\u001a\u00020-J\b\u0010D\u001a\u00020\"H\u0002J\b\u0010E\u001a\u00020\"H\u0002J\b\u0010F\u001a\u00020\"H\u0002J\u000e\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u00020IJ\b\u0010J\u001a\u00020\"H\u0002J\u0006\u0010K\u001a\u00020\"J\b\u0010L\u001a\u00020\"H\u0002J\b\u0010M\u001a\u00020\"H\u0002J\u0016\u0010N\u001a\u00020\"2\u0006\u0010,\u001a\u00020-2\u0006\u0010O\u001a\u00020\u0005J\b\u0010P\u001a\u0004\u0018\u00010QJ\b\u0010R\u001a\u00020\"H\u0002J\u0010\u0010S\u001a\u00020\"2\u0006\u0010T\u001a\u00020\bH\u0002J\u0010\u0010U\u001a\u00020\"2\u0006\u0010T\u001a\u00020\bH\u0002J\u0010\u0010V\u001a\u00020\"2\u0006\u0010T\u001a\u00020\bH\u0002J\u0006\u0010W\u001a\u00020\"J\u0006\u0010X\u001a\u00020\"J\b\u0010Y\u001a\u00020\"H\u0002J\u0006\u0010Z\u001a\u00020\"J\u0006\u0010[\u001a\u00020\"J\u0018\u0010\\\u001a\u00020\"2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006_"}, d2 = {"Lcom/epson/epos2_printer/ui/MobileEntryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/davidmiguel/numberkeyboard/NumberKeyboardListener;", "()V", "REQUEST_CODE_UPDATE_APP", "", "REQUEST_PERMISSION", "amount", "", "branchTimer", "", "getBranchTimer", "()J", "setBranchTimer", "(J)V", "count", "mImageLogo", "Landroid/widget/ImageView;", "mPrinter", "Lcom/epson/epos2/printer/Printer;", "getMPrinter", "()Lcom/epson/epos2/printer/Printer;", "setMPrinter", "(Lcom/epson/epos2/printer/Printer;)V", "mProccedAr", "Landroid/widget/Button;", "mProccedEn", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "viewModel", "Lcom/epson/epos2_printer/viewmodel/QViewModel;", "cancelTimer", "", "clickListener", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getPreference", "increaseBrightness", "initializeObject", "isCanWriteSettings", "context", "Landroid/content/Context;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLeftAuxButtonClicked", "onNumberClicked", "number", "onResume", "onRightAuxButtonClicked", "onTouchEvent", "onWindowFocusChanged", "hasFocus", "preventStatusBarExpansion", "proceedToNext", "proceedWithArabic", "proceedWithEnglish", "requestCanWriteSettings", "activity", "Landroid/app/Activity;", "requestRuntimePermission", "sendVersion", "setObserver", "settingLanguage", "setupLight", "light", "shakeError", "Landroid/view/animation/TranslateAnimation;", "showAmount", "showToastFail", "message", "showToastInfo", "showToastSuccess", "startAnimationError", "startAnimationInputNumberError", "startKioskService", "startTimer", "updateApp", "updateBranchPreference", "id", "name", "app_debug"})
public final class MobileEntryActivity extends androidx.appcompat.app.AppCompatActivity implements com.davidmiguel.numberkeyboard.NumberKeyboardListener {
    private com.epson.epos2_printer.viewmodel.QViewModel viewModel;
    private java.lang.String amount = "";
    private int count = 0;
    private final int REQUEST_PERMISSION = 100;
    private android.widget.Button mProccedEn;
    private android.widget.Button mProccedAr;
    private android.widget.ImageView mImageLogo;
    @org.jetbrains.annotations.Nullable()
    private com.epson.epos2.printer.Printer mPrinter;
    private long branchTimer = 0L;
    @org.jetbrains.annotations.NotNull()
    private final android.os.CountDownTimer timer = null;
    private int REQUEST_CODE_UPDATE_APP = 12;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final com.epson.epos2.printer.Printer getMPrinter() {
        return null;
    }
    
    public final void setMPrinter(@org.jetbrains.annotations.Nullable()
    com.epson.epos2.printer.Printer p0) {
    }
    
    public final long getBranchTimer() {
        return 0L;
    }
    
    public final void setBranchTimer(long p0) {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event) {
        return false;
    }
    
    public final void cancelTimer() {
    }
    
    public final void startTimer() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
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
    
    private final void startKioskService() {
    }
    
    private final void increaseBrightness() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateBranchPreference(int id, java.lang.String name) {
    }
    
    /**
     * @param context
     * @param light max 255
     */
    public final void setupLight(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int light) {
    }
    
    public final boolean isCanWriteSettings(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void requestCanWriteSettings(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void preventStatusBarExpansion(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void clickListener() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.animation.TranslateAnimation shakeError() {
        return null;
    }
    
    public final void startAnimationError() {
    }
    
    public final void startAnimationInputNumberError() {
    }
    
    @java.lang.Override()
    public void onNumberClicked(int number) {
    }
    
    @java.lang.Override()
    public void onLeftAuxButtonClicked() {
    }
    
    @java.lang.Override()
    public void onRightAuxButtonClicked() {
    }
    
    private final void showAmount() {
    }
    
    public final void sendVersion() {
    }
    
    private final void setObserver() {
    }
    
    private final void settingLanguage() {
    }
    
    private final void proceedWithEnglish() {
    }
    
    private final void proceedWithArabic() {
    }
    
    private final void proceedToNext() {
    }
    
    private final int getPreference() {
        return 0;
    }
    
    private final void showToastSuccess(java.lang.String message) {
    }
    
    private final void showToastFail(java.lang.String message) {
    }
    
    private final void showToastInfo(java.lang.String message) {
    }
    
    private final void requestRuntimePermission() {
    }
    
    private final boolean initializeObject() {
        return false;
    }
    
    public final void updateApp() {
    }
    
    public MobileEntryActivity() {
        super();
    }
}