import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] table;
        int currentPlayer = 1;
        int result;
        int [] move;
        table = tableInit();
        do
        {
            drawTable(table);
            move = getValidMove(sc, table, currentPlayer);
            makeMove(table, move, currentPlayer);
            result = checkWinner(table);
            currentPlayer = nextPlayer(currentPlayer);
        }
        while (result == 0);
        drawTable(table);
        displayWinner(result);
    }
    public static int [][] tableInit()
    {
        return new int [3][3];
    }
    public static void drawTable(int [][] table)
    {
        System.out.println("+-+-+-+");
        System.out.println(""
                + "|"+table[0][0]+"|"+table[0][1]+"|"+table[0][2]+"|");
        System.out.println("+-+-+-+");
        System.out.println(""
                + "|"+table[1][0]+"|"+table[1][1]+"|"+table[1][2]+"|");
        System.out.println("+-+-+-+");
        System.out.println(""
                + "|"+table[2][0]+"|"+table[2][1]+"|"+table[2][2]+"|");
        System.out.println("+-+-+-+");
    }
    public static int [] getValidMove(Scanner sc, int [][] table, int currentPlayer)
    {
        System.out.println("A(z) "+currentPlayer+"-es játékos következik.");
        System.out.println("Melyik sor?");
        int row = sc.nextInt();
        System.out.println("Melyik oszlop?");
        int column = sc.nextInt();
        while (row > 2 || row < 0 || column > 2 || column < 0)
        {
            System.out.println("Hibás mezőszám!");
            System.out.println("Melyik sor?");
            row = sc.nextInt();
            System.out.println("Melyik oszlop?");
            column = sc.nextInt();
        }
        while (table [row][column] == 1 || table [row][column] == 2)
        {
            System.out.println("Hibás mezőszám!");
            System.out.println("Melyik sor?");
            row = sc.nextInt();
            System.out.println("Melyik oszlop?");
            column = sc.nextInt();
        }
        int [] field = new int [2];
        field [0] = row;
        field [1] = column;
        return field;
    }
    public static void makeMove(int [][] table, int [] move, int currentPlayer)
    {

        table [move[0]][move[1]] = currentPlayer;

    }
    public static int checkWinner(int [][] table)
    {
        if (table[0][0] == 1 && table [0][1] == 1 && table[0][2] == 1 ||
                table[1][0] == 1 && table [1][1] == 1 && table[1][2] == 1 ||
                table[2][0] == 1 && table [2][1] == 1 && table[2][2] == 1 ||
                table[0][0] == 1 && table [1][0] == 1 && table[2][0] == 1 ||
                table[0][1] == 1 && table [1][1] == 1 && table[2][1] == 1 ||
                table[0][2] == 1 && table [1][2] == 1 && table[2][2] == 1 ||
                table[0][0] == 1 && table [1][1] == 1 && table[2][2] == 1 ||
                table[2][0] == 1 && table [1][1] == 1 && table[0][2] == 1
        )
        {
            return 1;
        }
        if (table[0][0] == 2 && table [0][1] == 2 && table[0][2] == 2 ||
                table[1][0] == 2 && table [1][1] == 2 && table[1][2] == 2 ||
                table[2][0] == 2 && table [2][1] == 2 && table[2][2] == 2 ||
                table[0][0] == 2 && table [1][0] == 2 && table[2][0] == 2 ||
                table[0][1] == 2 && table [1][1] == 2 && table[2][1] == 2 ||
                table[0][2] == 2 && table [1][2] == 2 && table[2][2] == 2 ||
                table[0][0] == 2 && table [1][1] == 2 && table[2][2] == 2 ||
                table[2][0] == 2 && table [1][1] == 2 && table[0][2] == 2
        )
        {
            return 2;
        }
        if (table[0][0] != 0 && table [0][1] != 0 && table[0][2] != 0 &&
                table[1][0] != 0 && table [1][1] != 0 && table[1][2] != 0 &&
                table[2][0] != 0 && table [2][1] != 0 && table[2][2] != 0 &&
                table[0][0] != 0 && table [1][0] != 0 && table[2][0] != 0 &&
                table[0][1] != 0 && table [1][1] != 0 && table[2][1] != 0 &&
                table[0][2] != 0 && table [1][2] != 0 && table[2][2] != 0 &&
                table[0][0] != 0 && table [1][1] != 0 && table[2][2] != 0 &&
                table[2][0] != 0 && table [1][1] != 0 && table[0][2] != 0
        )
        {
            return 3;
        }
        return 0;
    }
    public static int nextPlayer(int currentPlayer)
    {
        if (currentPlayer == 1)
            return 2;
        else
            return 1;
    }
    public static void displayWinner(int result)
    {
        if (result == 1)
        {
            System.out.println("Az 1-es játékos győzött.");
        }
        if (result == 2)
        {
            System.out.println("A 2-es játékos győzött.");
        }
        if (result == 3)
            System.out.println("Döntetlen!");
    }
}