package tema;

import java.util.ArrayList;
import java.util.Random;

public class Grid extends ArrayList<ArrayList<Cell>> {

    Character personajCurent;
    Cell celulaCurenta;
    int lungime;
    int latime;


    private Grid(int latime, int lungime)
    {
        super(latime);
        this.lungime = lungime;
        this.latime = latime;

        for ( int i=0; i< lungime; i++)
        {
            this.add( new ArrayList<Cell>(lungime));
        }

    }
    public static Grid generateTestare (Character caracter)
    {
        Grid harta = new Grid(5, 5);
        harta.latime = 5;
        harta.lungime = 5;

        for(int i=0; i < 5 ; i++) {
            ArrayList<Cell> rand = new ArrayList<>(5);
            for (int j = 0; j < 5; j++) {
                if (i == 0 && j == 0) {
                    Cell celula = new Cell(i, j, Cell.Tip.START, null);
                    rand.add(celula);
                    continue;
                }
                if (i == 4 && j == 4) {

                    Cell celula = new Cell(i, j, Cell.Tip.FINISH, null);
                    rand.add(celula);
                    continue;
                }
                if ((i == 0 && j == 3) || (i == 1 && j == 3) || (i == 2 && j == 0)) {
                    Shop maga = new Shop();
                    Cell celula = new Cell(i, j, Cell.Tip.SHOP, maga);
                    rand.add(celula);
                    continue;
                }
                if (i == 3 && j == 4) {
                    Enemy dusman = new Enemy();

                    Cell celula = new Cell(i, j, Cell.Tip.ENEMY, dusman);
                    rand.add(celula);
                    continue;
                }
                Cell celula = new Cell(i, j, Cell.Tip.EMPTY, null);
                rand.add(celula);
            }
            harta.add(i, rand);

        }
        harta.celulaCurenta = harta.get(0).get(0);
        harta.celulaCurenta.visited = true;
        harta.personajCurent = caracter;

        caracter.x = 0;
        caracter.y = 0;

        return harta;

    }
    public static Grid generate(int latime, int lungime, Character caracter)// mai mare decat 3x3
    {
        Grid harta = new Grid(latime, lungime);
        harta.latime = latime;
        harta.lungime = lungime;

        int midLatime = latime/2;
        int midLungime = lungime/2;



       for(int i=0; i < latime; i++)
       {
           ArrayList<Cell> rand = new ArrayList<>(lungime);
           for (int j = 0 ; j < lungime; j++)
           {
               if ( i == 0 && j == 0) {
                   Cell celula = new Cell(i, j, Cell.Tip.START, null);
                   rand.add( celula);
                   continue;
               }
               if (i==1 && j == 1) {
                   Shop maga = new Shop();
                   Cell celula = new Cell(i, j, Cell.Tip.SHOP, maga );
                   rand.add( celula);
                   continue;
               }
               if ( i== latime-2 && j == lungime-1)
               {
                   Enemy dusman = new Enemy();

                   Cell celula = new Cell(i, j, Cell.Tip.ENEMY, dusman);
                   rand.add(celula);
                   continue;
               }
               if ( i== latime-1 && j == lungime-2)
               {
                   Enemy dusman = new Enemy();

                   Cell celula = new Cell(i, j, Cell.Tip.ENEMY, dusman);
                   rand.add( celula);
                   continue;
               }
               if ( i== midLatime && j == midLungime)
               {
                   Enemy dusman = new Enemy();

                   Cell celula = new Cell(i, j, Cell.Tip.ENEMY, dusman);
                   rand.add( celula);
                   continue;
               }
               if ( i== latime-1 && j == lungime-1)
               {

                   Cell celula = new Cell(i, j, Cell.Tip.FINISH, null);
                   rand.add( celula);
                   continue;
               }

               Random randomizer = new Random();
               int nr =  randomizer.nextInt(100);
               if ( nr < 80)
               {
                   Cell celula = new Cell(i, j, Cell.Tip.EMPTY, null);
                   rand.add(celula);
               }
               if (nr >= 80 && nr < 90)
               {
                   Enemy dusman = new Enemy();
                   Cell celula = new Cell(i, j, Cell.Tip.ENEMY, dusman);
                   rand.add( celula);
                   }
               if ( nr >= 90)
               {
                   Shop maga = new Shop();
                   Cell celula = new Cell(i, j, Cell.Tip.SHOP, maga );
                   rand.add( celula);
               }
           }
           harta.add(i, rand);
       }


       harta.celulaCurenta = harta.get(0).get(0);
       harta.celulaCurenta.visited = true;
       harta.personajCurent = caracter;
       return harta;

    }

