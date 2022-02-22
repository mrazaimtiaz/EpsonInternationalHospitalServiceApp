package com.epson.epos2_printer.models


data class IsBranchOpen(
        var IsOpen: Boolean?,
        var IsOnBreak: Boolean?,
        var msgEn: String?,
        var msgAr: String?,

        var AvialableUpdate: Int?
)