package it.gr.demo.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value = { "title", "content", "id" })
public class NoteDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4674952817095777887L;
	private Long id;
	private String title;
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}