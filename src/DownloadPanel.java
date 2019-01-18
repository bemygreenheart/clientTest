import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownloadPanel extends JPanel {
    private JLabel resultLabel;
    private JTextField fileNameField;
    private ImageIcon icon;
    private JFrame motherFrame;
    private JButton menuButton;
    private JPanel hPanel;

    public DownloadPanel(  String fileName,int type, JFrame frame) {
        motherFrame=frame;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        if(type==0)
        {
            icon=new ImageIcon(getClass().getResource("correct.jpeg"));
        }
        else
           icon= new ImageIcon(getClass().getResource("errorCode.jpeg"));

        resultLabel = new JLabel(icon);
        resultLabel.setVisible(true);

        this.add(resultLabel,BorderLayout.CENTER);
         hPanel= new JPanel();
        BoxLayout box= new BoxLayout(hPanel,BoxLayout.X_AXIS);
        if (type == 0) {

            hPanel.setBackground(new Color(60,80,120));
            hPanel.setLayout(box);
            JLabel inputLabel = new JLabel("    Saved File Name: ");
            inputLabel.setForeground(new Color(204,204,204));
            inputLabel.setFont(new Font("sanSerif",Font.BOLD,30));
            hPanel.add(inputLabel,BorderLayout.SOUTH);
            hPanel.setVisible(true);

            fileNameField = new JTextField(20);
            fileNameField.setMaximumSize(new Dimension(300,30));
            fileNameField.setFont(new Font("sanSerif",Font.BOLD,20));
            fileNameField.setForeground(new Color(60,80,120));
            fileNameField.setText(fileName);
            hPanel.add(fileNameField, BorderLayout.SOUTH);

            JPanel gapPanel= new JPanel();
            gapPanel.setBackground(new Color(60,80,120));
            gapPanel.setMaximumSize(new Dimension(60,100));
            hPanel.add(gapPanel);

            hPanel.setVisible(true);

        }
        menuButton= new JButton("Main manu");
        menuButton.addActionListener(new SaveHandler());
        menuButton.setMaximumSize(new Dimension(100,30));
        hPanel.add(menuButton);
        this.add(hPanel,BorderLayout.SOUTH);

    }
private class SaveHandler implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        DownloadPanel.this.remove(hPanel);
        motherFrame.remove(DownloadPanel.this);
        motherFrame.add(new Welcome(motherFrame));
        motherFrame.pack();
    }
}
}
