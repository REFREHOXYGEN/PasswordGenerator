
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler {
    public void start(){
        View view = new View();

        view.bildWindow();
        final String[] buffer = {null};
        view.getBttOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PassGenerator generatePass = new PassGenerator(Integer.parseInt(view.getSpinner().getValue().toString()),
                                                                view.getChekSpecSimvol().isSelected(),
                                                                view.getChekBiglathin().isSelected(),
                                                                view.getCheklathin().isSelected(),
                                                                view.getChekNumber().isSelected());

                view.getFealdOut().setForeground(Color.GREEN);
                buffer[0] = generatePass.generate();
                view.setFealdOut(buffer[0]);
            }
        });
        view.getFealdOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.setFealdOut("COPY");
                view.getFealdOut().setForeground(Color.RED);
                StringSelection stringSelection = new StringSelection(buffer[0]);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });
    }

}
