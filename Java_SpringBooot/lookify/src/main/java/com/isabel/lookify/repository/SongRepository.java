package com.isabel.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song>findAll();
	List<Song>findAllByArtista(String artista);
	List<Song>findTop10ByOrderByClasificacionDesc();
}
