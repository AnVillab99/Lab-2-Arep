package edu.escuelaing.arep.Calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * Main class, mean and deviation
 *
 */
public class Calculator {
    
    
    
    
    public static String Calcular(String req) throws Exception {
        
        LinkedList<Double> l1 = new LinkedList<Double>();
        List<String> ls = Arrays.asList(req.split(","));
        for(String s:ls){           
            l1.add(Double.parseDouble(s));
        }       
        NumberFormat format = new DecimalFormat("#0.000");    
        Iterator<Double> it1 = l1.iterator();

        Double m1=mean(l1,it1);
        String[] a =new String[2];
        
        a[0]=m1.toString();
        
        String st =format.format(stdDev(l1,it1,m1)).toString();
        a[1]=st;
        String res ="{\"mean\":"+m1+",\"std\":"+st+"}";


        return res;


    }

    /**
     * Method makes a linikedlist of doubles out of a txt file on a given path
     * @param path path were the txt is located
     * @return linkedlist of the values on the txt
     * @throws Exception if theres an error reading the txt
     */
    public static LinkedList<Double> makeTest(String path) throws Exception {
        LinkedList<Double> l = new LinkedList<Double>();
        File file = new File(path);
        BufferedReader buf = new BufferedReader(new FileReader(file));
        Double data;
        String d;

        d = buf.readLine();
        while (!(d == null || d.length()==0)) {
            data = Double.parseDouble(d);

            
            l.add(data);
            d = buf.readLine();
            
        }
            
        buf.close();
        return l;
    }

    /**
     * Methods return the mean of a double linked list
     * @param l linked list of doubles
     * @param it linkedlist iterator
     * @return mean 
     */
    public static Double mean(LinkedList<Double> l, Iterator<Double> it) {
        Double suma = 0.0;
        int ls = l.size();
        while (ls>=1){
            double a =it.next();
            suma +=a;
            ls--;
        }
        return suma / l.size();
    }

    /**
     * Method returns the standard deviation of a doublelinkedlist
     * @param l linked list
     * @param it linked list iterator
     * @param m mean of the lnked list
     * @return the standard deviation of the linked list
     */
    public static Double stdDev(LinkedList<Double> l, Iterator<Double> it, Double m) {
        
        Double suma = 0.0;     

        it=l.iterator();   
        int ls = l.size();
        while (ls>=1){

            double a =it.next();
            a-=m;        
            suma += a * a;
            ls--;
        }
        suma =suma/( l.size() - 1);
        return Math.sqrt(suma);
    }
}
