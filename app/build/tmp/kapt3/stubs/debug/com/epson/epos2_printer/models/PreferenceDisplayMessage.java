package com.epson.epos2_printer.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\rJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u000b\u0010)\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bH\u00c6\u0003Jn\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\u0006H\u00d6\u0001J\t\u00103\u001a\u00020\bH\u00d6\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00064"}, d2 = {"Lcom/epson/epos2_printer/models/PreferenceDisplayMessage;", "", "FreeDisplay", "", "EnableSecondtimer", "showblinkindex", "", "LastCalledPanelID", "", "LastCalledBookedNo", "LastCalledSummarizeMsg", "Secondlastcalled", "Thirdlastcalled", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnableSecondtimer", "()Ljava/lang/Boolean;", "setEnableSecondtimer", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getFreeDisplay", "setFreeDisplay", "getLastCalledBookedNo", "()Ljava/lang/String;", "setLastCalledBookedNo", "(Ljava/lang/String;)V", "getLastCalledPanelID", "setLastCalledPanelID", "getLastCalledSummarizeMsg", "setLastCalledSummarizeMsg", "getSecondlastcalled", "setSecondlastcalled", "getThirdlastcalled", "setThirdlastcalled", "getShowblinkindex", "()Ljava/lang/Integer;", "setShowblinkindex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/epson/epos2_printer/models/PreferenceDisplayMessage;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class PreferenceDisplayMessage {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean FreeDisplay;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean EnableSecondtimer;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer showblinkindex;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String LastCalledPanelID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String LastCalledBookedNo;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String LastCalledSummarizeMsg;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Secondlastcalled;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Thirdlastcalled;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getFreeDisplay() {
        return null;
    }
    
    public final void setFreeDisplay(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getEnableSecondtimer() {
        return null;
    }
    
    public final void setEnableSecondtimer(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getShowblinkindex() {
        return null;
    }
    
    public final void setShowblinkindex(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastCalledPanelID() {
        return null;
    }
    
    public final void setLastCalledPanelID(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastCalledBookedNo() {
        return null;
    }
    
    public final void setLastCalledBookedNo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastCalledSummarizeMsg() {
        return null;
    }
    
    public final void setLastCalledSummarizeMsg(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSecondlastcalled() {
        return null;
    }
    
    public final void setSecondlastcalled(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThirdlastcalled() {
        return null;
    }
    
    public final void setThirdlastcalled(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public PreferenceDisplayMessage(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean FreeDisplay, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean EnableSecondtimer, @org.jetbrains.annotations.Nullable()
    java.lang.Integer showblinkindex, @org.jetbrains.annotations.Nullable()
    java.lang.String LastCalledPanelID, @org.jetbrains.annotations.Nullable()
    java.lang.String LastCalledBookedNo, @org.jetbrains.annotations.Nullable()
    java.lang.String LastCalledSummarizeMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String Secondlastcalled, @org.jetbrains.annotations.Nullable()
    java.lang.String Thirdlastcalled) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.epson.epos2_printer.models.PreferenceDisplayMessage copy(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean FreeDisplay, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean EnableSecondtimer, @org.jetbrains.annotations.Nullable()
    java.lang.Integer showblinkindex, @org.jetbrains.annotations.Nullable()
    java.lang.String LastCalledPanelID, @org.jetbrains.annotations.Nullable()
    java.lang.String LastCalledBookedNo, @org.jetbrains.annotations.Nullable()
    java.lang.String LastCalledSummarizeMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String Secondlastcalled, @org.jetbrains.annotations.Nullable()
    java.lang.String Thirdlastcalled) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}