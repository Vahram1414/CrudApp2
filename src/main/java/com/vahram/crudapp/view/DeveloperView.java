package com.vahram.crudapp.view;

import com.vahram.crudapp.controller.DeveloperController;
import com.vahram.crudapp.controller.SkillController;
import com.vahram.crudapp.controller.SpecialtyController;
import com.vahram.crudapp.model.Developer;
import com.vahram.crudapp.model.Skill;
import com.vahram.crudapp.model.Specialty;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

//через скилконтроллер и спешелтиконтроллер получить коллекции например, скилов,


public class DeveloperView {
    private final DeveloperController developerController = new DeveloperController();
    private final SkillController skillController = new SkillController();
    private final SpecialtyController specialtyController = new SpecialtyController();
    private final Scanner scanner = new Scanner(System.in);

    public void runMenu() {
        int userInput;
        while (true) {
            printMenu();
            userInput = getInput();
            performAction(userInput);
        }
    }

    private void printMenu() {
        System.out.println("Выберите операцию: ");
        System.out.println("1 - создания разработчика");
        System.out.println("2 - получения разработчика");
        System.out.println("3 - обновление разработчика");
        System.out.println("4 - удаление разработчика");
        System.out.println("5 - получение разработчиков");
        System.out.println("9 - Назад");
    }

    private int getInput() {
        Scanner sc = new Scanner(System.in);
        int userInput = -1;
        while (userInput < 0 || userInput > 9) {
            try {
                System.out.println("Введите цифру");
                userInput = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return userInput;
    }

    private void performAction(int userInput) {
        switch (userInput) {
            case 1:
                createDeveloper();
                break;
            case 2:
                getDeveloper();
                break;
            case 3:
                updateDeveloper();
                break;
            case 4:
                deleteDeveloper();
                break;
            case 5:
                getDevelopers();
                break;
            case 9:
                System.out.println("Back");
//                System.exit(0); эту стркоу удалить
                break;
        }
    }

    private void getDevelopers() {
        List<Skill> developers = skillController.getAll();
        System.out.println("Список скиллов" + developers);
    }

    private void createDeveloper() {
        System.out.println("Enter developer firstNname: ");
        String developerFirstName = scanner.nextLine();
        System.out.println("Enter developer lastNname: ");
        String developerLastName = scanner.nextLine();
        List<Specialty> specialties = specialtyController.getAll();
        out.println(specialties);
        out.println("Enter specialty id: ");
        Integer developerSpecialtId = scanner.nextInt();
        Specialty specialty = specialties.stream()
                .filter(specialty -> specialty.getId().equals(developerSpecialtId));

                //Получить из коллекции спешелтис объект спешелти у которого айди = девелоперспешелти Айди

        developerController.createDeveloper(developerFirstName, developerLastName, null,null);
    }

    private void updateDeveloper() {
        List<Developer> developers = developerController.getAll();
        out.println(developers);
        out.println("Укажите айди разраба");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        Developer updatedDeveloper = developerController.updateDeveloper(id, name);
        System.out.println("Обновленный разраб " + updatedDeveloper);

    }

    private void deleteDeveloper() {
        System.out.println("Enter Developer id");
        Integer skId = scanner.nextInt();
        developerController.deleteDeveloper(skId);
        out.println("Вы удалили скил " + skId);
    }

    private void getDeveloper() {
        System.out.println("Enter id");
        Integer developerId = scanner.nextInt();
        System.out.println("entered id: " + developerId);
        Developer currentDeveloper = developerController.getDeveloper(developerId);
        System.out.println("Developer: " + currentDeveloper);
    }
}
