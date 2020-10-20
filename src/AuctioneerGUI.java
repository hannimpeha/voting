import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;

import javax.swing.*;

/** example of agent architecture's functions overriding */
public class AuctioneerGUI extends AgArch {

    JTextArea jt;
    JFrame    f;
    JButton auction;

    int auctionId = 0;

    public AuctioneerGUI() {
        jt = new JTextArea(10, 30);
        auction = new JButton("Start news");
        auction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                auctionId++;
                Literal goal = ASSyntax.createLiteral("start", ASSyntax.createNumber(auctionId));
                getTS().getC().addAchvGoal(goal, null);
                auction.setEnabled(true);
            }
        });

        f = new JFrame("Auctioneer agent");
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(BorderLayout.SOUTH, auction);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void stop() {
        f.dispose();
        super.stop();
    }
}

