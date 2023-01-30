package tema;

public class ManaPotion implements Potion{
    int pret;
    int puncteRegenerate;
    int greutate;

    public ManaPotion(int pret, int puncteRegenerate, int greutate)
    {
        this.pret = pret;
        this.puncteRegenerate = puncteRegenerate;
        this.greutate = greutate;
    }
    @Override
    public void foloseste(Character caracter) {
        caracter.manaCurent+= puncteRegenerate;
        if ( caracter.manaCurent > caracter.manaMax) caracter.manaCurent = caracter.manaMax;
        caracter.inventarPotiuni.eliminaPotiune( caracter.inventarPotiuni.listaPotiuni.indexOf(this));
    }

    @Override
    public int getPret() {
        return pret;
    }

    @Override
    public int getGreutate() {
        return greutate;
    }

    @Override
    public int valoareRegeneranta() {
        return puncteRegenerate;
    }

    public String toString()
    {
        return "Potiune de Mana care costa " + pret + " monede,regenereaza " + puncteRegenerate + " puncte de Mana si are greutatea de " + greutate + " \n";
    }
}
