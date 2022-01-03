package dragontools.dragons;

public class Drakeborn extends Wyrm{
    private Dragon patron;
    private Dragonborn mother;
    private Matriarch matriarch;
    private Voice voice;

    public Drakeborn(String name, String[] colors) {
        super(name, colors);
    }

    public Drakeborn(String name, String[] colors, Dragonborn mother) {
        super(name, colors);
        setMother(mother);
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

    public void setMate(Dragonborn m) {
        super.setMate(m);
    }

    public Wyrm getMate() {
        return (Wyrm) super.getMate();
    }

    public Dragonborn getMother() {
        return mother;
    }

    public Matriarch getMatriarch() {
        return matriarch;
    }

    public Voice getVoice() {
        return voice;
    }

    public Dragon getPatron() {
        return patron;
    }

    @Override
    public String toString() {
        char q = '"';
        String result = "{ ";
        result += "\"name\": " + q + getName() + q;
        result += ", \"color\": " + q + getColors() + q;
        if (mother != null) {
            result += ", \"mother\": " + q + mother.getName() + q;
        }
        if (matriarch != null) {
            result += ", \"matriarch\": " + q + matriarch.getName() + q;
        }
        if (getMate() != null) {
            result += ", \"mate\": " + q + getMate().getName() + q;
        }
        result += "} ";
        return result;
    }
}
