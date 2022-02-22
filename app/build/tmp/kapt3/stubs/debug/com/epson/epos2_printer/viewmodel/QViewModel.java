package com.epson.epos2_printer.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006JF\u0010\u000f\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020)J\u0006\u00101\u001a\u00020%J\b\u00102\u001a\u00020+H\u0002J\u000e\u0010\u0016\u001a\u00020%2\u0006\u00103\u001a\u00020)J\u0016\u0010\u001b\u001a\u00020%2\u0006\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020)J(\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n08H\u0002J(\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\t2\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n08H\u0002J(\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\t2\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n08H\u0002J(\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t2\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n08H\u0002J(\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\n0\t2\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\n08H\u0002J(\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\n0\t2\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\n08H\u0002J\u0006\u0010>\u001a\u00020+J\u000e\u0010\u001f\u001a\u00020%2\u0006\u00103\u001a\u00020)JQ\u0010?\u001a\u00020@2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010AJ\u0011\u0010B\u001a\u00020@H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010CJ\u0019\u0010D\u001a\u00020@2\u0006\u00103\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u00020@2\u0006\u00103\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ!\u0010G\u001a\u00020@2\u0006\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010HJ!\u0010I\u001a\u00020@2\u0006\u00103\u001a\u00020)2\u0006\u0010J\u001a\u00020\'H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010KJ)\u0010L\u001a\u00020@2\u0006\u00103\u001a\u00020)2\u0006\u0010M\u001a\u00020\'2\u0006\u0010N\u001a\u00020\'H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010OJ\u0016\u0010P\u001a\u00020%2\u0006\u00103\u001a\u00020)2\u0006\u0010J\u001a\u00020\'J\u001e\u0010Q\u001a\u00020%2\u0006\u00103\u001a\u00020)2\u0006\u0010M\u001a\u00020\'2\u0006\u0010N\u001a\u00020\'R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n $*\u0004\u0018\u00010#0#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006R"}, d2 = {"Lcom/epson/epos2_printer/viewmodel/QViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "qRepository", "Lcom/epson/epos2_printer/repository/QRepository;", "(Landroid/app/Application;Lcom/epson/epos2_printer/repository/QRepository;)V", "branches", "Landroidx/lifecycle/MutableLiveData;", "Lcom/epson/epos2_printer/utils/Resource;", "", "Lcom/epson/epos2_printer/models/Branches;", "getBranches", "()Landroidx/lifecycle/MutableLiveData;", "branchesResponse", "getBookTicket", "Lcom/epson/epos2_printer/models/BookTicket;", "getGetBookTicket", "getBookTicketResponse", "getSendLog", "Lcom/epson/epos2_printer/models/LogReturn;", "getSendLogResponse", "getServices", "Lcom/epson/epos2_printer/models/Services;", "getGetServices", "getServicesResponse", "getTabletStatus", "getTicket", "Lcom/epson/epos2_printer/models/GetTicket;", "getGetTicket", "getTicketResponse", "isBranchOpen", "Lcom/epson/epos2_printer/models/IsBranchOpen;", "isBranchOpenResponse", "mContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/Job;", "mobileNumber", "", "serviceID", "", "IsHandicap", "", "isVip", "languageID", "AppointmentCode", "branchId", "QbranchID", "getBranchesApi", "getServerPreference", "branchID", "QueueID", "language", "handleBranchesResponse", "response", "Lretrofit2/Response;", "handleGetBookTicketResponse", "handleGetLogResponse", "handleGetServicesResponse", "handleGetTicketResponse", "handleIsBranchOpenResponse", "hasInternetConnection", "safeGetBookTicket", "", "(Ljava/lang/String;IZZIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeGetBranches", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeGetIsBranchOpen", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeGetServices", "safeGetTicket", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeSendLog", "errorMsg", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeTabletStatus", "type", "status", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLog", "sendTabletStatus", "app_debug"})
public final class QViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.Branches>>> branches = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.IsBranchOpen>>> isBranchOpen = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.Services>>> getServices = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.BookTicket>>> getBookTicket = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.GetTicket>>> getTicket = null;
    private final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.LogReturn>>> getSendLog = null;
    private final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.LogReturn>>> getTabletStatus = null;
    private java.util.List<com.epson.epos2_printer.models.Branches> branchesResponse;
    private java.util.List<com.epson.epos2_printer.models.IsBranchOpen> isBranchOpenResponse;
    private java.util.List<com.epson.epos2_printer.models.Services> getServicesResponse;
    private java.util.List<com.epson.epos2_printer.models.BookTicket> getBookTicketResponse;
    private java.util.List<com.epson.epos2_printer.models.GetTicket> getTicketResponse;
    private java.util.List<com.epson.epos2_printer.models.LogReturn> getSendLogResponse;
    private final android.content.Context mContext = null;
    private final com.epson.epos2_printer.repository.QRepository qRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.Branches>>> getBranches() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.IsBranchOpen>>> isBranchOpen() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.Services>>> getGetServices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.BookTicket>>> getGetBookTicket() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.GetTicket>>> getGetTicket() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBranchesApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job isBranchOpen(int branchID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getServices(int branchID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBookTicket(@org.jetbrains.annotations.NotNull()
    java.lang.String mobileNumber, int serviceID, boolean IsHandicap, boolean isVip, int languageID, int AppointmentCode, int branchId, int QbranchID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getTicket(int QueueID, int language) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job sendLog(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job sendTabletStatus(int branchID, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String status) {
        return null;
    }
    
    private final com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.Branches>> handleBranchesResponse(retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Branches>> response) {
        return null;
    }
    
    private final com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.IsBranchOpen>> handleIsBranchOpenResponse(retrofit2.Response<java.util.List<com.epson.epos2_printer.models.IsBranchOpen>> response) {
        return null;
    }
    
    private final com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.Services>> handleGetServicesResponse(retrofit2.Response<java.util.List<com.epson.epos2_printer.models.Services>> response) {
        return null;
    }
    
    private final com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.BookTicket>> handleGetBookTicketResponse(retrofit2.Response<java.util.List<com.epson.epos2_printer.models.BookTicket>> response) {
        return null;
    }
    
    private final com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.GetTicket>> handleGetTicketResponse(retrofit2.Response<java.util.List<com.epson.epos2_printer.models.GetTicket>> response) {
        return null;
    }
    
    private final com.epson.epos2_printer.utils.Resource<java.util.List<com.epson.epos2_printer.models.LogReturn>> handleGetLogResponse(retrofit2.Response<java.util.List<com.epson.epos2_printer.models.LogReturn>> response) {
        return null;
    }
    
    private final boolean getServerPreference() {
        return false;
    }
    
    public final boolean hasInternetConnection() {
        return false;
    }
    
    public QViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.epson.epos2_printer.repository.QRepository qRepository) {
        super(null);
    }
}