package com.epson.epos2_printer.models


data class PreferenceDisplayMessage(
        var FreeDisplay: Boolean?,
        var EnableSecondtimer: Boolean?,
        var showblinkindex: Int?,
        var LastCalledPanelID: String?,
        var LastCalledBookedNo: String?,
        var LastCalledSummarizeMsg: String?,
        var Secondlastcalled: String?,
        var Thirdlastcalled: String?
)

