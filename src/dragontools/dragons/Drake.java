package dragontools.dragons;
 
public class Drake extends Wyrm{
    private Matriarch matriarch;
    private Dragon mother;

    public Drake(String name, String[] colors) {
        super(name, colors);
    }

    public Drake(String name, String[] colors, Dragon mother) {
        super(name, colors);
        setMother(mother);
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

    public void setMate(Dragon m) {
        super.setMate(m);
        matriarch = getMate().getMatriarch();
    }

    public Dragon getMate() {
        return (Dragon) super.getMate();
    }

    public Dragon getMother() {
        return mother;
    }

    public Matriarch getMatriarch() {
        return matriarch;
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
