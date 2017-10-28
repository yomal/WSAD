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
public class FinalRobotFirst extends AlphaBot{

   
   public void run()
   {
       while(true)
       {
           ahead(300);
           turnGunRight(360);
           scan();
           ahead(100);
           turnGunLeft(360);
       }
   }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        
        turnGunRight(event.getBearing());
        fire(3);
        
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        ahead(300);
        turnLeft(90);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        
        event.getBearingRadians();
        back(300);
    }
   
    
   
   
    
}
