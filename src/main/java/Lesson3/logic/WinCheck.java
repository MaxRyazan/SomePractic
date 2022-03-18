package Lesson3.logic;

import Lesson3.body.Cell;
import Lesson3.body.Maps;

public class WinCheck {

    private boolean winCheckByRows(final char symbol) {
        for (int i = 0; i < 3; i++) {
            if (Maps.getSymbol(new Cell(i, 0)) == Maps.getSymbol(new Cell(i, 1)) &&
                    Maps.getSymbol(new Cell(i, 1)) == Maps.getSymbol(new Cell(i, 2)) &&
                    Maps.getSymbol(new Cell(i, 2)) == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean winCheckByCols(final char symbol) {
        for (int i = 0; i < 3; i++) {
            if (Maps.getSymbol(new Cell(0, i)) == Maps.getSymbol(new Cell(1, i)) &&
                    Maps.getSymbol(new Cell(1, i)) == Maps.getSymbol(new Cell(2, i)) &&
                    Maps.getSymbol(new Cell(2, i)) == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean winCheckByDiagonalOne(final char symbol) {
        return Maps.getSymbol(new Cell(0, 0)) == Maps.getSymbol(new Cell(1, 1)) &&
                Maps.getSymbol(new Cell(1, 1)) == Maps.getSymbol(new Cell(2, 2)) &&
                Maps.getSymbol(new Cell(2, 2)) == symbol;

    }

    private boolean winCheckByDiagonalTwo(final char symbol) {
        return Maps.getSymbol(new Cell(0, 2)) == Maps.getSymbol(new Cell(1, 1)) &&
                Maps.getSymbol(new Cell(1, 1)) == Maps.getSymbol(new Cell(2, 0)) &&
                Maps.getSymbol(new Cell(2, 0)) == symbol;
    }

    private boolean winCheck(final char symbol) {
        return winCheckByCols(symbol) ||
                winCheckByRows(symbol) ||
                winCheckByDiagonalOne(symbol) ||
                winCheckByDiagonalTwo(symbol);
    }

    public boolean uisUerWin(String symbol) {
        return winCheck(symbol.charAt(0));
    }
}