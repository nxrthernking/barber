package harbour.barber.controller;

import harbour.barber.model.User;
import harbour.barber.model.dto.OrderDto;
import harbour.barber.service.EmployeeService;
import harbour.barber.service.OrderService;
import harbour.barber.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;

    private final UserService userService;

    private final EmployeeService employeeService;

    @GetMapping
    @Secured("ROLE_USER")
    public String getAllOrders(Principal principal, Model model) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("orders", orderService.getAllByUserId(user));
        return "user-orders";
    }

    @GetMapping(value = "/add/{id}")
    @Secured("ROLE_USER")
    public String add(@PathVariable(value = "id") Long id, Model model) {
        OrderDto order = new OrderDto();
        order.setEmployeeId(id);
        model.addAttribute("order", order);
        return "order_add";
    }

    @PostMapping(value = "/add")
    @Secured("ROLE_USER")
    public String submitOrder(@ModelAttribute OrderDto order, Principal principal) {
        order.setUsername(principal.getName());
        orderService.add(order);
        return "redirect:/";
    }

}
