package com.vahram.crudapp.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vahram.crudapp.model.Skill;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonSkillRepositoryImpl implements SkillRepository {
    private final static String FILE_PATH = "D:\\Моя практика\\crudapp\\src\\main\\resources\\skills.json";
    private final static String FILE_ENCODING = "UTF-8";

    private final static Gson GSON = new Gson();

    @Override
    public Skill getById(Integer id) {
        return getAllSkillsInternal().stream()
                .filter(skill -> skill.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Skill> getAll() {
        return getAllSkillsInternal();
    }

    @Override
    public Skill create(Skill skillToCreate) {
        List<Skill> skillList = getAllSkillsInternal();

        int generatedId = generateNewId(skillList);
        skillToCreate.setId(generatedId);
        skillList.add(skillToCreate);
        writeSkillsInternal(skillList);

        return skillToCreate;
    }

    @Override
    public Skill update(Skill skillToUpdate) {
        List<Skill> skills = getAllSkillsInternal().stream()
                .map(existingSkill -> {
                    if(existingSkill.getId().equals(skillToUpdate.getId())) {
                        return skillToUpdate;
                    }
                    return existingSkill;
                }).collect(Collectors.toList());

        writeSkillsInternal(skills);
        return skillToUpdate;
    }


    @Override
    public void deleteById(Integer id) {
        List<Skill> skillList = getAllSkillsInternal();
        skillList.removeIf(existingSkill -> existingSkill.getId().equals(id));
        writeSkillsInternal(skillList);
    }

    private Integer generateNewId(List<Skill> skills) {
        return skills.stream()
                .mapToInt(Skill::getId).max().orElse(0) + 1;
    }

    private List<Skill> getAllSkillsInternal() {
        try (FileInputStream fisTargetFile = new FileInputStream(FILE_PATH)) {
            String targetFileStr = IOUtils.toString(fisTargetFile, FILE_ENCODING);
            Type targetClassType = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            return GSON.fromJson(targetFileStr, targetClassType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void writeSkillsInternal(List<Skill> skills) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            GSON.toJson(skills, writer);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла");
        }
    }
}
