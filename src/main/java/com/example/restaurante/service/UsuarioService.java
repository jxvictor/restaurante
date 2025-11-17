package com.example.restaurante.service;

import com.example.restaurante.model.Usuario;
import com.example.restaurante.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
