package com.isabel.telefonos.clases;

import com.isabel.telefonos.interfaces.Ringable;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	public String ring() {
		return String.format("Galaxy %s says %s", getVersionNumber(),getRingtone());
	}

	public String unlock() {
		return "Unlocking via finger print";
	}

	public void displayInfo() {
		System.out.println(String.format("Galaxy %s from  %s",getVersionNumber() ,getCarrier()));
	}

}
