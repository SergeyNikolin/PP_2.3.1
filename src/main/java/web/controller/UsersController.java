package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.models.User;
import web.services.UserService;

import java.util.List;

@Controller
public class UsersController {


	private UserService userService;
	private static final String REDIRECT = "redirect:/";

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/add")
	public String addUserPage() {
		return "userAdd";
	}

	@PostMapping("/add")
	public String addUser(@RequestParam String name, @RequestParam String lastName, @RequestParam int age, RedirectAttributes redirectAttributes) {
		User user = new User();
		user.setName(name);
		user.setLastName(lastName);
		user.setAge(age);
		userService.addUser(user);
		redirectAttributes.addFlashAttribute("message", "User added successfully");
		return REDIRECT;
	}

	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return REDIRECT;
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		if (user != null) {
			model.addAttribute("user", user);
			return "edit";
		} else {
			return REDIRECT;
		}
	}

	@PostMapping("/edit/{id}")
	public String updateUser(@PathVariable Long id, @ModelAttribute("user") User updatedUser) {
		User existingUser = userService.getUserById(id);
		existingUser.setName(updatedUser.getName());
		existingUser.setLastName(updatedUser.getLastName());
		existingUser.setAge(updatedUser.getAge());
		userService.updateUser(existingUser);
		return REDIRECT;
	}

}