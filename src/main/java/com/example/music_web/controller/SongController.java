package com.example.music_web.controller;

import com.example.music_web.model.Song;
import com.example.music_web.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private SongService songservice;

    @GetMapping("/")
    public String home(Model model){
        List<Song> songs = songservice.getAllSongs();
        model.addAttribute("songs", songs);
        return "song-list";
    }

    // Hiển thị form để thêm bài hát
    @GetMapping("/add-song")
    public String showAddSongForm(Model model){
        model.addAttribute("song", new Song());
        return "add-song";
    }

    // Xử lý form khi người dùng thêm bài hát mới
    @PostMapping("/add-song")
    public String addSong(@ModelAttribute Song song){
        songservice.saveSong(song);
        return "redirect:/"; // Chuyển hướng về trang chủ (hoặc trang danh sách bài hát)
    }

    // Hiển thị bài hát cần chỉnh sửa
    @GetMapping("/update-song")
    public String showUpdateSongForm(@RequestParam("id") Long id, Model model) {
        Song song = songservice.getSongById(id);
        if(song!=null){
            model.addAttribute("song", song);
        }
        return "update-song";
    }

    // Xử lý form người dùng cập nhật bài hát mới
    @PostMapping("/update-song")
    public String updateSong(@ModelAttribute Song song){
        songservice.editSong(song);
        return "redirect:/";
    }

    @GetMapping("/delete-song")
    public String deleteSong(@RequestParam("id") long id){
        songservice.deleteSong(id);
        return "redirect:/";
    }
}
