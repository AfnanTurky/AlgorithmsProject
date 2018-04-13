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
public class Edge {
    private vertex destination;
    private Edge nextEdge;
    private int wieght;

    public Edge() {
    }

    public Edge(int wieght) {
        this.wieght = wieght;
    }

    public Edge(vertex destination) {
        this.destination = destination;
    }

    public vertex getDestination() {
        return destination;
    }

    public void setDestination(vertex destination) {
        this.destination = destination;
    }

    public Edge getNextEdge() {
        return nextEdge;
    }

    public void setNextEdge(Edge nextEdge) {
        this.nextEdge = nextEdge;
    }

    public int getWieght() {
        return wieght;
    }

    public void setWieght(int wieght) {
        this.wieght = wieght;
    }
    
   
}
