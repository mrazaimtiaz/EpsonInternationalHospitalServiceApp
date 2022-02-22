package com.epson.epos2_printer.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b@\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0013J\u0010\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u00109\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u00c6\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010 J\u0010\u0010B\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010 J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00b0\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010I\u001a\u00020\u0003H\u00d6\u0001J\t\u0010J\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010#\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b\'\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b6\u0010\u0019\"\u0004\b7\u0010\u001b\u00a8\u0006K"}, d2 = {"Lcom/epson/epos2_printer/models/CounterStatus;", "", "Counter_PK_ID", "", "Counter_Name", "", "Counter_ScreenID", "packetData", "dataInt", "", "FreeDisplay", "", "EnableSecondtimer", "showblinkindex", "LastCalledPanelID", "LastCalledBookedNo", "LastCalledSummarizeMsg", "Secondlastcalled", "Thirdlastcalled", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCounter_Name", "()Ljava/lang/String;", "setCounter_Name", "(Ljava/lang/String;)V", "getCounter_PK_ID", "()Ljava/lang/Integer;", "setCounter_PK_ID", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCounter_ScreenID", "setCounter_ScreenID", "getEnableSecondtimer", "()Ljava/lang/Boolean;", "setEnableSecondtimer", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getFreeDisplay", "setFreeDisplay", "getLastCalledBookedNo", "setLastCalledBookedNo", "getLastCalledPanelID", "setLastCalledPanelID", "getLastCalledSummarizeMsg", "setLastCalledSummarizeMsg", "getSecondlastcalled", "setSecondlastcalled", "getThirdlastcalled", "setThirdlastcalled", "getDataInt", "()Ljava/util/List;", "setDataInt", "(Ljava/util/List;)V", "getPacketData", "setPacketData", "getShowblinkindex", "setShowblinkindex", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/epson/epos2_printer/models/CounterStatus;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class CounterStatus {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer Counter_PK_ID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Counter_Name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Counter_ScreenID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String packetData;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.Integer> dataInt;
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
    public final java.lang.Integer getCounter_PK_ID() {
        return null;
    }
    
    public final void setCounter_PK_ID(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCounter_Name() {
        return null;
    }
    
    public final void setCounter_Name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCounter_ScreenID() {
        return null;
    }
    
    public final void setCounter_ScreenID(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPacketData() {
        return null;
    }
    
    public final void setPacketData(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.Integer> getDataInt() {
        return null;
    }
    
    public final void setDataInt(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> p0) {
    }
    
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
    
    public CounterStatus(@org.jetbrains.annotations.Nullable()
    java.lang.Integer Counter_PK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.String Counter_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String Counter_ScreenID, @org.jetbrains.annotations.Nullable()
    java.lang.String packetData, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> dataInt, @org.jetbrains.annotations.Nullable()
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
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.Integer> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.epson.epos2_printer.models.CounterStatus copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer Counter_PK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.String Counter_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String Counter_ScreenID, @org.jetbrains.annotations.Nullable()
    java.lang.String packetData, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> dataInt, @org.jetbrains.annotations.Nullable()
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