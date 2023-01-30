package tema;

import java.util.ArrayList;

public abstract class Entity implements Element<Entity> {
    ArrayList<Spell> listaAbilitati = new ArrayList<>();
    int viataCurent;
    int viataMax;
    int manaCurent;
    int manaMax;

    boolean protectieFire;
    boolean protectieIce;
    boolean protectieEarth;

    void regenerareViata (int hpRegenerat)
    {
        viataCurent+= hpRegenerat;
        if (viataCurent > viataMax) viataCurent = viataMax;
    }

    void regenerareMana ( int mpRegenerat)
    {
        manaCurent += mpRegenerat;
        if ( manaCurent > manaMax) manaCurent = manaMax;
    }

    void folosesteSpell ( Spell spell , Entity inamic )
    {
        if ( manaCurent >= spell.costMana)
        {
            inamic.accept(spell);
            manaCurent-= spell.costMana;
        }
        listaAbilitati.remove(spell);
    }

    abstract void receiveDamage(int damage);
    abstract int getDamage();

    @Override
    public void accept(Visitor<Entity> visitor) {
        visitor.visit(this);
    }
}
