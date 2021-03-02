package it.gr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gr.demo.model.Note;
import it.gr.demo.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public Iterable<Note> getNotes() {
		return noteRepository.findAll();
	}

	@Override
	public Note getNote(Long id) {
		return noteRepository.findById(id).orElseThrow();
	}

	@Override
	public Note createNote(Note newNote) {
		return noteRepository.save(newNote);
	}

	@Override
	public Note updateNote(Long id, Note newNote) {
		Note noteToUpdate = noteRepository.findById(id).orElseThrow();
		noteToUpdate.setTitle(newNote.getTitle());
		noteToUpdate.setContent(newNote.getContent());
		return noteRepository.save(noteToUpdate);
	}

	@Override
	public void deleteNote(Long id) {
		noteRepository.delete(noteRepository.findById(id).orElseThrow());
	}
}