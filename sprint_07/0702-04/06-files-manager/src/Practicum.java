import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Practicum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                System.out.println("Выход.");
                break;
            }

            System.out.println("Введите путь к файлу/директории: ");
            String enteredPath = scanner.nextLine();
            Path path = Paths.get(enteredPath); // создайте переменную пути

            switch (command) {
                case "ls":
                    if (Files.exists(path) && Files.isDirectory(path)) {
                        if (Files.exists(path)) { // проверьте, не ошибся ли пользователь
                            try {
                                for (String element : path.toFile().list()) {
                                    System.out.println(element);
                                }
                            } catch (Exception e) {
                                System.out.println("Ошибка при запросе содержимого директории.");
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Указанная директория не существует.");
                        }
                        break;
                    }

                case "mkdir":
                    try {
                        Files.createDirectory(path);
                        System.out.println("Директория успешно создана.");
                    } catch (IOException e) {
                        System.out.println("Ошибка при создании директории.");
                        e.printStackTrace();
                    }
                    break;
                case "touch":
                    if (Files.exists(path)) { // проверьте, не ошибся ли пользователь
                        System.out.println("Файл уже существует.");
                    } else {
                        try {
                            Files.createFile(path);
                            System.out.println("Файл успешно создан.");
                        } catch (IOException e) {
                            System.out.println("Ошибка при создании файла.");
                            e.printStackTrace();
                        }
                    }
                    break;
                case "rename":
                    if (Files.exists(path)) { // проверьте, не ошибся ли пользователь
                        System.out.println("Введите новое имя файла/директории: ");
                        String newName = scanner.nextLine();

                        try {
                            Path newPath = path.resolveSibling(newName);
                            Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING); // с помощью опции StandardCopyOption.REPLACE_EXISTING
                            System.out.println("Файл/директория успешно переименованы.");
                        } catch (IOException e) {
                            System.out.println("Ошибка при переименовании.");
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Файл/директория не найдены.");
                    }
                    break;
                case "rm_file":
                    try {
                        if (Files.exists(path)) {
                            Files.deleteIfExists(path);
                            System.out.println("Файл удалён.");
                        } else {
                            System.out.println("Эта команда удаляет только файлы!");
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка при удалении файла.");
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Неизвестная команда.");
            }

        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("ls - посмотреть содержимое директории.");
        System.out.println("mkdir - создать директорию.");
        System.out.println("touch - создать файл.");
        System.out.println("rename - переименовать директорию/файл.");
        System.out.println("rm_file - удалить файл.");
        System.out.println("exit - выход.");
    }

}