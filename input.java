import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class input extends Actor
{
    
    
    boolean isAsked = false;
  
    /**
     * Act - do whatever the rectangle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
      
      int number = 1;
      if(isAsked == false ){
          String num = Greenfoot.ask("How many numbers do you want to generate? (5-20)");
          number = Integer.parseInt(num);
          
          RadixSort radixSort = new RadixSort(number);
      
          radixSort.radixSort();
          
          getWorld().showText(radixSort.getStartingArgs(), 250, 10);
          
          
          getWorld().showText(radixSort.getStage(0), 250, 35);
          getWorld().showText(radixSort.getStage(1), 250, 60);
          getWorld().showText(radixSort.getStage(2), 250, 85);
          getWorld().showText(radixSort.toString(), 250, 110);
          isAsked = true;
      }
      
      
      
      
 
    }    
}
