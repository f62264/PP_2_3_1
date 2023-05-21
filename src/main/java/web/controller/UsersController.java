package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("users") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("users") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("users", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "edit";

        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@RequestParam(value = "id") Long id) {
        User user = userService.deleteUserById(id);
        return "redirect:/users";
    }
}
