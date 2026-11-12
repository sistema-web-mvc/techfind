package br.edu.iftm.techfind.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.iftm.techfind.model.Item;
import br.edu.iftm.techfind.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    public Optional<Item> buscarPorId(Long id) {
        return itemRepository.findById(id);
    }

    public Long cadastrar(Item item) {
        return itemRepository.insert(item);
    }

    public boolean atualizar(Item item) {
        return itemRepository.update(item) > 0;
    }

    public boolean excluir(Long id) {
        return itemRepository.deleteById(id) > 0;
    }
}