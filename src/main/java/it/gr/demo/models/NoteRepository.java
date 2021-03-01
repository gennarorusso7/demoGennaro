package it.gr.demo.models;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository <Note, Long> {}