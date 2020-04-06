package com.learnazure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learnazure.services.FileServices;

@RestController
@RequestMapping("/uploadFile")
public class FileController {
	
	@Autowired
	FileServices services;

	@GetMapping("/")
	public String home() {
		return "Hello File Controller. Try Post Method for File Submission";
	}

	@PostMapping("/")
	public String singleFileUpload(@RequestParam("file") MultipartFile file) {

		String uploadStatus = "Failure";

		try {

			// Get the file and save it tmp directory or any other resource
			byte[] bytes = file.getBytes();
			
			Path path = Paths.get("/tmp/" + file.getOriginalFilename());
			
			Files.write(path, bytes);

			System.out.println("Intiating Upload");
			

			uploadStatus = services.uploadFileToBlob(path, file.getOriginalFilename());

		} catch (IOException e) {
			// Perform Exception Handling
		}

		return uploadStatus;
	}

}
