package Tests_2019_3;

public class SpiralMatrix {
    private int[][] mat;

    /**
     * Skapar en spiralmatris av storlek size x size
     */
    public SpiralMatrix(int size) {
        mat = new int[size][size];
            /* fyller en hel spiralmatris genom att upprepade gånger anropa
            metoden fillBorder */
    }

    /**
     * Fyller yttervarvet i delspiralmatrisen av storlek sideLen x sideLen
     * med startvärdet startValue i position [startPosition][startPosition]
     */
    private void fillBorder(int startValue, int sideLen, int startPosition) {

    }
}
