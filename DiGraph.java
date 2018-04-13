/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author Afnan AlOtaibi
 * date : 4/13/2018
 */
public class DiGraph {
    private int count;
    private vertex first;

    public DiGraph() {
    } 
    public int getCount() {
        return count;
    }

    public vertex   getFirst() {
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
        
        int weight=calculateWeight(from,to);
        if(fromPtr==null ||toPtr==null )
            return ;
       fromPtr.setOut(fromPtr.getOut()+1);
       toPtr.setIn(toPtr.getIn()+1);
       Edge temp=new Edge(toPtr);
       temp.setWieght(weight);
       
       if(fromPtr.getEdge()==null){
           fromPtr.setEdge(temp);
       }
       else{
       temp.setNextEdge(fromPtr.getEdge());
       fromPtr.setEdge(temp);
    }
    } 
    
     private int calculateWeight(String  from, String  to) {
         int f=Integer.parseInt(from.substring(from.lastIndexOf('.')+1));
         int t=Integer.parseInt(to.substring(from.lastIndexOf('.')+1));
         
         return Math.abs(f-t);
     
     }
    
    public void deleteEdge(String from, String to){
       vertex fromPtr=find(from);
       vertex toPtr=find(to);
       if(fromPtr==null || toPtr==null)
           return ;
       
       Edge ArcWalk=fromPtr.getEdge();
        
       if(ArcWalk==null)
           return ;
       
       fromPtr.setOut(fromPtr.getOut()-1);
       toPtr.setIn(toPtr.getIn()-1);
       
       if(ArcWalk.getDestination()==toPtr)
           fromPtr.setEdge(fromPtr.getEdge().getNextEdge());
       else{
           while(ArcWalk.getNextEdge()!=null && ArcWalk.getNextEdge().getDestination()==toPtr)
               ArcWalk=ArcWalk.getNextEdge();
           if(ArcWalk.getNextEdge()!=null)
               ArcWalk.setNextEdge(ArcWalk.getNextEdge().getNextEdge());
       }
    }

    public vertex find(String k) {
        vertex curr=first;
        
        while(curr!=null &&!curr.getKey().equals(k))
            curr=curr.getNextVertix();
        
        return curr;
    }
    
    public void printGraph(){
        vertex curr=first;
    
    while(curr!=null){
            System.out.print("vertix:"+ curr.getKey()+" d= "+curr.getD());
            
            Edge temp=curr.getEdge();
            if(temp !=null ){    
            System.out.print(" Adjececnt: ");
            
            while(temp!=null){
                System.out.print(temp.getDestination().getKey()+" Wieght: "+temp.getWieght()+", ");
                temp=temp.getNextEdge();}
            }
            
            curr=curr.getNextVertix();
            System.out.println("");
    }
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
    
  
    

    
}
