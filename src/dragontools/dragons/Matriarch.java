package dragontools.dragons;

import java.util.ArrayList;

public class Matriarch extends Dragon {
    private ArrayList<Dragon> sisters;
    private ArrayList<Drake> consorts;

    public Matriarch(String name, String[] colors) {
        super(name, colors);
        sisters = new ArrayList<>();
        consorts = new ArrayList<>();
    }

    public void addSister(Dragon d) {
        sisters.add(d);
    }

    public ArrayList<Dragon> getSisters() {
        return sisters;
    }

    public void addconsort(Drake d) {
        consorts.add(d);
    }

    public ArrayList<Drake> getConsorts() {
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
        if (getChoir() != null ) {
            result += ",";
            result += getChoir().toString();
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
