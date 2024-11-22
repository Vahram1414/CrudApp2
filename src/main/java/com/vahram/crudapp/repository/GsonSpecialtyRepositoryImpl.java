package com.vahram.crudapp.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vahram.crudapp.model.Skill;
import com.vahram.crudapp.model.Specialty;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {
    private final static String FILE_PATH = "D:\\Моя практика\\crudapp\\src\\main\\resources\\skills.json";
    private final static String FILE_ENCODING = "UTF-8";

    private final static Gson GSON = new Gson();

    @Override
    public Specialty getById(Integer id) {
        return getAllSpecialtiesInternal().stream()
                .filter(specialty -> specialty.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Specialty> getAll() {
        return getAllSpecialtiesInternal();
    }

    @Override
    public Specialty create(Specialty specialtyToCreate) {
        List<Specialty> specialtyList = getAllSpecialtiesInternal();

        int generatedId = generateNewId(specialtyList);
        specialtyToCreate.setId(generatedId);
        specialtyList.add(specialtyToCreate);
        writeSpecialtiesInternal(specialtyList);

        return specialtyToCreate;
    }

    @Override
    public Specialty update(Specialty specialtyToUpdate) {
        List<Specialty> specialties = getAllSpecialtiesInternal().stream()
                .map(existingSpecialty -> {
                    if(existingSpecialty.getId().equals(specialtyToUpdate.getId())) {
                        return specialtyToUpdate;
                    }
                    return existingSpecialty;
                }).collect(Collectors.toList());

        writeSpecialtiesInternal(specialties);
        return specialtyToUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        List<Specialty> specialtyList = getAllSpecialtiesInternal();
        specialtyList.removeIf(existingSpecialty -> existingSpecialty.getId().equals(id));
        writeSpecialtiesInternal(specialtyList);
    }

    private Integer generateNewId(List<Specialty> specialties) {
        return specialties.stream()
                .mapToInt(Specialty::getId).max().orElse(0) + 1;
    }

    private List<Specialty> getAllSpecialtiesInternal() {
        try (FileInputStream fisTargetFile = new FileInputStream(FILE_PATH)) {
            String targetFileStr = IOUtils.toString(fisTargetFile, FILE_ENCODING);
            Type targetClassType = new TypeToken<ArrayList<Specialty>>() {
            }.getType();
            return GSON.fromJson(targetFileStr, targetClassType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void writeSpecialtiesInternal(List<Specialty> specialties) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            GSON.toJson(specialties, writer);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла");
        }
    }
}
