package Kemia;

public class App {
    public static void main(String[] args) {
        Task taskObj = new Task();
        taskObj.fileRead("felfedezesek.csv");

        // 3. feladat
        System.out.println(taskObj.howManyData());

        // 4. feladat
        taskObj.ancientTimeExplored();

        // 5, 6 feladat
        taskObj.askChemicalSign();

        // 7. feladat
        taskObj.mostTimeBetweenTwoElementDiscover();

        // 8. feladat
        taskObj.statistics();
    }
}
