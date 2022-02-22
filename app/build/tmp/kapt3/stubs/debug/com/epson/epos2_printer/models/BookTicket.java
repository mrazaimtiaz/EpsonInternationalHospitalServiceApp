package com.epson.epos2_printer.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/epson/epos2_printer/models/BookTicket;", "", "NewPKID", "", "BookedNo", "", "QueueSize", "EstimatedTime", "PrintTime", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getBookedNo", "()Ljava/lang/String;", "setBookedNo", "(Ljava/lang/String;)V", "getEstimatedTime", "()Ljava/lang/Integer;", "setEstimatedTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNewPKID", "setNewPKID", "getPrintTime", "setPrintTime", "getQueueSize", "setQueueSize", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/epson/epos2_printer/models/BookTicket;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class BookTicket {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer NewPKID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String BookedNo;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer QueueSize;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer EstimatedTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String PrintTime;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNewPKID() {
        return null;
    }
    
    public final void setNewPKID(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBookedNo() {
        return null;
    }
    
    public final void setBookedNo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getQueueSize() {
        return null;
    }
    
    public final void setQueueSize(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getEstimatedTime() {
        return null;
    }
    
    public final void setEstimatedTime(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrintTime() {
        return null;
    }
    
    public final void setPrintTime(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public BookTicket(@org.jetbrains.annotations.Nullable()
    java.lang.Integer NewPKID, @org.jetbrains.annotations.Nullable()
    java.lang.String BookedNo, @org.jetbrains.annotations.Nullable()
    java.lang.Integer QueueSize, @org.jetbrains.annotations.Nullable()
    java.lang.Integer EstimatedTime, @org.jetbrains.annotations.Nullable()
    java.lang.String PrintTime) {
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
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.epson.epos2_printer.models.BookTicket copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer NewPKID, @org.jetbrains.annotations.Nullable()
    java.lang.String BookedNo, @org.jetbrains.annotations.Nullable()
    java.lang.Integer QueueSize, @org.jetbrains.annotations.Nullable()
    java.lang.Integer EstimatedTime, @org.jetbrains.annotations.Nullable()
    java.lang.String PrintTime) {
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