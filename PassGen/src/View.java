import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame jFrame;
    private JPanel panelMain;
    private JPanel panelOut;
    private JPanel panelChek;
    private JTextField fealdOut;

    public JTextField getFealdOut() {
        return fealdOut;
    }

    private JButton bttOk;
    private JCheckBox chekBiglathin;
    private JCheckBox chekSpecSimvol;
    private JCheckBox cheklathin;
    private JCheckBox chekNumber;
    private JSpinner spinner;
    private SpinnerModel spinLength;

    public JButton getBttOk() {
        return bttOk;
    }

    public JCheckBox getChekBiglathin() {
        return chekBiglathin;
    }

    public JCheckBox getChekSpecSimvol() {
        return chekSpecSimvol;
    }

    public JCheckBox getCheklathin() {
        return cheklathin;
    }

    public JCheckBox getChekNumber() {
        return chekNumber;
    }

    public SpinnerModel getSpinner() {
        return spinLength;
    }

    public void setFealdOut(String fealdOut) {
        this.fealdOut.setText(fealdOut);
    }

    public void bildWindow(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame = new JFrame("PassGen");
        int width = 450;
        int height = 110;
        int startPosX = dimension.width>width?width:dimension.width;
        int startPosY = dimension.height>height?height:dimension.height;
        buildMainPanel();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(startPosX,startPosY,width,height);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
    private void buildMainPanel(){
        panelMain = new JPanel();
        jFrame.add(panelMain);

        panelOut = new JPanel();

        fealdOut = new JTextField();
        fealdOut.setColumns(28);
        panelOut.add(fealdOut);

        spinLength = new SpinnerNumberModel(12,1,35,1);
        spinner = new JSpinner(spinLength);
        panelOut.add(spinner);

        bttOk = new JButton();
        bttOk.setText("OK");
        panelOut.add(bttOk);

        panelChek = new JPanel();

        chekSpecSimvol = new JCheckBox("Специальные символы",true);
        panelChek.add(chekSpecSimvol);

        chekBiglathin = new JCheckBox("Большие буквы",true);
        panelChek.add(chekBiglathin);

        cheklathin = new JCheckBox("Буквы",true);
        panelChek.add(cheklathin);

        chekNumber = new JCheckBox("Числа",true);
        panelChek.add(chekNumber);

        panelMain.add(panelOut);
        panelMain.add(panelChek);

    }
}
