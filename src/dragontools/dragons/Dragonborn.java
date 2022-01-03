package dragontools.dragons;

import java.util.ArrayList;

public class Dragonborn extends Wyrm {
    private Dragon patron;
    private Dragonborn mother;
    private Matriarch matriarch;
    private Voice voice;
    private ArrayList<Dragonborn> daughters;
    private ArrayList<Drakeborn> sons;

    public Dragonborn(String name, String[] colors) {
        super(name, colors);
        daughters = new ArrayList<>();
        sons = new ArrayList<>();
    }

    public Dragonborn(String name, String[] colors, Dragonborn mother) {
        super(name, colors);
        setMother(mother);
        daughters = new ArrayList<>();
        sons = new ArrayList<>();
    }

    public void setPatron(Dragon p) {
        patron = p;
    }

    public void setMatriarch(Matriarch m) {
        matriarch = m;
    }

    public void setVoice(Voice v) {
        voice = v;
    }

    public void setMother(Dragonborn d) {
        mother = d;
        if (mother.getVoice() == null) {
            setVoice((Voice) d);
        } else {
            setVoice(d.getVoice());
        }
        patron = mother.getPatron();
        matriarch = mother.getMatriarch();
    }

    public void setMate(Drake m) {
        super.setMate(m);
    }

    public Wyrm getMate() {
        return (Wyrm) super.getMate();
    }

    public void addDaughter(Dragonborn d) {
        daughters.add(d);
        d.setMother(this);
    }

    public void addSon(Drakeborn d) {
        sons.add(d);
    }

    public ArrayList<Dragonborn> getDaughters() {
        return daughters;
    }

    public ArrayList<Drakeborn> getSons() {
        return sons;
    }

    public Dragon getPatron() {
        return patron;
    }

    public Matriarch getMatriarch() {
        return matriarch;
    }

    public Dragonborn getMother() {
        return mother;
    }

    public Voice getVoice() {
        return voice;
    }

    @Override
    public String toString() {
        char q = '"';
        String result ="{ ";
        result += "\"name\": " + q + getName() + q;
        result += ", \"color\": " + q + getColors() + q;
        if (getMate() != null) {
            result += ", \"mate\": " + getMate().toString();
        }
        if (daughters.size() > 0) {
            result += ", \"daughters\": [ ";
            for (int i = 0; i < daughters.size(); i ++) {
                if (i == daughters.size() - 1) {
                    result += daughters.get(i).toString() + "] ";
                } else {
                    result += daughters.get(i).toString() + ", ";
                }
            }
            result += "} ";
        } else {
            result += "} ";
        }
        return result;
    }

    
    }


