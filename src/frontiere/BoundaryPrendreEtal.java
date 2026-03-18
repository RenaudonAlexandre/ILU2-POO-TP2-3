package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant du notre village pour commercer ici.\n");	
		} else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal.");
			installerVendeur(nomVendeur);
		}
	}

	private void installerVendeur(String nomVendeur) {
		if(!controlPrendreEtal.resteEtals()) {
			System.out.println("Désolée " + nomVendeur +" je n'ai plus d'étal qui ne soit pas déjà occupé");
		} else {
			installerVendeur(nomVendeur);
			StringBuilder vendeur = new StringBuilder();
			System.out.println("C'est parfait, il me reste un étal pour vous !\n");
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
			int qteProdut = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
			prendreEtal(nomVendeur,produit,qteProdut);
		}
	}
}
