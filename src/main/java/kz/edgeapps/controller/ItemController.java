package kz.edgeapps.controller;

import kz.edgeapps.exception.ThereIsNoSuchUserException;
import kz.edgeapps.model.Item;
import kz.edgeapps.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO: плохая практика писать одинаковые эндпоинты и функции на разные методы!!!
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //TODO: если я вставлю поле id в json файл, то он изменит его, в таком случае ты можешь либо удалить update и оставить этот метод для создания и изменения, либо посавить какие-то ограничения здесь.
    @PostMapping(value = "/products")
    public ResponseEntity<?> create(@RequestBody Item item) {
        itemService.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Item>> read() {
        final List<Item> products = itemService.readAll();

        return products != null &&  !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // TODO: ты пробовал вытаскивать несуществующий id? у меня 500 ошибку кидает
    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Item> read(@PathVariable(name = "id") int id) {
        final Item item = itemService.read(id);

        return item != null
                ? new ResponseEntity<>(item, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Item item) {
        final boolean updated = itemService.update(item, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = itemService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}