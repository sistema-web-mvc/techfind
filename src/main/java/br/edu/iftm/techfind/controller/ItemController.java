package br.edu.iftm.techfind.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iftm.techfind.model.Item;
import br.edu.iftm.techfind.model.TipoItem;
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

    // ===== E3 · Criar item (Alfredo) =====
    // Mostra o formulário vazio
    @GetMapping("/itens/novo")
    public String novo(Model model) {
        Item item = new Item();
        item.setTipo(TipoItem.PERDIDO); // já vem marcado "Perdi"
        model.addAttribute("item", item);
        return "form-item";
    }

    // Recebe o formulário preenchido e grava no banco
    @PostMapping("/itens")
    public String criar(@ModelAttribute("item") Item item, RedirectAttributes redirect) {
        itemService.cadastrar(item);
        redirect.addFlashAttribute("mensagem", "Item publicado com sucesso.");
        return "redirect:/"; // POST-Redirect-GET
    }


    // ===== E3 · Editar item (Yamada) =====
    // (os métodos editar e atualizar entram aqui)

    // ===== E3 · Excluir item (Felipe Nogueira) =====
    // Exclui o item e volta para a lista com uma mensagem de sucesso
    @PostMapping("/itens/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes redirect) {
        itemService.excluir(id);
        redirect.addFlashAttribute("mensagem", "Item excluído com sucesso.");
        return "redirect:/"; // POST-Redirect-GET
    }

    // ===== E3 · Marcar como devolvido (Luany) =====
        // Marca como devolvido e volta para o detalhe do mesmo item
    @PostMapping("/itens/{id}/devolver")
    public String devolver(@PathVariable Long id, RedirectAttributes redirect) {
        itemService.marcarComoDevolvido(id);
        redirect.addFlashAttribute("mensagem", "Item marcado como devolvido.");
        return "redirect:/itens/" + id; // POST-Redirect-GET
    }
}