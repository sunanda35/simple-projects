package com.weatherapp.user.common.utils;

public enum Topic {

	User("User", 101),
	Password("Password",103),
	WishList("WishList", 104);

	
	private final String name;

	private final int code;

	private Topic(String name, int code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}


}
