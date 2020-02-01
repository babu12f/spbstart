package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/userContact")
public class UserContactResource {

    @Autowired
    UserContactRepository userContactRepository;

    @GetMapping("/all")
    public List<UserContact> getUserContact() {
        return userContactRepository.findAll();
    }

    @GetMapping("/update/{name}")
    public List<UserContact> update(@PathVariable("name") final String name) {
        User user = new User();
        UserContact userContact = new UserContact();
        UserLog userLog = new UserLog();
        UserLog userLog2 = new UserLog();

        userLog.setLog("first log");
        userLog2.setLog("second log");

        user.setTeamName("Development")
                .setSalary(10000)
                .setName(name)
                .setUserLogs(Arrays.asList(userLog, userLog2));

        userContact.setPhoneNo(11111111)
                .setUser(user);

        userContactRepository.save(userContact);

        return userContactRepository.findAll();
    }
}
