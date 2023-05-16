package com.isabel.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.lookify.models.Song;
import com.isabel.lookify.repository.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository songRepository;
	
	public List<Song> showAllSong(){
		return songRepository.findAll();
	}
	
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	
	public List<Song> findAllByArtist(String artista) {
		List<Song> songs = songRepository.findAllByArtista(artista);
		if (songs.isEmpty()) {
			return null;
		} else {
			return songs;
		}
	}

	public Song findById(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		return optionalSong.isPresent() ? optionalSong.get() : null;
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	public List<Song> topTen(){
		return songRepository.findTop10ByOrderByClasificacionDesc();
	}
}
