import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  @Test(timeout=500)
  public void testFilter() {
    List<String> list = Arrays.asList("apple", "banana", "cherry", "date");
    
    // Filter to include strings starting with 'a'
    List<String> filteredList = ListExamples.filter(list, s -> s.startsWith("a"));
    
    // Expected result: ["apple"]
    List<String> expected = Arrays.asList("apple");
    
    assertEquals(expected, filteredList);
  }
  @Test
  public void testMerge() {
    List<String> list1 = Arrays.asList("apple", "banana", "cherry");
    List<String> list2 = Arrays.asList("date", "fig", "grape");
    
    // Merge the two lists
    List<String> mergedList = ListExamples.merge(list1, list2);
    
    // Expected result: ["apple", "banana", "cherry", "date", "fig", "grape"]
    List<String> expected = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
    
    assertEquals(expected, mergedList);
  }
  @Test
  public void testFilter_EmptyList() {
    List<String> list = Collections.emptyList();
    
    // Filter to include strings starting with 'a'
    List<String> filteredList = ListExamples.filter(list, s -> s.startsWith("a"));
    
    // Expected result: []
    List<String> expected = Collections.emptyList();
    
    assertEquals(expected, filteredList);
  }
  @Test
  public void testMerge_EmptyList() {
    List<String> list1 = Collections.emptyList();
    List<String> list2 = Arrays.asList("apple", "banana");
    
    // Merge the two lists
    List<String> mergedList = ListExamples.merge(list1, list2);
    
    // Expected result: ["apple", "banana"]
    List<String> expected = Arrays.asList("apple", "banana");
    
    assertEquals(expected, mergedList);
  }
  
  @Test
  public void testMerge_SameList() {
    List<String> list1 = Arrays.asList("apple", "banana", "cherry");
    List<String> list2 = Arrays.asList("apple", "banana", "cherry");
    
    // Merge the two lists
    List<String> mergedList = ListExamples.merge(list1, list2);
    
    // Expected result: ["apple", "apple", "banana", "banana", "cherry", "cherry"]
    List<String> expected = Arrays.asList("apple", "apple", "banana", "banana", "cherry", "cherry");
    
    assertEquals(expected, mergedList);
  }


}
