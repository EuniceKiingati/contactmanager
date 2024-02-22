package com.eunice.contacts.contactPackage;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ContactService {

    ContactEntity createContact(ContactEntity contact);

    List<ContactEntity> getAllContacts();

    ContactEntity getContactById(Long id);

    List<ContactEntity> getContactsByName(String name);

    ContactEntity updateContact(Long id, ContactEntity contact);

    void deleteContact(Long id);

}
