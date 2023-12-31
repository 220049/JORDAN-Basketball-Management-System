package com.system.basketball_management_system.Service;

import com.system.basketball_management_system.Pojo.ContactPojo;
import com.system.basketball_management_system.entity.Contact;

import java.util.List;

public interface ContactService {
    String save(ContactPojo contactPojo);

    List<Contact> fetchAll();

    void deleteById(Integer id);
}
