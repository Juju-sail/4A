package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Note {
	// Attributs :
	public String id;
	public String titre;
	public String contenu;
	public String proprietaire;
	public List<String> categories;
	
	// Main :
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	// Constructeurs :
	public Note(String titre, String contenu, String proprietaire) {
		super();
		this.id = UUID.randomUUID().toString();
		this.titre = titre;
		this.contenu = contenu;
		this.proprietaire = proprietaire;
		this.categories = new ArrayList<String>();
		this.categories.add("");
		this.categories.add("");
		this.categories.add("");
	}
	
	public Note() {
		super();
		this.categories = new ArrayList<String>();
		this.categories.add("");
		this.categories.add("");
		this.categories.add("");
	}
	
	
	public String affCat() {
		String toreturn = "{";
		for(int i = 0 ; i < this.categories.size() ; i++) {
			toreturn += this.categories.get(i) + " |";
		}
		return toreturn + "}";
	}

	@Override
	public String toString() {
		return "[id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", proprietaire=" + proprietaire + ", categories= " + this.affCat() +"]";
	}
	
	public String afficheNote() {
		return "[titre=" + this.titre + ", contenu=" + this.contenu + ", proprietaire=" + this.proprietaire + ", categories= " + this.affCat() + "]";
	}
	
	
}
