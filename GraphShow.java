import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.util.List;

public class GraphShow {
    public static void main(String[] args) {

        Graph K9 = new Graph(9, false, true);
        for (int i=0; i<K9.printVertices()-1;i++){
            for (int j=0; j<K9.printVertices()-1; j++){
                if(i!=j){
                    K9.addEdge(i,j);
                }
                else{
                }
            }
        }

        K9.addweight(8,1,7);
        K9.addweight(8,2,12);
        K9.addweight(8,3,16);
        K9.addweight(8,4,12);
        K9.addweight(8,5,18);
        K9.addweight(8,6,19);
        K9.addweight(8,7,5); 
        K9.addweight(0,8,8);
        K9.addweight(7,1,7);
        K9.addweight(7,2,12);
        K9.addweight(7,3,19);
        K9.addweight(7,4,16);
        K9.addweight(7,5,18);
        K9.addweight(7,6,22); 
        K9.addweight(0,7,11);
        K9.addweight(6,1,20);
        K9.addweight(6,2,19);
        K9.addweight(6,3,5);
        K9.addweight(6,4,6);
        K9.addweight(6,5,8);
        K9.addweight(0,6,10);
        K9.addweight(5,1,15);
        K9.addweight(5,2,13);
        K9.addweight(5,3,8);
        K9.addweight(5,4,8);
        K9.addweight(0,5,12);
        K9.addweight(4,1,18);
        K9.addweight(4,2,17);
        K9.addweight(4,3,3); 
        K9.addweight(0,4,3);
        K9.addweight(3,1,20);
        K9.addweight(3,2,19); 
        K9.addweight(0,3,7);
        K9.addweight(2,1,9);
        K9.addweight(0,2,13);
        K9.addweight(0,1,16);

        Scanner intScan = new Scanner(System.in);
        System.out.println("Enter the number of tasks you have");
        int numOfTasks = intScan.nextInt();
        int [] tasks = new int[numOfTasks]; 
        String [] nameofTasks = new String [numOfTasks];
        Scanner scan  = new Scanner(System.in);
        System.out.println("Please enter the tasks you have such that the Lower Engine task=1, the Electrical task=2, the 02 task=3, the Weapons task=4" + "\n"+
            "the Shields task = 5, the Navigation task = 6, the Reactor task = 7, and the Upper Engine task = 8.");
        for (int i=0; i<numOfTasks; i++){
            tasks[i]= scan.nextInt();

        }  

        Graph kUser = new Graph(numOfTasks, false, true);
        for (int i=0; i<=numOfTasks-1;i++){
            for (int j=0; j<=numOfTasks-1; j++){
                if(i!=j){
                    kUser.addEdge(i,j);
                }
                else{
                }
            }
        }
        for (int i=0; i<tasks.length; i++){
            for (int j=0; j<tasks.length; j++){
                if (i==0 && j!=0){
                    kUser.addweight(i,j, K9.getEdgeValue(i,tasks[j]));
                }
                else if (i!=j){
                    kUser.addweight(i,j,(K9.getEdgeValue(tasks[i],tasks[j])));
                }
            }
        }
        /*
        kUser.printMatrix();
        System.out.println();
        System.out.println();
         */
        int weight = 0;
        int newWeight = 9999;
        String efficientPath="";
        switch(numOfTasks){
            case 1:
            for (int i = 0; i<1; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==0){
                    iString = "0"+iString;
                }
                if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                    for (int j=0; j<iString.length()-1; j++){        
                        int first = Integer.parseInt(iString.substring(j,j+1));
                        int second = Integer.parseInt(iString.substring(j+1,j+2));
                        weight = weight + kUser.getEdgeValue(first,second);

                    }
                    if (weight<newWeight){
                        newWeight = weight;
                        efficientPath += iString;
                    }
                }
                else{
                }

            }
            System.out.println("The cost of the most efficient path is " +newWeight+ 
                "\n,and the most efficient path is " +efficientPath.substring(efficientPath.length()-1)+
                "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
            break;
            case 2:
            for (int i = 1; i<12; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==1){
                    iString = "0"+iString;
                }
                if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                    for (int j=0; j<iString.length()-1; j++){        
                        int first = Integer.parseInt(iString.substring(j,j+1));
                        int second = Integer.parseInt(iString.substring(j+1,j+2));
                        weight = weight + kUser.getEdgeValue(first,second);

                    }
                    if (weight<newWeight){
                        newWeight = weight;
                        efficientPath += iString;
                    }
                }
                else{
                }
            }
            System.out.println("The cost of the most efficient path is " +newWeight+ 
                "\n,and the most efficient path is " +efficientPath.substring(efficientPath.length()-2)+
                "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
            break;   
            case 3:
            for (int i = 12; i<211; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==2){
                    iString = "0"+iString;
                }
                if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                    for (int j=0; j<iString.length()-1; j++){        
                        int first = Integer.parseInt(iString.substring(j,j+1));
                        int second = Integer.parseInt(iString.substring(j+1,j+2));
                        weight = weight + kUser.getEdgeValue(first,second);

                    }
                    if (weight<newWeight){
                        newWeight = weight;
                        efficientPath += iString;
                    }
                }
                else{
                }
            }
            System.out.println("The cost of the most efficient path is " +newWeight+ 
                "\n,and the most efficient path is " +efficientPath.substring(efficientPath.length()-3)+
                "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
            break;           
            case 4:
            for (int i = 123; i<3211; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==3){
                    iString = "0"+iString;
                }
                if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                    for (int j=0; j<iString.length()-1; j++){        
                        int first = Integer.parseInt(iString.substring(j,j+1));
                        int second = Integer.parseInt(iString.substring(j+1,j+2));
                        weight = weight + kUser.getEdgeValue(first,second);

                    }
                    if (weight<newWeight){
                        newWeight = weight;
                        efficientPath += iString;
                    }
                }
                else{
                }

            }
            System.out.println("The cost of the most efficient path is " +newWeight+ 
                "\n,and the most efficient path is " +efficientPath.substring(efficientPath.length()-4)+
                "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
            break; 
            case 5:
            for (int i = 1234; i<43211; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==4){
                    iString = "0"+iString;
                }
                if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                    for (int j=0; j<iString.length()-1; j++){        
                        int first = Integer.parseInt(iString.substring(j,j+1));
                        int second = Integer.parseInt(iString.substring(j+1,j+2));
                        weight = weight + kUser.getEdgeValue(first,second);

                    }
                    if (weight<newWeight){
                        newWeight = weight;
                        efficientPath += iString;

                    }
                }
                else{
                }
            }
            System.out.println("The cost of the most efficient path is " +newWeight+ 
                "\n,and the most efficient path is " +efficientPath.substring(efficientPath.length()-5)+
                "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
            break; 
            case 6:
            for (int i = 12345; i<543211; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==5){
                    iString = "0"+iString;
                }
                if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                    for (int j=0; j<iString.length()-1; j++){        
                        int first = Integer.parseInt(iString.substring(j,j+1));
                        int second = Integer.parseInt(iString.substring(j+1,j+2));
                        weight = weight + kUser.getEdgeValue(first,second);

                    }
                    if (weight<newWeight){
                        newWeight = weight;
                        efficientPath += iString;
                    }
                }
                else{
                }
            }
            System.out.println("The cost of the most efficient path is " +newWeight+ 
                "\n,and the most efficient path is " +efficientPath.substring(efficientPath.length()-6)+
                "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
            break;         
            case 7:
            for (int i = 123456; i<6543211; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==6){
                    iString = "0"+iString;
                }
                if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                    for (int j=0; j<iString.length()-1; j++){        
                        int first = Integer.parseInt(iString.substring(j,j+1));
                        int second = Integer.parseInt(iString.substring(j+1,j+2));
                        weight = weight + kUser.getEdgeValue(first,second);

                    }
                    if (weight<newWeight){
                        newWeight = weight;
                        efficientPath += iString;
                    }
                }
                else{
                }
            }
            System.out.println("The cost of the most efficient path is " +newWeight+ 
                "\n,and the most efficient path is " +efficientPath.substring(efficientPath.length()-7)+
                "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
            break;
            case 8:
            for (int i = 1234567; i<76543211; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==7){
                    iString = "0"+iString;
                }
                if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                    for (int j=0; j<iString.length()-1; j++){        
                        int first = Integer.parseInt(iString.substring(j,j+1));
                        int second = Integer.parseInt(iString.substring(j+1,j+2));
                        weight = weight + kUser.getEdgeValue(first,second);

                    }
                    if (weight<newWeight){
                        newWeight = weight;
                        efficientPath += iString;
                    }
                }
                else{
                }
            }
            System.out.println("The cost of the most efficient path is " +newWeight+ 
                "\n,and the most efficient path is " +efficientPath.substring(efficientPath.length()-8)+
                "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
            break;  
            case 9:
            for (int i = 12345678; i<876543211; i++){
                weight = 0;
                String iString = Integer.toString(i);
                if (iString.length()==8){
                    iString = "0"+iString;
                    if (kUser.lessThanN(iString)&&kUser.uniqueCharacters(iString)){
                        for (int j=0; j<iString.length()-1; j++){        
                            int first = Integer.parseInt(iString.substring(j,j+1));
                            int second = Integer.parseInt(iString.substring(j+1,j+2));
                            weight = weight + kUser.getEdgeValue(first,second);

                        }
                        if (weight<newWeight){
                            newWeight = weight;
                            efficientPath += iString;
                        }
                    }
                    else{
                    }
                }
                System.out.println("The cost of the most efficient path is " +newWeight+ ",and the most efficient path is " +efficientPath.substring(efficientPath.length()-9)+
                    "\n such that 0 is the first task you entered, 1 is the second task entered, and so on.");
                break;          

            }
        }
    }
}