package com.example.music_web.service;

import com.example.music_web.model.Song;
import com.example.music_web.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songrepsitory;

    public List<Song> getAllSongs(){
        return songrepsitory.findAll();
    }

    public Song getSongById(Long id){
        return songrepsitory.findById(id).orElse(null);
    }

    public void saveSong(Song song){
        songrepsitory.save(song);
    }

    public void editSong(Song song){
        songrepsitory.save(song);
    }

    public void deleteSong(long id){
        Song song = songrepsitory.findById(id).orElse(null);
        if(song!=null){
            songrepsitory.delete(song);
        }
    }
}