    public void goNorth(Character caracter, Game game)
    {
        if (celulaCurenta.x == 0) System.out.println("Nu pot sa ma deplasez la Nord");
        else
        {
            celulaCurenta = this.get(celulaCurenta.x-1).get(celulaCurenta.y);
            if ( celulaCurenta.visited == false )
            {
                Random random = new Random();
                int nr = random.nextInt(100);
                if ( nr < 20 && celulaCurenta.tip == Cell.Tip.EMPTY )
                {
                    caracter.inventarPotiuni.nrMonede+= 5; // are 20% sanse sa castige 5 monede pe o celula noua de tip EMPTY
                    System.out.println("Ai castigat 5 monede!");
                }

                game.afisarePoveste(celulaCurenta);
            }
            celulaCurenta.visited = true;
            caracter.x--;

        }

    }
    public void goSouth(Character caracter, Game game)
    {
        if (celulaCurenta.x == this.latime-1) System.out.println("Nu pot sa ma deplasez la Sud");
        else
        {
            celulaCurenta = this.get(celulaCurenta.x+1).get(celulaCurenta.y);
            if ( celulaCurenta.visited == false )
            {
                Random random = new Random();
                int nr = random.nextInt(100);
                if ( nr < 20 && celulaCurenta.tip == Cell.Tip.EMPTY )
                {
                    caracter.inventarPotiuni.nrMonede+= 5; // are 20% sanse sa castige 5 monede pe o celula noua de tip EMPTY
                    System.out.println("Ai castigat 5 monede!");
                }

                game.afisarePoveste(celulaCurenta);
            }
            celulaCurenta.visited = true;
            caracter.x ++;

        }

    }
    public void goWest(Character caracter, Game game)
    {
        if (celulaCurenta.y == 0) System.out.println("Nu pot sa ma deplasez la Vest");
        else
        {
            celulaCurenta = this.get(celulaCurenta.x).get(celulaCurenta.y-1);
            if ( celulaCurenta.visited == false )
            {
                Random random = new Random();
                int nr = random.nextInt(100);
                if ( nr < 20 && celulaCurenta.tip == Cell.Tip.EMPTY )
                {
                    caracter.inventarPotiuni.nrMonede+= 5; // are 20% sanse sa castige 5 monede pe o celula noua de tip EMPTY
                    System.out.println("Ai castigat 5 monede!");
                }

                game.afisarePoveste(celulaCurenta);
            }
            celulaCurenta.visited = true;
            caracter.y--;
        }
    }
    public void goEast(Character caracter, Game game)
    {
        if (celulaCurenta.y == this.lungime-1) System.out.println("Nu pot sa ma deplasez la Est");
        else
        {
            celulaCurenta = this.get(celulaCurenta.x).get(celulaCurenta.y+1);
            if ( celulaCurenta.visited == false )
            {
                Random random = new Random();
                int nr = random.nextInt(100);
                if ( nr < 20 && celulaCurenta.tip == Cell.Tip.EMPTY )
                {
                    caracter.inventarPotiuni.nrMonede+= 5; // are 20% sanse sa castige 5 monede pe o celula noua de tip EMPTY
                    System.out.println("Ai castigat 5 monede!");
                }

                game.afisarePoveste(celulaCurenta);
            }
            celulaCurenta.visited = true;
            caracter.y++;
        }
    }

    public String toString()
    {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i= 0; i< this.latime ; i++)
            stringBuffer.append(this.get(i).toString() + "\n");

        return stringBuffer.toString();
    }
}
