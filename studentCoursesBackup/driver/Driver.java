package studentCoursesBackup.driver;
import java.lang.Integer;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.*;
public class Driver 
{
	public static void printAll(Node currentNode, Results res){
        if(currentNode.getLeft() != null)
            printAll(currentNode.getLeft(), res);
        if(!(currentNode.stringConstruct().equals("")))
        res.writeLine(currentNode.getBNumber() + ":" + currentNode.stringConstruct());
        if(currentNode.getRight() != null)
            printAll(currentNode.getRight(), res);
     }
     
	public static void main(String[] args) 
	{
		if(args.length != 5){
			System.out.println("Incorrect number of arguments");
			return;
		}
		FileProcessor inp = new FileProcessor(args[0]);
		FileProcessor del = new FileProcessor(args[1]);
		Results res1 = new Results(args[2]);
		Results res2 = new Results(args[3]);
		Results res3 = new Results(args[4]);
		String takeIn;
		int currentBNum;
		char c;
		Node root = null;
		Node root2 = null ;
		Node root3 = null;
		boolean hasRoot = false;
		while((takeIn=inp.readLine())!=null){
			currentBNum = Integer.parseInt(takeIn.substring(0,4));
			c = takeIn.charAt(5);
			if(c>=65 && c<=75){
				if(!hasRoot){
					root = new Node(currentBNum, c);
					root2 = (Node)root.clone();
					root3 = (Node)root.clone();
					root.setListeners(root2, root3);
					hasRoot = true;
				}
				else{
					Node check= root.search(root, currentBNum);
					 if(check != null){
						check.addCourse(c);
						check.notifyAllIns(c);
					 }
					 else{
					 	Node inst = new Node(currentBNum, c);
						Node inst2 = (Node)inst.clone();
						Node inst3 = (Node)inst.clone();
						inst.setListeners(inst2, inst3);
					 	root.insertNode(root, inst);
					 	root2.insertNode(root2, inst2);
					 	root3.insertNode(root3, inst3);
					 }
				 }
				}
			}
		while((takeIn=del.readLine())!=null){
			currentBNum = Integer.parseInt(takeIn.substring(0,4));
			c = takeIn.charAt(5);
			if(c>=65 && c<=75){
				if(hasRoot){
					Node check= root.search(root, currentBNum);
					 if(check != null){
						check.updateSelfDel(c);
						check.notifyAllDel(c);
					 }
				 }
				}
			}
			printAll(root,res1);
			printAll(root2,res2);
			printAll(root3,res3);
		}
	}


/*
Node tester1 = new Node(1234,'A');
		Node tester2 = new Node(1235,'B');
		Node tester3 = new Node(1236,'A');
		Node tester4 = new Node(1233,'A');
		Node tester5 = new Node(1232,'A');
		tester1.insertNode(tester1, tester2);
		tester1.insertNode(tester1, tester3);
		tester1.insertNode(tester1, tester4);
		tester1.insertNode(tester1, tester5);

		Node currentNode = tester1;
			System.out.println(currentNode.getBNumber());
			System.out.println(currentNode.getLeft().getBNumber());
			System.out.println(currentNode.getLeft().getLeft().getBNumber());
			System.out.println(currentNode.getRight().getBNumber());
			System.out.println(currentNode.getRight().getRight().getBNumber());


		tester2.addCourse('K');
		tester2.addCourse('E');
		tester2.addCourse('D');

		System.out.println(tester2.stringConstruct());
*/