package com.epson.epos2_printer.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.epson.epos2_printer.models.Branches
import com.epson.epos2_printer.models.CounterStatus
import com.epson.epos2_printer.models.DispenserSettings
import com.epson.epos2_printer.models.PreferenceDisplayMessage
import com.epson.epos2_printer.repository.QRepository
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Constants.BRANCH_DEFAULT_VALUE
import com.epson.epos2_printer.utils.Constants.DELAY_CHECK_BRANCH
import com.epson.epos2_printer.utils.Constants.DELAY_LESS_THEN_ONE_SECOND
import com.epson.epos2_printer.utils.Constants.DELAY_ONE_MINUTE
import com.epson.epos2_printer.utils.Constants.DELAY_ONE_SECOND
import com.epson.epos2_printer.utils.Constants.DELAY_UPDATE_APP
import com.epson.epos2_printer.utils.Constants.IS_CALL_SENDDISPLAYMESSAGE
import com.epson.epos2_printer.utils.Constants.IS_CALL_TIMERDISPLAY
import com.epson.epos2_printer.utils.Constants.PACKET_CONFIG_AUTH
import com.epson.epos2_printer.utils.Constants.PREFERENCE_DISPLAY_MESSAGE_AUTH
import com.epson.epos2_printer.utils.Constants.SHOW_BLINK_INDEX_AUTH
import com.epson.epos2_printer.utils.Resource
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Response
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress


