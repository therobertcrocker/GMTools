package dragontools.dragons;

import java.util.ArrayList;

public class Dragon extends Wyrm {
    private Dragon mother;
    private Matriarch matriarch;
    private Choir choir;
    private ArrayList<Dragon> daughters;
    public ArrayList<Drake> sons;
    
    public Dragon(String name, String[] colors) {
        super(name, colors);
        daughters = new ArrayList<>();
        sons = new ArrayList<>();
        choir = null;
    }

    public Dragon(String name, String[] colors, Dragon mother) {
        super(name, colors);
        setMother(mother);
        daughters = new ArrayList<>();
        sons = new ArrayList<>();
        choir = null;
    }

    public void setMatriarch(Matriarch m) {
        matriarch = m;
    }

    public void setMother(Dragon d) {
        mother = d;
        if (mother.getMatriarch() == null) {
            setMatriarch((Matriarch) d);
        } else {
            setMatriarch(d.getMatriarch());
        }
    }

    public void setMate(Drake m) {
        super.setMate(m);
    }

    public Wyrm getMate() {
        return (Wyrm) super.getMate();
    }

    public void addDaughter(Dragon d) {
        daughters.add(d);
        d.setMother(this);
    }

    public void addSon(Drake d) {
        sons.add(d);
    }

    public void addChoir(Voice voice) {
        Choir c = new Choir(this, voice);
        addChoir(c);
    }

    public void addChoir(Choir c) {
        this.choir = c;
    }

    public Choir getChoir() {
        return choir;
    }

    public ArrayList<Dragon> getDaughters() {
        return daughters;
    }

    public ArrayList<Drake> getSons() {
        return sons;
    }

    public Matriarch getMatriarch() {
        return matriarch;
    }

    public Dragon getMother() {
        return mother;
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
        }
        if (choir != null ) {
            result += choir.toString();
        } else {
            result += "} ";
        }
        return result;
    }

    
}
