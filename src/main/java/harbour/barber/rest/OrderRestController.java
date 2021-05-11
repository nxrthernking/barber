package harbour.barber.rest;

import harbour.barber.model.Order;
import harbour.barber.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/orders")
public class OrderRestController {

    private final OrderService service;

    @GetMapping
    public List<Order> getAll(){
        return service.getAll();
    }

//    @PostMapping(value = "/add")
//    public void add(@RequestBody Order order){
//        service.add(order);
//    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.remove(id);
    }

}
