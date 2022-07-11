package kz.edgeapps.service;

import kz.edgeapps.model.Item;

import java.util.List;

public interface ItemService {

    //Создает новый товар
    void create(Item item);

    //Возвращает список всех имеющихся товаров
    List<Item> readAll();

    //Возвращает товар по его ID
    Item read(int id);

    //Обновляет товар с заданному ID/
    boolean update(Item item, int id);

    //Удаляет товар с заданным ID/
    boolean delete(int id);
}