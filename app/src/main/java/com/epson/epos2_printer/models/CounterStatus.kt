package com.epson.epos2_printer.models


data class CounterStatus(
        var Counter_PK_ID: Int?,
        var Counter_Name: String?,
        var Counter_ScreenID: String?,
        var packetData: String?,
        var dataInt: List<Int>?,
        var FreeDisplay: Boolean?,
        var EnableSecondtimer: Boolean?,
        var showblinkindex: Int?,
        var LastCalledPanelID: String?,
        var LastCalledBookedNo: String?,
        var LastCalledSummarizeMsg: String?,
        var Secondlastcalled: String?,
        var Thirdlastcalled: String?
)

// "FreeDisplay": true,
//    "EnableSecondtimer": true,
//    "showblinkindex": 0,
//    "LastCalledPanelID": "34213",
//    "LastCalledBookedNo": "S09",
//    "LastCalledSummarizeMsg": "S09->01",
//    "Secondlastcalled": "096->01",
//    "Thirdlastcalled": "095->01"