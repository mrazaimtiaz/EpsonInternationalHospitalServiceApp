package com.epson.epos2_printer.api

import com.epson.epos2_printer.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PdaAPI {
//qtouch_api_Centralized/api
    //qtouch_api_Centralized
    //Qtouch_API/Api
    @GET("Api/GetBranches")
    suspend fun getAllBranches(): Response<List<Branches>>


     // http://gickuwait-dev.com/api/DispenserGetSettings?branchID=1
    @GET("Api/DispenserGetSettings")
    suspend fun getDispenserGetSettings(@Query("branchID") branchID: Int): Response<List<DispenserSettings>>
  //  https://gickuwait-dev.com/api/SendDisplayMessage?branchid=1&SumerizeScreen1=33&SumerizeScreen2=33&voiceControllerID=43472&StrSound=en%7Cding3&strVolume=FF
    //    //http://gickuwait-dev.com/api/DisplayCounterStatus?branchID=1&WelcomeMessage=Welcome To Zain

    //http://gickuwait-dev.com/api/timerDisplay?showblinkindex=0&LastCalledPanelID=34213&LastCalledBookedNo=S09&SumerizeScreen1=33&SumerizeScreen2=33&LastCalledSummarizeMsg=S09-%3e01&Secondlastcalled&Thirdlastcalled
    @GET("Api/timerDisplay")
    suspend fun getSendTimerDisplay(@Query("showblinkindex") showblinkindex: Int,@Query("LastCalledPanelID") LastCalledPanelID: String,@Query("LastCalledBookedNo") LastCalledBookedNo: String,@Query("SumerizeScreen1") SumerizeScreen1: String,@Query("SumerizeScreen2") SumerizeScreen2: String,@Query("LastCalledSummarizeMsg") LastCalledSummarizeMsg: String,@Query("Secondlastcalled") Secondlastcalled: String,@Query("Thirdlastcalled") Thirdlastcalled: String): Response<List<CounterStatus>>


    @GET("Api/SendDisplayMessage")
    suspend fun getSendDisplayMessage(@Query("branchID") branchID: Int,@Query("SumerizeScreen1") SumerizeScreen1: String,@Query("SumerizeScreen2") SumerizeScreen2: String,@Query("voiceControllerID") voiceControllerID: String,@Query("StrSound") StrSound: String,@Query("strVolume") strVolume: String,@Query("freeDisplay") freeDisplay: Boolean): Response<List<CounterStatus>>


    @GET("Api/DisplayCounterStatus")
    suspend fun getDisplayCounterStatus(@Query("branchID") branchID: Int,@Query("WelcomeMessage") WelcomeMessage: String): Response<List<CounterStatus>>


    @GET("api/GetWorkingHoursBranches")
    suspend fun isBranchOpen(@Query("branchID") branchID: Int): Response<List<IsBranchOpen>>
    
    @GET("api/GetServices")
    suspend fun getServices(@Query("branchID") branchID: Int): Response<List<Services>>
    @POST("api/BookTicketfrmBranch")
    suspend fun getBookTicketNew(@Query("serviceID") serviceID: Int,
                              @Query("IsHandicap") IsHandicap: Boolean,
                              @Query("isVip") isVip: Boolean,
                              @Query("languageID") languageID: Int,
                              @Query("AppointmentCode") AppointmentCode: Int,
                              @Query("Customer_CivilID") Customer_CivilID: Int =0,
                              @Query("branchId") branchId: Int,): Response<List<BookTicket>>

    @POST("api/BookTicket")
    suspend fun getBookTicket(@Query("mobileNumber") mobileNumber: String,
                              @Query("serviceID") serviceID: Int,
                              @Query("IsHandicap") IsHandicap: Boolean,
                              @Query("isVip") isVip: Boolean,
                              @Query("languageID") languageID: Int,
                              @Query("AppointmentCode") AppointmentCode: Int,
                              @Query("branchId") branchId: Int,
                              @Query("QbranchID") QbranchID: Int): Response<List<BookTicket>>
    @GET("api/GetTicket")
    suspend fun getTicket(@Query("QueueID") QueueID: Int, @Query("language") language: Int): Response<List<GetTicket>>

    @GET("api/GetWorkingHourServices")
    suspend fun getWorkingHourService(@Query("branchID") branchID: Int, @Query("serviceID") serviceID: Int): Response<List<IsService>>

    @POST("api/TabletLog")
    suspend fun sendLog(@Query("branchid") branchid: Int, @Query("errorMsg") errorMsg: String): Response<List<LogReturn>>

    @POST("Api/TabletStatus")
    suspend fun tabletStatus(@Query("branchid") branchid: Int, @Query("type") type: String,@Query("status") status: String): Response<List<LogReturn>>


}