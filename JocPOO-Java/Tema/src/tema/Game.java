package tema;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;

public class Game {
    List<Account> listaConturi;
    Map<Cell.Tip, ArrayList<String>> povesti;

    private static Game instance = null;

    public static Game getInstance()
    {
        if ( instance == null) instance = new Game();
        return instance;

    }

    private Game()
    {
        listaConturi = new ArrayList<Account>();
        povesti = new TreeMap<Cell.Tip, ArrayList<String>>();
    }
    public void run()
    {
        instance = Game.getInstance();

        try
        {
            String cale1 = Paths.get("").toAbsolutePath().toString();
            cale1 += "\\accounts.json";

            String continutAccounts = Files.readString(Paths.get(cale1) );
            JSONObject jsonAccounts = new JSONObject(continutAccounts);

            JSONArray conturi = jsonAccounts.getJSONArray("accounts");
            for ( int i = 0 ; i< conturi.length() ;i++)
            {
                JSONObject jsonCont = conturi.getJSONObject(i);
                JSONObject jsonCredentiale = jsonCont.getJSONObject("credentials");
                String email = jsonCredentiale.getString("email");
                String parola = jsonCredentiale.getString("password");

                Credentials credentiale = new Credentials(email,parola);

                String numeJucator = jsonCont.getString("name");
                String taraJucator = jsonCont.getString("country");

                JSONArray jsonListaJocuri = jsonCont.getJSONArray("favorite_games");

                TreeSet<String> jocuriPreferate = new TreeSet<String>();

                for ( int j = 0 ; j < jsonListaJocuri.length(); j++)
                {
                    String joc = jsonListaJocuri.getString(j);
                    jocuriPreferate.add(joc);
                }

                Account.InformationBuilder infoBuilder = new Account.InformationBuilder(credentiale, numeJucator);
                infoBuilder.setJocuriPreferate(jocuriPreferate);
                infoBuilder.setTara(taraJucator);

                Account.Information informatie = infoBuilder.buildInformation();


                int jocuriJucate = jsonCont.getInt("maps_completed");
                ArrayList<Entity> personaje = new ArrayList<>();

                JSONArray jsonListaPersonaje = jsonCont.getJSONArray("characters");

                for ( int j = 0 ; j < jsonListaPersonaje.length(); j++)
                {
                    JSONObject jsonPersonaj = jsonListaPersonaje.getJSONObject(j);

                    String numePersonaj = jsonPersonaj.getString("name");
                    String profesiePersonaj = jsonPersonaj.getString("profession");
                    int levelPersonaj = jsonPersonaj.getInt("level");
                    int experientaPersonaj = jsonPersonaj.getInt("experience");

                    personaje.add(new Character.Factory().construireErou(profesiePersonaj, numePersonaj, experientaPersonaj, levelPersonaj));
                }

                instance.listaConturi.add(new Account(informatie, personaje, jocuriJucate));


            }
            // Sa parsam si JSON-ul pentru povesti

            String cale2 = Paths.get("").toAbsolutePath().toString();
            cale2 += "\\stories.json";

            String continutStories = Files.readString(Paths.get(cale2));
            JSONObject jsonStories = new JSONObject(continutStories);
            JSONArray storiuri = jsonStories.getJSONArray("stories");

            Map <Cell.Tip, ArrayList<String>> hashmap = new TreeMap<>();
            ArrayList<String> povestiEmpty = new ArrayList<>();
            ArrayList<String> povestiEnemy = new ArrayList<>();
            ArrayList<String> povestiShop = new ArrayList<>();
            ArrayList<String> povestiFinish = new ArrayList<>();

            for ( int i=0; i < storiuri.length(); i++)
            {
                JSONObject jsonPoveste = storiuri.getJSONObject(i);
                String tip = jsonPoveste.getString("type");
                String valoare = jsonPoveste.getString("value");


                if ( tip.compareTo("EMPTY") == 0)
                {
                    povestiEmpty.add(valoare);
                }
                if ( tip.compareTo("ENEMY") == 0)
                {
                    povestiEnemy.add(valoare);
                }
                if ( tip.compareTo("SHOP") == 0)
                {
                    povestiShop.add(valoare);
                }
                if ( tip.compareTo("FINISH") == 0)
                {
                    povestiFinish.add(valoare);
                }
            }

            hashmap.put(Cell.Tip.EMPTY, povestiEmpty);
            hashmap.put(Cell.Tip.ENEMY, povestiEnemy);
            hashmap.put(Cell.Tip.SHOP, povestiShop);
            hashmap.put(Cell.Tip.FINISH, povestiFinish);



            instance.povesti = hashmap;
        }
        catch( IOException e)
        {
            e.printStackTrace();
            System.out.println("Eroare la path!");
        }
        catch (InformationIncompleteException e)
        {
            e.printStackTrace();
        }


    }

    public void optiuniCelula(Cell celulaCurenta, Character caracter)
    {
        Scanner scanner = new Scanner(System.in);

        if ( celulaCurenta.tip == Cell.Tip.EMPTY) System.out.println("Celula este goala!");
        if ( celulaCurenta.tip == Cell.Tip.START) System.out.println("Ai ajuns inapoi la START.");
        if ( celulaCurenta.tip == Cell.Tip.FINISH) System.out.println("Ai ajuns la FINISH!Jocul s-a incheiat");
        if ( celulaCurenta.tip == Cell.Tip.SHOP)
        {
            System.out.println("Ai ajuns la un magazin. Poti cumpara din urmatoarea lista de potiuni.");
            Shop shop = (Shop) celulaCurenta.tipCell;
            System.out.println(shop.listaPotiuni);

        }
        if ( celulaCurenta.tip == Cell.Tip.ENEMY)
        {
            System.out.println("Ai dat de un inamic. Sa inceapa batalia.");
        }
    }
    public void afisarePoveste (Cell celulaCurenta)
    {
        Random random = new Random();
        int nr2 = random.nextInt(100);
        if (celulaCurenta.tip == Cell.Tip.EMPTY)
        {
            System.out.println(povesti.get(Cell.Tip.EMPTY).get( nr2 % povesti.get(Cell.Tip.EMPTY).size())); // afisarea unei povesti random
        }
        if (celulaCurenta.tip == Cell.Tip.ENEMY)
        {
            System.out.println(povesti.get(Cell.Tip.ENEMY).get( nr2 % povesti.get(Cell.Tip.ENEMY).size())); // afisarea unei povesti random
        }
        if (celulaCurenta.tip == Cell.Tip.SHOP)
        {
            System.out.println(povesti.get(Cell.Tip.SHOP).get( nr2 % povesti.get(Cell.Tip.SHOP).size())); // afisarea unei povesti random
        }
        if (celulaCurenta.tip == Cell.Tip.FINISH)
        {
            System.out.println(povesti.get(Cell.Tip.FINISH).get( nr2 % povesti.get(Cell.Tip.FINISH).size())); // afisarea unei povesti random
        }
    }
}
