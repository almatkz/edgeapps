package kz.edgeapps.repository;

import kz.edgeapps.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>  {
}