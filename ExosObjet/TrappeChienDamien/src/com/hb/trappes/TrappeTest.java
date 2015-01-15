package com.hb.trappes;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a418918f-466a-484b-b232-b97cf2126871")
public class TrappeTest {
    @objid ("5a9f3fdb-5d5a-482a-8156-c57d8ae3f425")
    public static void main(String[] args) {
        Trappe trappe = new Trappe();
        Telecommande telecommande = new Telecommande(trappe);
        
        System.out.println("Fido aboit et veut sortir.");
        
        System.out.println("On appuie sur la télécommande.");
        telecommande.presserBouton();

        telecommande.presserBouton();
        
        System.out.println("Fido sort.");
        
        try {
        	Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) { }
        
        System.out.println("Fido fait ce qu'il a à faire.");
        
        System.out.println("Fido aboit et veut rentrer.");
        
        System.out.println("On appuie sur la télécommande.");
        telecommande.presserBouton();
        
        System.out.println("Fido rentre.");
    }

}
