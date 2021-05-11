package harbour.barber.controller;

import harbour.barber.model.dto.UserDto;
import harbour.barber.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/register")
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String getRegisterForm(Model model){
        model.addAttribute("user",new UserDto());
        return "registration";
    }

    @PostMapping
    public String register(@ModelAttribute UserDto request, Model model){
        userService.add(request);
        return "redirect:/orders";
    }
}
