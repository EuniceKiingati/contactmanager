package com.eunice.contacts.contactPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//indicates that this is a controller that handles RESTful requests
@RequestMapping("contacts") //defining base path for all the endpoints
public class ContactController {
     private final ContactService contactService;

     @Autowired//constructor injection of ContactService
     public ContactController(ContactService contactService){
         this.contactService=contactService;
     }

    // Endpoint to retrieve all contacts
    @GetMapping
    public ResponseEntity<List<ContactEntity>> getAllContacts() {
        List<ContactEntity> contacts = contactService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK); // Respond with the list of contacts and HTTP status 200 (OK)
    }
    // Endpoint to create a new contact
    @PostMapping
    public ResponseEntity<ContactEntity> createContact(@RequestBody ContactEntity contact) {
        ContactEntity createdContact = contactService.createContact(contact);
        return new ResponseEntity<>(createdContact, HttpStatus.CREATED); // Respond with the created contact and HTTP status 201 (Created)
    }

}
