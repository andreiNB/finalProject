package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.javaro35.finalProject.dto.UserDto;
import ro.sda.javaro35.finalProject.entities.User;
import ro.sda.javaro35.finalProject.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public String showUser(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping("/users/create")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "user_create";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute("userForm") @Valid UserDto form, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "user_create";
        }
        userService.createUser(form);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{userId}")
    public String showEditForm(@PathVariable("userId") long id, Model model) {
        UserDto userForm = userService.findById(id);
        model.addAttribute("userForm", userForm);
        return "user_create";
    }

    @GetMapping("/users/delete/{userId}")
    public String deleteUser(@PathVariable("userId") int id, Model model) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
