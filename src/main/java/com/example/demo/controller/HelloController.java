package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/users")
public class HelloController {

    private final UserDAO userDAO;

    @Autowired
    public HelloController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

//    @GetMapping("/add")
//    public String showAddUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "add-user";
//    }

    
    
    
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userDAO.addUser(user);
        return "redirect:/users/all";
    }







    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userDAO.getUserById(id);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userDAO.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDAO.deleteUser(id);
    }
}
