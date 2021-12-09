package com.example.apifutbol.models;

import com.google.gson.annotations.SerializedName;

public class TveventsItem{

	@SerializedName("dateEvent")
	private String dateEvent;

	@SerializedName("idChannel")
	private String idChannel;

	@SerializedName("strCountry")
	private String strCountry;

	@SerializedName("strTime")
	private String strTime;

	@SerializedName("strLogo")
	private String strLogo;

	@SerializedName("strChannel")
	private String strChannel;

	@SerializedName("idEvent")
	private String idEvent;

	@SerializedName("id")
	private String id;

	@SerializedName("strSport")
	private String strSport;

	@SerializedName("strEvent")
	private String strEvent;

	@SerializedName("strTimeStamp")
	private String strTimeStamp;

	@SerializedName("strSeason")
	private String strSeason;

	public void setDateEvent(String dateEvent){
		this.dateEvent = dateEvent;
	}

	public String getDateEvent(){
		return dateEvent;
	}

	public void setIdChannel(String idChannel){
		this.idChannel = idChannel;
	}

	public String getIdChannel(){
		return idChannel;
	}

	public void setStrCountry(String strCountry){
		this.strCountry = strCountry;
	}

	public String getStrCountry(){
		return strCountry;
	}

	public void setStrTime(String strTime){
		this.strTime = strTime;
	}

	public String getStrTime(){
		return strTime;
	}

	public void setStrLogo(String strLogo){
		this.strLogo = strLogo;
	}

	public String getStrLogo(){
		return strLogo;
	}

	public void setStrChannel(String strChannel){
		this.strChannel = strChannel;
	}

	public String getStrChannel(){
		return strChannel;
	}

	public void setIdEvent(String idEvent){
		this.idEvent = idEvent;
	}

	public String getIdEvent(){
		return idEvent;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStrSport(String strSport){
		this.strSport = strSport;
	}

	public String getStrSport(){
		return strSport;
	}

	public void setStrEvent(String strEvent){
		this.strEvent = strEvent;
	}

	public String getStrEvent(){
		return strEvent;
	}

	public void setStrTimeStamp(String strTimeStamp){
		this.strTimeStamp = strTimeStamp;
	}

	public String getStrTimeStamp(){
		return strTimeStamp;
	}

	public void setStrSeason(String strSeason){
		this.strSeason = strSeason;
	}

	public String getStrSeason(){
		return strSeason;
	}

	@Override
 	public String toString(){
		return 
			"TveventsItem{" + 
			"dateEvent = '" + dateEvent + '\'' + 
			",idChannel = '" + idChannel + '\'' + 
			",strCountry = '" + strCountry + '\'' + 
			",strTime = '" + strTime + '\'' + 
			",strLogo = '" + strLogo + '\'' + 
			",strChannel = '" + strChannel + '\'' + 
			",idEvent = '" + idEvent + '\'' + 
			",id = '" + id + '\'' + 
			",strSport = '" + strSport + '\'' + 
			",strEvent = '" + strEvent + '\'' + 
			",strTimeStamp = '" + strTimeStamp + '\'' + 
			",strSeason = '" + strSeason + '\'' + 
			"}";
		}
}