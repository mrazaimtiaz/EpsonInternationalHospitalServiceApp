package com.epson.epos2_printer.repository

import com.epson.epos2_printer.api.RetrofitInstance
import com.epson.epos2_printer.api.RetrofitInstanceLocal


class QRepositoryLocal {

    suspend fun getDispenserGetSettings(branchID: Int) = RetrofitInstance.api.getDispenserGetSettings(branchID)

    suspend fun getDisplayCounterStatus(branchID: Int, WelcomeMessage: String)= RetrofitInstance.api.getDisplayCounterStatus(branchID,WelcomeMessage)


    suspend fun getAllBranches() =
            RetrofitInstanceLocal.api.getAllBranches()

    suspend fun isBranchOpen(branchID: Int) =
            RetrofitInstanceLocal.api.isBranchOpen(branchID)

    suspend fun getServices(branchID: Int) =
            RetrofitInstanceLocal.api.getServices(branchID)


    suspend fun getBookTicket(mobileNumber: String, serviceID: Int, IsHandicap: Boolean, isVip: Boolean, languageID: Int,
                              AppointmentCode: Int,
                              branchId: Int,
                              QbranchID: Int) =
            RetrofitInstanceLocal.api.getBookTicket(mobileNumber=mobileNumber,serviceID= serviceID,IsHandicap= IsHandicap,isVip= isVip,languageID= languageID,AppointmentCode= AppointmentCode,branchId= branchId,QbranchID=QbranchID)

    suspend fun getTicket(QueueID: Int, language: Int) =
            RetrofitInstanceLocal.api.getTicket(QueueID, language)

    suspend fun getWorkingHourService(branchID: Int, serviceID: Int) =
            RetrofitInstanceLocal.api.getWorkingHourService(branchID, serviceID)


}