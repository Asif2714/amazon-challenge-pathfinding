import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Handler with deals with the Enter Button
public class KeyHandler implements KeyListener {

    Panel panel;

    public KeyHandler(Panel panel){
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_ENTER){
            //panel.search();
            panel.autoSearch();
        }
    }

    @Override
    public void keyReleased(KeyEvent e){

    }

}
