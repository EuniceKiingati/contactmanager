package com.eunice.contacts.contactPackage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public ContactServiceImpl(com.eunice.contacts.contactPackage.ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

//    @Autowired
//    public ContactServiceImpl(ContactRepository contactRepository) {
//        this.contactRepository = contactRepository;
//    }

    @Override
    public ContactEntity createContact(ContactEntity contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<ContactEntity> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public ContactEntity getContactById(Long id) {
        Optional<ContactEntity> optionalContact = contactRepository.findById(id);
        return optionalContact.orElse(null);
    }

    @Override
    public List<ContactEntity> getContactsByName(String name) {
        return contactRepository.findByNameIgnoreCase(name);
    }

    @Override
    public ContactEntity updateContact(Long id, ContactEntity contact) {
        if (contactRepository.existsById(id)) {
            contact.setId(id);
            return contactRepository.save(contact);
        } else {
            return null; // Contact with given id not found
        }
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

}
