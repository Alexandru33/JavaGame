package tema;

import java.util.Random;

public class Rogue extends Character {
    public Rogue(String nume,int x,int y){
        this.nume = nume;

        this.listaAbilitati.add(new Earth());
        this.listaAbilitati.add(new Fire());
        this.listaAbilitati.add(new Ice());
        viataCurent = 100;
        manaCurent  = 100;

        viataMax = 100;
        manaMax = 100;

        putere = 50 + expCurent/10;
        carisma = 25 + expCurent/10;
        dexteritate = 75 + expCurent/10;


        expCurent = 0;
        levelCurent = 0;

        inventarPotiuni = new Inventory(50, 15);

        this.x = x;
        this.y = y;


        protectieEarth = true;
        protectieFire = false;
        protectieIce = false;
    }
    @Override
    void receiveDamage( int damage) {
        Random rand = new Random();
        int randInt = rand.nextInt(200);
        if ( randInt < carisma+putere) damage/=2;

        viataCurent-=damage;
        if (viataCurent < 1) System.out.println("Rogue-ul cu numele "+ nume + " a murit. :(");

    }

    @Override
    int getDamage() {
        Random rand = new Random();
        int randInt = rand.nextInt(200);
        if  (randInt < dexteritate) return dexteritate*3/20;
        return dexteritate;
    }

    public String toString() {
        return "Rogue{" +
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
