package it.gr.demo.controller;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.gr.demo.model.Note;
import it.gr.demo.dto.NoteDto;
import it.gr.demo.service.NoteService;

@RestController
@RequestMapping("/demo")
public class NoteController {
	@Autowired
	NoteService noteService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/notes")
	public ResponseEntity<Object> getNotes() {
		return new ResponseEntity<>(noteService.getNotes(), HttpStatus.OK);
	}

	@GetMapping("/notes/{id}")
	public ResponseEntity<Object> getNote(@PathVariable Long id) {
		NoteDto note = modelMapper.map(noteService.getNote(id), NoteDto.class);
		return new ResponseEntity<>(note, HttpStatus.OK);
	}

	@PostMapping("/notes")
	public ResponseEntity<Object> createNote(@RequestBody NoteDto newNote) {
		Note note = modelMapper.map(newNote, Note.class);
		noteService.createNote(note);
		return new ResponseEntity<>("Note created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/notes/{id}")
	public ResponseEntity<Object> updateNote(@PathVariable Long id, @RequestBody NoteDto noteToUpdate) {
		Note note = modelMapper.map(noteToUpdate, Note.class);
		noteService.updateNote(id, note);
		return new ResponseEntity<>("Note updated successsfully", HttpStatus.OK);
	}

	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Object> deleteNote(@PathVariable Long id) {
		noteService.deleteNote(id);
		return new ResponseEntity<>("Note deleted successsfully", HttpStatus.OK);
	}

	/**
	 * RestCall from frontEnd
	 */

	@GetMapping(value = "/string", produces = MediaType.APPLICATION_JSON_VALUE)
	public NoteDto getDemoString() {
		NoteDto nota = new NoteDto();
		nota.setTitle("Andare a fare la spesa");
		return nota;
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Note> getNotesTable() {                                    // Map from Note to NoteDto missing
		return (List<Note>) noteService.getNotes();
	}
//	@ResponseBody
//	public List<NoteDto> getNotesTable() { 
//		List<Note> notes = (List<Note>) noteService.getNotes(); // cast from iterable to list
//		List<NoteDto> notesDto = new ArrayList<>();
//		for (int i = 0; i < notes.size(); i++) {
//			NoteDto dto = modelMapper.map(notes.get(i), NoteDto.class);
//			notesDto.add(dto);
//		}
//		return notesDto;
//	}
}