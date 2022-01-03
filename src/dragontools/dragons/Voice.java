package dragontools.dragons;

import java.util.ArrayList;

public class Voice  extends Dragonborn {
    private ArrayList<Dragonborn> sisters;
    private ArrayList<Drakeborn> consorts;

    public Voice(String name, String[] colors) {
        super(name, colors);
        sisters = new ArrayList<>();
        consorts = new ArrayList<>();
    }

    public void addSister(Dragonborn d) {
        sisters.add(d);
    }

    public ArrayList<Dragonborn> getSisters() {
        return sisters;
    }

    public void addconsort(Drakeborn d) {
        consorts.add(d);
    }

    public ArrayList<Drakeborn> getConsorts() {
        return consorts;
    }

    @Override
    public String toString() {
        char q = '"';
        String result = "{ ";
        result += "\"name\": " + q + getName() + q;
        result += ", \"color\":" + q + getColors() + q;
        if (consorts.size() > 0) {
            result += ", \"consorts\": [ ";
            for (int i = 0; i < consorts.size(); i++) {
                if (i == consorts.size() - 1) {
                    result += consorts.get(i).toString() + "] ";
                } else {
                    result += consorts.get(i).toString() + ", ";
                }
            }
        }
        if (getDaughters().size() > 0) {
            result += ", \"daughters\": [ ";
            for (int i = 0; i < getDaughters().size(); i++) {
                if (i == getDaughters().size() - 1) {
                    result += getDaughters().get(i).toString() + "] ";
                } else {
                    result += getDaughters().get(i).toString() + ", ";
                }
            }
            result += "} ";
        }
        if (sisters.size() > 0) {
            result += ", \"sisters\": [ ";
            for (int i = 0; i < sisters.size(); i++) {
                if (i == sisters.size() - 1) {
                    result += sisters.get(i).toString() + "] ";
                } else {
                    result += sisters.get(i).toString() + ", ";
                }
            }
            result += "} ";
        } else {
            result += "} ";
        }
        return result;
    }
}
