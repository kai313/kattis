import java.util.Arrays;

public class PlantingTrees {
    Kattio io = new Kattio(System.in, System.out);
    int [] trees;
    int numberOfSeeds;
    public static void main(String[] args) {
        new PlantingTrees();
    }

    PlantingTrees() {
        handleInput();
        System.out.println(daysUntilParty());
        io.close();
    }

    int daysUntilParty() {
        Arrays.sort(trees);
        int daysUntilParty = 2;
        int daysLeft = 0;
        int i = 0;
        for(int day = numberOfSeeds-1; day >= 0; day--) {
            trees[day] -= numberOfSeeds - i;
            daysUntilParty++;
            i++;
        }
        for(int day = numberOfSeeds-1; day >= 0; day--) {
            if (trees[day] > daysLeft)
                daysLeft = trees[day];
        }
        daysUntilParty += daysLeft;
        return daysUntilParty;
    }

    void handleInput() {
        numberOfSeeds = io.getInt();
        trees = new int[numberOfSeeds];
        for(int day = 0; day < numberOfSeeds; day++) {
            trees[day] = io.getInt();
        }
    }
}