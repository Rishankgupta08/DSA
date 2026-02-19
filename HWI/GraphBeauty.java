package HWI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

class GraphBeauty{
    static int[] parent;
    static int[] size;
    static Map<Integer, HashSet<Integer>> compMap;
    static Map<Integer,Integer> compbeauty;
    public static int find(int x){
        if(x==parent[x]) return x;
        return  parent[x]=find(parent[x]);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int t=sc.nextInt();
        //  initialization 
        parent=new int[n+1];
        size=new int[n+1];
        compMap=new HashMap<>();
        compbeauty=new HashMap<>();

        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
            HashSet<Integer> set=new HashSet<>();
            set.add(i);
            compMap.put(i,set);
            compbeauty.put(i,1);
        }
        long totalBeauty=0;
        while(q-- > 0){
            int type=sc.nextInt();
            int u=sc.nextInt();
            int v=sc.nextInt();

            if(type==1){
                int p_u=find(u);
                int p_v=find(v);
                if(p_u != p_v){
                    if(size[p_u] < size[p_v]){
                        int temp=p_u;
                        p_u=p_v;
                        p_v=temp;
                    }
                    parent[p_v]=p_u;
                    size[p_u]+=size[p_v];

                    HashSet<Integer> big=compMap.get(p_u);
                    HashSet<Integer> small=compMap.get(p_v);
                    int beautyBig=compbeauty.get(p_u);
                    for(int node : small){
                        boolean left=big.contains(node-1);
                        boolean right=big.contains(node+1);
                        if(left && right) beautyBig--;
                        else if( !left && !right) beautyBig++;
                        big.add(node);
                    }
                    // Adding new HashSet and new Beauty to parent of u
                    compMap.put(p_u,big);
                    compbeauty.put(p_u,beautyBig);
                    //Remove small HashSet and its beauty 
                    compbeauty.remove(p_v);
                    compMap.remove(p_v);
                }
            }
            else if(type==2){
                int p_u=find(u);
                int beauty_u=compbeauty.get(p_u);
                totalBeauty+=beauty_u;
            }
        }
        System.out.println(totalBeauty);

    }
}