class BackEndViewModel(
    app: Application,
    private val qRepository: QRepository
) : AndroidViewModel(app) {

    // val branches: MutableLiveData<Resource<List<Branches>>> = MutableLiveData()
    // private val getSendLog: MutableLiveData<Resource<List<LogReturn>>> = MutableLiveData()


    //  private var getSendLogResponse: List<LogReturn>? = null


     private val mContext = getApplication<Application>().applicationContext


/*    init {
    saveISCallSendDisplayMessage(true)
    savePreferenceDisplayMessage(null)
    saveShowBlinkIndexPreference(-1)
    saveIsCallTIMERDISPLAY(false)
    setDispenserSettings()

    CoroutineScope(Dispatchers.Main).launch {
        delay(Constants.DELAY_CHECK_BRANCH)
        getCounter()
        sendDisplayMessage()
        timerDisplay()
    }
       *//* val delay = 1000L
        RepeatHelper.repeatDelayed(delay) {
            sendLog(0,"");
        }*//*

    }*/

    val changeImage: MutableLiveData<Resource<Boolean>> = MutableLiveData()

    fun callChangeImage(){
        changeImage.postValue(Resource.Success(true))
    }
    fun timerDisplay() {
        Log.d("TAG", "timerDisplay: called ")
        val branchID = getPreference()
        if (branchID != BRANCH_DEFAULT_VALUE) {

            val dispenserSetting = getDispenserConfigurationPreference()
            val isCallTimerDisplay = getIsCallTIMERDISPLAY()
            val preferenceDisplayMessage = getPreferenceDisplayMessage()
            if (dispenserSetting != null && preferenceDisplayMessage != null) {
                if (isCallTimerDisplay) {
                    viewModelScope.launch {
                        if (getServerPreference()) {
                            try {

                                var LastCalledPanelID = preferenceDisplayMessage.LastCalledPanelID
                                if (LastCalledPanelID.isNullOrEmpty()) {
                                    LastCalledPanelID = ""
                                }
                                var LastCalledSummarizeMsg =
                                    preferenceDisplayMessage.LastCalledSummarizeMsg
                                if (LastCalledSummarizeMsg.isNullOrEmpty()) {
                                    LastCalledSummarizeMsg = ""
                                }
                                var lastCalledBookedNo = preferenceDisplayMessage.LastCalledBookedNo
                                if (lastCalledBookedNo.isNullOrEmpty()) {
                                    lastCalledBookedNo = ""
                                }

                                var secondlastcalled = preferenceDisplayMessage.Secondlastcalled
                                if (secondlastcalled.isNullOrEmpty()) {
                                    secondlastcalled = ""
                                }

                                var thirdlastcalled = preferenceDisplayMessage.Thirdlastcalled
                                if (thirdlastcalled.isNullOrEmpty()) {
                                    thirdlastcalled = ""
                                }
                                //33  //33
                                val response = qRepository.getSendTimerDisplayLocal(
                                    getShowBlinkIndexPreference(),
                                    LastCalledPanelID,
                                    lastCalledBookedNo,
                                    dispenserSetting.SysConfig_SummarizeID2.toString(),
                                    dispenserSetting.SysConfig_SummarizeID2.toString(),
                                    LastCalledSummarizeMsg,
                                    secondlastcalled,
                                    thirdlastcalled
                                )

                                when (val resultResponse =
                                    handleGetCounterStatusResponse(response)) {
                                    is Resource.Success -> {

                                        Log.d("TAG", "timerDisplay: called 1")
                                        val list = resultResponse.data

                                        //showing toast
                                        withContext(Dispatchers.Main) {
                                            showToastInfo()
                                        }

                                        withContext(Dispatchers.IO) {
                                            Log.d("TAG", "timerDisplay: called 4")
                                            if (!list.isNullOrEmpty()) {

                                                Log.d("TAG", "timerDisplay: called 2")
                                                sendPackets(list, dispenserSetting,"timerDisplay")
                                            } else {

                                                Log.d("TAG", "timerDisplay: called 3")
                                            }
                                        }

                                        withContext(Dispatchers.IO) {
                                            if (!list.isNullOrEmpty()) {
                                                for (item in list) {
                                                    item.EnableSecondtimer?.let {
                                                        saveIsCallTIMERDISPLAY(
                                                            it
                                                        )
                                                    }
                                                    item.FreeDisplay?.let {
                                                        saveISCallSendDisplayMessage(
                                                            it
                                                        )
                                                    }
                                                    delay(75)
                                                }
                                            }
                                        }
                                        val showBlinkIndex = getShowBlinkIndexPreference()
                                        saveShowBlinkIndexPreference(showBlinkIndex)
                                        delay(DELAY_LESS_THEN_ONE_SECOND)
                                        timerDisplay()
                                    }
                                    is Resource.Error -> {
                                        //showing toast
                                        withContext(Dispatchers.Main) {
                                            showToastInfo()
                                        }
                                        Log.d("TAG", "timerDisplay: called 12")
                                        delay(DELAY_LESS_THEN_ONE_SECOND)
                                        timerDisplay()
                                    }
                                }
                            } catch (t: Throwable) {
                                //showing toast
                                withContext(Dispatchers.Main) {
                                    showToastInfo()
                                }
                                Log.d("TAG", "timerDisplay:3 called 12")
                                delay(DELAY_LESS_THEN_ONE_SECOND)
                                timerDisplay()
                            }
                        } else {
                            try {
                                var LastCalledPanelID = preferenceDisplayMessage.LastCalledPanelID
                                if (LastCalledPanelID.isNullOrEmpty()) {
                                    LastCalledPanelID = ""
                                }
                                var LastCalledSummarizeMsg =
                                    preferenceDisplayMessage.LastCalledSummarizeMsg
                                if (LastCalledSummarizeMsg.isNullOrEmpty()) {
                                    LastCalledSummarizeMsg = ""
                                }
                                var LastCalledBookedNo = preferenceDisplayMessage.LastCalledBookedNo
                                if (LastCalledBookedNo.isNullOrEmpty()) {
                                    LastCalledBookedNo = ""
                                }

                                var Secondlastcalled = preferenceDisplayMessage.Secondlastcalled
                                if (Secondlastcalled.isNullOrEmpty()) {
                                    Secondlastcalled = ""
                                }

                                var thirdlastcalled = preferenceDisplayMessage.Thirdlastcalled
                                if (thirdlastcalled.isNullOrEmpty()) {
                                    thirdlastcalled = ""
                                }
                                //33  //33
                                val response = qRepository.getSendTimerDisplay(
                                    getShowBlinkIndexPreference(),
                                    LastCalledPanelID,
                                    LastCalledBookedNo,
                                    dispenserSetting.SysConfig_SummarizeID1.toString(),
                                    dispenserSetting.SysConfig_SummarizeID2.toString(),
                                    LastCalledSummarizeMsg,
                                    Secondlastcalled,
                                    thirdlastcalled
                                )

                                when (val resultResponse =
                                    handleGetCounterStatusResponse(response)) {
                                    is Resource.Success -> {
                                        val list = resultResponse.data
                                        //showing toast
                                        withContext(Dispatchers.Main) {
                                            showToastInfo()
                                        }
                                        if (!list.isNullOrEmpty()) {
                                            sendPackets(list, dispenserSetting,"timerDisplay")

                                        }

                                        withContext(Dispatchers.IO) {
                                            if (!list.isNullOrEmpty()) {
                                                for (item in list) {
                                                    item.EnableSecondtimer?.let {
                                                        saveIsCallTIMERDISPLAY(
                                                            it
                                                        )
                                                    }
                                                    item.FreeDisplay?.let {
                                                        saveISCallSendDisplayMessage(
                                                            it
                                                        )
                                                    }
                                                    delay(75)
                                                }
                                            }
                                        }

                                        val showBlinkIndex = getShowBlinkIndexPreference()
                                        saveShowBlinkIndexPreference(showBlinkIndex)
                                        delay(DELAY_LESS_THEN_ONE_SECOND)
                                        timerDisplay()
                                    }
                                    is Resource.Error -> {
                                        //showing toast
                                        withContext(Dispatchers.Main) {
                                            showToastInfo()
                                        }
                                        delay(DELAY_LESS_THEN_ONE_SECOND)
                                        timerDisplay()
                                    }
                                }
                            } catch (t: Throwable) {
                                //showing toast
                                withContext(Dispatchers.Main) {
                                    showToastInfo()
                                }
                                delay(DELAY_LESS_THEN_ONE_SECOND)
                                timerDisplay()
                            }
                        }
                    }
                } else {
                    viewModelScope.launch {
                        withContext(Dispatchers.Main) {
                            showToastInfo()
                        }
                        delay(DELAY_LESS_THEN_ONE_SECOND)
                        timerDisplay()
                    }
                }


            } else {
                viewModelScope.launch {
                    withContext(Dispatchers.Main) {
                        showToastInfo()
                    }
                    delay(DELAY_LESS_THEN_ONE_SECOND)
                    timerDisplay()
                }
            }
        } else {
            viewModelScope.launch {
                delay(DELAY_LESS_THEN_ONE_SECOND)
                timerDisplay()
            }
        }
    }

    fun sendDisplayMessage() {

        val branchID = getPreference()
        if (branchID != BRANCH_DEFAULT_VALUE) {

            val dispenserSetting = getDispenserConfigurationPreference()
            val isCallSendDisplayMessage = getISCallSendDisplayMessage()
            if (dispenserSetting != null) {
                if (isCallSendDisplayMessage) {
                    viewModelScope.launch {
                        if (getServerPreference()) {
                            try {

                                //https://gickuwait-dev.com/qtouch_api/api/SendDisplayMessage?branchid=1&SumerizeScreen1=33&SumerizeScreen2=33&voiceControllerID=43472&StrSound=en|ding3&strVolume=FF
                                val response = qRepository.getSendDisplayMessageLocal(
                                    branchID,
                                    dispenserSetting.SysConfig_SummarizeID1.toString(),
                                    dispenserSetting.SysConfig_SummarizeID2.toString(),
                                    dispenserSetting.SysConfig_VoiceControllerIP.toString(),
                                    dispenserSetting.SysConfig_SpeakerSound.toString(),
                                    dispenserSetting.SysConfig_SpeakerVolume.toString(),
                                    isCallSendDisplayMessage
                                )

                                when (val resultResponse =
                                    handleGetCounterStatusResponse(response)) {
                                    is Resource.Success -> {

                                        val list = resultResponse.data

                                        //showing toast
                                        withContext(Dispatchers.Main) {
                                            showToastInfo()
                                        }
                                        if (!list.isNullOrEmpty()) {
                                            sendPackets(list, dispenserSetting,"sendDisplayMessage")

                                        }
                                        withContext(Dispatchers.IO) {
                                            if (!list.isNullOrEmpty()) {
                                                for (item in list) {
                                                    val isCallTimeDisplay = item.EnableSecondtimer
                                                    isCallTimeDisplay?.let {
                                                        saveIsCallTIMERDISPLAY(
                                                            it
                                                        )
                                                    }
                                                    val preferenceDisplayMessage =
                                                        PreferenceDisplayMessage(
                                                            FreeDisplay = item.FreeDisplay,
                                                            EnableSecondtimer = item.EnableSecondtimer,
                                                            showblinkindex = item.showblinkindex,
                                                            LastCalledPanelID = item.LastCalledPanelID,
                                                            LastCalledBookedNo = item.LastCalledBookedNo,
                                                            LastCalledSummarizeMsg = item.LastCalledSummarizeMsg,
                                                            Secondlastcalled = item.Secondlastcalled,
                                                            Thirdlastcalled = item.Thirdlastcalled
                                                        )
                                                    savePreferenceDisplayMessage(
                                                        preferenceDisplayMessage
                                                    )
                                                    delay(100)
                                                }
                                            }
                                        }

                                        delay(DELAY_ONE_SECOND)
                                        sendDisplayMessage()
                                    }
                                    is Resource.Error -> {
                                        //showing toast
                                        withContext(Dispatchers.Main) {
                                            showToastInfo()
                                        }
                                        delay(DELAY_ONE_SECOND)
                                        sendDisplayMessage()
                                    }
                                }
                            } catch (t: Throwable) {
                                //showing toast
                                withContext(Dispatchers.Main) {
                                    showToastInfo()
                                }
                                delay(DELAY_ONE_SECOND)
                                sendDisplayMessage()
                            }
                        } else {
                            try {
                                //                                val response = qRepository.getSendDisplayMessage(branchID,33,33,43472,"en|ding3","01",isCallSendDisplayMessage)
                                val response = qRepository.getSendDisplayMessage(
                                    branchID,
                                    dispenserSetting.SysConfig_SummarizeID1.toString(),
                                    dispenserSetting.SysConfig_SummarizeID2.toString(),
                                    dispenserSetting.SysConfig_VoiceControllerIP.toString(),
                                    dispenserSetting.SysConfig_SpeakerSound.toString(),
                                    dispenserSetting.SysConfig_SpeakerVolume.toString(),
                                    isCallSendDisplayMessage
                                )

                                when (val resultResponse =
                                    handleGetCounterStatusResponse(response)) {
                                    is Resource.Success -> {
                                        val list = resultResponse.data

                                        //showing toast
                                        withContext(Dispatchers.Main) {
                                            showToastInfo()
                                        }
                                        if (!list.isNullOrEmpty()) {
                                            sendPackets(list, dispenserSetting,"sendDisplayMessage")

                                        }
                                        withContext(Dispatchers.IO) {
                                            if (!list.isNullOrEmpty()) {
                                                for (item in list) {
                                                    val isCallTimeDisplay = item.EnableSecondtimer
                                                    isCallTimeDisplay?.let {
                                                        saveIsCallTIMERDISPLAY(
                                                            it
                                                        )
                                                    }
                                                    val preferenceDisplayMessage =
                                                        PreferenceDisplayMessage(
                                                            FreeDisplay = item.FreeDisplay,
                                                            EnableSecondtimer = item.EnableSecondtimer,
                                                            showblinkindex = item.showblinkindex,
                                                            LastCalledPanelID = item.LastCalledPanelID,
                                                            LastCalledBookedNo = item.LastCalledBookedNo,
                                                            LastCalledSummarizeMsg = item.LastCalledSummarizeMsg,
                                                            Secondlastcalled = item.Secondlastcalled,
                                                            Thirdlastcalled = item.Thirdlastcalled
                                                        )
                                                    savePreferenceDisplayMessage(
                                                        preferenceDisplayMessage
                                                    )
                                                    delay(100)
                                                }
                                            }
                                        }

                                        delay(DELAY_ONE_SECOND)
                                        sendDisplayMessage()
                                    }
                                    is Resource.Error -> {
                                        //showing toast
                                        withContext(Dispatchers.Main) {
                                            showToastInfo()
                                        }
                                        delay(DELAY_ONE_SECOND)
                                        sendDisplayMessage()
                                    }
                                }
                            } catch (t: Throwable) {
                                //showing toast
                                withContext(Dispatchers.Main) {
                                    showToastInfo()
                                }
                                delay(DELAY_ONE_SECOND)
                                sendDisplayMessage()
                            }
                        }
                    }
                } else {
                    viewModelScope.launch {
                        withContext(Dispatchers.Main) {
                            showToastInfo()
                        }
                        delay(DELAY_ONE_SECOND)
                        sendDisplayMessage()
                    }
                }


            } else {
                viewModelScope.launch {
                    withContext(Dispatchers.Main) {
                        showToastInfo()
                    }
                    delay(DELAY_ONE_SECOND)
                    sendDisplayMessage()
                }
            }
        } else {
            viewModelScope.launch {
                delay(DELAY_ONE_SECOND)
                sendDisplayMessage()
            }
        }
    }

    fun getCounter() {

        val branchID = getPreference()
        if (branchID != BRANCH_DEFAULT_VALUE) {

            val dispenserSetting = getDispenserConfigurationPreference()
            if (dispenserSetting != null) {

                viewModelScope.launch {
                    if (getServerPreference()) {
                        try {
                            val response = qRepository.getDisplayCounterStatusLocal(
                                branchID,
                                dispenserSetting.SysConfig_CounterMsg.toString()
                            )

                            when (val resultResponse = handleGetCounterStatusResponse(response)) {
                                is Resource.Success -> {
                                    val list = resultResponse.data

                                    //showing toast
                                    withContext(Dispatchers.Main) {
                                        showToastInfo()
                                    }
                                    if (!list.isNullOrEmpty()) {
                                        sendPackets(list, dispenserSetting,"getCounter")
                                    }
                                    delay(DELAY_ONE_MINUTE)
                                    getCounter()
                                }
                                is Resource.Error -> {
                                    //showing toast
                                    withContext(Dispatchers.Main) {
                                        showToastInfo()
                                    }
                                    delay(DELAY_CHECK_BRANCH)
                                    getCounter()
                                }
                            }
                        } catch (t: Throwable) {
                            //showing toast
                            withContext(Dispatchers.Main) {
                                showToastInfo()
                            }
                            delay(DELAY_CHECK_BRANCH)
                            getCounter()
                        }
                    } else {
                        try {
                            val response = qRepository.getDisplayCounterStatus(
                                branchID,
                                dispenserSetting.SysConfig_CounterMsg.toString()
                            )

                            when (val resultResponse = handleGetCounterStatusResponse(response)) {
                                is Resource.Success -> {
                                    val list = resultResponse.data

                                    //showing toast
                                    withContext(Dispatchers.Main) {
                                        showToastInfo()
                                    }
                                    if (!list.isNullOrEmpty()) {
                                        sendPackets(list, dispenserSetting,"getCounter")
                                    }
                                    delay(DELAY_ONE_MINUTE)
                                    getCounter()
                                }
                                is Resource.Error -> {
                                    //showing toast
                                    withContext(Dispatchers.Main) {
                                        showToastInfo()
                                    }
                                    delay(DELAY_CHECK_BRANCH)
                                    getCounter()
                                }
                            }
                        } catch (t: Throwable) {
                            //showing toast
                            withContext(Dispatchers.Main) {
                                showToastInfo()
                            }
                            delay(DELAY_CHECK_BRANCH)
                            getCounter()
                        }
                    }
                }

            } else {
                viewModelScope.launch {
                    //showing toast
                    withContext(Dispatchers.Main) {
                        showToastInfo()
                    }
                    delay(DELAY_CHECK_BRANCH)
                    getCounter()
                }
            }
        } else {
            viewModelScope.launch {
                //showing toast
                withContext(Dispatchers.Main) {
                    showToastInfo()
                }
                delay(DELAY_CHECK_BRANCH)
                getCounter()
            }
        }
    }

    fun setDispenserSettings() {
        Log.d("TAG", "setDispenserSettings: set ")
        val branchID = getPreference()
        if (branchID != BRANCH_DEFAULT_VALUE) {
            viewModelScope.launch {
                if (getServerPreference()) {
                    try {
                        val response = qRepository.getDispenserGetSettingsLocal(branchID)
                        when (val resultResponse = handleGetDispenserSettingResponse(response)) {
                            is Resource.Success -> {
                                Log.d("TAG", "okhttpsetDispenserSettings: called 1")
                                val list = resultResponse.data

                                //showing toast
                                withContext(Dispatchers.Main) {
                                    showToastInfo()
                                }
                                if (!list.isNullOrEmpty()) {
                                    val dispenserSettings = list[0]
                                    saveDispenserSettingsPreference(dispenserSettings)
                                    delay(DELAY_UPDATE_APP)
                                    setDispenserSettings()
                                }
                            }
                            is Resource.Error -> {
                                //showing toast
                                withContext(Dispatchers.Main) {
                                    showToastInfo()
                                }
                                Log.d("TAG", "okhttpsetDispenserSettings: called 2")
                                delay(DELAY_CHECK_BRANCH)
                                setDispenserSettings()
                            }
                        }
                    } catch (t: Throwable) {
                        //showing toast
                        withContext(Dispatchers.Main) {
                            showToastInfo()
                        }
                        Log.d("TAG", "okhttpsetDispenserSettings: called 3")
                        delay(DELAY_CHECK_BRANCH)
                        setDispenserSettings()
                    }
                } else {
                    try {
                        val response = qRepository.getDispenserGetSettings(branchID)

                        when (val resultResponse = handleGetDispenserSettingResponse(response)) {
                            is Resource.Success -> {
                                val list = resultResponse.data

                                //showing toast
                                withContext(Dispatchers.Main) {
                                    showToastInfo()
                                }
                                if (!list.isNullOrEmpty()) {
                                    Log.d("TAG", "okhttpsetDispenserSettings: called 4")
                                    val dispenserSettings = list[0]
                                    saveDispenserSettingsPreference(dispenserSettings)
                                    delay(DELAY_UPDATE_APP)
                                    setDispenserSettings()
                                }
                            }

                            is Resource.Error -> {

                                //showing toast
                                withContext(Dispatchers.Main) {
                                    showToastInfo()
                                }
                                Log.d("TAG", "okhttpsetDispenserSettings: called 5")
                                delay(DELAY_CHECK_BRANCH)
                                setDispenserSettings()
                            }
                        }
                    } catch (t: Throwable) {
                        //showing toast
                        withContext(Dispatchers.Main) {
                            showToastInfo()
                        }
                        Log.d("TAG", "okhttpsetDispenserSettings: called 6")
                        delay(DELAY_CHECK_BRANCH)
                        setDispenserSettings()
                    }
                }
            }
        } else {

            viewModelScope.launch {
                //showing toast
                withContext(Dispatchers.Main) {
                    showToastInfo()
                }
                delay(DELAY_CHECK_BRANCH)
                setDispenserSettings()
            }

        }
    }

    private fun handleGetCounterStatusResponse(response: Response<List<CounterStatus>>): Resource<List<CounterStatus>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->

                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleGetDispenserSettingResponse(response: Response<List<DispenserSettings>>): Resource<List<DispenserSettings>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->

                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    /*   fun settingHexValue( displayID: String,  strData: String,  StartPix: String): ByteArray{
           var MsgAdd: String
           var MsgCmd: String
           var MsgPar1: String
           var MsgPar2: String
           var MsgCRC8: String
           var MsgData: ByteArray
           var strMsgData: String
           var MsgLen: Int

           var strDisplayID: String = displayID.decodeHex().hex()
           while (strDisplayID.length < 4) {
               strDisplayID = "0$strDisplayID"
           }
           MsgAdd = strDisplayID.toString()
           MsgCmd = "T".decodeHex().hex()
           MsgPar1 = "0A"
           MsgPar2 = "0$StartPix"
           MsgData = strData.toByteArray(Charset.forName("ASCII"))
           strMsgData = ""
           for (i in 1..MsgData.size -1) {
               strMsgData += (" " + MsgData[i].toString().decodeHex().hex())
           }

           MsgLen = (((MsgAdd.length
                   + (MsgCmd.length
                   + (MsgPar1.length
                   + (MsgPar2.length
                   + (MsgData.size * 2)))))
                   / 2)
                   + 1)
           strMsgData = strMsgData.trimStart();
          var StrMsgToSend = strMsgData.split(" ");


           strMsgData = (" " + (MsgLen.toHexString() + (" "+ (MsgAdd.substring(0, 2) + (" "
                   + (MsgAdd.substring(2, 2) + (" "
                   + (MsgCmd + (" "
                   + (MsgPar1 + (" "
                   + (MsgPar2 + strMsgData))))))))))));

           var x: ByteArray = ByteArray(MsgLen -1)
           for(i in 1 until MsgLen){
               x[i] = (("&H" + StrMsgToSend[i]).toByte())
           }

           MsgCRC8 = x.toString().decodeHex().hex()
           strMsgData = (strMsgData + (" " + MsgCRC8));
           StrMsgToSend = strMsgData.split(" ");

           var ret: ByteArray = ByteArray(StrMsgToSend.size)
           var ms: ByteArrayOutputStream  =  ByteArrayOutputStream(StrMsgToSend.size)



           for(input in 1..StrMsgToSend.size -1){
               ms.write(StrMsgToSend[input].toByte().toInt())
           }
           ms.close()


          return ms.toByteArray()


       }*/

    fun sendPackets(list: List<CounterStatus?>, dispenserSetting: DispenserSettings,message:String) {


          CoroutineScope(Dispatchers.IO).launch {
        // Get the address that we are going to connect to.
        //192.168.0.117
        //  dispenserSetting.SysConfig_SwitchIP
        val addr = InetAddress.getByName(dispenserSetting.SysConfig_SwitchIP)

        try {
            // dispenserSetting.SysConfig_Port!!.toInt()
            val port = dispenserSetting.SysConfig_Port?.toInt()
            //   var i = 0
            try {
                DatagramSocket().use { serverSocket ->
                    //   CoroutineScope(Dispatchers.IO).launch {
                    for (counterStatus in list) {
                        Log.d("TAG", "sendPackets: called from $message ${counterStatus?.dataInt} ")

                        if (!counterStatus?.dataInt.isNullOrEmpty()) {
                            val byteArrayTest = ByteArray(counterStatus?.dataInt!!.size)
                            var i = 0
                            val tempList = counterStatus.dataInt
                            if (tempList != null) {
                                for (item in tempList) {
                                    byteArrayTest[i] = item.toByte()
                                    Log.d("TAG", "sendPackets: the byte ${item.toByte()} / $item")
                                    i++
                                }
                                val msgPacket = port?.let {
                                    DatagramPacket(
                                        byteArrayTest,
                                        byteArrayTest.size, addr, it
                                    )
                                }
                                serverSocket.send(msgPacket)
                                println(
                                    "Server sent packet with msg: $byteArrayTest ${
                                        counterStatus.packetData.toString().toByteArray()
                                    }"
                                )
                                // Thread.sleep(500)
                                    delay(500)


                            }

                        }
                        /* //val byteArray: ByteArray = Base64.getDecoder().decode(counterStatus?.packetData.toString())
                         var byteArrayTest: ByteArray  = ByteArray(23)
                         var i =0

                         for(single in counterStatus!!.dataInt!!.size){
                             Log.d("TAG", "sendPackets: bytes ${singleByte} ")

                         }
                         byteArrayTest[0] = 21
                         byteArrayTest[1] = 133.toByte()
                         byteArrayTest[2] = 165.toByte()
                         byteArrayTest[3] = 84
                         byteArrayTest[4] = 10
                         byteArrayTest[5] = 0
                         byteArrayTest[6] = 87
                         byteArrayTest[7] = 101
                         byteArrayTest[8] = 108
                         byteArrayTest[9] = 99
                         byteArrayTest[10] = 111
                         byteArrayTest[11] = 109
                         byteArrayTest[12] = 101
                         byteArrayTest[13] = 32
                         byteArrayTest[14] = 84
                         byteArrayTest[15] = 111
                         byteArrayTest[16] = 32
                         byteArrayTest[17] = 90
                         byteArrayTest[18] = 97
                         byteArrayTest[19] = 105
                         byteArrayTest[20] = 110
                         byteArrayTest[21] = 183.toByte()
                         byteArrayTest[22] = 0
                         //counterStatus?.packetData.toString().toByteArray()
                      //   var byteArraySecondTest = settingHexValue(counterStatus?.Counter_ScreenID!!,"wwww","dd")
                         val msgPacket = DatagramPacket(
                             byteArrayTest,
                             byteArrayTest.size, addr,port
                         )
                         serverSocket.send(msgPacket)
                         println("Server sent packet with msg: ${byteArrayTest} ${ counterStatus?.packetData.toString().toByteArray()}")
                         Thread.sleep(500)*/
                    }
                //    }


                }
            } catch (ex: java.lang.Exception) {
                ex.printStackTrace()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }


        }

    }


    //*********************************************** getMethod *********************************************************
    /*  object RepeatHelper {
          fun repeatDelayed(delay: Long, todo: () -> Unit) {
              val handler = Handler()
              handler.postDelayed(object : Runnable {
                  override fun run() {
                      todo()
                      handler.postDelayed(this, delay)
                  }
              }, delay)
          }
      }*/
    /* fun sendLog(branchID: Int, errorMsg: String) = viewModelScope.launch {
         Log.d("TAG", "sendLog: sending log ")
        // safeSendLog(branchID, errorMsg)
     }*/


    //*********************************************** safeMethod *********************************************************
    /*   private suspend fun safeSendLog(branchID: Int, errorMsg: String) {
           getSendLog.postValue(Resource.Loading())
           //   try {
           if (getServerPreference()) {
               try {
                   val response = qRepository.sendLogLocal(branchID, errorMsg)
                   getSendLog.postValue(handleGetLogResponse(response))
               } catch (t: Throwable) {
                   when (t) {
                       is Exception -> getSendLog.postValue(Resource.Error(Resources.getSystem().getString(R.string.server_error_admin)))
                       else -> getSendLog.postValue(Resource.Error(Resources.getSystem().getString(R.string.server_error_admin)))
                   }
               }
           } else {
               if (hasInternetConnection()) {
                   try {
                       val response = qRepository.sendLog(branchID, errorMsg)
                       getSendLog.postValue(handleGetLogResponse(response))
                   } catch (t: Throwable) {
                       when (t) {
                           is Exception -> getSendLog.postValue(Resource.Error(Resources.getSystem().getString(R.string.server_error_admin)))
                           else -> getSendLog.postValue(Resource.Error(Resources.getSystem().getString(R.string.server_error_admin)))
                       }
                   }
               } else {
                   getSendLog.postValue(Resource.Error(Resources.getSystem().getString(R.string.internet_error_admin)))
               }
           }
           *//*  // if (hasInternetConnection()) {
               val response = qRepository.getBookTicket(mobileNumber, serviceID, IsHandicap, isVip, languageID, AppointmentCode, branchId, QbranchID)
               getBookTicket.postValue(handleGetBookTicketResponse(response))
         *//**//*  } else {
                getBookTicket.postValue(Resource.Error(mContext.getString(R.string.internet_error_admin)))
            }*//*
        *//*    } catch (t: Throwable) {
                when (t) {
                    is Exception -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                    else -> getBookTicket.postValue(Resource.Error(mContext.getString(R.string.server_error_admin)))
                }
            }*//*
    }
*/
    //*********************************************** handle response *********************************************************
    /*   private fun handleGetLogResponse(response: Response<List<LogReturn>>): Resource<List<LogReturn>> {
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
   */
    //***********************************************  Preference    *************
    private fun saveDispenserSettingsPreference(dispenserSetting: DispenserSettings) {
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private

        val editor = pref.edit()
        val gson = Gson()
        val json = gson.toJson(dispenserSetting)
        editor.putString(PACKET_CONFIG_AUTH, json)
        editor.apply()

    }

    fun savePreferenceDisplayMessage(preferenceDisplayMessage: PreferenceDisplayMessage?) {
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private

        val editor = pref.edit()
        val gson = Gson()
        if (preferenceDisplayMessage != null) {
            val json = gson.toJson(preferenceDisplayMessage)
            editor.putString(PREFERENCE_DISPLAY_MESSAGE_AUTH, json)
            editor.apply()
        } else {
            val json = ""
            editor.putString(PREFERENCE_DISPLAY_MESSAGE_AUTH, json)
            editor.apply()
        }


    }


    private fun getPreferenceDisplayMessage(): PreferenceDisplayMessage? {
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0

        val gson = Gson()
        val json: String? = pref.getString(PREFERENCE_DISPLAY_MESSAGE_AUTH, "")

        if (json.isNullOrEmpty()) {
            return null
        } else {
            return gson.fromJson(json, PreferenceDisplayMessage::class.java)
        }
    }

    private fun getDispenserConfigurationPreference(): DispenserSettings? {
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0

        val gson = Gson()
        val json: String? = pref.getString(PACKET_CONFIG_AUTH, "")

        if (json.isNullOrEmpty()) {
            return null
        } else {
            return gson.fromJson(json, DispenserSettings::class.java)
        }
    }

    fun saveShowBlinkIndexPreference(showBlinkIndex: Int) {
        var value = showBlinkIndex + 1
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private

        val editor = pref.edit()
        if (value == 6) {
            value = 0
        }
        editor.putInt(SHOW_BLINK_INDEX_AUTH, value)
        editor.apply()

    }

    private fun getShowBlinkIndexPreference(): Int {
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private mode

        return pref.getInt(SHOW_BLINK_INDEX_AUTH, 0)

    }

    private fun getPreference(): Int {

        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private mode

        return pref.getInt(Constants.BRANCH_AUTH_ID, BRANCH_DEFAULT_VALUE)

    }

    fun saveISCallSendDisplayMessage(isCallSendMessage: Boolean) {
        Log.d("TAG", "saveISCallSendDisplayMessage: calling ")
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private

        val editor = pref.edit()
        editor.putBoolean(IS_CALL_SENDDISPLAYMESSAGE, isCallSendMessage)
        editor.apply()

    }

    fun saveIsCallTIMERDISPLAY(isCallTIMERDISPLAY: Boolean) {
        Log.d("TAG", "saveIsCallTIMERDISPLAY: ")
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private

        val editor = pref.edit()
        editor.putBoolean(IS_CALL_TIMERDISPLAY, isCallTIMERDISPLAY)
        editor.apply()

    }

    private fun getISCallSendDisplayMessage(): Boolean {
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private mode

        return pref.getBoolean(IS_CALL_SENDDISPLAYMESSAGE, true)

    }

    private fun getIsCallTIMERDISPLAY(): Boolean {
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private mode

        return pref.getBoolean(IS_CALL_TIMERDISPLAY, false)

    }

    //*********************************************** Internet connection check *********************************************************
    private fun getServerPreference(): Boolean {
        val pref = getApplication<Application>().getSharedPreferences(
            Constants.SERVER_AUTH,
            0
        ) // 0 - for private mode

        return pref.getBoolean(Constants.LOCAL_DATABASE, false)

    }


/*
    private fun hasInternetConnection(): Boolean {
        return true
        */
/*      val connectivityManager = getApplication<QappApplication>().getSystemService(
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
              return false*//*

    }
*/

    private fun showToastInfo() {
        /* FancyToast.makeText(
             mContext, message, FancyToast.LENGTH_SHORT,
             FancyToast.INFO, false
         ).show()*/
    }
}