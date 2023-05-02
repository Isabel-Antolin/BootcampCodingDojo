package com.isabel.telefonos.clases;

public abstract class Phone {
	private String versionNumber;
	private int baterryPercentage;
	private String carrier;
	private String ringtone;

	public Phone(String versionNumber, int baterryPercentage, String carrier, String ringtone) {
		this.versionNumber = versionNumber;
		this.baterryPercentage = baterryPercentage;
		this.carrier = carrier;
		this.ringtone = ringtone;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getBaterryPercentage() {
		return baterryPercentage;
	}

	public void setBaterryPercentage(int baterryPercentage) {
		this.baterryPercentage = baterryPercentage;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getRingtone() {
		return ringtone;
	}

	public void setRingtone(String ringtone) {
		this.ringtone = ringtone;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public abstract void displayInfo();
}
