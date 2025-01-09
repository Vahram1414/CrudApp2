package com.vahram.crudapp.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vahram.crudapp.model.Developer;
import com.vahram.crudapp.model.Skill;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository{
    private final static String FILE_PATH = "D:\\Моя практика\\crudapp\\src\\main\\resources\\developer.json";
    private final static String FILE_ENCODING = "UTF-8";

    private final static Gson GSON = new Gson();

    @Override
    public Developer getById(Integer id) {
        return getAllDevelopersInternal().stream()
                .filter(developer -> developer.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Developer> getAll() {
        return getAllDevelopersInternal();
    }

    @Override
    public Developer create(Developer developerToCreate) {
        List<Developer> developerList = getAllDevelopersInternal();

        int generatedId = generateNewId(developerList);
        developerToCreate.setId(generatedId);
        developerList.add(developerToCreate);
        writeDevelopersInternal(developerList);

        return developerToCreate;
    }

    @Override
    public Developer update(Developer devloperToUpdate) {
        List<Developer> developers = getAllDevelopersInternal().stream()
                .map(existingDeveloper -> {
                    if(existingDeveloper.getId().equals(devloperToUpdate.getId())) {
                        return devloperToUpdate;
                    }
                    return existingDeveloper;
                }).collect(Collectors.toList());

        writeDevelopersInternal(developers);
        return devloperToUpdate;
    }


    @Override
    public void deleteById(Integer id) {
        List<Developer> developerList = getAllDevelopersInternal();
        developerList.removeIf(existingDeveloper -> existingDeveloper.getId().equals(id));
        writeDevelopersInternal(developerList);
    }

    private Integer generateNewId(List<Developer> developers) {
        return developers.stream()
                .mapToInt(Developer::getId).max().orElse(0) + 1;
    }

    private List<Developer> getAllDevelopersInternal() {
        try (FileInputStream fisTargetFile = new FileInputStream(FILE_PATH)) {
            String targetFileStr = IOUtils.toString(fisTargetFile, FILE_ENCODING);
            Type targetClassType = new TypeToken<ArrayList<Developer>>() {
            }.getType();
            return GSON.fromJson(targetFileStr, targetClassType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void writeDevelopersInternal(List<Developer> developers) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            GSON.toJson(developers, writer);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла");
        }
    }

    @Override
    public Developer developer(Developer developerToUpdate) {
        return null;
    }
}
