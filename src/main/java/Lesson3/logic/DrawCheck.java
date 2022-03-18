
package Lesson3.logic;

import Lesson3.body.Cell;
import Lesson3.body.Maps;

public class DrawCheck {
    public boolean check() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Maps.isEmpty(new Cell(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}