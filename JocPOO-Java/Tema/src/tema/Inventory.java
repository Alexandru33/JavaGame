package tema;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    ArrayList<Potion> listaPotiuni;
    int greutateMax;
    int nrMonede;

    public Inventory(int greutateMax, int nrMonede)
    {
        this.greutateMax = greutateMax;
        this.nrMonede = nrMonede;
        this.listaPotiuni = new ArrayList<Potion>();
    }

    int greutateRamasa()
    {
        int greutatePotiuni = 0;
        for(Iterator<Potion> it = listaPotiuni.iterator(); it.hasNext();)
        {
            greutatePotiuni += it.next().getGreutate();
        }
        return ( greutateMax - greutatePotiuni );
    }
    void adaugaPotiune ( Potion potiune )
    {
        if ( greutateRamasa() >= potiune.getGreutate() && nrMonede >= potiune.getPret())
        {
            listaPotiuni.add(potiune);
            nrMonede -=potiune.getPret();
        }
        else System.out.println("Nu mai e loc sau nu mai sunt bani pentru potiune!\n");

    }

    void eliminaPotiune (int index)
    {
        listaPotiuni.remove(index);
    }

    public String toString ()
    {
        return listaPotiuni.toString() + "\nBani: " + nrMonede;
    }


}
