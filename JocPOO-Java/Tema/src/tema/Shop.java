package tema;

import java.util.ArrayList;
import java.util.Random;

public class Shop implements CellElement{
    ArrayList<Potion> listaPotiuni = new ArrayList<>();

    public Shop()
    {
        Random rand = new Random();
        int nrPotiuni = 2;
        nrPotiuni += rand.nextInt(3);
        for ( int i=0; i < nrPotiuni; i++)
        {
            boolean viataSauMana = rand.nextBoolean();
            if ( viataSauMana == true)
            {
                listaPotiuni.add(new HealthPotion(1,10, 1));
            }
            if ( viataSauMana == false)
            {
                listaPotiuni.add( new ManaPotion(1, 20, 1));
            }
        }
    }

    Potion selectAndRemovePotion(int index)
    {
        Potion potiuneSelectata = listaPotiuni.get(index);
        listaPotiuni.remove(index);
        return potiuneSelectata;
    }
    @Override
    public char toCharacter() {
        return 'S';
    }

    @Override
    public String toString() {
        return "Shop{\n" +
                 listaPotiuni +
                '}';
    }
}
