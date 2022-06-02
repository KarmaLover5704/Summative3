import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class input extends Actor
{
    
    
    
  
    /**
     * Act - do whatever the rectangle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    
      String num = Greenfoot.ask("How many numbers do you want to generate? (5-20)");
      
      int number = Integer.parseInt(num);
    }    
}
