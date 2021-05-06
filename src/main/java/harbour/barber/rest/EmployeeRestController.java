package harbour.barber.rest;

import harbour.barber.model.dto.EmployeeDto;
import harbour.barber.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/employees")
public class EmployeeRestController {
    private final EmployeeService service;

    @GetMapping
    public List<EmployeeDto> getAll(){
        return service.getAll();
    }

    @PostMapping(value = "/add")
    public void add(@RequestBody EmployeeDto employeeDto){
        service.add(employeeDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.remove(id);
    }

}
