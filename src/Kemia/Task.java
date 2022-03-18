package Kemia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task {
    List<Entity> chemical = new ArrayList<Entity>();
    FileManager fmObj = new FileManager();

    public void fileRead(String fileName) {
        chemical = fmObj.fileRead(fileName);
    }

    public Integer howManyData() {
        return chemical.size();
    }

    public void ancientTimeExplored() {
        long amount = chemical.stream().filter(x -> x.getYear().equals("Ókor")).count();
        System.out.println("Felfedezések száma az Ókorban: " + amount);
    }

    public void askChemicalSign() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Kérek egy vegyjelet: ");
            String askedChemicalSign = br.readLine();
            while (!((askedChemicalSign.length() == 1 || askedChemicalSign.length() == 2) && askedChemicalSign.matches(".*[a-zA-Z]+.*[a-zA-Z]"))) {
                System.out.println("Kérek egy vegyjelet: ");
                askedChemicalSign = br.readLine();
            }
            int index = 0;
            boolean isThere = false;
            for (int i = 0; i < chemical.size(); i++) {
                if (chemical.get(i).getChemicalSign().toLowerCase().contains(askedChemicalSign.toLowerCase()) ||
                        chemical.get(i).getChemicalSign().toUpperCase().contains(askedChemicalSign.toUpperCase()) ||
                        chemical.get(i).getChemicalSign().equals(askedChemicalSign)) {
                    isThere = true;
                    index = i;
                    break;
                } else {
                    isThere = false;
                }
            }
            if (isThere) {
                System.out.println("6. feladat: Keresés");
                System.out.println("Az elem vegyjele: " + chemical.get(index).getChemicalSign());
                System.out.println("Az elem neve: " + chemical.get(index).getElement());
                System.out.println("Rendszáma: " + chemical.get(index).getChemicalIndex());
                System.out.println("Felfedezés éve: " + chemical.get(index).getYear());
                System.out.println("Felfedező: " + chemical.get(index).getExplorer());
            } else {
                System.out.println("Keresés");
                System.out.println("Nincs ilyen elem az adatforrásban!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostTimeBetweenTwoElementDiscover() {
        int mostTime = 0;
        for (int i = 0; i < chemical.size()-1; i++) {
            if (!chemical.get(i).getYear().equals("Ókor")) {
                if (Integer.parseInt(chemical.get(i + 1).getYear()) - Integer.parseInt(chemical.get(i).getYear()) > mostTime) {
                    mostTime = Integer.parseInt(chemical.get(i + 1).getYear()) - Integer.parseInt(chemical.get(i).getYear());
                }
            }
        }
        System.out.println(mostTime + " év volt a leghosszabb időszak két elem felfedezése között.");
    }

    public void statistics() {
        Map<String, Integer> discoveries = new HashMap<String, Integer>();
        for (int i = 0; i < chemical.size(); i++) {
            if (!chemical.get(i).getYear().equals("Ókor")) {
                discoveries.put(chemical.get(i).getYear(), discoveries.getOrDefault(chemical.get(i).getYear(), 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : discoveries.entrySet()) {
            if (entry.getValue() > 3) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " db");
            }
        }
    }

}
