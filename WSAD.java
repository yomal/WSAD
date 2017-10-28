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
   
   public void run()
   {
       while(true)
       {
           //ahead(300);
           turnRadarLeft(360);
           //ahead(100);
       }
   }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {   
        
        double angle = getGunHeading();
        
        event.getBearing();
        
        /*
        if(event.getBearing() > 0){
            turnGunRight(event.getBearing());
            turnRadarRight(event.getBearing());
        }
        else
        {
            turnGunLeft(-event.getBearing());
            turnRadarLeft(-event.getBearing());
        }
        //fire(3);
        */
    }
  

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        turnLeft(90);
        back(250);
        ahead(300);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        turnRight(event.getBearing() + 90);
        ahead(300);
        back(200);
        turnGunRight(90);
    }
   
    
   
   
    
}
