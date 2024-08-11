package org.app.controller;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.app.model.Note;
import org.app.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;


    @GetMapping(value = "/list")
    public Iterable<Note> getList(){
        return noteService.listAll();
    }

    @GetMapping("/{id}")
    public Note findById(@PathVariable Long id) throws Exception {
        return noteService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note) {
        return noteService.create(note);
    }

    @PutMapping("/{id}")
    public Note editNote(@PathVariable Long id, @RequestBody Map<String, String> json, HttpServletResponse httpServletResponse) throws Exception {
       ;
        return noteService.update(id,  json.get("title"), json.get("content"));
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long noteId, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setStatus(302);
        noteService.deleteById(noteId);
    }

}
