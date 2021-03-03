package it.gr.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.gr.demo.model.Note;
import it.gr.demo.dto.NoteDto;
import it.gr.demo.service.NoteService;

@RestController
@RequestMapping("/api")
public class NoteController {
	@Autowired
	NoteService noteService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/notes")
	@ResponseStatus(HttpStatus.OK)
	public List<NoteDto> getNotes() {
		List<Note> notes = noteService.getNotes();
		List<NoteDto> notesDto = new ArrayList<>();
		for (Note note : notes) {
			NoteDto noteDto = modelMapper.map(note, NoteDto.class);
			notesDto.add(noteDto);
		}
		return notesDto;
	}

	@GetMapping("/notes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public NoteDto getNote(@PathVariable Long id) {
		return modelMapper.map(noteService.getNote(id), NoteDto.class);
	}

	@PostMapping("/notes")
	@ResponseStatus(HttpStatus.CREATED)
	public Object createNote(@RequestBody NoteDto newNote) {
		Note note = modelMapper.map(newNote, Note.class);
		return noteService.createNote(note);
	}

	@PutMapping("/notes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Object updateNote(@PathVariable Long id, @RequestBody NoteDto noteToUpdate) {
		Note note = modelMapper.map(noteToUpdate, Note.class);
		return noteService.updateNote(id, note);
	}

	@DeleteMapping("/notes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteNote(@PathVariable Long id) {
		noteService.deleteNote(id);
	}

	/**
	 * RestCalls from WebUI
	 */

	@GetMapping(value = "/string", produces = MediaType.APPLICATION_JSON_VALUE)
	public NoteDto getTitle() {
		NoteDto noteDto = new NoteDto();
		noteDto.setTitle(noteService.getNote((long) 1).getTitle()); // it's a demo...
		return noteDto;
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<NoteDto> getNotesTable() {
		List<Note> notes = noteService.getNotes();
		List<NoteDto> notesDto = new ArrayList<>();
		for (Note note : notes) {
			NoteDto noteDto = modelMapper.map(note, NoteDto.class);
			notesDto.add(noteDto);
		}
		return notesDto;
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Object createNoteTable(@RequestBody NoteDto newNote) {
		Note note = modelMapper.map(newNote, Note.class);
		return noteService.createNote(note);
	}
}