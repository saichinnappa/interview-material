package com.practice.java.features.designpatterns.structural.proxy;

public interface TwitterService {
	public String getTimeline(String screenName);
	public void postToTimeline(String screenName, String message);
}
