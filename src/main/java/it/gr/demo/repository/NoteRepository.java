package it.gr.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.gr.demo.model.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
	public List<Note> findAll();
}