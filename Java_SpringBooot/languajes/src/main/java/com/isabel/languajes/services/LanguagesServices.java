package com.isabel.languajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.isabel.languajes.models.Languages;
import com.isabel.languajes.repositories.LanguagesRepository;

@Service
public class LanguagesServices {
	@Autowired
	private LanguagesRepository languageRepo;
	
	public List<Languages> showLenguages(){
		List<Languages> listLanguages= languageRepo.findAll();
		return listLanguages;
	}
	
	public Languages createLanguage(Languages languages) {
		return languageRepo.save(languages);
	}

	public Languages showLanguagesbyId(Long id) {
		Optional<Languages> len= languageRepo.findById(id);
		return len.isPresent() ? len.get() : null;
	}

	public Languages updateLanguage(Long id,Languages l) {
		Optional<Languages> currentLanguages = languageRepo.findById(id);
		if(currentLanguages.isPresent()) {
			Languages foundLanguage =currentLanguages.get();
			foundLanguage.setName(l.getName());
			foundLanguage.setCreator(l.getCreator());
			foundLanguage.setCurrentVersion(l.getCurrentVersion());
			return languageRepo.save(foundLanguage);
		}else {
			return null;
		}
	}

	public void deleteLanguage(Long id) {
		 languageRepo.deleteById(id);
	}
}
