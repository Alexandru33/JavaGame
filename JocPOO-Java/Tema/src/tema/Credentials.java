package tema;

public class Credentials {
    private String email;
    private String parola;

    public Credentials(String email, String parola)
    {
        this.email = email;
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
