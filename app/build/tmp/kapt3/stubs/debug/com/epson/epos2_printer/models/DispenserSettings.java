package com.epson.epos2_printer.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u008d\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u000207H\u00d6\u0001J\t\u00108\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012\u00a8\u00069"}, d2 = {"Lcom/epson/epos2_printer/models/DispenserSettings;", "", "SysConfig_LCDPCIP", "", "SysConfig_LCDPCMN", "SysConfig_SwitchIP", "SysConfig_VoiceControllerIP", "SysConfig_VoiceControllerMN", "SysConfig_SpeakerVolume", "SysConfig_Port", "SysConfig_SpeakerSound", "SysConfig_SummarizeID1", "SysConfig_SummarizeID2", "SysConfig_CounterMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSysConfig_CounterMsg", "()Ljava/lang/String;", "setSysConfig_CounterMsg", "(Ljava/lang/String;)V", "getSysConfig_LCDPCIP", "setSysConfig_LCDPCIP", "getSysConfig_LCDPCMN", "setSysConfig_LCDPCMN", "getSysConfig_Port", "setSysConfig_Port", "getSysConfig_SpeakerSound", "setSysConfig_SpeakerSound", "getSysConfig_SpeakerVolume", "setSysConfig_SpeakerVolume", "getSysConfig_SummarizeID1", "setSysConfig_SummarizeID1", "getSysConfig_SummarizeID2", "setSysConfig_SummarizeID2", "getSysConfig_SwitchIP", "setSysConfig_SwitchIP", "getSysConfig_VoiceControllerIP", "setSysConfig_VoiceControllerIP", "getSysConfig_VoiceControllerMN", "setSysConfig_VoiceControllerMN", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class DispenserSettings {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_LCDPCIP;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_LCDPCMN;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_SwitchIP;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_VoiceControllerIP;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_VoiceControllerMN;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_SpeakerVolume;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_Port;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_SpeakerSound;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_SummarizeID1;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_SummarizeID2;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String SysConfig_CounterMsg;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_LCDPCIP() {
        return null;
    }
    
    public final void setSysConfig_LCDPCIP(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_LCDPCMN() {
        return null;
    }
    
    public final void setSysConfig_LCDPCMN(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_SwitchIP() {
        return null;
    }
    
    public final void setSysConfig_SwitchIP(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_VoiceControllerIP() {
        return null;
    }
    
    public final void setSysConfig_VoiceControllerIP(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_VoiceControllerMN() {
        return null;
    }
    
    public final void setSysConfig_VoiceControllerMN(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_SpeakerVolume() {
        return null;
    }
    
    public final void setSysConfig_SpeakerVolume(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_Port() {
        return null;
    }
    
    public final void setSysConfig_Port(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_SpeakerSound() {
        return null;
    }
    
    public final void setSysConfig_SpeakerSound(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_SummarizeID1() {
        return null;
    }
    
    public final void setSysConfig_SummarizeID1(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_SummarizeID2() {
        return null;
    }
    
    public final void setSysConfig_SummarizeID2(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSysConfig_CounterMsg() {
        return null;
    }
    
    public final void setSysConfig_CounterMsg(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public DispenserSettings(@org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_LCDPCIP, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_LCDPCMN, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SwitchIP, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_VoiceControllerIP, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_VoiceControllerMN, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SpeakerVolume, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_Port, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SpeakerSound, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SummarizeID1, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SummarizeID2, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_CounterMsg) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final com.epson.epos2_printer.models.DispenserSettings copy(@org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_LCDPCIP, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_LCDPCMN, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SwitchIP, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_VoiceControllerIP, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_VoiceControllerMN, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SpeakerVolume, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_Port, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SpeakerSound, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SummarizeID1, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_SummarizeID2, @org.jetbrains.annotations.Nullable()
    java.lang.String SysConfig_CounterMsg) {
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