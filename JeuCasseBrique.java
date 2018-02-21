//GRANDPERRIN LOIC - MAILLARD CYNTHIA  - GROUPE TP6 - PROJET 2 
/**
 * Jeu du casse-briques.<br>
 * Les fonctionnalites du menu sont les suivantes:<br>
 *   - Deplacement de la raquette par la souris<br>
 *   - Deplacement de la balle automatiquement<br>
 *   - Detection des chocs entre la boule et les briques<br>
 *   - Detection du nombre de briques restantes<br>
 *   - Ecoulement du temps <br>
 *   - Disparition des briques si choc avec la boule <br>
 *   - Affichage graphique des elements<br>
 *   - Changement des parametres du jeu<br>
 *   - Boucle de jeu<br>
 *
 * @author GRANDPERRIN Loic
 * @author MAILLARD Cynthia
 * @version 1.0, 17/05/2017
 */
class JeuCasseBrique  {

    //////////////Types agreges//////////////////

	/**
	* Type agrege de stockage d'une position dans un espace a deux dimensions entieres.
	*/
	static class Position2D {
		/** Position x. */
		int x;
		/** Position y. */
		int y;
	}

	/**
	* Type agrege de stockage de la largeur et hauteur entiere.
	*/
	static class Taille {
		/** Largeur.*/
		int largeur;
		/** Hauteur.*/
		int hauteur;
	}
	
	/**
	* Type agrege de stockage de la nouvelle positiondans un espace a deux dimensions.
	*/
    static class Deplacement {
        int x;
        int y;
    }

    /**
	* Type agrege de stockage des parametres de l'ecran.
	*/
	static class EcranAffichage {
		/** Abscisse et ordonnee du coin superieur gauche de la fenetre.*/
		Position2D coin = new Position2D();
		/** Nombre de pixel en largeur et hauteur de la zone d'affichage.*/
		Taille ecranJeu = new Taille();
		/** Resolution en x de la fenetre entiere.*/
		int largeurFenetre;
		/** Resolution en Y de la fenetre entiere.*/
		int hauteurFenetre;
	}

	/**
	* Type agrege de stockage des parametres du jeu (raquette, boule, briques, autres)
	*/
    static class CasseBrique {
    	/** Position de la raquette */
        Position2D posRaquette = new Position2D();
        /** Dimensions de la raquette */
        Taille raquette = new Taille();
        /** Position de deplacement de la raquette */
        Deplacement depRaquette = new Deplacement();

        /** Position de la Boule */
        Position2D posBoule = new Position2D();
        /** Rayon de la boule */
        int rayonBoule;
        /** Position de deplacement de la boule */
        Deplacement depBoule = new Deplacement();

        /** Tableau de briques*/
        boolean [][] tabBriques = new boolean[5][7];
        /** Nombre de briques restantes */
        int briquesRestantes;
        /** Nombre de colonne de briques */
        int colonneBriques;
        /** Nombre de ligne de briques */
        int ligneBriques;
        /**Dimensions des briques */
        Taille briques = new Taille();

        /** Victoire de la partie (true: gagne - false: perdu)*/
        boolean partie = true;
        /** Fin de la partie */
        boolean partieFini = false;
        /** Temps ecoule*/
        double temps;
        /** Hauteur maximum de la zone de jeu */
        int plafond;
    }

    /////////////Sous algorithmes////////////////

    public static boolean collisionBoule(Position2D posBoule, int rayonBoule, Position2D posObs, Taille obs) {

       return !(posBoule.x + rayonBoule < posObs.x 
            || posBoule.x - rayonBoule > posObs.x+obs.largeur 
            || posBoule.y + rayonBoule < posObs.y 
            || posBoule.y - rayonBoule > posObs.y+obs.hauteur);
    }
    
    /**
	* Detection du choc de la boule<br>
	* @param cb Parametres du jeu.
	* @param posObs Position de l'obstacle.
	* @param obs Taille de l'obstacle.
	*/
    public static void chocBoule(CasseBrique cb, Position2D posObs, Taille obs) {

    	/**Choc en haut de l'obstacle*/
        if(posObs.y >= cb.posBoule.y && posObs.y <= cb.posBoule.y + cb.rayonBoule ) {
            cb.depBoule.y = - Math.abs(cb.depBoule.y);
        }
        /**Choc en bas de l'obstacle*/
        else if (posObs.y + obs.hauteur <= cb.posBoule.y && posObs.y + obs.hauteur >= cb.posBoule.y - cb.rayonBoule ) {
            cb.depBoule.y = Math.abs(cb.depBoule.y);
        }
        /**Choc a gauche de l'obstacle*/
        else if (posObs.x > cb.posBoule.x && posObs.x < cb.posBoule.x + cb.rayonBoule) {
            cb.depBoule.x = -  Math.abs(cb.depBoule.x);
        }
        /**Choc a droite de l'obstacle*/
        else if (posObs.x + obs.largeur < cb.posBoule.x && posObs.x + obs.largeur > cb.posBoule.x - cb.rayonBoule) {
            cb.depBoule.x = Math.abs(cb.depBoule.x);
        }
    }

