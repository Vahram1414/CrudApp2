package com.vahram.crudapp.controller;

import com.vahram.crudapp.model.Developer;
import com.vahram.crudapp.model.Developer;
import com.vahram.crudapp.model.Skill;
import com.vahram.crudapp.model.Specialty;
import com.vahram.crudapp.repository.DeveloperRepository;
import com.vahram.crudapp.repository.GsonDeveloperRepositoryImpl;
import com.vahram.crudapp.repository.GsonDeveloperRepositoryImpl;
import com.vahram.crudapp.repository.DeveloperRepository;

import java.util.List;

public class DeveloperController {
    private final DeveloperRepository developerRepository = new GsonDeveloperRepositoryImpl();

    SkillController skillController = new SkillController();

    public static SkillController getAllSkills() {
        getAllSkills().getAll();

        return null;
    }

    public List<Developer> getAll() {

        return developerRepository.getAll();
    }

    public Developer getDeveloper(int id) {

        return developerRepository.getById(id);
    }

    public Developer createDeveloper(String firstName, String lastName, List<Skill> skills, Specialty specialty) {
        Developer developerToCreate = new Developer();
        developerToCreate.setFirstName(firstName);
        developerToCreate.setLastName(lastName);
        developerToCreate.setSkills(skills);
        developerToCreate.setSpecialty(specialty);
        return developerRepository.create(developerToCreate);
    }

    public Developer updateDeveloper(int id, String newName) {
        Developer developerToUpdate = new Developer();
        developerToUpdate.setId(id);
        developerToUpdate.setFirstName(newName);
        developerToUpdate.setLastName(newName);
        return developerRepository.update(developerToUpdate);
    }

    public void deleteDeveloper(int id) {

        developerRepository.deleteById(id);
    }
}
