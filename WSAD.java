/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import robocode.*;
/**
 *
 * @author ASUS
 */
public class WSAD extends CharlieBot{
   
    boolean peek; // Don't turn if there's a robot there
    double moveAmount; // How much to move
    
    double bulletdamage = 4;
    
   public void run()
   {
       
       moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        peek = false;

        turnLeft(getHeading() % 90);
        ahead(moveAmount);
        // Turn the gun to turn right 90 degrees.
        peek = true;
        turnRight(90);

        while (true) {

                turnGunRight(90);
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
      
   
    public void smartTurn()
    {
        if(getX() < getWidth() / 5)
        {
            if(getHeading() < 30 && getHeading() > 330)
            {
                turnRight(45);
            }
        }
        if(getY() > getWidth() / 5)
        {
            if(getHeading() > 30 && getHeading() < 75 )
            {
                turnRight(45);
            }
        }
        ahead(100);
    }
    
    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        
        if(event.getBearing() < 30 && event.getBearing() > -30 )
        {
            turnRight(90);
            ahead(100);
        }
    }  

    @Override
    public void onHitWall(HitWallEvent event) {
        //turnRight(90);
    }

    @Override
    public void onRobotDetected(ScannedRobotEvent event) {
        
        if(getOthers() > 10)
        {
            bulletdamage = 3;
        }
        if(getOthers() > 3)
        {
            bulletdamage = 2;
        }
        else
        {
            bulletdamage = 1;
        }
        
        if(getOthers() < 3 & event.getDistance() < 60)
        {
            bulletdamage = 3;
        }   
        
        double objHeading;
        double gunHeading = getGunHeading();
        objHeading = event.getBearing() + getHeading();
        
                
        turnGunLeft(objHeading - gunHeading); 
        fire(bulletdamage);
        smartTurn();
        turnGunLeft(objHeading - gunHeading + 10); 
        fire(bulletdamage);
        
        

    }

    @Override
    public void onHitRobot(HitRobotEvent e) {
        if (e.getBearing() == 0) {
            fire(3);
        } else if (e.getBearing() == -90) {
            turnGunLeft(90);
            fire(2);
        } else if (e.getBearing() == 90) {
            turnGunRight(90);
            fire(2);
        } else if (e.getBearing() > -20 && e.getBearing() < 20) {
            fire(3);
        } else if (e.getBearing() > -35 && e.getBearing() < 35) {
            fire(2);
        } else if (e.getBearing() > -50 && e.getBearing() < 50) {
            fire(1);
        } else {
            //back(50);
        }
    }

    
}
