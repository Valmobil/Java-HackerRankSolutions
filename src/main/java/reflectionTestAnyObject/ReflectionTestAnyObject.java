package reflectionTestAnyObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import javax.swing.JOptionPane;

public class ReflectionTestAnyObject {

  public static void main(String[] args) {
    String name;
    if (args.length>0) {
      name = args[0];
    } else {
      name = JOptionPane.showInputDialog("Enter class name (e.g. java.util.Date): ");
    }
    try {
      //Print class and superclass names
      Class cl = Class.forName(name);
      Class superClass = cl.getSuperclass();
      System.out.println("Class name: " + name);
      if (superClass != null && Object.class != superClass) {
        System.out.println("SuperClass name: " + superClass.getName());
      }
      printConstructors(cl);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void printConstructors(Class cl) {
    Constructor[] constructors = cl.getConstructors();
    for (int i = 0; i < constructors.length; i++) {
      Constructor constructor = constructors[i];
      String name = constructor.getName();
      System.out.println(Modifier.toString(cl.getModifiers()));
      System.out.println("Constructor name: " + name + "{");
      Class[] parameterTypes = constructor.getParameterTypes();
      for (int j = 0; j < parameterTypes.length; j++) {
        if (j > 0) {
          System.out.print(", ");
        }
        System.out.println(parameterTypes[j].getName());
      }
      System.out.println("};");
    }

  }
}
