# azurespringboot

Sample Spring Boot App using the Azure Storage services and package as Docker image Container Google jib.

Azure provides Spring Boot starter libraries , under the hood these libraries do use Azure SDK and does package the app  seamless for integration with any Spring Boot App. One of the challenges i did face is these starter libraries don't use the latest version of Azure SDK always . 

Also this spring boot app is packaged as Docker image without any Docker dependencies on the build machine . Using the Google jib maven plugin

This project should help to easily understand to build your own Spring Boot app directly using Azure SDK's and package as Docker image.



How to use 

1. Check out the code and Update the below property in the Application.properties under src/main/resources with the azure storage connection string and Container name

azure.storage.container-name=<Update Container Name>
azure.storage.connection.string=<Update Connection String>
  
  2. Update the below properties to set limit on the File Transfer
  
  spring.servlet.multipart.max-file-size=2GB
  spring.servlet.multipart.max-request-size=3GB
  
 3. This can be tested using Postman
  
    POST Method URI - localhost:8080/uploadFile/
    
 4. Edit the below Continer repo settings in pom.xml
 
   <docker.repo><Repo URL></docker.repo>
		<docker.app.namespace><Application name ></docker.app.namespace>
		<docker.repo.username></docker.repo.username>
		<docker.repo.password></docker.repo.password>
    
  5. Execute the below mvn goal and image should be pushed the repo.
  
      mvn compile jib:build
    
    

