package com.isabel.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.relationships.models.License;
import com.isabel.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository licenseRepository;
	
	public License createLicense(License lisence) {
		return licenseRepository.save(lisence);
	}
	
	public License findTopByOrderByNumeroDesc() {
		return licenseRepository.findTopByOrderByNumeroDesc();
	}
	
	public List<License> showAllLicenses(){
		return licenseRepository.findAll();
	}
	

}
