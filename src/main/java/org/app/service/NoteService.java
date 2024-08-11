package org.app.service;

import org.app.model.Note;
import org.app.model.dto.NoteDto;
import org.app.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NoteService {
    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    private final NoteRepository repo;

    public List<Note> listAll() {
        return repo.findAll();
    }

    public Note create(Note note) {
        return repo.save(note);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Note update(Long id, NoteDto noteDto) throws Exception {
        if (Objects.isNull(getById(id))) {
            throw new IllegalArgumentException("Note not found");
        }
        Note note = repo.getById(id);
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        return repo.save(note);

    }

    public Note getById(Long id) throws Exception {
        Optional<Note> optionalNote = repo.findById(id);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        } else {
            throw new Exception("NoteEntity not found");
        }
    }
}
