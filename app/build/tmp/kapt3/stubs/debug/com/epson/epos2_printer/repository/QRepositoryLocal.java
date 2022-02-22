package com.epson.epos2_printer.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J]\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00050\u00042\u0006\u0010\u0018\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00050\u00042\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ%\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00050\u00042\u0006\u0010\u0018\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J-\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00050\u00042\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J-\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00050\u00042\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J%\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00050\u00042\u0006\u0010\u0018\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/epson/epos2_printer/repository/QRepositoryLocal;", "", "()V", "getAllBranches", "Lretrofit2/Response;", "", "Lcom/epson/epos2_printer/models/Branches;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookTicket", "Lcom/epson/epos2_printer/models/BookTicket;", "mobileNumber", "", "serviceID", "", "IsHandicap", "", "isVip", "languageID", "AppointmentCode", "branchId", "QbranchID", "(Ljava/lang/String;IZZIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDispenserGetSettings", "Lcom/epson/epos2_printer/models/DispenserSettings;", "branchID", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayCounterStatus", "Lcom/epson/epos2_printer/models/CounterStatus;", "WelcomeMessage", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServices", "Lcom/epson/epos2_printer/models/Services;", "getTicket", "Lcom/epson/epos2_printer/models/GetTicket;", "QueueID", "language", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWorkingHourService", "Lcom/epson/epos2_printer/models/IsService;", "isBranchOpen", "Lcom/epson/epos2_printer/models/IsBranchOpen;", "app_debug"})
public final class QRepositoryLocal {
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDispenserGetSettings(int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.DispenserSettings>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDisplayCounterStatus(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String WelcomeMessage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllBranches(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Branches>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isBranchOpen(int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.IsBranchOpen>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getServices(int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Services>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBookTicket(@org.jetbrains.annotations.NotNull()
    java.lang.String mobileNumber, int serviceID, boolean IsHandicap, boolean isVip, int languageID, int AppointmentCode, int branchId, int QbranchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.BookTicket>>> p8) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTicket(int QueueID, int language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.GetTicket>>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWorkingHourService(int branchID, int serviceID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.IsService>>> p2) {
        return null;
    }
    
    public QRepositoryLocal() {
        super();
    }
}