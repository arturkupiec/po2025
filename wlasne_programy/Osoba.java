public class Osoba {
    String name;
    int age;
    boolean isAlive;
    static int ilePrzedstawiono;

    String przedstawSie(boolean czyKononoskopia){
        ilePrzedstawiono++;
        if(czyKononoskopia) {
            String przywitanie = "Szanowni Panstwo, kochani moi " + name + "mam " + age + " lat";
            return przywitanie;
        }else{
            return "no dzien dobry, jemy pszny obiadek z " + name + " NO JUZ POL SLOIKA OPEIRD PRZEPRASZAM ZE TAK POWIEDZIALEM";
        }
    }

    static int ilePrzedstawionoLiczba(){
        return ilePrzedstawiono;
    }

    void porownajZ10(){
        int x = 0;
        while(x++ < 10) {}
        String message = x > 10 ? "Wieksze niz" : "Mniejsze niz ";
        System.out.println(message+","+x);
    }

    void sumNoObserver(int a, int b){
        System.out.println(a+b);
    }

    }

