/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalrobotfirst;
import robocode.*;
/**
 *
 * @author ASUS
 */
public class WSAD extends AlphaBot{
   
    boolean peek; // Don't turn if there's a robot there
	double moveAmount; // How much to move
    
   public void run()
   {
       
       moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		// Initialize peek to false
        peek = false;

        turnLeft(getHeading() % 90);
        ahead(moveAmount);
        // Turn the gun to turn right 90 degrees.
        peek = true;
        turnGunRight(90);
        turnRight(90);

        while (true) {
                // Look before we turn when ahead() completes.
                peek = true;
                // Move up the wall
                ahead(moveAmount);
                // Don't look now
                peek = false;
                // Turn to the next wall
                turnRight(90);
        }

   }

    public void move()
    {
        
    }
   
    @Override
    public void onScannedRobot(ScannedRobotEvent event) {   
        
        double objHeading;
        double gunHeading = getGunHeading();
        objHeading = event.getBearing() + getHeading();
        
        if(objHeading > 360)
            objHeading -= 360;
        
        double enemybearing = objHeading - gunHeading;
        
        if(enemybearing == 0)
        {
            fire(1);
        }
        else if(enemybearing < 180 )
        {
            turnGunRight(objHeading - gunHeading);
            fire(1);
        }
        else
        {
            turnGunLeft(objHeading - gunHeading);
            fire(1);
        }
        
    }
    
    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        turnLeft(90);
        ahead(300);
    }


   
    
   
   
    
}
