package com.pixels.feedservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(value = { UsernameNotFoundException.class })
	public ResponseEntity<String> usernameNotFoundExceptionHandler() {
		return new ResponseEntity<>("User not found or does not exist..", HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(value = { UserSearchEmptyResult.class })
	public ResponseEntity<String> userSearchEmptyResultHandler() {
		return new ResponseEntity<>("No users found..", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { UserStoryUploadFailedException.class })
	public ResponseEntity<String> userStoryUploadFailedExceptionHandler() {
		return new ResponseEntity<>("Upload failed..", HttpStatus.CONFLICT);
	}
	

	@ExceptionHandler(value = { PostNotFoundException.class })
	public ResponseEntity<String> postNotFoundExceptionHandler() {
		return new ResponseEntity<>("Post not found..", HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(value = { CommentNotFound.class })
	public ResponseEntity<String> commentNotFoundHandler() {
		return new ResponseEntity<>("Comment not found..", HttpStatus.NOT_FOUND);
	}
}
