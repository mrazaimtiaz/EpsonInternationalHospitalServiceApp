package com.epson.epos2_printer.models


data class Services(
        var Services_Name_EN: String?,
        var Services_Name_AR: String?,
        var Services_PK_ID: Int?,
        var Services_TicketDesigner_FK_ID: Int?,
        var Services_Description: String?,
        var Services_Color: String?,
        var Services_AllowSMS: Boolean?,
        var BranchServices_Service_FK_ID: Int?,
        var BranchServices_Branch_FK_ID: Int?,
        var Services_Parent_ID: Int?,
        var Services_Logo: String?,
        var Services_Description_Ar: String?,
        var Services_BackGroundImage: String?,
        var Services_FontName: String?,
        var Services_FontSize: String?,
        var Services_FontStyle: String?,
        var Services_FontColor: String?,
        var TicketDesigner_FileName: String?
)