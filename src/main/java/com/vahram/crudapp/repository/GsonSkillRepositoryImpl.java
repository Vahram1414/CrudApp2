package com.vahram.crudapp.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vahram.crudapp.model.Skill;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static javax.print.attribute.standard.MediaSizeName.D;

public class GsonSkillRepositoryImpl implements SkillRepository {
    @Override
    public Skill getById(Integer id) throws IOException {
        List<Skill> skillList = getAllSkillInternal();
        return skillList.stream().filter(skill -> skill.getId().equals(id))
        .findAny()
        .orElse(null);

    }

    @Override
    public List<Skill> getAll() {
        try {
            return getAllSkillInternal();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Skill create(Skill thisskill) {
        int max;
        int objId;
        try {
            List<Skill> skillList = getAllSkillInternal();
            max = skillList.stream().map(skill1 -> skill1.getId()).max(Math::max).get();
            objId = max + 1;
            thisskill.setId(objId);
            skillList.add(thisskill);
            writeSkillsInternal(skillList);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Skill update(Skill skill) throws IOException {
        //получить коллекцию скилов
        //среди них получить тот скилл, который имеет айдишник в переданном аргументе и если они совпадают, то заменить текущий скил на пришедший
        //записать его в файл коллекцию с замененным скилом и вернуть скилл
        List<Skill> skillList = getAllSkillInternal();
        for (Skill sks : skillList) {
            if (getAllSkillInternal().equals(skill.getId())) {
                skillList.remove(sks);
                skillList.add(skill);
                writeSkillsInternal(skillList);
                return skill;
            }
        }
        return null;
    }


    @Override
    public void deleteById(Integer id) throws IOException {
//        получить коллекцию скилов
//        удалить из коллекцию скилл у которого айди равен переданному
//        записать обновленную коллекцию без удаленног оскила в файл
        List<Skill> skillList = getAllSkillInternal();
        for (Skill sks : skillList) {
            if (getAllSkillInternal().equals(sks.getId())) {
                skillList.remove(sks);
            }
        }
        writeSkillsInternal(skillList);

    }


    private List<Skill> getAllSkillInternal() throws IOException {
        FileInputStream fisTargetFile = new FileInputStream(new File("D:\\Моя практика\\crudapp\\src\\main\\resources\\skills.json"));
        String targetFileStr = IOUtils.toString(fisTargetFile, "UTF-8");

        Type targetClassType = new TypeToken<ArrayList<Skill>>() {
        }.getType();
        List<Skill> targetCollection = new Gson().fromJson(targetFileStr, targetClassType);
        return targetCollection;
    }

    public void writeSkillsInternal(List<Skill> skills) throws IOException {

        Gson gson = new Gson();
        try (Writer writer = new FileWriter("D:\\Моя практика\\crudapp\\src\\main\\resources\\skills.json")) {

            gson.toJson(skills, writer);

        } catch (IOException e) {
            System.out.println("Test");
        }

    }
}
