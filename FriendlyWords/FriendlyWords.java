import java.util.*;
public class FriendlyWords 
{
    public static void main(String args[]) 
    {
        String[] input = { "cat", "net", "eat", "apple", "land", "chicken", "go", "dog", "ate", "mango", "ten", "teaching", "cheating", "god", "act","tea" };
        FriendlyWords fw = new FriendlyWords();
        ArrayList<ArrayList<String>> output = fw.getFriendly(input);
        fw.displayResult(output);
    }
    public void displayResult(ArrayList<ArrayList<String>> output)
    {
        for(ArrayList<String> al: output)
        {
            for(String str: al)
            {
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
    public ArrayList<ArrayList<String>> getFriendly(String[] input)
    {
        int n = input.length;
        Arrays.sort(input); //sorting to preserve order
        HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
        //mapping strings to length
        for(int i=0;i<n;i++)
        {
            int cur_len = input[i].length();
            if(!hm.containsKey(cur_len))
            {
                ArrayList<String> al = new ArrayList<String>();
                al.add(input[i]);
                hm.put(cur_len,al);
            }
            else
            {
                ArrayList<String> al = hm.get(cur_len);
                al.add(input[i]);
                hm.put(cur_len,al);
            }
        }
        HashMap<String, ArrayList<String>> sortedhm = new HashMap<String, ArrayList<String>>();
        Iterator it = hm.entrySet().iterator();
        //sorting and mapping strings to their sorted form
        while (it.hasNext()) 
        {
            Map.Entry pair = (Map.Entry)it.next();
            //System.out.println(pair.getKey() + " = " + pair.getValue());
            ArrayList<String> al = (ArrayList<String>)pair.getValue();
            if(al.size()>1)
            {
                for(String str: al)
                {
                    char[] strs = str.toCharArray();
                    Arrays.sort(strs);
                    String sorted_str = new String(strs);
                    if(!sortedhm.containsKey(sorted_str))
                    {
                        ArrayList<String> al_sorted = new ArrayList<String>();
                        al_sorted.add(str);
                        sortedhm.put(sorted_str,al_sorted);
                    }
                    else
                    {
                        ArrayList<String> al_sorted = sortedhm.get(sorted_str);
                        al_sorted.add(str);
                        sortedhm.put(sorted_str,al_sorted);
                    }
                }
            }
            it.remove(); 
        }
        Map<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
        it = sortedhm.entrySet().iterator();
        //mapping to Treemap to preserve order
        while (it.hasNext()) 
        {
            Map.Entry pair = (Map.Entry)it.next();
            ArrayList<String> al = (ArrayList<String>)pair.getValue();
            if(al.size()>1)
            {
                map.put(al.get(0),al);
            }
            it.remove();
        }
        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
        it = map.entrySet().iterator();
        //mapping to Treemap to preserve order
        while (it.hasNext()) 
        {
            Map.Entry pair = (Map.Entry)it.next();
            output.add((ArrayList<String>)pair.getValue());
            it.remove();
        }
        return output;
    }
}