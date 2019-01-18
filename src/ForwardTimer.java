import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForwardTimer extends JLabel {

    private long remainingTime;

    public ForwardTimer (){
        remainingTime=0;

        Timer timer= new Timer(1000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ForwardTimer .this.setText(getTimeString());
                remainingTime+=1000;
                ForwardTimer .this.repaint();

            }
        });
        timer.start();
    }

    private String getTimeString()
    {
        int hour=(int)remainingTime/(60*1000*60);
        int min=((int)remainingTime/(60*1000))%60;
        int secund=((int)remainingTime/1000)%60;
        return String.format("%02d : %02d : %02d",hour,min,secund );
    }
}


