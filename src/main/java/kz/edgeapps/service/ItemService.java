package kz.edgeapps.service;

import kz.edgeapps.model.Item;

import java.util.List;

public interface ItemService {

    /**
     * Создает нового клиента
     * @param item - клиент для создания
     */
    void create(Item item);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Item> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Item read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param item - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Item item, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}