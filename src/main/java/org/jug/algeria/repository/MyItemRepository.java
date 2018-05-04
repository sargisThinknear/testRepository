package org.jug.algeria.repository;

import org.jug.algeria.domain.MyItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MyItemRepository extends JpaRepository<MyItem, Long> {
}
