package tema;

public class HealthPotion implements Potion{
    int pret;
    int puncteRegenerate;
    int greutate;

    public HealthPotion(int pret, int puncteRegenerate, int greutate)
    {
        this.pret = pret;
        this.puncteRegenerate = puncteRegenerate;
        this.greutate = greutate;
    }
    @Override
    public void foloseste(Character caracter) {
        caracter.viataCurent+= puncteRegenerate;
        if ( caracter.viataCurent > caracter.viataMax) caracter.viataCurent = caracter.manaMax;
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
        return "Potiune de Viata care costa " + pret + " monede,regenereaza " + puncteRegenerate + " puncte de Viata si are greutatea de " + greutate + " \n";
    }
}
