package tema;

public abstract class Character extends Entity{

    String nume;
    int x,y;
    Inventory inventarPotiuni;
    int expCurent;
    int levelCurent;

    int putere;
    int carisma;
    int dexteritate;

    void cumpararePotiune ( Potion potiune)
    {
        if ( inventarPotiuni.greutateRamasa() >= potiune.getGreutate() && inventarPotiuni.nrMonede >= potiune.getPret())
        {
            inventarPotiuni.adaugaPotiune(potiune);
            System.out.println("Potiune cumparata");
        }
        else
        {
            System.out.println("Nu exista bani/spatiu pentru potiune");
        }
    }

    static class Factory {

        public Character construireErou (String profesiePersonaj, String numePersonaj, int experientaPersonaj, int levelPersonaj)
        {
            if ( profesiePersonaj.compareTo("Warrior") == 0)
            {
                Warrior w = new Warrior(numePersonaj, 0 ,0);
                w.expCurent = experientaPersonaj;
                w.levelCurent = levelPersonaj;
                return w;
            }
            else if ( profesiePersonaj.compareTo("Mage") == 0 )
            {
                Mage m = new Mage(numePersonaj, 0 ,0);
                m.expCurent = experientaPersonaj;
                m.levelCurent = levelPersonaj;
                return m;
            }
            else if ( profesiePersonaj.compareTo("Rogue") == 0 )
            {
                Rogue r = new Rogue(numePersonaj, 0 ,0);
                r.expCurent = experientaPersonaj;
                r.levelCurent = levelPersonaj;
                return r;
            }
            return null;
        }
    }
}