    public static void chocBouleRaquette(CasseBrique cb) {
        
        int d; //distance entre la boule et le centre de la raquette
        d = cb.posBoule.x - (cb.posRaquette.x + (cb.raquette.largeur/2));
        
        if(d > 0) {
            cb.depBoule.x = (int)(10 * Math.cos(Math.PI/2 * (Math.cos(Math.PI/cb.raquette.largeur * (cb.posBoule.x - cb.posRaquette.x) + (Math.PI/2) ))));

            cb.depBoule.y = (int)(10 * Math.sin(Math.PI/2 * (Math.cos(Math.PI/cb.raquette.largeur * (cb.posBoule.x - cb.posRaquette.x) + (Math.PI/2) ))))+1;
        }
        else {
            cb.depBoule.x = -((int)(10 * Math.cos(Math.PI/2 * (Math.cos(Math.PI/cb.raquette.largeur * (cb.posBoule.x - cb.posRaquette.x) + (Math.PI/2) ))))+1);

            cb.depBoule.y = (int)(10 * Math.sin(Math.PI/2 * (Math.cos(Math.PI/cb.raquette.largeur * (cb.posBoule.x - cb.posRaquette.x) + (Math.PI/2) ))))+1;
        }
    }

    

    ////////////Sous-algorithmes principaux//////////

    /**
	* Etat initiale du jeu en debut de partie<br>
	* @param cb Parametres du cassebrique.
	* @param ea Parametres d'affichages.
	*/
    public static void etatInit(CasseBrique cb, EcranAffichage ea) {
        /**Limite en haut de la zone de jeu*/
        cb.plafond = 70;

        /**Parametres de la raquette*/
        cb.raquette.hauteur = 30;
        cb.posRaquette.y = ea.coin.y + ea.ecranJeu.hauteur - cb.raquette.hauteur - 10;
        cb.posRaquette.x = (ea.coin.x + ea.ecranJeu.largeur + cb.raquette.largeur)/2 - cb.raquette.largeur;

        /**Parametres de la boule*/
        cb.posBoule.x = ea.coin.x + (ea.ecranJeu.largeur/2);
        cb.posBoule.y = ea.coin.y + (ea.ecranJeu.hauteur/2);
        cb.rayonBoule = 10;
        cb.depBoule.x = 10;
        cb.depBoule.y = 10;

        /**Parametress des briques*/
        cb.colonneBriques = 7;
        cb.ligneBriques = 5;
        cb.briques.largeur = 64;
        cb.briques.hauteur = 31;
        cb.briquesRestantes = 35;

        /**Initialisation de la presence des briques en debut de jeu*/
        for (int i = 0; i < cb.ligneBriques; i++) {
            for (int j = 0; j < cb.colonneBriques; j++) {
                cb.tabBriques[i][j] = true;
            }
        }

        /**Initialisation du temps*/
        cb.temps = 180;
    }
    
    /**
	* Changement des parametres durant la partie.<br>
	* @param cb Parametres du cassebrique.
	* @param ea Parametres d'affichages.
	*/
    public static void update(CasseBrique cb, EcranAffichage ea) {
        /**Rafraichir le temps */
            EcranGraphique.wait(10);
            if(EcranGraphique.getMouseX() != -1){
                cb.temps = cb.temps - 0.05 ;
            }

        /**Deplacement de la raquette*/

		if(EcranGraphique.getMouseX() != -1){
			EcranGraphique.setXorMode(true);
			cb.posRaquette.x = EcranGraphique.getMouseX() - cb.raquette.largeur/2;
			cb.posRaquette.y = ea.coin.y + ea.ecranJeu.hauteur - cb.raquette.hauteur;
			if(cb.posRaquette.x <= 0){
				cb.posRaquette.x = 0;
			}
			
			else if(cb.posRaquette.x + cb.raquette.largeur >=ea.ecranJeu.largeur ){
				cb.posRaquette.x = ea.ecranJeu.largeur - cb.raquette.largeur;
			}
			
			EcranGraphique.flush();
			EcranGraphique.setXorMode(false);
		}


        /**Deplacement de la boule*/

		if(EcranGraphique.getMouseX() != -1) {
	        cb.posBoule.x = cb.posBoule.x + cb.depBoule.x;
	        cb.posBoule.y = cb.posBoule.y + cb.depBoule.y;
		}
    	
        /**Choc de la boule avec un autre objet*/

            /**Choc avec la raquette*/
            if(collisionBoule(cb.posBoule, cb.rayonBoule, cb.posRaquette, cb.raquette)) { 
                chocBouleRaquette(cb);
            }

            /**Choc avec les briques*/
            for (int i = 0; i < cb.ligneBriques; i++) {
                for (int j = 0; j < cb.colonneBriques; j++) {

                    if(cb.tabBriques[i][j]) {

                        Position2D posBriques = new Position2D();
                        posBriques.x = 26 + cb.briques.largeur * j;
                        posBriques.y = cb.plafond + 26 + cb.briques.hauteur * i;
                        if(collisionBoule(cb.posBoule, cb.rayonBoule, posBriques, cb.briques)) {
                            cb.tabBriques[i][j] = false;
                            chocBoule(cb, posBriques, cb.briques);
                        }
                    }
                }
            }

            /**Choc avec les murs*/

                /**Choc cote gauche de l'ecran*/
                if(cb.posBoule.x - cb.rayonBoule <= ea.coin.x) {
                    cb.depBoule.x = - cb.depBoule.x;
                }
                /**Choc cote droit de l'ecran*/
                else if (cb.posBoule.x + cb.rayonBoule >= ea.coin.x + ea.ecranJeu.largeur) {
                    cb.depBoule.x = - cb.depBoule.x;
                }
                /**Choc en haut de l'ecran (plafond)*/
                else if (cb.posBoule.y - cb.rayonBoule <= cb.plafond) {
                    cb.depBoule.y = - cb.depBoule.y;
                }
                        
                
            


        /**Calcul du nombre de briques restantes*/
        cb.briquesRestantes = 0;
        for (int i = 0; i < cb.ligneBriques; i++) {
            for (int j = 0; j < cb.colonneBriques; j++) {
                if (cb.tabBriques[i][j]) {
                    cb.briquesRestantes = cb.briquesRestantes + 1;
                }
            }
        }
    }
    

