package leetcode;

/*
You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.

Sample Input:

student_course_pairs_1 = [
  ["58", "Software Design"],     58  :  [Software Design,Economics,Linear Algebra]
  ["58", "Linear Algebra"],      17  :  [Software Design,Linear Algebra]
  ["94", "Art History"],         94  :  [Economics]
  ["94", "Operating Systems"],   25  :  [Economics]
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
]

Sample Output (pseudocode, in any order):

find_pairs(student_course_pairs_1) =>
{
  [58, 17]: ["Software Design", "Linear Algebra"]
  [58, 94]: ["Economics"]
  [58, 25]: ["Economics"]
  [94, 25]: ["Economics"]
  [17, 94]: []
  [17, 25]: []
}

Additional test cases:

Sample Input:

student_course_pairs_2 = [
  ["42", "Software Design"],
  ["0", "Advanced Mechanics"],
  ["9", "Art History"],
]

Sample output:

find_pairs(student_course_pairs_2) =>
{
  [0, 42]: []
  [0, 9]: []
  [9, 42]: []
}
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentCoursesPair {
  
  private static void pairsMap(String[][] str1){
    
       Map<String,List<String>> map = new HashMap<>();
    
       for(String[] s:str1){
          String std = s[0];
          String course = s[1];
         
          if(map.containsKey(std)){
            map.get(std).add(course);
          }
          else{
            List<String> lst = new ArrayList<>();
            lst.add(course);
            map.put(std,lst);
          }
       }
 



       Map<List<String>,List<String>> res = new HashMap<>();
       for(Map.Entry<String,List<String>> entry1:map.entrySet()){
          String std1 = entry1.getKey();
          List<String> course1 = entry1.getValue();
         
          for(Map.Entry<String,List<String>> entry2:map.entrySet()){
                String std2 = entry2.getKey();
                
                List<String> stud = new ArrayList<>();
                List<String> course2 = entry2.getValue();
                
                stud.add(std1);
                stud.add(std2); 
                List<String> union = Stream.concat(course1.stream(), course2.stream())
                	    .distinct()
                	    .collect(Collectors.toList());
                if(std1.compareTo(std2) > 0){
                  List<String> intersect = course1.stream()
              		    .filter(course2::contains)
              		    .collect(Collectors.toList());
                  res.put(stud,intersect);
                }
               
          }
       }
    
    System.out.println(res);
    
  }
  
  public static void main(String[] argv) {
    String[][] studentCoursePairs1 = {
      {"58", "Software Design"},
      {"58", "Linear Algebra"},
      {"94", "Art History"},
      {"94", "Operating Systems"},
      {"17", "Software Design"},
      {"58", "Mechanics"},
      {"58", "Economics"},
      {"17", "Linear Algebra"},
      {"17", "Political Science"},
      {"94", "Economics"},
      {"25", "Economics"}
    };

    String[][] studentCoursePairs2 = {
      {"42", "Software Design"},
      {"0", "Advanced Mechanics"},
      {"9", "Art History"},
    };
     
    pairsMap(studentCoursePairs1);
    
  }  
}


















/*
You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.

Sample Input:

student_course_pairs_1 = [
  ["58", "Software Design"], 58 - S.D , L.A 
  ["58", "Linear Algebra"],  17  - S.D
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
]

Sample Output (pseudocode, in any order):

find_pairs(student_course_pairs_1) =>
{
  [58, 17]: ["Software Design", "Linear Algebra"]
  [58, 94]: ["Economics"]
  [58, 25]: ["Economics"]
  [94, 25]: ["Economics"]
  [17, 94]: []
  [17, 25]: []
}

Additional test cases:

Sample Input:

student_course_pairs_2 = [
  ["42", "Software Design"],
  ["0", "Advanced Mechanics"],
  ["9", "Art History"],
]

Sample output:

find_pairs(student_course_pairs_2) =>
{
  [0, 42]: []
  [0, 9]: []
  [9, 42]: []
}
*/

/*
import java.io.*;
import java.util.*;

public class Solution {
  
  private static void pairsMap(String[][] str1){
    
       Map<String,List<String>> map = new HashMap<>();
    
       for(String[] s:str1){
          String std = s[0];
          String course = s[1];
         
          if(map.containsKey(std)){
            map.get(std).add(course);
          }
          else{
            List<String> lst = new ArrayList<>();
            lst.add(course);
            map.put(std,lst);
          }
       }
        

       Map<List<String>,List<String>> res = new HashMap<>();
       for(Map.Entry<String,List<String>> entry1:map.entrySet()){
          String std1 = entry1.getKey();
          List<String> course1 = entry1.getValue();
         
          for(Map.Entry<String,List<String>> entry2:map.entrySet()){
                String std2 = entry2.getKey();
                List<String> lst = new ArrayList<>();
                List<String> stud = new ArrayList<>();
            
                List<String> course2 = entry2.getValue();
                
                stud.add(std1);
                stud.add(std2); 
                
                if(std1.compareTo(std2) > 0){
                  List<String> courses = new ArrayList<>();
                  for(String s1: course1){
                    
                    
                    for(String s2 : course2){
                      
                      if(s1.equals(s2)){
                        courses.add(s1);
                        
                      }
                    }
                    
                  }
                  res.put(stud,courses);
                }
                
               
          }
       }
    
    System.out.println(res); */
    
//     for(Map.Entry<String,List<String>> entry:map.entrySet){
    
     
//     }
//     Map<Set<String>,List<String>> map1 = new HashMap<>();
//     HashSet<String> set1 = new HashSet<>();
//     for(String[] s:str1){
//         String k = s[0];
//         String v = s[1];
//         set1.add(k);
//         List<String> lst = new ArrayList<>();
//         lst.add(v);
//         if(!map1.containsKey(set1))
//           map1.put(set1,lst);
//         else
//           map1.get(set1).add(lst);
//     }
    
 /* }
  
  public static void main(String[] argv) {
    String[][] studentCoursePairs1 = {
      {"58", "Software Design"},
      {"58", "Linear Algebra"},
      {"94", "Art History"},
      {"94", "Operating Systems"},
      {"17", "Software Design"},
      {"58", "Mechanics"},
      {"58", "Economics"},
      {"17", "Linear Algebra"},
      {"17", "Political Science"},
      {"94", "Economics"},
      {"25", "Economics"}
    };

    String[][] studentCoursePairs2 = {
      {"42", "Software Design"},
      {"0", "Advanced Mechanics"},
      {"9", "Art History"},
    };
     
    pairsMap(studentCoursePairs1);
    
  }
}
*/
