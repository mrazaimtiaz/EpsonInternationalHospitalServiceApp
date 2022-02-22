package com.epson.epos2_printer.repository

import com.epson.epos2_printer.api.RetrofitInstance
import com.epson.epos2_printer.api.RetrofitInstanceLocal
import com.epson.epos2_printer.models.CounterStatus
import com.epson.epos2_printer.models.DispenserSettings
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


class QRepository {
    suspend fun getAllBranches() =
            RetrofitInstance.api.getAllBranches()


    suspend fun getSendTimerDisplay(showblinkindex: Int,LastCalledPanelID: String, LastCalledBookedNo: String,SumerizeScreen1: String,SumerizeScreen2: String, LastCalledSummarizeMsg: String,Secondlastcalled: String,Thirdlastcalled: String) = RetrofitInstance.api.getSendTimerDisplay(showblinkindex, LastCalledPanelID, LastCalledBookedNo,SumerizeScreen1,SumerizeScreen2, LastCalledSummarizeMsg, Secondlastcalled, Thirdlastcalled)

    suspend fun getDispenserGetSettings(branchID: Int) = RetrofitInstance.api.getDispenserGetSettings(branchID)


    suspend fun getSendDisplayMessage( branchID: Int,SumerizeScreen1: String,SumerizeScreen2: String, voiceControllerID: String,StrSound: String, strVolume: String, freeDisplay: Boolean) = RetrofitInstance.api.getSendDisplayMessage(branchID, SumerizeScreen1, SumerizeScreen2, voiceControllerID, StrSound, strVolume,freeDisplay)


    suspend fun getDisplayCounterStatus(branchID: Int, WelcomeMessage: String)= RetrofitInstance.api.getDisplayCounterStatus(branchID,WelcomeMessage)


    suspend fun isBranchOpen(branchID: Int) =
            RetrofitInstance.api.isBranchOpen(branchID)

    suspend fun getServices(branchID: Int) =
            RetrofitInstance.api.getServices(branchID)


    suspend fun getBookTicket(mobileNumber: String, serviceID: Int, IsHandicap: Boolean, isVip: Boolean, languageID: Int,
                              AppointmentCode: Int,
                              branchId: Int,
                              QbranchID: Int) =
            RetrofitInstance.api.getBookTicket(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)

    suspend fun getTicket(QueueID: Int, language: Int) =
            RetrofitInstance.api.getTicket(QueueID, language)

    suspend fun getWorkingHourService(branchID: Int, serviceID: Int) =
            RetrofitInstance.api.getWorkingHourService(branchID, serviceID)

    suspend fun sendLog(branchID: Int, errorMsg: String) =
            RetrofitInstance.api.sendLog(branchID, errorMsg)

    suspend fun tabletStatus(branchID: Int, type: String,status: String) =
            RetrofitInstance.api.tabletStatus(branchID, type,status)


    //local
    suspend fun getSendTimerDisplayLocal(showblinkindex: Int,LastCalledPanelID: String, LastCalledBookedNo: String,SumerizeScreen1: String,SumerizeScreen2: String, LastCalledSummarizeMsg: String,Secondlastcalled: String,Thirdlastcalled: String) = RetrofitInstanceLocal.api.getSendTimerDisplay(showblinkindex, LastCalledPanelID, LastCalledBookedNo,SumerizeScreen1,SumerizeScreen2, LastCalledSummarizeMsg, Secondlastcalled, Thirdlastcalled)

    suspend fun getDispenserGetSettingsLocal(branchID: Int) = RetrofitInstanceLocal.api.getDispenserGetSettings(branchID)


    suspend fun getSendDisplayMessageLocal( branchID: Int,SumerizeScreen1: String,SumerizeScreen2: String, voiceControllerID: String,StrSound: String, strVolume: String,freeDisplay: Boolean) = RetrofitInstanceLocal.api.getSendDisplayMessage(branchID, SumerizeScreen1, SumerizeScreen2, voiceControllerID, StrSound, strVolume,freeDisplay)


    suspend fun getDisplayCounterStatusLocal(branchID: Int, WelcomeMessage: String)= RetrofitInstanceLocal.api.getDisplayCounterStatus(branchID,WelcomeMessage)


    suspend fun getAllBranchesLocal() =
            RetrofitInstanceLocal.api.getAllBranches()

    suspend fun isBranchOpenLocal(branchID: Int) =
            RetrofitInstanceLocal.api.isBranchOpen(branchID)

    suspend fun getServicesLocal(branchID: Int) =
            RetrofitInstanceLocal.api.getServices(branchID)


    suspend fun getBookTicketLocal(mobileNumber: String, serviceID: Int, IsHandicap: Boolean, isVip: Boolean, languageID: Int,
                              AppointmentCode: Int,
                              branchId: Int,
                              QbranchID: Int) =
            RetrofitInstanceLocal.api.getBookTicket(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)

    suspend fun getTicketLocal(QueueID: Int, language: Int) =
            RetrofitInstanceLocal.api.getTicket(QueueID, language)

    suspend fun getWorkingHourServiceLocal(branchID: Int, serviceID: Int) =
            RetrofitInstanceLocal.api.getWorkingHourService(branchID, serviceID)

    suspend fun sendLogLocal(branchid: Int, errorMsg: String) =
            RetrofitInstanceLocal.api.sendLog(branchid, errorMsg)

    suspend fun tabletStatusLocal(branchID: Int, type: String,status: String) =
            RetrofitInstanceLocal.api.tabletStatus(branchID, type,status)


}