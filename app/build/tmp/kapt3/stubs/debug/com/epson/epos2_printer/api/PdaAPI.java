package com.epson.epos2_printer.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006Jm\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u0011\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0013\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014Jc\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u0011\u001a\u00020\f2\b\b\u0003\u0010\u0016\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\'\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010\u001e\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJc\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010!\u001a\u00020\n2\b\b\u0001\u0010\"\u001a\u00020\n2\b\b\u0001\u0010#\u001a\u00020\n2\b\b\u0001\u0010$\u001a\u00020\n2\b\b\u0001\u0010%\u001a\u00020\n2\b\b\u0001\u0010&\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'Jm\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00040\u00032\b\b\u0001\u0010)\u001a\u00020\f2\b\b\u0001\u0010*\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n2\b\b\u0001\u0010!\u001a\u00020\n2\b\b\u0001\u0010\"\u001a\u00020\n2\b\b\u0001\u0010,\u001a\u00020\n2\b\b\u0001\u0010-\u001a\u00020\n2\b\b\u0001\u0010.\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\'\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ1\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00040\u00032\b\b\u0001\u00104\u001a\u00020\f2\b\b\u0001\u00105\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106J1\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106J\'\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ1\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00040\u00032\b\b\u0001\u0010=\u001a\u00020\f2\b\b\u0001\u0010>\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ;\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00040\u00032\b\b\u0001\u0010=\u001a\u00020\f2\b\b\u0001\u0010@\u001a\u00020\n2\b\b\u0001\u0010A\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010B\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006C"}, d2 = {"Lcom/epson/epos2_printer/api/PdaAPI;", "", "getAllBranches", "Lretrofit2/Response;", "", "Lcom/epson/epos2_printer/models/Branches;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookTicket", "Lcom/epson/epos2_printer/models/BookTicket;", "mobileNumber", "", "serviceID", "", "IsHandicap", "", "isVip", "languageID", "AppointmentCode", "branchId", "QbranchID", "(Ljava/lang/String;IZZIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookTicketNew", "Customer_CivilID", "(IZZIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDispenserGetSettings", "Lcom/epson/epos2_printer/models/DispenserSettings;", "branchID", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayCounterStatus", "Lcom/epson/epos2_printer/models/CounterStatus;", "WelcomeMessage", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSendDisplayMessage", "SumerizeScreen1", "SumerizeScreen2", "voiceControllerID", "StrSound", "strVolume", "freeDisplay", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSendTimerDisplay", "showblinkindex", "LastCalledPanelID", "LastCalledBookedNo", "LastCalledSummarizeMsg", "Secondlastcalled", "Thirdlastcalled", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServices", "Lcom/epson/epos2_printer/models/Services;", "getTicket", "Lcom/epson/epos2_printer/models/GetTicket;", "QueueID", "language", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWorkingHourService", "Lcom/epson/epos2_printer/models/IsService;", "isBranchOpen", "Lcom/epson/epos2_printer/models/IsBranchOpen;", "sendLog", "Lcom/epson/epos2_printer/models/LogReturn;", "branchid", "errorMsg", "tabletStatus", "type", "status", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PdaAPI {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "Api/GetBranches")
    public abstract java.lang.Object getAllBranches(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Branches>>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "Api/DispenserGetSettings")
    public abstract java.lang.Object getDispenserGetSettings(@retrofit2.http.Query(value = "branchID")
    int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.DispenserSettings>>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "Api/timerDisplay")
    public abstract java.lang.Object getSendTimerDisplay(@retrofit2.http.Query(value = "showblinkindex")
    int showblinkindex, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "LastCalledPanelID")
    java.lang.String LastCalledPanelID, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "LastCalledBookedNo")
    java.lang.String LastCalledBookedNo, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "SumerizeScreen1")
    java.lang.String SumerizeScreen1, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "SumerizeScreen2")
    java.lang.String SumerizeScreen2, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "LastCalledSummarizeMsg")
    java.lang.String LastCalledSummarizeMsg, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "Secondlastcalled")
    java.lang.String Secondlastcalled, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "Thirdlastcalled")
    java.lang.String Thirdlastcalled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p8);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "Api/SendDisplayMessage")
    public abstract java.lang.Object getSendDisplayMessage(@retrofit2.http.Query(value = "branchID")
    int branchID, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "SumerizeScreen1")
    java.lang.String SumerizeScreen1, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "SumerizeScreen2")
    java.lang.String SumerizeScreen2, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "voiceControllerID")
    java.lang.String voiceControllerID, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "StrSound")
    java.lang.String StrSound, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "strVolume")
    java.lang.String strVolume, @retrofit2.http.Query(value = "freeDisplay")
    boolean freeDisplay, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p7);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "Api/DisplayCounterStatus")
    public abstract java.lang.Object getDisplayCounterStatus(@retrofit2.http.Query(value = "branchID")
    int branchID, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "WelcomeMessage")
    java.lang.String WelcomeMessage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.CounterStatus>>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/GetWorkingHoursBranches")
    public abstract java.lang.Object isBranchOpen(@retrofit2.http.Query(value = "branchID")
    int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.IsBranchOpen>>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/GetServices")
    public abstract java.lang.Object getServices(@retrofit2.http.Query(value = "branchID")
    int branchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Services>>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/BookTicketfrmBranch")
    public abstract java.lang.Object getBookTicketNew(@retrofit2.http.Query(value = "serviceID")
    int serviceID, @retrofit2.http.Query(value = "IsHandicap")
    boolean IsHandicap, @retrofit2.http.Query(value = "isVip")
    boolean isVip, @retrofit2.http.Query(value = "languageID")
    int languageID, @retrofit2.http.Query(value = "AppointmentCode")
    int AppointmentCode, @retrofit2.http.Query(value = "Customer_CivilID")
    int Customer_CivilID, @retrofit2.http.Query(value = "branchId")
    int branchId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.BookTicket>>> p7);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/BookTicket")
    public abstract java.lang.Object getBookTicket(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "mobileNumber")
    java.lang.String mobileNumber, @retrofit2.http.Query(value = "serviceID")
    int serviceID, @retrofit2.http.Query(value = "IsHandicap")
    boolean IsHandicap, @retrofit2.http.Query(value = "isVip")
    boolean isVip, @retrofit2.http.Query(value = "languageID")
    int languageID, @retrofit2.http.Query(value = "AppointmentCode")
    int AppointmentCode, @retrofit2.http.Query(value = "branchId")
    int branchId, @retrofit2.http.Query(value = "QbranchID")
    int QbranchID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.BookTicket>>> p8);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/GetTicket")
    public abstract java.lang.Object getTicket(@retrofit2.http.Query(value = "QueueID")
    int QueueID, @retrofit2.http.Query(value = "language")
    int language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.GetTicket>>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/GetWorkingHourServices")
    public abstract java.lang.Object getWorkingHourService(@retrofit2.http.Query(value = "branchID")
    int branchID, @retrofit2.http.Query(value = "serviceID")
    int serviceID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.IsService>>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/TabletLog")
    public abstract java.lang.Object sendLog(@retrofit2.http.Query(value = "branchid")
    int branchid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "errorMsg")
    java.lang.String errorMsg, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.LogReturn>>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "Api/TabletStatus")
    public abstract java.lang.Object tabletStatus(@retrofit2.http.Query(value = "branchid")
    int branchid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "type")
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "status")
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.epson.epos2_printer.models.LogReturn>>> p3);
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}