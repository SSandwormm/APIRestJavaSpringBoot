package com.springboot.apiCRUD.controller;


import com.springboot.apiCRUD.model.Usuario;
import com.springboot.apiCRUD.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository repo;

    public UsuarioController(UsuarioRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        System.out.println("NOMBRE = " + usuario.getNombre());
        System.out.println("EMAIL = " + usuario.getEmail());

        return repo.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario u) {
        Usuario usuario = repo.findById(id).orElseThrow();
        usuario.setNombre(u.getNombre());
        usuario.setEmail(u.getEmail());
        return repo.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
