import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Game {
    private String [][] board = new String[3][3];
    private String XOmark;
    private CPlayer _one;
    private CPlayer _two;
    private PrintWriter in1;
    private BufferedReader out1;
    private PrintWriter in2;
    private BufferedReader out2;


    public Game(CPlayer one,CPlayer two){
        _one=one;
        _two=two;
        try {
            in1 = new PrintWriter(_one.getClient().getOutputStream());
            in2 = new PrintWriter(_two.getClient().getOutputStream());
            in1.println("You are Player One with X");
            in2.println("You are Player two with O");
        }catch (IOException g){
            g.printStackTrace();
        }
        clear();
        XOmark="X";
    }

    public void clear(){
        for (int i =0;i<3;i++){
            for (int j =0;j<3;j++){
                board[i][j]="-";
            }
        }
    }

    public void print(){
        System.out.println("*************");
        for (int i=0;i<3;i++){
            System.out.print("| ");
            for (int j=0;j<3;j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("");
            System.out.println("*************");
        }
    }

    public void printToPlayer(){
        in1.println("*************");
        in2.println("*************");
        for (int i=0;i<3;i++){
            in1.print("| ");
            in2.print("| ");
            for (int j=0;j<3;j++){
                in1.print(board[i][j] + " | ");
                in2.print(board[i][j] + " | ");
            }
            in1.println("");
            in2.println("");
            in1.println("*************");
            in2.println("*************");
        }
    }

    public boolean movesMaxed() {
        boolean check = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("-")) {
                    check = false;
                }
            }
        }
        return check;
    }

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    private boolean checkRowCol(String one, String two, String three) {
        return (!(one.equals("-")) && (one.equals(two)) && (two.equals(three)));
    }

    public void changePlayer() {
        if (XOmark.equals("X")) {
            XOmark = "O";
            in2.println("Player 2 it is your turn to play");
        }
        else {
            XOmark = "X";
            in1.println("Player 1 it is your turn to play");
        }
    }

    public boolean placeMark(int row, int col) {

        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col].equals("-")) {
                    board[row][col] = XOmark;
                    return true;
                }
            }
        }

        return false;
    }

    public String getCurrentPlayerMark()
    {
        return XOmark;
    }

}
