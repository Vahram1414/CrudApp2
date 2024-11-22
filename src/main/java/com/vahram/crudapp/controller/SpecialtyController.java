package com.vahram.crudapp.controller;

import com.vahram.crudapp.model.Specialty;
import com.vahram.crudapp.model.Specialty;
import com.vahram.crudapp.repository.*;
import com.vahram.crudapp.repository.SpecialtyRepository;
import com.vahram.crudapp.repository.SpecialtyRepository;

import java.util.List;

public class SpecialtyController {
    private final SpecialtyRepository specialtyRepository = new GsonSpecialtyRepositoryImpl();

    public List<Specialty> getAll() {

        return specialtyRepository.getAll();
    }

    public Specialty getSpecialty(int id) {

        return specialtyRepository.getById(id);
    }

    public Specialty createSpecialty(String name) {
        Specialty specialtyToCreate = new Specialty();
        specialtyToCreate.setName(name);
        return specialtyRepository.create(specialtyToCreate);
    }

    public Specialty updateSpecialty(int id, String name) {
        Specialty specialtyToUpdate = new Specialty();
        specialtyToUpdate.setId(id);
        specialtyToUpdate.setName(name);
        return specialtyRepository.update(specialtyToUpdate);
    }

    public void deleteSpecialty(int id) {

        specialtyRepository.deleteById(id);
    }
}
