# azurespringboot

Integration of Azure Storage services using Spring Boot .

Azure provides Spring Boot starter libraries , under the hood these libraries do use Azure SDK and package for seamless integration with any Spring Boot App. One of the challenges i did face is these starter libraries don't use the latest version of Azure SDK always . 

This project should allows us to easily understand to build your own Spring Boot app using Azure SDK's

How to use 

1. Update the below property in the Application.properties under src/main/resources with the azure storage connection string and Container name

azure.storage.container-name=<Update Container Name>
azure.storage.connection.string=<Update Connection String>
  
  2. This can be tested using Postman
  
    POST Method URI - localhost:8080/uploadFile/
