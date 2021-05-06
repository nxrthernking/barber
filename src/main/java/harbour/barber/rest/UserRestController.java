package harbour.barber.rest;

import harbour.barber.model.dto.UserDto;
import harbour.barber.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/users")
public class UserRestController {

    private final UserService service;

    @GetMapping
    public List<UserDto> getAll(){
        return service.getAll();
    }

    @PostMapping(value = "/add")
    public void add(@RequestBody UserDto request){
        service.add(request);
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.remove(id);
    }

}
