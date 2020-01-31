package reflectionTestAnyObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
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
      System.out.println();
      printConstructors(cl);
      System.out.println();
      printMethods(cl);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void printMethods(Class cl) {
    Method[] methods = cl.getDeclaredMethods();
    System.out.println("List of Methods:");
    for (int i = 0; i < methods.length ; i++) {
      Method method = methods[i];
      Class retType = method.getReturnType();
      String name = method.getName();
      String modifier = Modifier.toString(method.getModifiers());

      System.out.format("%s %s %s %s", modifier, retType, name, "(");
      Parameter[] parameters = method.getParameters();
      for (int j = 0; j < parameters.length; j++) {
        if (j > 0) {
          System.out.print(", ");
        }
        String param = parameters[j].toString();
        System.out.print(param);
      }
      System.out.println(");");
    }
  }

  private static void printConstructors(Class cl) {
    Constructor[] constructors = cl.getConstructors();
    System.out.println("Constructors:");
    for (int i = 0; i < constructors.length; i++) {
      Constructor constructor = constructors[i];
      String name = constructor.getName();
      System.out.print(Modifier.toString(cl.getModifiers()));
      System.out.print(" " + name + "(");
      Class[] parameterTypes = constructor.getParameterTypes();
      for (int j = 0; j < parameterTypes.length; j++) {
        if (j > 0) {
          System.out.print(", ");
        }
        System.out.print(parameterTypes[j].getName());

      }
      System.out.println(");");
    }

  }
}
