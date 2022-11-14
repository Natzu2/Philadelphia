/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.cirtucalr;

/**
 *
 * @author Sisti
 */
public class ListaCircular {
    public class Node{  
        int data;  
        Node next;  
        public Node(int data) {  
            this.data = data;  
        }  
    }  
  

    public Node head = null;  
    public Node tail = null;  
  

    public void add(int data){  
  
        Node newNode = new Node(data);  

        if(head == null) {  

            head = newNode;  
            tail = newNode;  
            newNode.next = head;  
        }  
        else {  

            tail.next = newNode;  
 
            tail = newNode;  

            tail.next = head;  
        }  
    }  
  

    public void display() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("Lista vacía");  
        }  
        else {  
            System.out.println("Nodos de la lista: ");  
             do{  
 
                System.out.print(" "+ current.data);  
                current = current.next;  
            }while(current != head);  
            System.out.println();  
        }  
    }  
}

    
