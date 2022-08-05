package kz.edgeapps.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
//TODO: если что hibernate(JPARepository) может автоматом создать таблицу через клаcc, то есть если исользуешь JPA то необязтаельно писать отдельные скрипты для создания таблицы
//  также есть lombok аннотации которые добавляют геттеры и сеттеры автоматом на каждое поле

// TODO: Также, здесь желательно не передавать через этот класс инфу, тоже не лучшая практика, он идет как JPA Entity и нужен для общения с базой, могут выйти нежелательные ошибки/проблемы
//  скажем как у меня постоянно выходил BAD_REQUEST без какой-либо дополнительной инфы, потратил минут 5-10 на выяснение,не спорю тут я тупанул, но люди часто тупят и лучше работать наверняка)
//  для передачи Инфы часто используют DTO(Data Transfer Objects) классы, в целом то же самое но без лишних аннотаций и связей.
@Entity
@Table(name = "product_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    //… getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}