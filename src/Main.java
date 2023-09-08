import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9\u200D";
        int personLive = 3;

        String monster = "\uD83E\uDDDF\u200D";
        String castle = "\uD83C\uDFF0";
        int size = 5;
        int personX = 1;
        int personY = size;



        int step = 0;

        String[][] board = new String[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                board[y][x] = "  ";
            }
        }


        int countMonster = size * size - size - 1;
        Random r = new Random();
        for (int i = 0; i <= countMonster; i++) {
            board[r.nextInt(size - 1)][r.nextInt(size)] = monster;
        }
        int castleX = r.nextInt(size);
        int castleY = 0;


        board[castleY][castleX] = castle;

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
            case "ДА" -> {
//
                int maxStep = 2;

                while (true) {
                    board[personY - 1][personX - 1] = person;

                    outputBoard(board, personLive);

                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                            "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + "))");
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    // проверка
                    if (x != personX && y != personY) {
                        System.out.println("Неккоректный ход");
                    } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                        step++;
                        if (board[y - 1][x - 1].equals("  ")) {
                            board[personY - 1][personX - 1] = "  ";
                            personX = x;
                            personY = y;
                            System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                                    "\nХод номер: " + step);
                        } else {
                            System.out.println("Решите задачу:");
                            int key = r.nextInt(2);
                            if (taskMonster(0)) {
                                board[personY - 1][personX - 1] = "  ";
                                personX = x;
                                personY = y;


                            } else {
                                personLive--;
                            }
                        }
                    } else {
                        System.out.println("Координаты не изменены");
                    }

                    if (personLive <= 0) {
                        break;
                    }
                }

                System.out.println("Закончились жизни. Итог: ...");
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }

    static boolean taskMonster(int key) {
        if (key == 0) {
            Random r = new Random();
            int x = r.nextInt(100);
            int y = r.nextInt(100);
            int trueAnswer = x + y;
            System.out.println("Реши пример: " + x + " + " + y + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
//
        } else {
//            //тут можно вставить игру быки-коровы, но я не успеваю..
            return false;
        }
    }


    static void outputBoard(String[][] board, int live) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] raw : board) {
            System.out.println(wall);
            for (String col : raw) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);


        System.out.println("Live:\t" + live + "\n");
    }
}