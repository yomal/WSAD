/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import robocode.*;
import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;

/**
 *
 * @author ASUS
 */
public class WSAD extends BravoBot{
   
    boolean peek; // Don't turn if there's a robot there
    double moveAmount; // How much to move
    
    double bulletdamage = 5;
    
   public void run()
   {
       
    moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        peek = false;

        turnLeft(getHeading() % 90);
        ahead(moveAmount);
        // Turn the gun to turn right 90 degrees.
        peek = true;
        turnRadarRight(360);
        turnRight(90);

        while (true) {
            
            if(getOthers() > 3){
                // Look before we turn when ahead() completes.
                peek = true;
                // Move up the wall
                ahead(moveAmount);
                // Don't look now
                peek = false;
                // Turn to the next wall
                turnRight(90);
            }else{
                        turnRight(20);
			// Limit our speed to 5
			// Start moving (and turning)
			//ahead(100);
                        

            }
        }
   }

    public void move()
    {
        
    }
   
    @Override
    public void onScannedRobot(ScannedRobotEvent event) {   
        
        if(getOthers() > 8)
        {
            fire(3);
        }
        
        double objHeading;
        double gunHeading = getGunHeading();
        objHeading = event.getBearing() + getHeading();
        
        if(objHeading > 360)
            objHeading -= 360;
        
        double enemybearing = objHeading - gunHeading;
        
        if(enemybearing == 0)
        {
            fire(3);
        }
        else if(enemybearing < 180 )
        {
            turnRight(objHeading - gunHeading);
            fire(2);
        }
        else
        {
            turnLeft(objHeading - gunHeading);
            fire(1);
        }
        
    }
    
    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        turnLeft(90);
        ahead(300);
    }  
   
     public void onHitRobot(HitRobotEvent e) {
         turnRight(90);
     }
}