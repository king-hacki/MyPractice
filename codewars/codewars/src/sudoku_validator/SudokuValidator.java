package sudoku_validator;

import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.*;

public class SudokuValidator {

    private final int[][] sudoku;

    public SudokuValidator(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public boolean check() {
        return validate3x3Square() && validateHorizontalAndVerticalLines();
    }

    private boolean validate3x3Square() {
        return startCellsRows0_3_6()
                .allMatch(row -> cellIndexesByFirstRow(row)
                        .map(cellIndex -> columnByRowAndCell(row, cellIndex))
                        .mapToObj(column -> arrayFrom3x3CellByStartedRowAndColumn(row, column))
                        .allMatch(this::validateArray));
    }

    private IntStream startCellsRows0_3_6() {
        return iterate(0, row -> row + 3).limit(3);
    }

    private IntStream cellIndexesByFirstRow(int firstRowInCell) {
        int lastRowInCell = firstRowInCell + 2;
        return rangeClosed(firstRowInCell, lastRowInCell);
    }

    private int columnByRowAndCell(int row, int cellIndex) {
        return (cellIndex - row) * 3;
    }

    private boolean validateHorizontalAndVerticalLines() {
        return range(0, 9).allMatch(i ->
                validateArray(arrayFromHorizontalLineWithIndex(i)) &&
                validateArray(arrayFromVerticalLineWithIndex(i)));
    }

    private int[] arrayFrom3x3CellByStartedRowAndColumn(int row, int column) {
        return range(0, 9)
                .map(i -> sudoku[row + rowAdder(i)][column + columnAdder(i)])
                .toArray();
    }

    private int columnAdder(int i) {
        return i - i/3 * 3;
    }

    private int rowAdder(int i) {
        return i / 3;
    }

    private int[] arrayFromHorizontalLineWithIndex(int index) {
        return stream(sudoku[index], 0, 9).toArray();
    }

    private int[] arrayFromVerticalLineWithIndex(int index) {
        return range(0, 9).map(j -> sudoku[j][index]).toArray();
    }

    private boolean validateArray(int[] line) {
        return  isValidCountOfNumbers(line) && isArrayContainAllNumbers(line);
    }

    private boolean isValidCountOfNumbers(int [] line) {
        return line.length == 9;
    }

    private boolean isArrayContainAllNumbers(int [] line) {
        return rangeClosed(1, 9).allMatch(index -> of(line)
                .anyMatch(element -> element == index));
    }
}




