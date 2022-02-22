package com.epson.epos2_printer.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J]\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J]\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ-\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J-\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 JU\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\u0006\u0010\'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)JU\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\u0006\u0010\'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J]\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J]\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J%\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ%\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ-\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00050\u00042\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J-\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00050\u00042\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J-\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J-\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J%\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ%\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ-\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J-\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00050\u00042\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J5\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010KJ5\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010K\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006M"}, d2 = {"Lcom/epson/epos2_printer/repository/QRepository;", "", "()V", "getAllBranches", "Lretrofit2/Response;", "", "Lcom/epson/epos2_printer/models/Branches;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBranchesLocal", "getBookTicket", "Lcom/epson/epos2_printer/models/BookTicket;", "mobileNumber", "", "serviceID", "", "IsHandicap", "", "isVip", "languageID", "AppointmentCode", "branchId", "QbranchID", "(Ljava/lang/String;IZZIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookTicketLocal", "getDispenserGetSettings", "Lcom/epson/epos2_printer/models/DispenserSettings;", "branchID", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDispenserGetSettingsLocal", "getDisplayCounterStatus", "Lcom/epson/epos2_printer/models/CounterStatus;", "WelcomeMessage", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayCounterStatusLocal", "getSendDisplayMessage", "SumerizeScreen1", "SumerizeScreen2", "voiceControllerID", "StrSound", "strVolume", "freeDisplay", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSendDisplayMessageLocal", "getSendTimerDisplay", "showblinkindex", "LastCalledPanelID", "LastCalledBookedNo", "LastCalledSummarizeMsg", "Secondlastcalled", "Thirdlastcalled", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSendTimerDisplayLocal", "getServices", "Lcom/epson/epos2_printer/models/Services;", "getServicesLocal", "getTicket", "Lcom/epson/epos2_printer/models/GetTicket;", "QueueID", "language", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTicketLocal", "getWorkingHourService", "Lcom/epson/epos2_printer/models/IsService;", "getWorkingHourServiceLocal", "isBranchOpen", "Lcom/epson/epos2_printer/models/IsBranchOpen;", "isBranchOpenLocal", "sendLog", "Lcom/epson/epos2_printer/models/LogReturn;", "errorMsg", "sendLogLocal", "branchid", "tabletStatus", "type", "status", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tabletStatusLocal", "app_debug"})
public final class QRepository {
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllBranches(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Branches>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSendTimerDisplay(int showblinkindex, @org.jetbrains.annotations.NotNull()
    java.lang.String LastCalledPanelID, @org.jetbrains.annotations.NotNull()
    java.lang.String LastCalledBookedNo, @org.jetbrains.annotations.NotNull()
    java.lang.String SumerizeScreen1, @org.jetbrains.annotations.NotNull()
    java.lang.String SumerizeScreen2, @org.jetbrains.annotations.NotNull()
    java.lang.String LastCalledSummarizeMsg, @org.jetbrains.annotations.NotNull()
    java.lang.String Secondlastcalled, @org.jetbrains.annotations.NotNull()
    java.lang.String Thirdlastcalled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p8) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDispenserGetSettings(int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.DispenserSettings>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSendDisplayMessage(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String SumerizeScreen1, @org.jetbrains.annotations.NotNull()
    java.lang.String SumerizeScreen2, @org.jetbrains.annotations.NotNull()
    java.lang.String voiceControllerID, @org.jetbrains.annotations.NotNull()
    java.lang.String StrSound, @org.jetbrains.annotations.NotNull()
    java.lang.String strVolume, boolean freeDisplay, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p7) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDisplayCounterStatus(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String WelcomeMessage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p2) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendLog(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.LogReturn>>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object tabletStatus(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.LogReturn>>> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSendTimerDisplayLocal(int showblinkindex, @org.jetbrains.annotations.NotNull()
    java.lang.String LastCalledPanelID, @org.jetbrains.annotations.NotNull()
    java.lang.String LastCalledBookedNo, @org.jetbrains.annotations.NotNull()
    java.lang.String SumerizeScreen1, @org.jetbrains.annotations.NotNull()
    java.lang.String SumerizeScreen2, @org.jetbrains.annotations.NotNull()
    java.lang.String LastCalledSummarizeMsg, @org.jetbrains.annotations.NotNull()
    java.lang.String Secondlastcalled, @org.jetbrains.annotations.NotNull()
    java.lang.String Thirdlastcalled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p8) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDispenserGetSettingsLocal(int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.DispenserSettings>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSendDisplayMessageLocal(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String SumerizeScreen1, @org.jetbrains.annotations.NotNull()
    java.lang.String SumerizeScreen2, @org.jetbrains.annotations.NotNull()
    java.lang.String voiceControllerID, @org.jetbrains.annotations.NotNull()
    java.lang.String StrSound, @org.jetbrains.annotations.NotNull()
    java.lang.String strVolume, boolean freeDisplay, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p7) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDisplayCounterStatusLocal(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String WelcomeMessage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllBranchesLocal(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Branches>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isBranchOpenLocal(int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.IsBranchOpen>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getServicesLocal(int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Services>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBookTicketLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String mobileNumber, int serviceID, boolean IsHandicap, boolean isVip, int languageID, int AppointmentCode, int branchId, int QbranchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.BookTicket>>> p8) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTicketLocal(int QueueID, int language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.GetTicket>>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWorkingHourServiceLocal(int branchID, int serviceID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.IsService>>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendLogLocal(int branchid, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.LogReturn>>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object tabletStatusLocal(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.LogReturn>>> p3) {
        return null;
    }
    
    public QRepository() {
        super();
    }
}