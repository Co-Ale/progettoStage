package com.example.demo.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CsvController {

    @PostMapping(value = "/upload-csv-file" ,  consumes = {"multipart/form-data"})
    public ResponseEntity<?> csvUpload(@RequestBody MultipartFile file ) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String content = reader.lines().collect(Collectors.joining("\n"));
            return new ResponseEntity<>(content, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/upload-txt-file", consumes = "text/plain")
    public ResponseEntity<?> txtUpload(@RequestBody String fileContent) {
        try {
            // Il contenuto del file txt è ora direttamente nella variabile fileContent come stringa
            return new ResponseEntity<>(fileContent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get-txt-file")
    public ResponseEntity<?> getTxtFile() {
        try {
            // Crea un file system resource
            Resource file = new FileSystemResource("test.txt");

            // Imposta l'header per forzare il download
            String headerValue = "attachment; filename=\"" + file.getFilename() + "\"";
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                    .body(file);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @GetMapping("/get-txt-file")
    public ResponseEntity<?> getTxtFile() {
        try {
            File file = new File("test.txt");
            String sFile = "";
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                sFile += scanner.nextLine()+ "\n";
            }
            scanner.close();


            // Il contenuto del file txt è ora direttamente nella variabile fileContent come stringa
            //return new ResponseEntity<>(file, HttpStatus.OK);
           // message = "Uploaded the file successfully: " + file.getOriginalFilename();  
            return ResponseEntity.status(HttpStatus.OK).body(sFile );
          //  return ResponseEntity.ok(service.uploadStudents(file));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    
    @GetMapping("/get-csv-file")
    public ResponseEntity<?> getCsvFile() {
        try {
            File file = new File("test.csv");
            String sFile = "";
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                sFile += scanner.nextLine()+ "\n";
            }
            scanner.close();
            return ResponseEntity.status(HttpStatus.OK).body(sFile );
         
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


/*
    @PostMapping(value = "/upload-txt-file" ,  consumes = {"multipart/form-data"})
    public ResponseEntity<?> txtUpload(@RequestBody MultipartFile file ) {
         try {
            String contents = new BufferedReader(new InputStreamReader(file.getInputStream())).lines().collect(Collectors.joining("\n"));

            //byte[] content = file.getBytes();

            return new ResponseEntity<>( contents , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
     */
}