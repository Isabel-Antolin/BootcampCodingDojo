package com.isabel.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isabel.lookify.models.Song;
import com.isabel.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {
	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String showIndex() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String showdashboard(@ModelAttribute("song") Song song,Model model) {
		model.addAttribute("songs", songService.showAllSong());
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String showNew(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> topTen = songService.topTen();
		model.addAttribute("topTen", topTen);
		return "topTen.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "/new.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/search")
	public String searchByArtist(@ModelAttribute("song") Song song,@RequestParam("artista") String artista) {
		return "redirect:/search/" + artista;
	}
	@GetMapping("/search/{artista}")
	public String showSearchArtist(@PathVariable("artista") String artista,Model model,@ModelAttribute("song") Song song) {
		List<Song> songs  = songService.findAllByArtist(artista);
	    if (songs != null && !songs.isEmpty()) {
	        model.addAttribute("artista", artista);
	        model.addAttribute("songs", songs);
	        return "searchArtista.jsp";
	    } else {
	        return "redirect:/dashboard";
	    }
	}
	
	@GetMapping("/songs/{id}")
	public String viewSong(@PathVariable("id") Long id,Model model) {
		model.addAttribute("song", songService.findById(id));
		return "song.jsp";
	}
	
	@DeleteMapping("/song/{id}")
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	

}
