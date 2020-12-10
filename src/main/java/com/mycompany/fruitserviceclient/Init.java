/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fruitserviceclient;

import com.mycompany.fruitservice.constants.Constants;
import com.mycompany.fruitservice.interfaces.ComputeInterface;
import com.mycompany.fruitservice.interfaces.TaskInterface;
import com.mycompany.fruitservice.models.Fruit;
import com.mycompany.fruitservice.tasks.AddFruitPrice;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author haamani
 */
public class Init {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Registry registry = LocateRegistry.getRegistry(Constants.RMI_PORT); 
        ComputeInterface engine = (ComputeInterface)registry.lookup(Constants.RMI_ID); 
        Fruit fruit = new Fruit("Mango",20);       
        TaskInterface add = new AddFruitPrice();        
        engine.compute(add, fruit);        
    }
    
}