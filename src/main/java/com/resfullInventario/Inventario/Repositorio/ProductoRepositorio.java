package com.resfullInventario.Inventario.Repositorio;

import com.resfullInventario.Inventario.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
