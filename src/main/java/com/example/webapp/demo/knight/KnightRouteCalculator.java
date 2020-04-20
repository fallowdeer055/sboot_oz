package com.example.webapp.demo.knight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KnightRouteCalculator {

    private static final int BOARD_SIZE = 8;
    private boolean[][] visited = new boolean[BOARD_SIZE][BOARD_SIZE];
    private List<Cell> route = new ArrayList<>();
    private boolean solutionFound = false;


    public KnightRouteCalculator() {
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                visited[i][j] = false;
            }
        }
    }


    public void recVisit(Cell c) {

        visited[c.getX()][c.getY()] = true;
        route.add(c);

        if (finalConditionsReached()) {
            solutionFound = true;
            return;
        }

        for (Cell nextCell : getPossibleStepsFrom(c)) {
            recVisit(nextCell);
            if (solutionFound) {
                return;
            }
        }

        visited[c.getX()][c.getY()] = false;
        route.remove(route.size() - 1);
    }

    private boolean finalConditionsReached() {
        return route.size() == BOARD_SIZE * BOARD_SIZE &&

                getPotentialStepsFrom(route.get(0)).contains(
                        route.get(route.size() - 1)
                );
    }


    public List<Cell> getPossibleStepsFrom(Cell c) {

        return getPotentialStepsFrom(c).stream()
                .filter(
                        cell -> cell.getX() >= 0 && cell.getY() >= 0 &&
                                cell.getX() < BOARD_SIZE && cell.getY() < BOARD_SIZE
                )
                .filter(
                        cell -> !visited[cell.getX()][cell.getY()]
                )
                .collect(Collectors.toList());
    }

    public List<Cell> getPotentialStepsFrom(Cell c) {
        return Arrays.asList(
                new Cell(c.getX() + 1, c.getY() + 2),
                new Cell(c.getX() + 1, c.getY() - 2),
                new Cell(c.getX() - 1, c.getY() + 2),
                new Cell(c.getX() - 1, c.getY() - 2),
                new Cell(c.getX() + 2, c.getY() + 1),
                new Cell(c.getX() + 2, c.getY() - 1),
                new Cell(c.getX() - 2, c.getY() + 1),
                new Cell(c.getX() - 2, c.getY() - 1)
        );
    }


    public void printBoard() {

        if (solutionFound) {

            String[][] boardToPrint = new String[BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < route.size(); i++) {
                Cell c = route.get(i);
                boardToPrint[c.getX()][c.getY()] = String.format(" %2d", i);
            }

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    System.out.print(boardToPrint[i][j]);
                }
                System.out.println();
            }

        } else {
            System.out.println("No solution found");
        }
    }


    public static void main(String[] args) {

        KnightRouteCalculator knightRouteCalculator = new KnightRouteCalculator();

        knightRouteCalculator.recVisit(new Cell(3, 3));

        knightRouteCalculator.printBoard();

    }


}

class Cell {
    private int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
