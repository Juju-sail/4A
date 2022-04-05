package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DemoApplication;

@RestController
public class BlocNote {
	// Attributs
	private List<Note> notes;
	
	// Main
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	// Constructeurs :
	public BlocNote(Note n) {
		super();
		this.notes = new ArrayList<Note>();
		notes.add(n);
	}
	public BlocNote() {
		super();
		this.notes = new ArrayList<Note>();
		}
	// Getters & Setters
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	@GetMapping("/notes")
	public List<Note> listeNotes(){
		return this.notes;
	}
	
	@GetMapping("/notes/{id}")
	public Note note(@PathVariable(value = "id") int id) {
		//Get note
		Note note = this.notes.get(id);
		return note;
	}
	
	@GetMapping("notes/{id}/categories")
	public List<String> catego(@PathVariable(value = "id") int id){
		List<String> cat = this.notes.get(id).categories;
		return cat;
	}
	
	@PostMapping("/note")
	public void note(
			@RequestParam(value = "titre", required = true) String titre, 
			@RequestParam(value = "contenu", defaultValue = "...") String contenu, 
			@RequestParam(value = "proprietaire", defaultValue = "ordi") String proprietaire) throws IOException{
		
		//Create note
		Note note = new Note(titre, contenu, proprietaire);
		this.notes.add(note);
		System.out.println("|Note " + note + " crée|");
	}
	
	@DeleteMapping("/note/{id}")
	public void deleteNote(@PathVariable(value = "id") int id) throws IOException {
		this.notes.remove(id);
		System.out.println("Note suprimée");
		
	}
	@PostMapping("/modif")
	public void modifNote(
			@RequestParam(value = "id", defaultValue = "0") int id, 
			@RequestParam(value = "titre", required = false) String titre, 
			@PathVariable(value = "contenu", required = false) String contenu, 
			@PathVariable(value = "proprietaire", required = false) String proprietaire) throws IOException {
		Note oldNote = this.notes.get(id);
		Note newNote = new Note();
		
		newNote.id = oldNote.id;
		if(titre != null) {
			System.out.println("Changement du titre : " + oldNote.titre + " -> " + titre);
			newNote.titre = titre;
		}
		else {
			newNote.titre = oldNote.titre;
		}
		if(contenu != null) {
			System.out.println("Changement du contenu : " + oldNote.contenu + " -> " + contenu);
			newNote.contenu = contenu;
		}
		else {
			newNote.contenu = oldNote.contenu;
		}
		if(proprietaire != null) {
			System.out.println("Changement du proprietaire : " + oldNote.proprietaire + " -> " + proprietaire);
			newNote.proprietaire = proprietaire;
		}
		else {
			newNote.proprietaire = oldNote.proprietaire;
		}
		
		this.notes.set(id, newNote);
		System.out.println("Note modifiée : " + oldNote.afficheNote() + " est devenue " + newNote.afficheNote());
	}
	
	@PostMapping("/modif/categories")
	public void modifCateg(
			@RequestParam(value = "id", defaultValue = "0", required = true) int id, 
			@RequestParam(value = "categorie1", required = false) String cat1, 
			@RequestParam(value = "categorie2", required = false) String cat2, 
			@RequestParam(value = "categorie3", required = false) String cat3) {
		Note oldNote = this.notes.get(id);
		Note newNote = new Note();
		newNote.id = oldNote.id;
		newNote.titre = oldNote.titre;
		newNote.contenu = oldNote.contenu;
		newNote.proprietaire = oldNote.proprietaire;
		if(cat1 != null) {
			newNote.categories.set(0, cat1);
		}
		else {
			newNote.categories.set(0, oldNote.categories.get(0));
		}
		if(cat2 != null) {
			newNote.categories.set(1, cat2);
		}
		else {
			newNote.categories.set(1, oldNote.categories.get(1));
		}
		if(cat3 != null) {
			newNote.categories.set(2, cat3);
		}
		else {
			newNote.categories.set(2, oldNote.categories.get(2));
		}
		this.notes.set(id, newNote);
		System.out.println("Note {" + newNote.titre + "} modifiée. Ses categories sont passée de : " + oldNote.affCat() + " à " + newNote.affCat());
	}
	
}
