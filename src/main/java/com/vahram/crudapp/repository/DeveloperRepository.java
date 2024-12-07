package com.vahram.crudapp.repository;

import com.vahram.crudapp.model.Developer;
import com.vahram.crudapp.model.Developer;
import com.vahram.crudapp.model.Skill;

public interface DeveloperRepository extends GenericRepository<Developer, Integer>{
    Developer developer(Developer developerToUpdate);
}
