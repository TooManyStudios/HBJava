package com.hb.trappes;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("165e8cfa-1612-43c0-b3dd-b67d0d4e0b53")
public class Telecommande {
    @objid ("869cad01-c0bc-4c65-aaf2-26eb74c2cd78")
    private Trappe trappe;

    @objid ("6418c93e-f2db-4d9e-810d-f64803b53d58")
    public Telecommande(Trappe trappe) {
        this.trappe = trappe;
    }

    @objid ("04a8cbb0-eeeb-4fc6-991e-1cb98575f395")
    public void presserBouton() {
        System.out.println("Le bouton de la télécommande est pressé.");
        trappe.toggle();
    }

}
