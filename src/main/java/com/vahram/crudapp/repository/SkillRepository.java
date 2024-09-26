package com.vahram.crudapp.repository;

import com.vahram.crudapp.model.Skill;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SkillRepository {
    Skill getById(Integer id) throws IOException;

    List<Skill> getAll();

    Skill create(Skill skill) throws FileNotFoundException;

    Skill update (Skill skill) throws IOException;

    void deleteById(Integer id) throws IOException;
}

