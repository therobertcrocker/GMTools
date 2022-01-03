package dragontools.dragons;


import java.util.Hashtable;

public class Clan {
    private String name;
    private String[] colors;
    private Matriarch matriarch;
    private Hashtable<String, Dragon> dragons;
    private Hashtable<String, Drake> drakes;
    

    public Clan(Matriarch m) {
        matriarch = m;
        name = matriarch.getName();
        colors = m.colors();
        dragons = new Hashtable<>();
        drakes = new Hashtable<>();
    }

    public void addFirstDaughter(Dragon d) {
        matriarch.addDaughter(d);
        dragons.put(d.getName(), d);
    }

    public void addFirstDaughter(String name) {
        addFirstDaughter(new Dragon(name, colors, matriarch));
    }

    public void addFirstChoir(Voice voice) {
        matriarch.addChoir(voice);
    }

    public void addFirstChoir(Choir c) {
        matriarch.addChoir(c);
    }


    public void addSister(Dragon d) {
        matriarch.addSister(d);
        dragons.put(d.getName(), d);
    }

    public void addSister(String name) {
        Dragon sister = new Dragon(name, colors);
        sister.setMatriarch(matriarch);
        addSister(sister);
    }

    public void addConsort(Drake c) {
        matriarch.addconsort(c);
        drakes.put(c.getName(), c);
    }

    public void addFirstSon(Drake s) {
        matriarch.addSon(s);
        drakes.put(s.getName(), s);
    }

    public void addFirstSon(String name) {
        addFirstSon(new Drake(name, colors, matriarch));
    }

    public void addDaughter(String mother, Dragon d) {
        dragons.put(d.getName(), d);
        dragons.get(mother).addDaughter(d);
    }

    public void addSon(String mother, Drake s) {
        drakes.put(s.getName(), s);
        dragons.get(mother).addSon(s);
    }

    public void mate(String wife, Drake m) {
        if (!drakes.contains(m)) {
            drakes.put(m.getName(), m);
        }
        dragons.get(wife).setMate(m);
    }

    public void mate(String mate, Dragon d) {
        if (!dragons.contains(d)) {
            dragons.put(d.getName(), d);
        }
        drakes.get(mate).setMate(d);
    }

    public void addChoir(String patron, Voice voice) {
        dragons.get(patron).addChoir(voice);
    }

    public void addChoir(String patron, Choir choir) {
        dragons.get(patron).addChoir(choir);
    }

    public Choir getFirstChoir() {
        return matriarch.getChoir();
    }

    public Choir getChoir(String patron) {
        return dragons.get(patron).getChoir();
    }

    @Override
    public String toString() {
        char q = '"';
        String result = "{ \"clan\": {";
        result += "\"name\": " + q + name + "\", ";
        result += "\"matriarch\": " + matriarch.toString();
        result += "}";
        return result;
    }
}
