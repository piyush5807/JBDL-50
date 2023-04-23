import java.util.Comparator;

@FunctionalInterface
public interface SampleFunctionalInterface {

  /**
   * Functional interfaces are those interfaces which have one non overriding abstract method.
   */

  boolean isNull(Object a); // abstract functions

  boolean equals(Object a);

//  int compare(Object o);

  int hashCode();

}
