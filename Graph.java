/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import queue.*;

/**
 *
 * @author Afnan AlOtaibi
 */
public class Graph {

    private int count;
    private vertex first;

    public Graph() {
    } 
    public int getCount() {
        return count;
    }

    public vertex getFirst() {
        return first;
    }
    
    public void insertVertix(String data ){
        vertex temp=new vertex(data);
        if(first==null){
            first=temp;
        }
        else{
            temp.setNextVertix(first);
            first=temp;
        }
        
        count++;
    }
    
    public vertex deleteVertex(String data){
        if(first==null)
            return null;
        vertex returnData=find(data);
        if(returnData==null){
            System.err.println("the vertex not found ");
            return null;}
        
        if(returnData.getIn()!=0)
        {
            deleteDestination(returnData);
        }
        
        if(returnData==first)
            first=first.getNextVertix();
        else{
           vertex temp=first;
           
           while(temp!=null && temp.getNextVertix()!=returnData)
               temp=temp.getNextVertix();
           
           if(temp!=null)
               temp.setNextVertix(temp.getNextVertix().getNextVertix());     
        }
        
        count--;
        return returnData;
    }
    
    
    public void insertEdge(String from, String to){
        vertex fromPtr=find(from);
        vertex toPtr=find(to);
        if(fromPtr==null ||toPtr==null )
            return ;
       fromPtr.out++;
       toPtr.in++;
       Edge temp=new Edge(toPtr);
       Edge temp2=new Edge(fromPtr);
       
       
       if(fromPtr.getEdge()==null){
           fromPtr.setEdge(temp);
       }
       else{
       temp.setNextEdge(fromPtr.getEdge());
       fromPtr.setEdge(temp);
    }
       
        if(toPtr.getEdge()==null){
           toPtr.setEdge(temp2);
       }
       else{
       temp2.setNextEdge(toPtr.getEdge());
       toPtr.setEdge(temp);
    }
    } 
    
    public void deletEdge(T from, T to){
       vertex fromPtr=find(from);
       vertex toPtr=find(to);
       if(fromPtr==null || toPtr==null)
           return ;
       
       Edge ArcWalk=fromPtr.getEdge();
       Edge ArcWalk2=toPtr.getEdge();
        
       if(ArcWalk==null)
           return ;
       
       fromPtr.out--;
       toPtr.in--;
       
       if(ArcWalk.getDestination()==toPtr)
           fromPtr.setEdge(fromPtr.getEdge().getNextEdge());
       else{
           while(ArcWalk.getNextEdge()!=null && ArcWalk.getNextEdge().getDestination()==toPtr)
               ArcWalk=ArcWalk.getNextEdge();
           if(ArcWalk.getNextEdge()!=null)
               ArcWalk.setNextEdge(ArcWalk.getNextEdge().getNextEdge());
       }
       
       if(ArcWalk2==null)
           return ;
       
       toPtr.out--;
       fromPtr.in--;
       
       if(ArcWalk2.getDestination()==fromPtr)
           toPtr.setEdge(toPtr.getEdge().getNextEdge());
       else{
           while(ArcWalk2.getNextEdge()!=null && ArcWalk2.getNextEdge().getDestination()==fromPtr)
               ArcWalk2=ArcWalk2.getNextEdge();
           if(ArcWalk2.getNextEdge()!=null)
               ArcWalk2.setNextEdge(ArcWalk2.getNextEdge().getNextEdge());
       }
    }

    public vertex find(T k) {
        vertex curr=first;
        
        while(curr!=null &&curr.getData()!=k)
            curr=curr.getNextVertix();
        
        return curr;
    }
    
  

    private void deleteDestination(vertex  del) {
        vertex temp=first;
        
        while(temp!=null){
            Edge temp2=temp.getEdge();
            
            while(temp2!=null){
                if(temp2.getNextEdge()!=null && temp2.getNextEdge().getDestination()==del)
                    temp2.setNextEdge(temp2.getNextEdge().getNextEdge());
                
                temp2=temp2.getNextEdge();
                    }
            temp=temp.getNextVertix();
        }
    }
    
    public void BFS(){
        vertex curr=first;
        while(curr!=null)
        {
            curr.d=Integer.MAX_VALUE;
            curr.process=false;
            curr.PI=null;
            
            curr=curr.getNextVertix();
        }
        
        first.d=0;
        
        LQueue<vertex> Q=new LQueue();
        Q.enQueue(first);
        
        vertex u;
        
        while(!Q.isEmpty())
        {
            u=Q.deQueue();
            
            Edge e=u.getEdge();
            
            while(e!=null){
                if(!e.getDestination().process)
                { e.getDestination().PI=u;
                e.getDestination().d=u.d+1;
                Q.enQueue(e.getDestination());}
                
                e=e.getNextEdge();
            }
            u.process=true;
          
            System.out.println(u.getData()+" ");
        }
        
        
    }
 

    private void fillQueue(LQueue Q) {
        vertex curr=first;
        
        while(curr!=null){
            Q.enQueue(curr);
            curr=curr.getNextVertix();
        }
    
    }
  public void printGraph(){
        vertex curr=first;
    
    while(curr!=null){
            System.out.print("vertix:"+ curr.getData());
            
            Edge temp=curr.getEdge();
            if(temp !=null ){    
            System.out.print(" Adjececnt: ");
            
            while(temp!=null){
                System.out.print(temp.getDestination().getData()+" ");
                temp=temp.getNextEdge();}
            }
            
            curr=curr.getNextVertix();
            System.out.println("");
    }
    }
  
}
   

