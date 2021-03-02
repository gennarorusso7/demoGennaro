package it.gr.demo.service;

import java.util.List;

import it.gr.demo.model.Note;

public interface NoteService {

	public List <Note> getNotes();

	public Note getNote(Long id);

	public Note createNote(Note newNote);

	public Note updateNote(Long id, Note newNote);

	public void deleteNote(Long id);
}