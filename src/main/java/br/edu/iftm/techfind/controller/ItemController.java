package br.edu.iftm.techfind.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import br.edu.iftm.techfind.model.Item;
import br.edu.iftm.techfind.service.ItemService;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("itens", itemService.listarTodos());
        return "home";
    }

    @GetMapping("/itens/{id}")
    public String detalhe(@PathVariable Long id, Model model) {
        Item item = itemService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));
        model.addAttribute("item", item);
        return "detalhe-item";
    }
}