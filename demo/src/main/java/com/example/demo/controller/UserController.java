package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class UserController {

	    private UserService userService;

	    @RequestMapping("/list")
	    public String listPerson(Model model) {

	        model.addAttribute("person", userService.listPerson());

	        return "list";
	    }

	    @GetMapping("/add")
	    public String addPage(Model model) {
	        return "add-page";
	    }

	    @PostMapping("/add")
	    public String addPerson(Model model, HttpServletRequest request) throws Exception {

	        String name 	= request.getParameter("name");
	        String email 	= request.getParameter("email");
	        String password = request.getParameter("password");
	        String phone 	= request.getParameter("phone");
	        String userId 	= request.getParameter("user_id");

	        UserDto userDto = new UserDto();
	        userDto.setName(name);
	        userDto.setEmail(email);
	        userDto.setPassword(password);
	        userDto.setPhone(phone);
	        userDto.setUserId(userId);
	        
	        userService.addPerson(userDto);
	        return "redirect:/list";
	    }

	    @GetMapping("/update/{id}")
	    public String updatePage(Model model, @PathVariable("id") String userId) {
	        model.addAttribute("person", userService.findById(userId));
	        return "update-page";
	    }

	    @PostMapping("/update/{id}")
	    public String updatePerson(Model model, @PathVariable("id") String userId, HttpServletRequest request) {
	        String name 	= request.getParameter("name");
	        String email 	= request.getParameter("email");
	        String password = request.getParameter("password");
	        String phone 	= request.getParameter("phone");

	        UserDto userDto = new UserDto();
	        userDto.setName(name);
	        userDto.setPassword(password);
	        userDto.setUserId(userId);
	        userDto.setEmail(email);
	        userDto.setPhone(phone);
	        
	        userService.updatePerson(userDto);

	        return "redirect:/list";
	    }

	    @GetMapping("/delete/{id}")
	    public String deletePerson(Model model, @PathVariable("id") String userId) {
	    	userService.deletePerson(userId);
	        return "redirect:/list";
	    }

}
