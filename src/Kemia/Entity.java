package Kemia;

public class Entity {

    private String year;
    private String element;
    private String chemicalSign;
    private Integer chemicalIndex;
    private String explorer;

    public Entity(String year, String element, String chemicalSign, Integer chemicalIndex, String explorer) {
        this.year = year;
        this.element = element;
        this.chemicalSign = chemicalSign;
        this.chemicalIndex = chemicalIndex;
        this.explorer = explorer;
    }

    public String getYear() {
        return year;
    }

    public String getElement() {
        return element;
    }

    public String getChemicalSign() {
        return chemicalSign;
    }

    public Integer getChemicalIndex() {
        return chemicalIndex;
    }

    public String getExplorer() {
        return explorer;
    }
}
