package tema;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity implements CellElement{

    @Override
    public char toCharacter() {
        return 'E';
    }

    public Enemy()
    {
        Random random = new Random();
        this.viataMax = 70 + random.nextInt(20);
        this.viataCurent = viataMax;

        this.manaMax = 50 + random.nextInt(20);
        this.manaCurent = manaMax;

        protectieEarth = random.nextBoolean();
        protectieFire = random.nextBoolean();
        protectieIce = random.nextBoolean();

        listaAbilitati = new ArrayList<Spell>(4);
        if ( random.nextInt()/3 == 0) listaAbilitati.add(new Ice());
        if ( random.nextInt()/3 == 1) listaAbilitati.add(new Fire());
        if ( random.nextInt()/3 == 1) listaAbilitati.add(new Earth());

    }

    @Override
    void receiveDamage(int damage) {
        viataCurent-=damage;
        if ( viataCurent < 1) System.out.println("Inamicul a murit");
    }

    @Override
    int getDamage() {
        return 5;
    }
}
