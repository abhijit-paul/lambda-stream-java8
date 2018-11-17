import java.util.*;

public class FindNemo {
  public static void main(String[] args) {
    List<String> names =
      Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

    findNemo(names);

    Optional<String> result = names.stream().filter(FindNemo::findNemoStat2).findFirst();
    showIsNemoFound(result.isPresent());

    showIsNemoFound(names.stream().anyMatch(FindNemo::findNemoStat2));
  }

  public static void findNemoStat(String name) {
    if(name.equals("Nemo")) {
        System.out.println("Found Nemo");
    }
  }

  public static boolean findNemoStat2(String name) {
      if("Nemo".equals(name))   {
          System.out.println("Found Nemo");
          return true;
      }
      else {
          return false;
      }
  }

  public static void showIsNemoFound(boolean isFound) {
      if (!isFound)  {
          System.out.println("Sorry, Nemo not found");
      }
  }

  public static void findNemo(List<String> names) {
    boolean found = false;
    for(String name : names) {
      if(name.equals("Nemo")) {
        found = true;
        break;
      }
    }

    if(found)
      System.out.println("Found Nemo");
    else
      System.out.println("Sorry, Nemo not found");
  }
}