package com.learnazure.services;


import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

@Service
public class FileServices {
	
	@Value("${azure.storage.connection.string}")
	public String CONNECTION_STRING ;
	

	@Value("${azure.storage.container-name}")
	public String CONTAINER_NAME;

	public String uploadFileToBlob(Path filePath, String fileName) {

		System.out.println("Intiating Upload" + CONNECTION_STRING + CONTAINER_NAME );

		// Get a reference to a blob
		BlobClient blobClient = getBlobClient(fileName);

		System.out.println("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());

		// Upload the blob
		blobClient.uploadFromFile(filePath.toString());

		return "Success";
	}
	
	
	private BlobClient getBlobClient(String fileName) {
		
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(CONNECTION_STRING)
				.buildClient();

		BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(CONTAINER_NAME);

		// Get a reference to a blob
		BlobClient blobClient = containerClient.getBlobClient(fileName);
		
		
		return blobClient;
		
		
		
	}

}
