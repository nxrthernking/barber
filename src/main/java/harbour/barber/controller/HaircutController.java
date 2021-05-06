package harbour.barber.controller;

import harbour.barber.service.HaircutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/haircuts")
public class HaircutController {

    private final HaircutService haircutService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("haircuts",haircutService.getAll());
        return "haircuts_list";
    }
}
