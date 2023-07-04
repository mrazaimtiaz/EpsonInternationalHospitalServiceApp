package com.epson.epos2_printer.viewmodel

import android.app.Application
import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.epson.epos2_printer.R
import com.epson.epos2_printer.models.*
import com.epson.epos2_printer.repository.QRepository
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class QViewModel(
        app: Application,
        private val qRepository: QRepository
) : AndroidViewModel(app) {

    val branches: MutableLiveData<Resource<List<Branches>>> = MutableLiveData()
    val isBranchOpen: MutableLiveData<Resource<List<IsBranchOpen>>> = MutableLiveData()
    val getServices: MutableLiveData<Resource<List<Services>>> = MutableLiveData()
    val getBookTicket: MutableLiveData<Resource<List<BookTicket>>> = MutableLiveData()
    val getTicket: MutableLiveData<Resource<List<GetTicket>>> = MutableLiveData()
  //  val getIsService: MutableLiveData<Resource<List<IsService>>> = MutableLiveData()
  private val getSendLog: MutableLiveData<Resource<List<LogReturn>>> = MutableLiveData()


    private val getTabletStatus: MutableLiveData<Resource<List<LogReturn>>> = MutableLiveData()

    //var mPrinterModel: Printer? = null


    private var branchesResponse: List<Branches>? = null
    private var isBranchOpenResponse: List<IsBranchOpen>? = null
    private var getServicesResponse: List<Services>? = null
    private var getBookTicketResponse: List<BookTicket>? = null
    private var getTicketResponse: List<GetTicket>? = null
   // private var getIsServiceResponse: List<IsService>? = null
    private var getSendLogResponse: List<LogReturn>? = null


   // private var getTabletStatusResponse: List<LogReturn>? = null


    private val mContext = getApplication<Application>().applicationContext




    /* init {
         getBranchesApi()
     }*/

    //*********************************************** getMethod *********************************************************
    fun getBranchesApi() = viewModelScope.launch {
        safeGetBranches()
    }

    fun isBranchOpen(branchID: Int) = viewModelScope.launch {
     //   safeGetIsBranchOpen(branchID)
    }

    /*suspend fun isBranchOpenForErrorActivity(branchID: Int) {
        safeGetIsBranchOpen(branchID)
    }*/

    fun getServices(branchID: Int) = viewModelScope.launch {
        safeGetServices(branchID)
    }

    //can remove later
    /* fun getIsServiceEnabled(branchID: Int,serviceID: Int) = viewModelScope.launch {
         safeGetIsServiceEnabled(branchID,serviceID)
     }
 */
    fun getBookTicket(mobileNumber: String, serviceID: Int, IsHandicap: Boolean, isVip: Boolean, languageID: Int,
                      AppointmentCode: Int,
                      branchId: Int,
                      QbranchID: Int) = viewModelScope.launch {
        safeGetBookTicket(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)

    }

    fun getTicket(QueueID: Int, language: Int) = viewModelScope.launch {
        safeGetTicket(QueueID, language)
    }


     fun sendLog(branchID: Int, errorMsg: String) = viewModelScope.launch {
      //   safeSendLog(branchID, errorMsg)
     }

    fun sendTabletStatus(branchID: Int, type: String,status: String) = viewModelScope.launch {
      //  safeTabletStatus(branchID, type,status)
    }


    //*********************************************** safeMethod *********************************************************
    private suspend fun safeGetBranches() {
        branches.postValue(Resource.Loading())
        //   try {
        if (getServerPreference()) {
            try {
                val response = qRepository.getAllBranchesLocal()
                branches.postValue(handleBranchesResponse(response))
            } catch (t: Throwable) {
                when (t) {
                    is Exception -> branches.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> branches.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }
        } else {
            if (hasInternetConnection()) {
                try {
                    val response = qRepository.getAllBranches()
                    branches.postValue(handleBranchesResponse(response))
                    //testing below
                    /*branches.postValue(Resource.Success(
                        listOf<Branches>(Branches("test","test",2 ,true))
                              ))*/
                } catch (t: Throwable) {
                    when (t) {
                        is Exception -> branches.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        else -> branches.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    }
                }
            } else {
                branches.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }
        }
        /*    //  if (hasInternetConnection()) {
                  val response = qRepository.getAllBranches()
                  branches.postValue(handleBranchesResponse(response))
         *//*     } else {
                branches.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }*/
        /*  } catch (t: Throwable) {
              when (t) {
                  is Exception -> branches.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                  else -> branches.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
              }
          }*/
    }

    private suspend fun safeGetIsBranchOpen(branchID: Int) {
        isBranchOpen.postValue(Resource.Loading())
        //   try {
        if (getServerPreference()) {
            try {
                Log.d("TAG", "safeGetIsBranchOpen: called except 6")
                val response = qRepository.isBranchOpenLocal(branchID)
                isBranchOpen.postValue(handleIsBranchOpenResponse(response))
                Log.d("TAG", "safeGetIsBranchOpen: called except 7")
            } catch (t: Throwable) {
                when (t) {
                    is Exception -> {
                        Log.d("TAG", "safeGetIsBranchOpen: called except 3")
                        isBranchOpen.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    }
                    else -> {
                        Log.d("TAG", "safeGetIsBranchOpen: called except 4")
                        isBranchOpen.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    }
                }
            }

        } else {
            if (hasInternetConnection()) {
                try {
                    val response = qRepository.isBranchOpen(branchID)
                    isBranchOpen.postValue(handleIsBranchOpenResponse(response))
                } catch (t: Throwable) {
                    when (t) {
                        is Exception -> {
                            Log.d("TAG", "safeGetIsBranchOpen: called except 1")
                            isBranchOpen.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        }
                        else -> {
                            Log.d("TAG", "safeGetIsBranchOpen: called except 2")
                            isBranchOpen.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        }
                    }
                }
            } else {
                isBranchOpen.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }
        }
        /* //   if (hasInternetConnection()) {
                val response = qRepository.isBranchOpen(branchID)
                isBranchOpen.postValue(handleIsBranchOpenResponse(response))
             *//*   } else {
                    isBranchOpen.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
                }*/
        /* } catch (t: Throwable) {
             when (t) {
                 is Exception -> isBranchOpen.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                 else -> isBranchOpen.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
             }
         }*/
    }

    private suspend fun safeGetServices(branchID: Int) {
        getServices.postValue(Resource.Loading())
        //  try {
        if (getServerPreference()) {
            try {
                val response = qRepository.getServicesLocal(branchID)
                getServices.postValue(handleGetServicesResponse(response))
            } catch (t: Throwable) {
                when (t) {
                    is Exception -> getServices.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> getServices.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }
        } else {
            if (hasInternetConnection()) {
                try {
                    val response = qRepository.getServices(branchID)
                    getServices.postValue(handleGetServicesResponse(response))
                    //testing below
                    /*getServices.postValue(Resource.Success(  listOf<Services>(
                        Services("test","test",1,1,"","",true,1,1,1,"","","","","22","","",""),
                        Services("test","test",1,1,"","",true,1,1,1,"","","","","22","","",""),
                        Services("test","test",1,1,"","",true,1,1,1,"","","","","22","","",""),

                        )))*/
                } catch (t: Throwable) {
                    when (t) {
                        is Exception -> getServices.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        else -> getServices.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    }
                }
            } else {
                getServices.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }
        }
        /* // if (hasInternetConnection()) {
              val response = qRepository.getServices(branchID)
              getServices.postValue(handleGetServicesResponse(response))
       *//*   } else {
                getServices.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }*/
        /* } catch (t: Throwable) {
             when (t) {
                 is Exception -> getServices.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                 else -> getServices.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
             }
         }*/
    }

    private suspend fun safeGetBookTicket(mobileNumber: String, serviceID: Int, IsHandicap: Boolean, isVip: Boolean, languageID: Int,
                                          AppointmentCode: Int,
                                          branchId: Int,
                                          QbranchID: Int) {
        getBookTicket.postValue(Resource.Loading())
        //   try {
        if (getServerPreference()) {
            try {
                val response = qRepository.getBookTicketLocal(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)
                getBookTicket.postValue(handleGetBookTicketResponse(response))
            } catch (t: Throwable) {
                when (t) {
                    is Exception -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }
        } else {
            if (hasInternetConnection()) {
                try {
                    val response = qRepository.getBookTicket(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)
                    getBookTicket.postValue(handleGetBookTicketResponse(response))
                } catch (t: Throwable) {
                    when (t) {
                        is Exception -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        else -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    }
                }
            } else {
                getBookTicket.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }
        }
        /*  // if (hasInternetConnection()) {
               val response = qRepository.getBookTicket(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)
               getBookTicket.postValue(handleGetBookTicketResponse(response))
         *//*  } else {
                getBookTicket.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }*/
        /*    } catch (t: Throwable) {
                when (t) {
                    is Exception -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }*/
    }


    private suspend fun safeGetTicket(QueueID: Int, language: Int) {
        getTicket.postValue(Resource.Loading())
      //  try {
            if (getServerPreference()) {
                try {
                    val response = qRepository.getTicketLocal(QueueID, language)
                    getTicket.postValue(handleGetTicketResponse(response))
                } catch (t: Throwable) {
                    when (t) {
                        is Exception -> getTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        else -> getTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    }
                }

            } else {
                if (hasInternetConnection()) {
                    try {
                        val response = qRepository.getTicket(QueueID, language)
                        getTicket.postValue(handleGetTicketResponse(response))
                    } catch (t: Throwable) {
                        when (t) {
                            is Exception -> getTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                            else -> getTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        }
                    }
                } else {
                    getTicket.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
                }
            }
            /*//   if (hasInternetConnection()) {
                   val response = qRepository.getTicket(QueueID,language)
                   getTicket.postValue(handleGetTicketResponse(response))
              *//* } else {
                getTicket.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }*/
     /*   } catch (t: Throwable) {
            when (t) {
                is Exception -> getTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                else -> getTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
            }
        }*/
    }
//can remove later
    /*   private suspend fun safeGetIsServiceEnabled(branchID: Int,serviceID: Int) {
           getIsService.postValue(Resource.Loading())
           try {
               if (hasInternetConnection()) {
                   val response = qRepository.getWorkingHourService(branchID,serviceID)
                   getIsService.postValue(handleGetIsServiceResponse(response))
               } else {
                   getIsService.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
               }
           } catch (t: Throwable) {
               when (t) {
                   is Exception -> getIsService.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                   else -> getIsService.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
               }
           }
       }*/


    private suspend fun safeSendLog(branchID: Int, errorMsg: String) {
        getSendLog.postValue(Resource.Loading())
        //   try {
        if (getServerPreference()) {
            try {
                val response = qRepository.sendLogLocal(branchID, errorMsg)
                getSendLog.postValue(handleGetLogResponse(response))
            } catch (t: Throwable) {
                when (t) {
                    is Exception -> getSendLog.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> getSendLog.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }
        } else {
            if (hasInternetConnection()) {
                try {
                    val response = qRepository.sendLog(branchID, errorMsg)
                    getSendLog.postValue(handleGetLogResponse(response))
                } catch (t: Throwable) {
                    when (t) {
                        is Exception -> getSendLog.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        else -> getSendLog.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    }
                }
            } else {
                getSendLog.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }
        }
        /*  // if (hasInternetConnection()) {
               val response = qRepository.getBookTicket(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)
               getBookTicket.postValue(handleGetBookTicketResponse(response))
         *//*  } else {
                getBookTicket.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }*/
        /*    } catch (t: Throwable) {
                when (t) {
                    is Exception -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }*/
    }


    private suspend fun safeTabletStatus(branchID: Int, type: String,status: String) {
        getTabletStatus.postValue(Resource.Loading())
        //   try {
        if (getServerPreference()) {
            try {
                val response = qRepository.tabletStatusLocal(branchID, type,status)
                getTabletStatus.postValue(handleGetLogResponse(response))
            } catch (t: Throwable) {
                when (t) {
                    is Exception -> getTabletStatus.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> getTabletStatus.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }
        } else {
            if (hasInternetConnection()) {
                try {
                    val response = qRepository.tabletStatus(branchID, type,status)
                    getTabletStatus.postValue(handleGetLogResponse(response))
                } catch (t: Throwable) {
                    when (t) {
                        is Exception -> getTabletStatus.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                        else -> getTabletStatus.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    }
                }
            } else {
                getTabletStatus.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }
        }
        /*  // if (hasInternetConnection()) {
               val response = qRepository.getBookTicket(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)
               getBookTicket.postValue(handleGetBookTicketResponse(response))
         *//*  } else {
                getBookTicket.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }*/
        /*    } catch (t: Throwable) {
                when (t) {
                    is Exception -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }*/
    }

    //*********************************************** handle response *********************************************************
    private fun handleBranchesResponse(response: Response<List<Branches>>): Resource<List<Branches>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                branchesResponse = if (branchesResponse == null) {
                    resultResponse
                } else {
                    resultResponse
                }
                return Resource.Success(branchesResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    private fun handleIsBranchOpenResponse(response: Response<List<IsBranchOpen>>): Resource<List<IsBranchOpen>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                isBranchOpenResponse = if (isBranchOpenResponse == null) {
                    resultResponse
                } else {
                    resultResponse
                }
                return Resource.Success(isBranchOpenResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    private fun handleGetServicesResponse(response: Response<List<Services>>): Resource<List<Services>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                getServicesResponse = if (getServicesResponse == null) {
                    resultResponse
                } else {
                    resultResponse
                }
                return Resource.Success(getServicesResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    private fun handleGetBookTicketResponse(response: Response<List<BookTicket>>): Resource<List<BookTicket>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                getBookTicketResponse = if (getBookTicketResponse == null) {
                    resultResponse
                } else {
                    resultResponse
                }
                return Resource.Success(getBookTicketResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    private fun handleGetTicketResponse(response: Response<List<GetTicket>>): Resource<List<GetTicket>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                getTicketResponse = if (getTicketResponse == null) {
                    resultResponse
                } else {
                    resultResponse
                }
                return Resource.Success(getTicketResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleGetLogResponse(response: Response<List<LogReturn>>): Resource<List<LogReturn>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                getSendLogResponse = if (getSendLogResponse == null) {
                    resultResponse
                } else {
                    resultResponse
                }
                return Resource.Success(getSendLogResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

//can remove later
/*
    private fun handleGetIsServiceResponse(response: Response<List<IsService>>): Resource<List<IsService>> {
        if (response.isSuccessful) {

            response.body()?.let { resultResponse ->
                getIsServiceResponse = if (getIsServiceResponse == null) {
                    resultResponse
                } else {
                    resultResponse
                }
                return Resource.Success(getIsServiceResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
*/

    //*********************************************** Internet connection check *********************************************************
    private fun getServerPreference(): Boolean {
        val pref = getApplication<Application>().getSharedPreferences(
                Constants.SERVER_AUTH,
                0
        ) // 0 - for private mode

        return pref.getBoolean(Constants.LOCAL_DATABASE, false)

    }



    fun hasInternetConnection(): Boolean {
        return true
        /* val connectivityManager = getApplication<QappApplication>().getSystemService(
                 Context.CONNECTIVITY_SERVICE
         ) as ConnectivityManager
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
             val activeNetwork = connectivityManager.activeNetwork ?: return false
             val capabilities =
                     connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
             return when {
                 capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                 capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                 capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                 else -> false
             }
         } else {
             connectivityManager.activeNetworkInfo?.run {
                 return when (type) {
                     ConnectivityManager.TYPE_WIFI -> true
                     ContactsContract.CommonDataKinds.Email.TYPE_MOBILE -> true
                     ConnectivityManager.TYPE_ETHERNET -> true
                     else -> false
                 }
             }
         }
         return false*/
    }

  /*   fun gettingPrinter(): Printer?{
         return  mPrinterModel

    }
     fun settingPrinter(printer: Printer?){
        mPrinterModel = printer
    }
*/




}