package it.gr.demo.repository;

import org.springframework.data.repository.CrudRepository;

import it.gr.demo.model.Note;

public interface NoteRepository extends CrudRepository <Note, Long> {}