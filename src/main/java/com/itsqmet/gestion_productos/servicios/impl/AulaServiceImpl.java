package com.itsqmet.gestion_productos.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.gestion_productos.modelos.Aula;
import com.itsqmet.gestion_productos.repositorios.AulaRepository;
import com.itsqmet.gestion_productos.servicios.AulaService;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    AulaRepository aulaRepository;

    // Implemantación de los métodos generados en AulaService
    // Guardar
    @Override
    public Aula saveAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    // Modificar
    @Override
    public Aula updateAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    // Listar todos los objetos
    @Override
    public List<Aula> getAulas() {
        return aulaRepository.findAll();
    }

    // Listar los objetos por ID
    @Override
    public Optional<Aula> getAulaById(int idAula) {
        return aulaRepository.findById(idAula);
    }

    // Eliminar
    @Override
    public void deleteAula(int idAula) {
        aulaRepository.deleteById(idAula);
    }

}