    /**
	* Affichage graphique des elements.<br>
	* @param cb Parametres du cassebrique.
	* @param ea Parametres d'affichages.
	*/
    public static void affichage(CasseBrique cb, EcranAffichage ea) {
        /**Ecran de jeu*/
        int [][] fond = EcranGraphique.loadPNGFile("fond.png");
        EcranGraphique.drawImage(0,0,fond);
        

        /**Ligne pour "plafond" de la zone de jeu*/
        EcranGraphique.setColor(255,255,255);
        EcranGraphique.drawLine(0,cb.plafond,600,cb.plafond);
       

        /**Nombre de briques restantes*/
        EcranGraphique.setColor(255,255,255);
        EcranGraphique.drawText(90, 49, EcranGraphique.COLABA8x13, cb.briquesRestantes );
      

        /**Temps restant*/
        EcranGraphique.setColor(255,255,255);
        EcranGraphique.drawText(76, 35, EcranGraphique.COLABA8x13, Math.round(cb.temps) );
       

        /**Raquette*/
        EcranGraphique.setColor(10,10,10);
        EcranGraphique.fillRect(cb.posRaquette.x, cb.posRaquette.y, cb.raquette.largeur, cb.raquette.hauteur);

        /**Boule*/
        EcranGraphique.setColor(200, 200, 0);
        EcranGraphique.fillCircle(cb.posBoule.x, cb.posBoule.y, cb.rayonBoule);
       

        /**Briques*/
        for (int i=0; i< cb.ligneBriques; i++) {
            for (int j=0; j< cb.colonneBriques ; j++) {
                if(cb.tabBriques[i][j]) {
                    int [][] briques = EcranGraphique.loadPNGFile("brique2.png");
                    EcranGraphique.drawImage(26 + cb.briques.largeur * j, cb.plafond + 26 + cb.briques.hauteur * i, briques);
                }
            }
        }
        
        /**Jeu en pause*/
        if( EcranGraphique.getMouseX() == -1){
        	EcranGraphique.setAlphaBlendingMode(true);
        	EcranGraphique.setAlpha(0.5);
        	EcranGraphique.setColor(255,0,0);
        	EcranGraphique.fillRect(0, 310, 500, 50);
        	EcranGraphique.setAlphaBlendingMode(false);
        	EcranGraphique.setColor(255,255,255);
        	EcranGraphique.drawText(180, 330, EcranGraphique.COLABA8x13, "Jeu en pause !" );
            EcranGraphique.drawText(70, 350, EcranGraphique.COLABA8x13, "Votre souris est hors de l'ecran de jeu !" );
        }
        EcranGraphique.flush();
    }


    /**
	* Programme principale.
	*/
    public static void main(String[] args) {
        
        boolean jeuLance = true;
        EcranAffichage ea = new EcranAffichage();
        CasseBrique cb = new CasseBrique();
        while(jeuLance){
            MenuCasseBrique.start(cb);
            cb.partieFini = false;
            EcranGraphique.init(ea.coin.x = 0, ea.coin.y = 0, ea.largeurFenetre = 538, ea.hauteurFenetre = 677, ea.ecranJeu.largeur
                    = 500, ea.ecranJeu.hauteur = 600,"Fenetre affichage jeu");
            etatInit(cb, ea);
            while (!cb.partieFini) {
        
                update(cb, ea);
                affichage(cb, ea);
            
                if (cb.briquesRestantes == 0){
                    cb.partieFini = true;
                    cb.partie = true;
                }
                else if ((cb.posBoule.y > cb.posRaquette.y)||(cb.temps <=0)){
                    cb.partieFini = true;
                    cb.partie = false;
                }
            }
            MenuCasseBrique.end(cb.partie, cb);
        }
    }
}
