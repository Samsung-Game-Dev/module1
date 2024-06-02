import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static HashMap<String, Pair> steps = new HashMap<>();
    private static  void print(String str) {
        System.out.println(str);
    };
    public static void main(String[] args) {
        steps.put("w", new Pair(0, -1));
        steps.put("a", new Pair(-1, 0));
        steps.put("s", new Pair(0, 1));
        steps.put("d", new Pair(1, 0));

        steps.put("ц", new Pair(0, -1));
        steps.put("ф", new Pair(-1, 0));
        steps.put("ы", new Pair(0, 1));
        steps.put("в", new Pair(1, 0));


        int sizeBoard = 5;

        Person person = new Person(sizeBoard);


        int step = 0;
        Random r = new Random();

        System.out.println();

        Cell[][] board = new Cell[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                if (r.nextInt(10) == 0) {
                    board[y][x] = new Mountain();

                } else {
                    board[y][x] = new EmptyCell();


                }
            }
        }


        int countMonster = sizeBoard * sizeBoard - sizeBoard - 10;
//        countMonster = 0;

        // для работы сбольшим количеством монстров воспользуемся массивом
        Monster[] arrMonster = new Monster[countMonster + 1];
        int count = 0;
        Monster test;
        while (count <= countMonster){
            if (r.nextBoolean()) {
                test = new Monster(sizeBoard);
            }else {
                test = new BigMonster(sizeBoard);
            }
            if (board[test.getY()][test.getX()] instanceof EmptyCell){
                board[test.getY()][test.getX()] = test;
                arrMonster[count] = test;
                count++;
            }

        }

        int castleX = r.nextInt(sizeBoard);
        int castleY = 0;


        board[castleY][castleX] = new Castle();

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);




        switch (answer) {
            case "ДА" -> {
                System.out.println("Выбери сложность игры(от 1 до 5):");
                int difficultGame = sc.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);
                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person;
                    outputBoard(board, person.getLive());
                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
//                    int x = sc.nextInt();
//                    int y = sc.nextInt();
                    if (person.getLive() <= 0) {
                        System.out.println("Вы погибли");
                        break;
                    }
                    String input = sc.nextLine().strip().toLowerCase();
                    Pair pair = steps.getOrDefault(input, new Pair(0, 0));
                    int x = person.x + pair.getX();
                    int y = person.y + pair.getY();
                    // проверка
                    if (person.moveCorrect(x, y)) {
                        Cell next = board[y - 1][x - 1];
                        if (next instanceof Capturable capturable) {
                            if (capturable.capture(difficultGame, person)) {
                                board[person.getY() - 1][person.getX() - 1] = new EmptyCell();
                                person.move(x, y);
                                if (next instanceof Castle) {
                                    System.out.println("Победа");
                                    break;
                                }
                            }
                        }

                    } else {
                        System.out.println("Неккоректный ход");
                    }
                }
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }

    static void outputBoard(Cell[][] board, int live) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (Cell[] raw : board) {
            System.out.println(wall);
            for (Cell col : raw) {
                System.out.print(leftBlock + col.getImage() + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);


        System.out.println("Количество жизней:\t" + live + "\n");
    }
}