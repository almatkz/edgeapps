package kz.edgeapps.service;

import kz.edgeapps.model.Item;
import kz.edgeapps.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void create(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> readAll() {
        return itemRepository.findAll();
    }

    // TODO: Преподолагаю ты видел, что там есть метод findById, но у тебя выходил syntax error.
    //  В случае если не знаешь что такое Optional, прогугли его(удобная вещь в джаве)
    //  можно написать что-то в стиле itemRepository.findById(id).orElse(null)
    @Override
    public Item read(int id) {
        return itemRepository.getOne(id);
    }

    @Override
    public boolean update(Item item, int id) {
        if (itemRepository.existsById(id)) {
            item.setId(id);
            itemRepository.save(item);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
