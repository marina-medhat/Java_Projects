/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package appletproj;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;


/**
 *
 * @author Marina
 */
public class helloApplet extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    
    @Override
    public void paint(Graphics g)
    {
        String x=getParameter("string");
        g.drawString(x, 50, 100);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
