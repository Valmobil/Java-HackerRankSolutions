package ReflectionGetMethods;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class ReflectionGetMethods {

  public static void main(String[] args) {
    Class student = Student.class;
    Method[] methods = student.getMethods();

    ArrayList<String> methodList = new ArrayList<>();
    for (Method m : methods) {
      methodList.add(m.getName());
    }
    Collections.sort(methodList);
    for (String name : methodList) {
      System.out.println(name);
    }
  }
}


