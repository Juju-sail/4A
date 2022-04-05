package com.example.demo;

public class NotFoundException extends RuntimeException {
	  public NotFoundException(
		      long id, String type) {
		    super(String.format(
		          "The %s with the id %d was not found.",
		          type, id));
		  }

}
