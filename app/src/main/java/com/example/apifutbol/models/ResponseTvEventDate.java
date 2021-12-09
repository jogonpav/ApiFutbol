package com.example.apifutbol.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseTvEventDate{

	@SerializedName("tvevents")
	private List<TveventsItem> tvevents;

	public void setTvevents(List<TveventsItem> tvevents){
		this.tvevents = tvevents;
	}

	public List<TveventsItem> getTvevents(){
		return tvevents;
	}

	@Override
 	public String toString(){
		return 
			"ResponseTvEventDate{" + 
			"tvevents = '" + tvevents + '\'' + 
			"}";
		}
}