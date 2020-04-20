package com.example.webapp.demo.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;

public class CowSpot {

    static int n;
    static int m;
    static char[][] field;

    public static void main(String[] args) throws FileNotFoundException {
        int inputNumber = 8;

        String inputFileName = "DATA/pageant_bronze/I." + inputNumber;
        Scanner scanner = new Scanner(new File(inputFileName));

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        field = new char[n][];
        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }

        Collection<Cell> spot1 = findSpot();
        Collection<Cell> spot2 = findSpot();

        int globalMin = Integer.MAX_VALUE;
        for ( Cell  cell1: spot1){
            for (Cell cell2: spot2){
                int distance = Math.abs(cell1.x-cell2.x) + Math.abs(cell1.y-cell2.y) - 1;

                if (distance < globalMin){
                    globalMin = distance;
                }
            }
        }

        System.out.println(globalMin);
    }

    private static Collection<Cell> findSpot() {
        // find where to start;
        boolean found = false;
        int x = 0, y = 0;
        loop1:
        for (x = 0; x < n; x++) {
            for (y = 0; y < m; y++) {
                if (field[x][y] == 'X') {
                    found = true;
                    break loop1;
                }
            }
        }

        if (!found) {
            throw new RuntimeException("should not happen");
        }

        Set<Cell> result = new LinkedHashSet<>();

        Set<Cell> front = new LinkedHashSet<>();
        front.add(new Cell(x, y));
        field[x][y] = 'o';


        while (!front.isEmpty()) {
            result.addAll(front);
            Set<Cell> newFront = new LinkedHashSet<>();

            front.forEach(cell -> {
                newFront.addAll(getAllNeigbbors(cell));
            });

            front = newFront;
        }

        return result;
    }

    private static Collection<Cell> getAllNeigbbors(Cell cell) {
        Set<Cell> neighbors = new LinkedHashSet<>();

        tryToAdd(neighbors, cell.x - 1, cell.y);
        tryToAdd(neighbors, cell.x + 1, cell.y);
        tryToAdd(neighbors, cell.x, cell.y + 1);
        tryToAdd(neighbors, cell.x, cell.y - 1);

        return neighbors;
    }

    private static void tryToAdd(Set<Cell> neighbors, int x, int y) {
        if ((x < 0) || (y < 0) || (x >= n) || (y >= m)) {
            return;
        }

        if (field[x][y] != 'X') {
            return;
        }

        neighbors.add(new Cell(x, y));
        field[x][y] = 'o';

    }


    static void outputField() {
        for (int i = 0; i < n; i++) {
            System.out.println(new String(field[i]));
        }
    }


}

class Cell {
    public int x, y;

    public Cell(int x, int y) {
        this.x = x;
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


    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}