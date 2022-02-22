package com.epson.epos2_printer.models


data class DispenserSettings(
        var SysConfig_LCDPCIP: String?,
        var SysConfig_LCDPCMN: String?,
        var SysConfig_SwitchIP: String?,
        var SysConfig_VoiceControllerIP: String?,
        var SysConfig_VoiceControllerMN: String?,
        var SysConfig_SpeakerVolume: String?,
        var SysConfig_Port: String?,
        var SysConfig_SpeakerSound: String?,
        var SysConfig_SummarizeID1: String?,
        var SysConfig_SummarizeID2: String?,
        var SysConfig_CounterMsg: String?
)