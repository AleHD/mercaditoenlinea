package com.unam.mercadoenlinea.repository;

import com.unam.mercadoenlinea.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOpinionRepository extends JpaRepository<Opinion, Long> {

    @Query("select o from Opinion o where o.producto.id like :fk")
    List<Opinion> findByForeignKey(@Param("fk") Long fk);
}
