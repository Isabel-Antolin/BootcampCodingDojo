package com.isabel.telefonos.clases;
import com.isabel.telefonos.interfaces.Ringable;

public class Iphone extends Phone implements Ringable {
  public Iphone(String versionNumber, int baterryPercentage, String carrier, String ringtone) {
	  super(versionNumber,baterryPercentage,carrier,ringtone);
  }
  
	public String ring() {
		return String.format("Iphone %s says %s", getVersionNumber(),getRingtone());
	}

	public String unlock() {
		return "Unlocking via facial recognition";
	}
  public void displayInfo() {
	  System.out.println(String.format("Iphone %s from  %s",getVersionNumber() ,getCarrier()));
	  }
}
