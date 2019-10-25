package Test_2018_October;

public class Applicant {

    private String name;
    private int id;
    private TestResult result;

    /**
     * Skapar en sökande med med namnet name, idnumret id och testresultatet
     * result.
     */
    public Applicant(String name, int id, TestResult result) {

        this.name = name;
        this.id = id;
        this.result = result;
    }

    /**
     * Returnerar namnet.
     */
    public String getName() {

        return name;
    }

    /**
     * Returnerar id-numret
     */
    public int getId() {
        return id;
    }

    /**
     * Returnerar medelvärdet av poängen.
     */
    public double mean() {
        return result.mean();
    }
}
