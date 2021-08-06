package com.unam.mercadoenlinea.repository;

import com.unam.mercadoenlinea.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

	@Query("select p from Producto p where p.usuario.id like :id")
	List<Producto> findUsuariousuarioid(@Param("id") Long id);

	//@Query(value = "SELECT * FROM producto p where p.titulo = :keyword", nativeQuery = true)
	//@Query(value = "SELECT * FROM producto p where (p.titulo REGEXP ^.*keyword.*$" , nativeQuery = true)
	//@Query(value = "SELECT * FROM producto p WHERE REGEXP_LIKE (p.titulo, :regExp)", nativeQuery = true)
	@Query(value = "SELECT * FROM producto p WHERE (p.titulo REGEXP '^.*Barbie.*$'" , nativeQuery = true)
	List<Producto> findByKeyword(@Param("regExp") String regExp);
}