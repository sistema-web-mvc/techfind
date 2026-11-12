package br.edu.iftm.techfind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/itens/novo")
    public String novoItem() {
        return "novo-item";
    }
}