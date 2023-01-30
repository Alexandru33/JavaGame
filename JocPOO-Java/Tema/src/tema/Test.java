package tema;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InvalidCommandException {


        Scanner scanner = new Scanner(System.in);
        Game game = Game.getInstance();
        game.run();
        Account contAles = game.listaConturi.get(2);
        Character caracterAles = (Character) contAles.personaje.get(0);
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        System.out.println("Contul jucatorului:");
        System.out.println(contAles);
        System.out.println("Eroul nostru:");
        System.out.println(caracterAles);

        Grid hartaTest = Grid.generateTestare(caracterAles);
        System.out.println(hartaTest);
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        hartaTest.goEast(caracterAles, game);
        game.optiuniCelula(hartaTest.celulaCurenta, caracterAles);
        System.out.println(hartaTest);
        System.out.println("Caracterul tau se afla pe pozitia " + caracterAles.x + ", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        hartaTest.goEast(caracterAles, game);
        game.optiuniCelula(hartaTest.celulaCurenta, caracterAles);
        System.out.println(hartaTest);
        System.out.println("Caracterul tau se afla pe pozitia " + caracterAles.x + ", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        hartaTest.goEast(caracterAles, game);
        game.optiuniCelula(hartaTest.celulaCurenta, caracterAles);
        System.out.println(hartaTest);
        System.out.println("Caracterul tau se afla pe pozitia " + caracterAles.x + ", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        Shop shop = (Shop) hartaTest.celulaCurenta.tipCell;
        while (!shop.listaPotiuni.isEmpty())
        {
            Potion potiune = shop.selectAndRemovePotion(0);
            caracterAles.cumpararePotiune(potiune);
        }

        System.out.println("Acum inventarul tau arata astfel");
        System.out.println(caracterAles.inventarPotiuni);
        System.out.println("Caracterul tau se afla pe pozitia "+ caracterAles.x +", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");

        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        hartaTest.goEast(caracterAles, game);
        game.optiuniCelula(hartaTest.celulaCurenta, caracterAles);
        System.out.println(hartaTest);
        System.out.println("Caracterul tau se afla pe pozitia "+ caracterAles.x +", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        hartaTest.goSouth(caracterAles, game);
        game.optiuniCelula(hartaTest.celulaCurenta, caracterAles);
        System.out.println(hartaTest);
        System.out.println("Caracterul tau se afla pe pozitia "+ caracterAles.x +", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        hartaTest.goSouth(caracterAles, game);
        game.optiuniCelula(hartaTest.celulaCurenta, caracterAles);
        System.out.println(hartaTest);
        System.out.println("Caracterul tau se afla pe pozitia "+ caracterAles.x +", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");
        if (scanner.nextLine().compareTo("P") == 1) {
            throw new InvalidCommandException();
        }
        hartaTest.goSouth(caracterAles, game);
        game.optiuniCelula(hartaTest.celulaCurenta, caracterAles);
        System.out.println(hartaTest);
        System.out.println("Caracterul tau se afla pe pozitia "+ caracterAles.x +", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        Enemy inamic = (Enemy)hartaTest.celulaCurenta.tipCell;
        while (!caracterAles.listaAbilitati.isEmpty())
        {
            System.out.println();
            System.out.println("Caracterul foloseste un spell!!");
            caracterAles.folosesteSpell( caracterAles.listaAbilitati.get(0), inamic);
            System.out.println("Caracterul mai are "+ caracterAles.viataCurent+" viata si " + caracterAles.manaCurent + " mana.");
            System.out.println("Inamicul mai are "+ inamic.viataCurent +" viata");

            System.out.println();
            System.out.println("Inamicul te ataca!");
            caracterAles.receiveDamage(inamic.getDamage());
            System.out.println("Caracterul mai are "+ caracterAles.viataCurent+" viata si " + caracterAles.manaCurent + " mana.");
            System.out.println("Inamicul mai are "+ inamic.viataCurent +" viata");
        }
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        while(caracterAles.inventarPotiuni.listaPotiuni.size() > 0)
        {
            Potion potiune = caracterAles.inventarPotiuni.listaPotiuni.get(0);
            potiune.foloseste(caracterAles);
            System.out.println("Caracterul foloseste o potiune si isi regenreaza viata/mana");
            System.out.println("Acum, caracterul mai are "+ caracterAles.viataCurent+" viata si " + caracterAles.manaCurent + " mana.");
        }
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        System.out.println();
        System.out.println("Caracterul ataca!");
        inamic.receiveDamage(caracterAles.getDamage());
        while ( inamic.viataCurent > 0 )
        {
            System.out.println();
            System.out.println("Inamicul ataca!");
            caracterAles.receiveDamage(inamic.getDamage());
            System.out.println("Caracterul ataca!");
            inamic.receiveDamage(caracterAles.getDamage());
            if ( inamic.viataCurent < 1) break;
            System.out.println();
            System.out.println("Caracterul mai are "+ caracterAles.viataCurent+" viata si " + caracterAles.manaCurent + " mana.");
            System.out.println("Inamicul mai are "+ inamic.viataCurent +" viata");
        }
        System.out.println("Ai ucis inamicul!");
        System.out.println(hartaTest);
        System.out.println("Caracterul tau se afla pe pozitia "+ caracterAles.x +", " + caracterAles.y + "si mai are " + caracterAles.inventarPotiuni.nrMonede + " bani.");
        if (!scanner.next().equals("P")) {
            throw new InvalidCommandException();
        }
        hartaTest.goSouth(caracterAles, game);
        game.optiuniCelula(hartaTest.celulaCurenta, caracterAles);
        System.out.println(hartaTest);

    }

}
