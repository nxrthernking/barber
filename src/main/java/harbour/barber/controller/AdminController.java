package harbour.barber.controller;

import harbour.barber.model.User;
import harbour.barber.model.dto.UserDto;
import harbour.barber.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> users() {
        return userService.getAll();
    }
}
