package com.epson.epos2_printer.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0002\u0010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\"\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020\u00152\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J/\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00042\u000e\b\u0001\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\b\b\u0001\u0010,\u001a\u00020-H\u0016\u00a2\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0015H\u0014J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u001dH\u0016J\u000e\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u000204J\b\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u0015H\u0002J\u001a\u00108\u001a\u00020\u00152\u0010\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020\u0015H\u0002J\u0016\u0010<\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010=\u001a\u00020\u0004J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0017H\u0002J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0017H\u0002J\u0010\u0010A\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0017H\u0002J\b\u0010B\u001a\u00020\u0015H\u0002J\u0018\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0017H\u0002J\u0010\u0010F\u001a\u00020\u00152\u0006\u0010G\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/epson/epos2_printer/ui/SettingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "REQUEST_PERMISSION", "", "arrayBranches", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getArrayBranches", "()Ljava/util/ArrayList;", "setArrayBranches", "(Ljava/util/ArrayList;)V", "branchCheck", "branchSelected", "getBranchSelected", "()I", "setBranchSelected", "(I)V", "viewModel", "Lcom/epson/epos2_printer/viewmodel/QViewModel;", "clickListener", "", "getPreference", "", "getPreferenceId", "()Ljava/lang/Integer;", "getServerLocalNamePreference", "getServerNamePreference", "getServerPreference", "", "isCanWriteSettings", "context", "Landroid/content/Context;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "requestCanWriteSettings", "activity", "Landroid/app/Activity;", "requestRuntimePermission", "setObserver", "settingBranchName", "settingBranchesSpinner", "spinnerArray", "", "settingLanguage", "setupLight", "light", "showToastFail", "message", "showToastInfo", "showToastSuccess", "spinnerListener", "updateBranchPreference", "id", "name", "updateServerPreference", "bol", "app_debug"})
public final class SettingActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.epson.epos2_printer.viewmodel.QViewModel viewModel;
    private final int REQUEST_PERMISSION = 100;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.Integer> arrayBranches;
    private int branchSelected = -1;
    private int branchCheck = 0;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> getArrayBranches() {
        return null;
    }
    
    public final void setArrayBranches(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> p0) {
    }
    
    public final int getBranchSelected() {
        return 0;
    }
    
    public final void setBranchSelected(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
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
    
    private final void clickListener() {
    }
    
    private final void spinnerListener() {
    }
    
    private final void setObserver() {
    }
    
    private final void settingBranchesSpinner(java.util.List<java.lang.String> spinnerArray) {
    }
    
    private final void showToastSuccess(java.lang.String message) {
    }
    
    private final void showToastFail(java.lang.String message) {
    }
    
    private final void showToastInfo(java.lang.String message) {
    }
    
    private final void settingLanguage() {
    }
    
    private final void settingBranchName() {
    }
    
    private final java.lang.String getPreference() {
        return null;
    }
    
    private final java.lang.Integer getPreferenceId() {
        return null;
    }
    
    private final boolean getServerPreference() {
        return false;
    }
    
    private final java.lang.String getServerLocalNamePreference() {
        return null;
    }
    
    private final java.lang.String getServerNamePreference() {
        return null;
    }
    
    private final void updateBranchPreference(int id, java.lang.String name) {
    }
    
    private final void updateServerPreference(boolean bol) {
    }
    
    private final void requestRuntimePermission() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    int[] grantResults) {
    }
    
    public SettingActivity() {
        super();
    }
}