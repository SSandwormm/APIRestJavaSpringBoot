package com.aplication.Usuario.service;

import com.aplication.Usuario.model.Producto;
import com.aplication.Usuario.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repo;

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto guardar(Producto p) {
        return repo.save(p);
    }

    public Producto buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no existe"));
    }

    public Producto actualizar(Long id, Producto p) {
        Producto db = buscar(id);
        db.setNombre(p.getNombre());
        db.setPrecio(p.getPrecio());
        db.setStock(p.getStock());
        return repo.save(db);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
