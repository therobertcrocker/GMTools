package dragontools;

import tools.processing.WriteFile;
import dragontools.dragons.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] color = new String[] {"Black", "Bronze"};
        Matriarch m = new Matriarch ("Iri", color);
        Clan iri = new Clan(m);

        iri.addSister("Kiri");
        iri.addSister("Miri");
        iri.addSister("Hiri");

        Drake a = new Drake("Han", new String[] {"Black"});
        iri.addConsort(a);
        iri.addFirstDaughter("Iri-Ko");
        iri.mate("Kiri", new Drake("Kono", new String[] {"Bronze"}));
        iri.addDaughter("Kiri", new Dragon("Kiri-Ra", color));

        iri.addFirstChoir(new Voice("Ko-Ra", color));
        Choir c = iri.getFirstChoir();
        c.addFirstDaughter("Ko-Rai");
        c.addFirstDaughter("Ko-Rae");
        c.addConsort(new Drakeborn("Ta-Loy", new String[] {"Bronze"}));
        c.mate("Ko-Rai", new Drakeborn("Lo-Ra", new String[] {"Black"}));
        c.addDaughter("Ko-Rai", new Dragonborn("Raisa", color));

        String file = "src/dragontools/output/iri.json";
        String body = iri.toString();

        WriteFile writer = new WriteFile(file, body);
        writer.make();
    }
}
