package tema;

import java.util.Random;

public class Mage extends Character{
    public Mage(String nume,int x, int y){
        this.nume = nume;

        this.listaAbilitati.add(new Earth());
        this.listaAbilitati.add(new Fire());
        this.listaAbilitati.add(new Ice());

        viataCurent = 100;
        manaCurent  = 100;

        viataMax = 100;
        manaMax = 100;

        putere = 10 + expCurent/10;
        carisma = 90 + expCurent/8;
        dexteritate = 50 + expCurent/10;

        expCurent = 0;
        levelCurent = 0;

        inventarPotiuni = new Inventory(20, 30);

        this.x = x;
        this.y = y;


        protectieEarth = false;
        protectieFire = false;
        protectieIce = true;
    }
    @Override
    void receiveDamage( int damage) {
        Random rand = new Random();
        int randInt = rand.nextInt(200);
        if ( randInt < putere+dexteritate) damage/=2;

        viataCurent-=damage;
        if (viataCurent < 1) System.out.println("Mageul cu numele "+ nume + " a murit. :(");

    }

    @Override
    int getDamage() {
        Random rand = new Random();
        int randInt = rand.nextInt(200);
        if  (randInt < carisma) return carisma*2/10;
        return carisma;
    }

    public String toString() {
        return "Mage{" +
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
