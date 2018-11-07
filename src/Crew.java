import javax.swing.*;

public class Crew {
    CrewMember[] crew = new CrewMember[5];
    private int money;

    public void createCrew()
    {
        crew[0].setName(JOptionPane.showInputDialog("Please enter the name of your Captain: "));

        for(int i = 1; i<5; i++)
        {
            crew[i].setName(JOptionPane.showInputDialog("Please enter the name of crew member " + i + ":"));
        }
    }
}
