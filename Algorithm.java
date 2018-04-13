/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;
import queue.*;
import java.security.SecureRandom;

/**
 *
 * @author Afnan AlOtaibi
 */
public class Algorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DiGraph x=GenerateRandomGraph(50);
//        DiGraph x=new DiGraph();

//        x.insertVertix("241.12.31."+14);
//        x.insertVertix("241.12.31.15");
//        x.insertVertix("241.12.31.16");
//        x.insertVertix("241.12.31.17");
//        x.insertVertix("241.12.31.18");
//        x.insertVertix("241.12.31.19");
//        x.insertVertix("241.12.31.120");
//        x.insertVertix("241.12.31.140");
//        x.insertEdge("241.12.31.14","241.12.31.140");
//        x.insertEdge("241.12.31.15","241.12.31.18");
//        x.insertEdge("241.12.31.14","241.12.31.15");
//        x.insertEdge("241.12.31.14","241.12.31.17");
//        x.insertEdge("241.12.31.140","241.12.31.120");
//        x.insertEdge("241.12.31.15","241.12.31.16");
//        x.insertEdge("241.12.31.15", "241.12.31.19");
//        x.insertEdge("241.12.31.19", "241.12.31.17");
//        x.insertEdge("241.12.31.16","241.12.31.18");
//        x.insertEdge("241.12.31.18", "241.12.31.19");
//        x.insertEdge("241.12.31.17", "241.12.31.120");
//        x.insertEdge("241.12.31.120", "241.12.31.15");
//       x.printGraph();
        shortestPathUsingDijkstra(x,"241.12.31.14","241.12.31.47");
        x.printGraph();
//        System.out.println(x.find("241.12.31.14").getKey());
        
      
    }
    public static void shortestPathUsingDijkstra(DiGraph g,String source, String destination  ){
        
        dijkstra(source,g);
        
        vertex s=g.find(destination);
        
        LStack S= new LStack();
        
        
        while(!s.getKey().equals(source)){
        S.push(s.getKey());
        s=s.getPI();
        }
        S.push(source);
        printRoutingTable(S);
    }

   public static  void dijkstra(String source,DiGraph g){
        vertex s=g.find(source);
        
        initilazeSingleSource(s,g);
        
        vertex[] arr=fillArray(g);
        
        MinPriorityQueue Q=new MinPriorityQueue(arr);
        
        vertex u; 
        
        while(!Q.isEmpty()){
            u=Q.extractMin();
            Edge e=u.getEdge();
            
            while(e!=null){
                relax(e.getDestination(),u,e.getWieght(),Q);
                e=e.getNextEdge();
            }
            
        }
    }
    public static  void initilazeSingleSource(vertex s, DiGraph g) {
        vertex curr=g.getFirst();
        
        while(curr!=null){
            curr.setD(Integer.MAX_VALUE);
            curr.setPI(null);
            curr=curr.getNextVertix();
        }
        
        s.setD(0);
    }  
    private static vertex[] fillArray(DiGraph g) {
        vertex curr=g.getFirst();
        vertex [] arr= new vertex[g.getCount()];
        for (int i = 0; i < arr.length; i++,curr=curr.getNextVertix()) {
            arr[i]=curr;
        }
    return arr;
    }

    private static void relax(vertex destination, vertex u, int wieght,MinPriorityQueue Q) {
        
        if(destination.getD()>(u.getD()+wieght))
        {
            destination.setD(u.getD()+wieght);
            destination.setPI(u);
           Q.decreaseKey(destination);
           
        }
    
    }

    private static void printRoutingTable(LStack<String> S) {
        String temp,s;
        s=S.pop();
        while(!S.isEmpty()){
            System.out.print(s+"(");
            temp= S.pop();
            s= S.pop();
            if(s==null)
                System.out.println(temp+","+"000.00.00.00)");
            else
                System.out.println(s+","+temp+")");
        }
    }

    private static DiGraph GenerateRandomGraph(int l) {
            DiGraph x= new DiGraph();
            
           
            boolean [][] ishere=new boolean[l][l];
            
            for (int i = 2; i <l+2; i++) {
                
                x.insertVertix("241.12.31."+i);
        }
            int numofEdges=(l*(l-1))/2 ;
            int numofEdgesPerV=(int)(numofEdges/l);
            SecureRandom rand= new SecureRandom();
            int r;
            int c=0;
            
            for (int i = 0; i <l; i++) {
                
                for (int j = 0; j < numofEdgesPerV; j++) {
                    r=rand.nextInt(l);
                    
                    if(r!=i && !ishere[i][r]){
                        
                        x.insertEdge("241.12.31."+(i+2),"241.12.31."+(r+2));
                        ishere[i][r]=true;
                       c++;
                    }
                }
        }
           System.out.println(c);
          return x;  
    }
}
