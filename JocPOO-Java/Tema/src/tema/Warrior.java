package tema;

import java.util.Random;

public class Warrior extends Character{

    public Warrior(String nume, int x, int y){
        this.nume = nume;

        this.listaAbilitati.add(new Earth());
        this.listaAbilitati.add(new Fire());
        this.listaAbilitati.add(new Ice());
        viataCurent = 100;
        manaCurent  = 100;

        viataMax = 100;
        manaMax = 100;

        putere = 100 + expCurent/8;
        carisma = 0 + expCurent/10;
        dexteritate = 50 + expCurent/10;

        expCurent = 0;
        levelCurent = 0;

        inventarPotiuni = new Inventory(100, 10);

        this.x = x;
        this.y = y;


        protectieEarth = false;
        protectieFire = true;
        protectieIce = false;
    }
    @Override
    void receiveDamage( int damage) {
        Random rand = new Random();
        int randInt = rand.nextInt(200);
        if ( randInt < carisma+dexteritate) damage/=2;

        viataCurent-=damage;
        if (viataCurent < 1) System.out.println("Warriorul cu numele "+ nume + " a murit. :(");

    }

    @Override
    int getDamage() {
        Random rand = new Random();
        int randInt = rand.nextInt(200);
        if  (randInt < putere) return putere*2/10;
        return putere/10;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "nume='" + nume + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", expCurent=" + expCurent +
                ", levelCurent=" + levelCurent +
                ", viataCurent=" + viataCurent +
                ", manaCurent=" + manaCurent +
                '}';
    }
}
