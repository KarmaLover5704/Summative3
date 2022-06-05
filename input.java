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
    
    public void printToScreen(String text,  int x, int y){
        GreenfootImage letters = new GreenfootImage(text, 25, Color.CYAN, new Color(0, 0, 0, 0));
        getWorld().getBackground().drawImage(letters, (getWorld().getWidth()-letters.getWidth())/2, y);
        
        
    }
     
    public void act() 
    {
        
      int delay = 200;
      int number = 1;
      if(isAsked == false ){
          String num = Greenfoot.ask("How many numbers do you want to generate? (5-20)");
          number = Integer.parseInt(num);
          
          RadixSort radixSort = new RadixSort(number);
      
          radixSort.radixSort();
          
          printToScreen("Original Array: " + radixSort.getStartingArgs(), 250, 10);
          Greenfoot.delay(delay);
          printToScreen("First Step: " + radixSort.getStage(0), 250, 35);
          Greenfoot.delay(delay);
          printToScreen("Second Step: " + radixSort.getStage(1), 250, 80);
          Greenfoot.delay(delay);
          printToScreen("Third Step: " + radixSort.getStage(2), 250, 110);
          Greenfoot.delay(delay);
          printToScreen("Sorted array: " + radixSort.toString(), 250, 140);
          Greenfoot.delay(delay);
          isAsked = true;
      }
      
      
      
      
 
    } 
    
}

