import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TestFriendlyWords 
{

    @Test
    public void test1FriendlyFunc() 
    {
        FriendlyWords fw = new FriendlyWords();
        String[] input = { "" };
        ArrayList<ArrayList<String>> actual =  fw.getFriendly(input);
        ArrayList<ArrayList<String>> expected = new  ArrayList<ArrayList<String>>();
        assertEquals(expected, actual);
    }
    
    @Test
    public void test2FriendlyFunc() 
    {
        FriendlyWords fw = new FriendlyWords();
        String[] input = { "abc" ,"def" };
        ArrayList<ArrayList<String>> actual =  fw.getFriendly(input);
        ArrayList<ArrayList<String>> expected = new  ArrayList<ArrayList<String>>();
        assertEquals(expected, actual);
    }

    @Test
    public void test3FriendlyFunc() 
    {
        FriendlyWords fw = new FriendlyWords();
        String[] input = { "eat", "ate", "mango", "ten", "tea" };
        ArrayList<ArrayList<String>> actual =  fw.getFriendly(input);
        ArrayList<String> al = new ArrayList<String>();
        al.add("ate");
        al.add("eat");
        al.add("tea");
        ArrayList<ArrayList<String>> expected = new  ArrayList<ArrayList<String>>();
        expected.add(al);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test4FriendlyFunc() 
    {
        FriendlyWords fw = new FriendlyWords();
        String[] input = { "cat", "net", "eat", "apple", "land", "chicken", "go", "dog", "ate", "mango", "ten", "teaching", "cheating", "god", "act","tea" };
        ArrayList<ArrayList<String>> actual =  fw.getFriendly(input);
        ArrayList<ArrayList<String>> expected = new  ArrayList<ArrayList<String>>();
        ArrayList<String> al = new ArrayList<String>();
        al.add("act");
        al.add("cat");
        expected.add(al);
        al = new ArrayList<String>();
        al.add("ate");
        al.add("eat");
        al.add("tea");
        expected.add(al);
        al = new ArrayList<String>();
        al.add("cheating");
        al.add("teaching");
        expected.add(al);
        al = new ArrayList<String>();
        al.add("dog");
        al.add("god");
        expected.add(al);
        al = new ArrayList<String>();
        al.add("net");
        al.add("ten");
        expected.add(al);
        assertEquals(expected, actual);
    }
}