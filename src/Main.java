import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9\u200D";
        int personLive = 3;

        String monster = "\uD83E\uDDDF\u200D";
        int sizeBoard = 3;
        int personX = 1;
        int personY = 3;

        int step = 0;
      
        String gamingField = "+ —— + —— + —— +\n"
                + "|    |    | \uD83C\uDFE0 |\n"
                + "+ —— + —— + —— +\n"
                + "|    | " + monster + " |    |\n"
                + "+ —— + —— + —— +\n"
                + "| " + person + " |    |    |\n"
                + "+ —— + —— + —— +";

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);



//        if (answer.equals("ДА")) {

//        System.out.println("Выбери сложность игры(от 1 до 5):");
//        int difficultGame = sc.nextInt();
//        System.out.println("Выбранная сложность:\t" + difficultGame);
//            System.out.println("Сколько жизней будет у персонажа?");
////            personLive = sc.nextInt(); // здесь необходимо рассказать о возможных ошибках(неверный тип, переполнение - еще раз и тд)
//            System.out.println(output_str);
//            System.out.println("Live:\t" + personLive + "\n");
//
//            System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
//                    "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + "))");
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            System.out.println(x + ", " + y);
//
//            // проверка
//            if (x != personX && y != personY) {
//                System.out.println("Неккоректный ход");
//            } else if (Math.abs(x - personX) == 1) {
//                personX = x;
//                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY);
//            } else if (Math.abs(y - personY) == 1) {
//                personY = y;
//                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY);
//            }else {
//                System.out.println("Координаты не изменены");
//            }
//
//        } else if (answer.equals("НЕТ")) {
//            System.out.println("Жаль, приходи еще!");
//        } else {
//            System.out.println("Данные введены неккоректно");
//        }

        switch (answer) {
            case "ДА" -> {
                System.out.println("Выбери сложность игры(от 1 до 5):");
                int difficultGame = sc.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);

                System.out.println(gamingField);
                System.out.println("Количество жизней:\t" + personLive + "\n");
                System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)" +
                        "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + "))");
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(x + ", " + y);

                // проверка
                if (x != personX && y != personY) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                    personX = x;
                    personY = y;
                    step++;
                    System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                            "\nХод номер: " + step);
                } else {
                    System.out.println("Координаты не изменены");
                }
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }
}
