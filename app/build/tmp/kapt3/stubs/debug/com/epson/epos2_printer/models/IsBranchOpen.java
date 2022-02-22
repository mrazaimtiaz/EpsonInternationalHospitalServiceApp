package com.epson.epos2_printer.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\fJJ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\tH\u00d6\u0001J\t\u0010\'\u001a\u00020\u0006H\u00d6\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001a\u00a8\u0006("}, d2 = {"Lcom/epson/epos2_printer/models/IsBranchOpen;", "", "IsOpen", "", "IsOnBreak", "msgEn", "", "msgAr", "AvialableUpdate", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAvialableUpdate", "()Ljava/lang/Integer;", "setAvialableUpdate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIsOnBreak", "()Ljava/lang/Boolean;", "setIsOnBreak", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getIsOpen", "setIsOpen", "getMsgAr", "()Ljava/lang/String;", "setMsgAr", "(Ljava/lang/String;)V", "getMsgEn", "setMsgEn", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/epson/epos2_printer/models/IsBranchOpen;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class IsBranchOpen {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean IsOpen;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean IsOnBreak;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String msgEn;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String msgAr;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer AvialableUpdate;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getIsOpen() {
        return null;
    }
    
    public final void setIsOpen(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getIsOnBreak() {
        return null;
    }
    
    public final void setIsOnBreak(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgEn() {
        return null;
    }
    
    public final void setMsgEn(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgAr() {
        return null;
    }
    
    public final void setMsgAr(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAvialableUpdate() {
        return null;
    }
    
    public final void setAvialableUpdate(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public IsBranchOpen(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean IsOpen, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean IsOnBreak, @org.jetbrains.annotations.Nullable()
    java.lang.String msgEn, @org.jetbrains.annotations.Nullable()
    java.lang.String msgAr, @org.jetbrains.annotations.Nullable()
    java.lang.Integer AvialableUpdate) {
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
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.epson.epos2_printer.models.IsBranchOpen copy(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean IsOpen, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean IsOnBreak, @org.jetbrains.annotations.Nullable()
    java.lang.String msgEn, @org.jetbrains.annotations.Nullable()
    java.lang.String msgAr, @org.jetbrains.annotations.Nullable()
    java.lang.Integer AvialableUpdate) {
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