package Practice1;

public class Bird extends Animal {
  
  private final static String moveClassName = "fly";
  
  public Bird(String name)
  {
    super(name, moveClassName);
  }
    
  @Override
  public String sound()
  {
    return "chirp";
  }


}

