package all;

import java.util.*;

/**
 * Created by ksama on 2/14/2016.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        HashMap<Integer,Set<Character>> rowMap = new HashMap<Integer, Set<Character>>();
        HashMap<Integer,Set<Character>> columnMap = new HashMap<Integer, Set<Character>>();
        HashMap<Integer,Set<Character>> gridMap = new HashMap<Integer, Set<Character>>();
        for(int i=0;i<9;i++){
            rowMap.put(i,new HashSet<Character>());
            columnMap.put(i,new HashSet<Character>());
            gridMap.put(i,new HashSet<Character>());
        }
        List<Position> emptyCells = new LinkedList<Position>();
       for(int i=0;i<board.length;i++){
           for(int j =0; j<board.length;j++){
              if(board[i][j] == '.'){
                  emptyCells.add(new Position(i,j));
              } else{
                  Set<Character> rowSet=rowMap.get(i);
                  Set<Character> columnSet=columnMap.get(j);
                  Set<Character> gridSet = gridMap.get(3*(i/3)+j/3);
                  rowSet.add(board[i][j]);
                  columnSet.add(board[i][j]);
                  gridSet.add(board[i][j]);
              }

           }
       }
        int w=0;
        while(w<100){
            for(int i=0;i<emptyCells.size();i++){
               Position empty = emptyCells.get(i);
                HashSet<Character> characters = new HashSet<Character>();
                for(int j=1;j<10;j++){
                    characters.add(String.valueOf(j).charAt(0));
                }
                Set<Character> chars = rowMap.get(empty.x);
                if(chars!=null){
                   for(char ch:chars){
                       characters.remove(ch);
                   }
                }
                chars = columnMap.get(empty.y);
                if(chars!=null){
                    for(char ch:chars){
                        characters.remove(ch);
                    }
                }
                chars = gridMap.get(3*(empty.x/3)+empty.y/3);
                if(chars!=null){
                    for(char ch:chars){
                        characters.remove(ch);
                    }
                }
                if(characters.size() == 1){
                    for(char ch:characters){
                        board[empty.x][empty.y] = ch;
                        rowMap.get(empty.x).add(ch);
                        columnMap.get(empty.y).add(ch);
                        gridMap.get(3*(empty.x/3)+empty.y/3).add(ch);
                    }
                    emptyCells.remove(i);

                }


            }
            w++;
       }
    }

    public class Position{
        int x,y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]){
       char[][] board =  {"..9748...".toCharArray(),
                          "7........".toCharArray(),
                          ".2.1.9...".toCharArray(),
                          "..7...24.".toCharArray(),
                          ".64.1.59.".toCharArray(),
                          ".98...3..".toCharArray(),
                          "...8.3.2.".toCharArray(),
                          "........6".toCharArray(),
                          "...2759..".toCharArray()};

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+"   ");
            }
            System.out.println();
        }

        System.out.println("=====================================");

        new SudokuSolver().solveSudoku(board);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
