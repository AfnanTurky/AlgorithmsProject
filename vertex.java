/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author Afnan AlOtaibi
 */
public class vertex {
    private vertex nextVertix;
    private String key;
    private int in;
    private int out;
    boolean process;
    private Edge Edge;
    private int d;
    private vertex PI;
    
    public vertex(String key) {
        this.key = key;
    }
    public vertex getNextVertix() {
        return nextVertix;
    }
    public void setNextVertix(vertex nextVertix) {
        this.nextVertix = nextVertix;
    }
    

    public Edge getEdge() {
        return Edge;
    }

    public void setEdge(Edge Edge) {
        this.Edge = Edge;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public boolean isProcess() {
        return process;
    }

    public void setProcess(boolean process) {
        this.process = process;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public vertex getPI() {
        return PI;
    }

    public void setPI(vertex PI) {
        this.PI = PI;
    }
    

    int compareTo(vertex v) {
        
         if (d < v.d) {
            return -1;
        } else if (d > v.d) {
            return 1;
        } else {
            return 0;
        }
    }
  
}
