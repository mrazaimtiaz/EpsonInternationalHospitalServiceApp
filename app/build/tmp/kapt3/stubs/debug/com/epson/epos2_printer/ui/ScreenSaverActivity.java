package com.epson.epos2_printer.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0011H\u0002J\u0006\u0010\"\u001a\u00020#J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010\'\u001a\u00020#H\u0014J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\u001c\u0010*\u001a\u00020#*\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/epson/epos2_printer/ui/ScreenSaverActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "backEndViewModel", "Lcom/epson/epos2_printer/viewmodel/BackEndViewModel;", "getBackEndViewModel", "()Lcom/epson/epos2_printer/viewmodel/BackEndViewModel;", "setBackEndViewModel", "(Lcom/epson/epos2_printer/viewmodel/BackEndViewModel;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "images", "", "", "isRunning", "", "()Z", "setRunning", "(Z)V", "selected", "getSelected", "()I", "setSelected", "(I)V", "viewModel", "Lcom/epson/epos2_printer/viewmodel/QViewModel;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getPreference", "observeScreenSaver", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setObserver", "setScreenSaver", "setImageDrawableWithAnimation", "Landroid/widget/ImageView;", "drawable", "Landroid/graphics/drawable/Drawable;", "duration", "app_debug"})
public final class ScreenSaverActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.epson.epos2_printer.viewmodel.QViewModel viewModel;
    private final java.util.List<java.lang.Integer> images = null;
    private int selected = 0;
    @org.jetbrains.annotations.Nullable()
    private kotlin.coroutines.CoroutineContext coroutineContext;
    public com.epson.epos2_printer.viewmodel.BackEndViewModel backEndViewModel;
    private boolean isRunning = true;
    private java.util.HashMap _$_findViewCache;
    
    public final int getSelected() {
        return 0;
    }
    
    public final void setSelected(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    public final void setCoroutineContext(@org.jetbrains.annotations.Nullable()
    kotlin.coroutines.CoroutineContext p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.epson.epos2_printer.viewmodel.BackEndViewModel getBackEndViewModel() {
        return null;
    }
    
    public final void setBackEndViewModel(@org.jetbrains.annotations.NotNull()
    com.epson.epos2_printer.viewmodel.BackEndViewModel p0) {
    }
    
    public final boolean isRunning() {
        return false;
    }
    
    public final void setRunning(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void observeScreenSaver() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public final void setImageDrawableWithAnimation(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$setImageDrawableWithAnimation, @org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable drawable, int duration) {
    }
    
    private final void setScreenSaver() {
    }
    
    private final void setObserver() {
    }
    
    private final int getPreference() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    public ScreenSaverActivity() {
        super();
    }
}