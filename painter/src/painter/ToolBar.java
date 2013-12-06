
package painter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ToolBar extends JPanel{    // JPanel is in the " javax.swing "
    
        MainWindows parent = null;      // It's a reference to Maindows
        JButton drawLineBtn;        
        JButton stopDrawLineBtn;
    
        ToolBar(MainWindows p)
        {
            parent = p;
            
            this.setBackground(Color.RED);      // Toolbar's backgorund is Red
            this.setLayout(new FlowLayout(FlowLayout.LEFT));   // when you move the window , it can free to chage its size
            //this.setLayout(new BorderLayout());
            
            JButton exitBtn= new JButton("Exit");   // The button of the effect is Close
            drawLineBtn= new JButton("DrawLine");   // The button of the Draw a Line
            stopDrawLineBtn = new JButton("StopDrawLine");  // The button of the Stop to drawline
            
            exitBtn.addMouseListener (      // Set the Listener
                    new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
                    {
                        public void mouseClicked(MouseEvent e)      // when you click the mouse
                        {
                            System.exit(0);     // The window will Close
                        }
                    }           
             );
            
            drawLineBtn.addMouseListener (      // Set the Listener
                    new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
                    {
                        public void mouseClicked(MouseEvent e)      // when you click the mouse
                        {
                            parent.page.fir = true;             // reset the first point
                            parent.parent.drawline = true;     // you can draw
                            ToolBar.this.stopDrawLineBtn.setEnabled(true);  // now stopdrawlinebtn can use
                            ToolBar.this.drawLineBtn.setEnabled(false);     // now drawlinebtn can't use
                        }
                    }           
             );
            
            stopDrawLineBtn.addMouseListener (      // Set the Listener
                    new MouseAdapter ()     // in the java.awt.event , it just a module contain Event
                    {
                        public void mouseClicked(MouseEvent e)      // when you click the mouse
                        {
                            parent.parent.drawline = false;     // you can't draw
                            ToolBar.this.stopDrawLineBtn.setEnabled(false);     // now stopdrawlinebtn can't use
                            ToolBar.this.drawLineBtn.setEnabled(true);     // now drawlinebtn can use
                        }
                    }           
             );
            
            this.stopDrawLineBtn.setEnabled(false);     // set stopdrawlinebtn can't use
            this.add(drawLineBtn);    // add a new Button
            this.add(stopDrawLineBtn);  // add a new Button
            this.add(exitBtn);      // add a new Button
        }

                   
}
