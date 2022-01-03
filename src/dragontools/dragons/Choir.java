package dragontools.dragons;


import java.util.Hashtable;

public class Choir {
    private String name;
    private String[] colors;
    private Dragon patron;
    private Voice voice;
    private Hashtable<String, Dragonborn> dragons;
    private Hashtable<String, Drakeborn> drakes;

    public Choir(Dragon p, Voice v) {
        patron = p;
        voice = v;
        name = patron.getName();
        colors = patron.colors();
        dragons = new Hashtable<>();
        drakes = new Hashtable<>();

    }

    public Dragon getPatron() {
        return patron;
    }

    public Voice getVoice() {
        return voice;
    }

    public void addFirstDaughter(Dragonborn d) {
        voice.addDaughter(d);
        dragons.put(d.getName(), d);
    }

    public void addFirstDaughter(String name) {
        addFirstDaughter(new Dragonborn(name, colors, voice));
    }


    public void addSister(Dragonborn d) {
        voice.addSister(d);
        dragons.put(d.getName(), d);
    }

    public void addSister(String name) {
        Dragonborn sister = new Dragonborn(name, colors);
        sister.setVoice(voice);
        addSister(sister);
    }

    public void addConsort(Drakeborn c) {
        voice.addconsort(c);
        drakes.put(c.getName(), c);
    }

    public void addFirstSon(Drakeborn s) {
        voice.addSon(s);
        drakes.put(s.getName(), s);
    }

    public void addFirstSon(String name) {
        addFirstSon(new Drakeborn(name, colors, voice));
    }

    public void addDaughter(String mother, Dragonborn d) {
        dragons.put(d.getName(), d);
        dragons.get(mother).addDaughter(d);
    }

    public void addSon(String mother, Drakeborn s) {
        drakes.put(s.getName(), s);
        dragons.get(mother).addSon(s);
    }

    public void mate(String wife, Drakeborn m) {
        if (!drakes.contains(m)) {
            drakes.put(m.getName(), m);
        }
        dragons.get(wife).setMate(m);
    }

    public void mate(String mate, Dragonborn d) {
        if (!dragons.contains(d)) {
            dragons.put(d.getName(), d);
        }
        drakes.get(mate).setMate(d);
    }

    @Override
    public String toString() {
        char q = '"';
        String result = "\"choir\": {";
        result += "\"name\": " + q + name + "\", ";
        result += "\"voice\": " + voice.toString();
        return result;
    }

}
