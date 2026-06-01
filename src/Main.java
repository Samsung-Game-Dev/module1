import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9\u200D";
        int personLive = 3;

        String monster = "\uD83E\uDDDF\u200D";
        String castle = "\uD83C\uDFF0";
        int sizeBoard = 5;
        int personX = 1;
        int personY = sizeBoard;



        int step = 0;

        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }


        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        Random r = new Random();
        for (int i = 0; i <= countMonster; i++) {
            board[r.nextInt(sizeBoard - 1)][r.nextInt(sizeBoard)] = monster;
        }
        int castleX = r.nextInt(sizeBoard);
        int castleY = 0;


        board[castleY][castleX] = castle;

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);



        switch (answer) {
            case "ДА" -> {
                System.out.println("Выбери сложность игры(от 1 до 5):");
                int difficultGame = sc.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);

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

                            if (taskMonster(difficultGame)) {
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

    static boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            Random random = new Random();
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int trueAnswer = a + b;
            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
        } else {
            //допишем потом здесь еще игру, а пока пусть наш игрок проигрывает по умолчанию
            return false;
        }
        return false;
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


        System.out.println("Количество жизней:\t" + live + "\n");
    }
}
