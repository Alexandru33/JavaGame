package tema;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Account {
    static class Information {
        private Credentials credentiale;
        private TreeSet<String> jocuriPreferate;
        private String numeJucator;
        private String taraJucator;

        private Information(InformationBuilder ib)
        {
            this.credentiale = ib.credentiale;
            this.jocuriPreferate = ib.jocuriPreferate;
            this.numeJucator = ib.numeJucator;
            this.taraJucator = ib.taraJucator;
        }

        @Override
        public String toString() {
            return "Information{" +
                    "credentiale=" + credentiale +
                    ", jocuriPreferate=" + jocuriPreferate +
                    ", numeJucator='" + numeJucator + '\'' +
                    ", taraJucator='" + taraJucator + '\'' +
                    '}';
        }
    }

    static class InformationBuilder
    {
        private Credentials credentiale;
        private TreeSet<String> jocuriPreferate;
        private String numeJucator;
        private String taraJucator;

        public InformationBuilder ( Credentials crederntiale, String numeJucator)
        {
            this.credentiale = crederntiale;
            this.numeJucator = numeJucator;

        }

        public void setTara (String taraJucator)
        {
            this.taraJucator = taraJucator;
        }

        public void setJocuriPreferate ( TreeSet<String> jocuriPreferate)
        {
            this.jocuriPreferate = jocuriPreferate;
        }

        public Information buildInformation() throws InformationIncompleteException
        {
            Information informatie = new Information(this);
            if ( numeJucator == null || credentiale == null) throw new InformationIncompleteException();
            return informatie;
        }
    }

    Information informatii;
    ArrayList<Entity> personaje = new ArrayList<>();
    int nrJocuriJucate;

    public Account( Information informatii, ArrayList<Entity> personaje, int nrJocuriJucate)
    {
        this.informatii = informatii;
        this.nrJocuriJucate = nrJocuriJucate;
        this.personaje = personaje;
    }

    @Override
    public String toString() {
        return "Account{" +
                "informatii=" + informatii +
                ", personaje=" + personaje +
                ", nrJocuriJucate=" + nrJocuriJucate +
                '}';
    }
}
