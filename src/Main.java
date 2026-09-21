import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9";
        String monster = "\uD83E\uDDDF";
        
        int personLive = 3;
        int sizeBoard = 5;
        int personX;
        int personY;
        int step = 0;

        personX = 1;
        personY = sizeBoard;
        // \n, \t - спец символ
        String gamingField = "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    | " + monster + " |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "| " + person + " |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +";
        
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
            case "ДА":
                System.out.println("Выбери сложность игры (от 1 до 5):");
                int difficultGame = scanner.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);

                System.out.println(gamingField);
                System.out.println("Количество жизней:\t" + personLive + "\n");
                System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)" +
                        "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + ")");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.println(x + ", " + y);

                if (x != personX && y != personY) {
                    System.out.println("Некорректный ход");
                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                    personX = x;
                    personY = y;
                    step+=1;
                    System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                            "\nХод номер: " + step);
                } else {
                    System.out.println("Координаты не изменены");
                }
                break;
                
            case "НЕТ":
               System.out.println("Жаль, приходи еще!");
               break;
        
            default:
               System.out.println("Данные введены некорректно");
        }
    }
}
