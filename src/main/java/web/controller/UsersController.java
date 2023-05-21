package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.dao.JpaUserDao;
import web.models.User;
import web.service.UserService;

import java.util.ListIterator;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsersList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("users") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("users") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("users", userService.getUserById(id));
        return "edit";
    }

    @GetMapping("/{id}/edit")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") User user, @PathVariable("id") Long id) {
        userService.saveUser(user);
        return "redirect:/users";
    }


}
