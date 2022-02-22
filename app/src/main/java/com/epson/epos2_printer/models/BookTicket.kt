package com.epson.epos2_printer.models


data class BookTicket(
        var NewPKID: Int?,
        var BookedNo: String?,
        var QueueSize: Int?,
        var EstimatedTime: Int?,
        var PrintTime: String?
)