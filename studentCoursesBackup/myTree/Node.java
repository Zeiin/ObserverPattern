package studentCoursesBackup.myTree;
import java.lang.Object;

public class Node implements Cloneable, ObserverI, SubjectI{
    int bNumber;
    boolean[] Course = new boolean[11];
    public Node[] listeners = new Node[2];
    Node left = null;
    Node right = null;
    boolean isTroot;
    char OriginalChar;
    
    public Node(int b, char c){
        for(int i=0;i<11;i++)
            Course[i] = false;
        bNumber = b;
        OriginalChar = c;
        Course[c-65] = true;
    }
    
    public Object clone(){
        Node cloned = new Node(this.bNumber, this.OriginalChar);
        return cloned;
    }
    
    public void setLeft(Node n){left = n;}
    public void setRight(Node n){right = n;}
    public void setTroot(){isTroot = true;}
    public void setListeners(Node n1, Node n2){
        listeners[0] = n1;
        listeners[1] = n2;
    }
    public int getBNumber(){return this.bNumber;}
    public boolean[] getCourse(){return this.Course;}
    public Node getLeft(){return this.left;}
    public Node getRight(){return this.right;}
    
    public void addCourse(char c){
                Course[c-65] = true;
    }
    
    public void insertNode(Node Troot, Node n)
    {
        if(n.getBNumber() < Troot.getBNumber()){
            if(Troot.getLeft() == null)
                Troot.setLeft(n);
            else
                insertNode(Troot.getLeft(), n);
        }
        else{
            if(Troot.getRight() == null)
                Troot.setRight(n);
            else
                insertNode(Troot.getRight(), n);
        }
    }
    
    public Node search(Node Troot, int bNum){
        if(Troot.getBNumber() == bNum)
            return Troot;
        else if(Troot.getBNumber() > bNum){
            if(Troot.getLeft() != null)
              return search(Troot.getLeft(), bNum);
            else
              return null;
        }
        else
            if(Troot.getRight() != null)
              return search(Troot.getRight(), bNum);
            else
              return null;
    }
    public void updateSelfIns(char c){
        this.Course[c-65] = true;
    }
    public void updateSelfDel(char c){
        this.Course[c-65] = false;
    }
    public void notifyAllIns(char c){
        this.listeners[0].updateSelfIns(c);
        this.listeners[1].updateSelfIns(c);
    }
    public void notifyAllDel(char c){
        this.listeners[0].updateSelfDel(c);
        this.listeners[1].updateSelfDel(c);
    }
    public String stringConstruct(){
        String sum = "";
        for(int i=0;i<11;i++){
            if(Course[i] == true){
                char c = 65;
                c += i;
                sum += Character.toString(c);
            }
        }
        return sum;
    }
}