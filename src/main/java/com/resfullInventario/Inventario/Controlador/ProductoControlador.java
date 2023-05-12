package com.resfullInventario.Inventario.Controlador;

import com.resfullInventario.Inventario.Modelo.Producto;
import com.resfullInventario.Inventario.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return servicio.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> listarProductoById(@PathVariable Integer id) {
        try {
            Producto producto = servicio.obtenerPorductoPorId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/producto")
    public void crearProducto(@RequestBody Producto producto) {
        servicio.guardarProducto(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Producto productoExistente = servicio.obtenerPorductoPorId(id);
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            
            servicio.guardarProducto(productoExistente);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/producto/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        servicio.eliminarProducto(id);
    }

    @GetMapping("/prueba")
    public String listar() {
        return "hola prueba";
    }


}
