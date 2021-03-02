package it.gr.demo.service;

import it.gr.demo.model.Note;

public interface NoteService {

	public Iterable<Note> getNotes();

	public Note getNote(Long id);

	public Note createNote(Note newNote);

	public Note updateNote(Long id, Note newNote);

	public void deleteNote(Long id);
}