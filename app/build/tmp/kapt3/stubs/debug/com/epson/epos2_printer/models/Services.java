package com.epson.epos2_printer.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bQ\b\u0086\b\u0018\u00002\u00020\u0001B\u00b9\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0017J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010P\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010 J\u0010\u0010T\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010U\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u00e6\u0001\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u000b2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Z\u001a\u00020\u0006H\u00d6\u0001J\t\u0010[\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010\'R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010\'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010\'R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010\'R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010\'R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010%\"\u0004\b3\u0010\'R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010%\"\u0004\b5\u0010\'R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010%\"\u0004\b7\u0010\'R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010\'R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010%\"\u0004\b;\u0010\'R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b<\u0010\u0019\"\u0004\b=\u0010\u001bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010%\"\u0004\bC\u0010\'\u00a8\u0006\\"}, d2 = {"Lcom/epson/epos2_printer/models/Services;", "", "Services_Name_EN", "", "Services_Name_AR", "Services_PK_ID", "", "Services_TicketDesigner_FK_ID", "Services_Description", "Services_Color", "Services_AllowSMS", "", "BranchServices_Service_FK_ID", "BranchServices_Branch_FK_ID", "Services_Parent_ID", "Services_Logo", "Services_Description_Ar", "Services_BackGroundImage", "Services_FontName", "Services_FontSize", "Services_FontStyle", "Services_FontColor", "TicketDesigner_FileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBranchServices_Branch_FK_ID", "()Ljava/lang/Integer;", "setBranchServices_Branch_FK_ID", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBranchServices_Service_FK_ID", "setBranchServices_Service_FK_ID", "getServices_AllowSMS", "()Ljava/lang/Boolean;", "setServices_AllowSMS", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getServices_BackGroundImage", "()Ljava/lang/String;", "setServices_BackGroundImage", "(Ljava/lang/String;)V", "getServices_Color", "setServices_Color", "getServices_Description", "setServices_Description", "getServices_Description_Ar", "setServices_Description_Ar", "getServices_FontColor", "setServices_FontColor", "getServices_FontName", "setServices_FontName", "getServices_FontSize", "setServices_FontSize", "getServices_FontStyle", "setServices_FontStyle", "getServices_Logo", "setServices_Logo", "getServices_Name_AR", "setServices_Name_AR", "getServices_Name_EN", "setServices_Name_EN", "getServices_PK_ID", "setServices_PK_ID", "getServices_Parent_ID", "setServices_Parent_ID", "getServices_TicketDesigner_FK_ID", "setServices_TicketDesigner_FK_ID", "getTicketDesigner_FileName", "setTicketDesigner_FileName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/epson/epos2_printer/models/Services;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Services {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_Name_EN;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_Name_AR;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer Services_PK_ID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer Services_TicketDesigner_FK_ID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_Description;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_Color;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean Services_AllowSMS;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer BranchServices_Service_FK_ID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer BranchServices_Branch_FK_ID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer Services_Parent_ID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_Logo;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_Description_Ar;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_BackGroundImage;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_FontName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_FontSize;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_FontStyle;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String Services_FontColor;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String TicketDesigner_FileName;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_Name_EN() {
        return null;
    }
    
    public final void setServices_Name_EN(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_Name_AR() {
        return null;
    }
    
    public final void setServices_Name_AR(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getServices_PK_ID() {
        return null;
    }
    
    public final void setServices_PK_ID(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getServices_TicketDesigner_FK_ID() {
        return null;
    }
    
    public final void setServices_TicketDesigner_FK_ID(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_Description() {
        return null;
    }
    
    public final void setServices_Description(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_Color() {
        return null;
    }
    
    public final void setServices_Color(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getServices_AllowSMS() {
        return null;
    }
    
    public final void setServices_AllowSMS(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBranchServices_Service_FK_ID() {
        return null;
    }
    
    public final void setBranchServices_Service_FK_ID(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBranchServices_Branch_FK_ID() {
        return null;
    }
    
    public final void setBranchServices_Branch_FK_ID(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getServices_Parent_ID() {
        return null;
    }
    
    public final void setServices_Parent_ID(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_Logo() {
        return null;
    }
    
    public final void setServices_Logo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_Description_Ar() {
        return null;
    }
    
    public final void setServices_Description_Ar(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_BackGroundImage() {
        return null;
    }
    
    public final void setServices_BackGroundImage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_FontName() {
        return null;
    }
    
    public final void setServices_FontName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_FontSize() {
        return null;
    }
    
    public final void setServices_FontSize(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_FontStyle() {
        return null;
    }
    
    public final void setServices_FontStyle(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getServices_FontColor() {
        return null;
    }
    
    public final void setServices_FontColor(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTicketDesigner_FileName() {
        return null;
    }
    
    public final void setTicketDesigner_FileName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public Services(@org.jetbrains.annotations.Nullable()
    java.lang.String Services_Name_EN, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Name_AR, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Services_PK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Services_TicketDesigner_FK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Description, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Color, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean Services_AllowSMS, @org.jetbrains.annotations.Nullable()
    java.lang.Integer BranchServices_Service_FK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.Integer BranchServices_Branch_FK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Services_Parent_ID, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Logo, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Description_Ar, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_BackGroundImage, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_FontName, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_FontSize, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_FontStyle, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_FontColor, @org.jetbrains.annotations.Nullable()
    java.lang.String TicketDesigner_FileName) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.epson.epos2_printer.models.Services copy(@org.jetbrains.annotations.Nullable()
    java.lang.String Services_Name_EN, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Name_AR, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Services_PK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Services_TicketDesigner_FK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Description, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Color, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean Services_AllowSMS, @org.jetbrains.annotations.Nullable()
    java.lang.Integer BranchServices_Service_FK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.Integer BranchServices_Branch_FK_ID, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Services_Parent_ID, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Logo, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_Description_Ar, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_BackGroundImage, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_FontName, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_FontSize, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_FontStyle, @org.jetbrains.annotations.Nullable()
    java.lang.String Services_FontColor, @org.jetbrains.annotations.Nullable()
    java.lang.String TicketDesigner_FileName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}