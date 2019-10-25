package Tests_2019_2;

public class Counter {

    char c;
    int n;

    /**
     * Skapa en räknare för tecknet c. Antalet är inledningsvis 0 (noll).
     */
    public Counter(char c) {
        this.c = c;
        this.n = 0;
    }

    /**
     * Tar reda på vilket tecken som räknas.
     */
    char getChar() {
        return this.c;
    }

    /**
     * Räknar en förekomst av tecknet, dvs öka antalet med ett.
     */
    void increase() {
        this.n++;
    }

    /**
     * Tar reda på antalet.
     */
    int getCount() {
        return n;
    }

    /**
     * Returnerar en sträng som beskriver tecknet och dess antal,
     * på formen "[S]: 27" (om tecknet ’S’ räknats 27 gånger).
     */
    public String toString(){
        return "[" + c + "]: " + n ;
    }
}
