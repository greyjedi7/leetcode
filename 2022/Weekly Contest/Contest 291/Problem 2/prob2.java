import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class prob2 {


    public int minimumCardPickup(int[] cards){

        Map<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<cards.length;i++){
            if(hashMap.get(cards[i]) == null){
                hashMap.put(cards[i], new ArrayList<>());
            }
            hashMap.get(cards[i]).add(i);
        }

        int minimumDistance = Integer.MAX_VALUE;

        Iterator<Integer> itr = hashMap.keySet().iterator();
        while(itr.hasNext()){
            List<Integer> list = hashMap.get(itr.next());

            for(int i=1;i<list.size();i++){
                int dist = list.get(i) - list.get(i-1) + 1;
                if(dist < minimumDistance){
                    minimumDistance = dist;
                }
               } 

        }

        if(minimumDistance == Integer.MAX_VALUE){
            return -1;
        }
        return minimumDistance;
    }

    public static void main(String[] args){
        int[] cards = new int[]{3,4,2,3,4,7};
        prob2 prob2Obj = new prob2();
        System.out.println(prob2Obj.minimumCardPickup(cards));
    }

}