//MAILLARD CYNTHIA - GRANDPERRIN LOIC - GROUPE TP6 - PROJET 2 
/**
 * Menu principale du casse-briques.<br>
 * Les fonctionnalites du menu sont les suivantes:<br>
 * - Lancer le jeu<br>
 * - Choix de la largeur de la raquette<br>
 * - Confirmation du choix de la raquette<br>
 * - Explications des regles du jeu<br>
 * - Affichage de la victoire ou defaite<br>
 * - Quitter le menu<br>
 *
 * @author GRANDPERRIN Loic
 * @author MAILLARD Cynthia
 * @version 1.0, 26/04/2017
 */
class MenuCasseBrique {

    /**
     * Type agrege de stockage d'une position dans un espace a deux dimensions entieres.
     */
    static class Position2D {
        /**
         * Position x.
         */
        int x;
        /**
         * Position y.
         */
        int y;
    }

    /**
     * Type agrege de stockage de la largeur et hauteur entiere d'un bouton.
     */
    static class Taille {
        /**
         * Largeur du bouton.
         */
        int largeur;
        /**
         * Hauteur du bouton.
         */
        int hauteur;
    }

    /**
     * Type agrege de stockage des parametres de l'ecran.
     */
    static class EcranAffichage {
        /**
         * Abscisse du coin superieur gauche de la fenetre.
         */
        int coinX;
        /**
         * Ordonnee du coin sup gauche de la fenetre.
         */
        int coinY;
        /**
         * Nombre de pixel en largeur de la zone d'affichage.
         */
        int largeur;
        /**
         * Nombre de pixel en hauteur de la zone d'affichage.
         */
        int hauteur;
        /**
         * Resolution en x de la fenetre entiere.
         */
        int largeurFenetre;
        /**
         * Resolution en Y de la fenetre entiere.
         */
        int hauteurFenetre;
    }

    /**
     * Type agrege de stockage des parametres d'un bouton.
     */
    static class Bouton {
        /**
         * Position du bouton.
         */
        Position2D posBouton = new Position2D();
        /**
         * Taille du bouton.
         */
        Taille tailleBouton = new Taille();
        /**
         * Etat du bouton (Activation / Desactivation).
         */
        boolean etat = true;
    }

    /**
     * Type agrege des differents boutons.
     */
    static class divBouton {
        /**
         * Bouton jouer
         */
        Bouton jouer = new Bouton();
        /**
         * Bouton relages
         */
        Bouton reglages = new Bouton();
        /**
         * Bouton regles
         */
        Bouton regles = new Bouton();
        /**
         * Bouton quitter
         */
        Bouton quitter = new Bouton();
        /**
         * Bouton resultats
         */
        Bouton resultats = new Bouton();
        /**
         * Bouton retour
         */
        Bouton retour = new Bouton();
        /**
         * Bouton raquette 20 pixels
         */
        Bouton pxl20 = new Bouton();
        /**
         * Bouton raquette 40 pixels
         */
        Bouton pxl40 = new Bouton();
        /**
         * Bouton raquette 60 pixels
         */
        Bouton pxl60 = new Bouton();
        /**
         * Bouton raquette 80 pixels
         */
        Bouton pxl80 = new Bouton();
        /**
         * Bouton raquette 100 pixels
         */
        Bouton pxl100 = new Bouton();
        /**
         * Bouton raquette 120 pixels
         */
        Bouton pxl120 = new Bouton();
    }

    /**
     * Verifie si le curseur de la souris clique sur un bouton.
     *
     * @param x       Position x du bouton.
     * @param y       Position y du bouton.
     * @param largeur La largeur du bouton.
     * @param hauteur La hauteur du bouton.
     * @param clicx   La position x de la souris.
     * @param clicy   La position y de la souris.
     * @return bouton Retourne un booleen suivant si le bouton est clique ou pas.
     */
    public static boolean cliqueBouton(int x, int y, int largeur, int hauteur, int clicx, int clicy) {
        /**S'il y a un clique, mais pas sur le bouton, bouton = false*/
        boolean bouton = false;
        /**S'il y a un clic sur le bouton, bouton = true*/
        if (clicx >= x && clicx <= (x + largeur) && clicy >= y && clicy <= (y + hauteur)) {
            bouton = true;
        }
        return bouton;
    }

    /**
     * Ouverture de la fenetre du jeu.
     *
     * @param btn Differents boutons.
     * @param cb Proprietes du casse brique.
     * @return jouer Lancement du jeu si vrai
     */
    public static boolean boutonJouer(divBouton btn, JeuCasseBrique.CasseBrique cb) {
    	/**Activation - Desactivation des boutons*/
    	btn.resultats.etat = false;btn.reglages.etat = false;btn.retour.etat = false; btn.jouer.etat = false;
        btn.quitter.etat = false;btn.regles.etat = false;btn.pxl20.etat = false;btn.pxl40.etat = false;
        btn.pxl60.etat = false;btn.pxl80.etat = false;btn.pxl100.etat = false;btn.pxl120.etat = false;
        boolean jouer = true;
        return jouer;
    }

    /**
     * Affichage du bouton retour
     *
     * @param btn Types agrege des differents boutons
     */
    public static void retour(divBouton btn) {

    	int [][] retour = EcranGraphique.loadPNGFile("retour.png");
        EcranGraphique.drawImage(320,500,retour);
    	btn.retour.posBouton.x = 320; btn.retour.posBouton.y = 500; btn.retour.tailleBouton.largeur = 130; btn.retour.tailleBouton.hauteur = 50;
    }

    /**
     * Affichage des boutons des pixels
     *
     * @param btn Types agreges des differents boutons
     */
    public static void pixels(divBouton btn) {
        EcranGraphique.setColor(200, 200, 0);
        EcranGraphique.fillRect(btn.pxl20.posBouton.x = 100, btn.pxl20.posBouton.y = 300, btn.pxl20.tailleBouton.largeur = 80, btn.pxl20.tailleBouton.hauteur = 30);
        EcranGraphique.fillRect(btn.pxl40.posBouton.x = 200, btn.pxl40.posBouton.y = 300, btn.pxl40.tailleBouton.largeur = 80, btn.pxl40.tailleBouton.hauteur = 30);
        EcranGraphique.fillRect(btn.pxl60.posBouton.x = 300, btn.pxl60.posBouton.y = 300, btn.pxl60.tailleBouton.largeur = 80, btn.pxl60.tailleBouton.hauteur = 30);
        EcranGraphique.fillRect(btn.pxl80.posBouton.x = 100, btn.pxl80.posBouton.y = 350, btn.pxl80.tailleBouton.largeur = 80, btn.pxl80.tailleBouton.hauteur = 30);
        EcranGraphique.fillRect(btn.pxl100.posBouton.x = 200, btn.pxl100.posBouton.y = 350, btn.pxl100.tailleBouton.largeur = 80, btn.pxl100.tailleBouton.hauteur = 30);
        EcranGraphique.fillRect(btn.pxl120.posBouton.x = 300, btn.pxl120.posBouton.y = 350, btn.pxl120.tailleBouton.largeur = 80, btn.pxl120.tailleBouton.hauteur = 30);

        EcranGraphique.setColor(0, 0, 0);
        EcranGraphique.drawString(112, 320, EcranGraphique.COLABA8x13, "20 pxl");
        EcranGraphique.drawString(212, 320, EcranGraphique.COLABA8x13, "40 pxl");
        EcranGraphique.drawString(312, 320, EcranGraphique.COLABA8x13, "60 pxl");
        EcranGraphique.drawString(112, 370, EcranGraphique.COLABA8x13, "80 pxl");
        EcranGraphique.drawString(210, 370, EcranGraphique.COLABA8x13, "100 pxl");
        EcranGraphique.drawString(310, 370, EcranGraphique.COLABA8x13, "120 pxl");
    }

    /**
     * Affichage de l'arriere plan
     */
    public static void background() {
    	int [][] fondMenu = EcranGraphique.loadPNGFile("fondMenu.png");
        EcranGraphique.drawImage(0,0,fondMenu);
    }

    /**
     * Affichage a l'ecran de la page Reglages.
     *
     * @param ea  Parametres de l'ecran.
     * @param btn Differents boutons.
     * @param x   Position x du bouton.
     * @param y   Position y du bouton.
     */
    public static void boutonReglages(EcranAffichage ea, divBouton btn, int x, int y) {
    	/**Activation - Desactivation des boutons*/
    	btn.resultats.etat = false;btn.reglages.etat = true;btn.retour.etat = true;btn.jouer.etat = false;
        btn.quitter.etat = false;btn.regles.etat = false;btn.pxl20.etat = true;btn.pxl40.etat = true;
        btn.pxl60.etat = true;btn.pxl80.etat = true;btn.pxl100.etat = true;btn.pxl120.etat = true;

        background();

        retour(btn);

        pixels(btn);

        int [][] reglage = EcranGraphique.loadPNGFile("reglage.png");
        EcranGraphique.drawImage(150,100,reglage);
        btn.reglages.posBouton.x = 150; btn.reglages.posBouton.y = 100; btn.reglages.tailleBouton.largeur = 200; btn.reglages.tailleBouton.hauteur = 50;

        EcranGraphique.setColor(0, 0, 0);
        EcranGraphique.drawText(120, 180, EcranGraphique.COLABA8x13, "Vous pouvez regler la largeur");
        EcranGraphique.drawText(180, 200, EcranGraphique.COLABA8x13, "de la raquette !");
        EcranGraphique.drawText(80, 240, EcranGraphique.COLABA8x13, "Par default (pxl): 60");

        EcranGraphique.drawText(80, 280, EcranGraphique.COLABA8x13, "Choisissez une largeur: ");
        EcranGraphique.flush();
    }

    /**
     * Affichage a l'ecran de la page de confirmation suite au choix de la raquette.
     *
     * @param ea  Parametres de l'ecran.
     * @param btn Differents boutons.
     * @param x   Position x du bouton.
     * @param y   Position y du bouton.
     * @param cb Proprietes du casse brique.
     */
    public static void confirmation(EcranAffichage ea, divBouton btn, int x, int y, JeuCasseBrique.CasseBrique cb) {
    	/**Activation - Desactivation des boutons*/
    	btn.resultats.etat = false;btn.reglages.etat = false;btn.retour.etat = true;btn.jouer.etat = false;
        btn.quitter.etat = false;btn.regles.etat = false;btn.pxl20.etat = false;btn.pxl40.etat = false;
        btn.pxl60.etat = false;btn.pxl80.etat = false;btn.pxl100.etat = false;btn.pxl120.etat = false;

        background();

        int [][] reglage = EcranGraphique.loadPNGFile("reglage.png");
        EcranGraphique.drawImage(150,100,reglage);
        btn.reglages.posBouton.x = 150; btn.reglages.posBouton.y = 100; btn.reglages.tailleBouton.largeur = 200; btn.reglages.tailleBouton.hauteur = 50;

        int [][] menu = EcranGraphique.loadPNGFile("menu.png");
        EcranGraphique.drawImage(320,500,menu);
        btn.retour.posBouton.x = 320; btn.retour.posBouton.y = 500; btn.retour.tailleBouton.largeur = 130; btn.retour.tailleBouton.hauteur = 50;


        EcranGraphique.setColor(0, 0, 0);
        EcranGraphique.drawText(140, 180, EcranGraphique.COLABA8x13, "Changement de la largeur");
        EcranGraphique.drawText(145, 200, EcranGraphique.COLABA8x13, "de la raquette reussi !");
        EcranGraphique.drawText(85, 240, EcranGraphique.COLABA8x13, "Largeur de la raquette : ");
        EcranGraphique.drawText(305, 240, EcranGraphique.COLABA8x13, cb.raquette.largeur);
    }
    
    /**
     * Affichage de l'ecran de defaite.
     *
     * @param ea  Parametres de l'ecran.
     * @param btn Differents boutons.
     * @param cb Proprietes du casse brique
     */
    public static void defaite(EcranAffichage ea, divBouton btn, JeuCasseBrique.CasseBrique cb) {
    	EcranGraphique.clear();
    	/**Activation - Desactivation des boutons*/
    	btn.resultats.etat = true;btn.reglages.etat = false;btn.retour.etat = false;btn.jouer.etat = false;
        btn.quitter.etat = false;btn.regles.etat = false;btn.pxl20.etat = false;btn.pxl40.etat = false;
        btn.pxl60.etat = false;btn.pxl80.etat = false;btn.pxl100.etat = false;btn.pxl120.etat = false;

        background();

        int [][] menu = EcranGraphique.loadPNGFile("menu.png");
        EcranGraphique.drawImage(320,500,menu);
        btn.resultats.posBouton.x = 320; btn.resultats.posBouton.y = 500; btn.resultats.tailleBouton.largeur = 130; btn.resultats.tailleBouton.hauteur = 50;

        int [][] resultat = EcranGraphique.loadPNGFile("resultat.png");
        EcranGraphique.drawImage(150,100,resultat);

        EcranGraphique.setColor(0, 0, 0);
        EcranGraphique.drawText(125, 180, EcranGraphique.COLABA8x13, "Vous avez perdu la partie !");
        EcranGraphique.drawText(80, 220, EcranGraphique.COLABA8x13, "Reessayez encore pour tenter de gagner !");
        EcranGraphique.flush();
    }
    
    /**
     * Affichage de l'ecran de vitoire.
     *
     * @param ea  Parametres de l'ecran.
     * @param btn Differents boutons.
     * @param cb Proprietes du casse brique.
     */
    public static void victoire(EcranAffichage ea, divBouton btn, JeuCasseBrique.CasseBrique cb) {
    	EcranGraphique.clear();
    	/**Activation - Desactivation des boutons*/
    	btn.resultats.etat = true;btn.reglages.etat = false;btn.retour.etat = false;btn.jouer.etat = false;
        btn.quitter.etat = false;btn.regles.etat = false;btn.pxl20.etat = false;btn.pxl40.etat = false;
        btn.pxl60.etat = false;btn.pxl80.etat = false;btn.pxl100.etat = false;btn.pxl120.etat = false;

        background();

        int [][] menu = EcranGraphique.loadPNGFile("menu.png");
        EcranGraphique.drawImage(320,500,menu);
        btn.resultats.posBouton.x = 320; btn.resultats.posBouton.y = 500; btn.resultats.tailleBouton.largeur = 130; btn.resultats.tailleBouton.hauteur = 50;

        int [][] resultat = EcranGraphique.loadPNGFile("resultat.png");
        EcranGraphique.drawImage(0,0,resultat);

        EcranGraphique.setColor(0, 0, 0);
        EcranGraphique.drawText(125, 180, EcranGraphique.COLABA8x13, "Vous avez gagne la partie !");
        EcranGraphique.drawText(80, 220, EcranGraphique.COLABA8x13, "Vous avez casse toutes les briques !");
        EcranGraphique.drawText(80, 240, EcranGraphique.COLABA8x13, "Temps restants :");
        EcranGraphique.drawText(235, 240, EcranGraphique.COLABA8x13, Math.round(cb.temps));
        EcranGraphique.flush();
    }

    /**
     * Affichage a l'ecran de la page Regles.
     *
     * @param ea  Parametres de l'ecran.
     * @param btn Differents boutons.
     * @param x   Position x du bouton.
     * @param y   Position y du bouton.
     */
    public static void boutonRegles(EcranAffichage ea, divBouton btn, int x, int y) {
    	/**Activation - Desactivation des boutons*/
    	btn.resultats.etat = false;btn.reglages.etat = false;btn.retour.etat = true;btn.jouer.etat = false;
        btn.quitter.etat = false;btn.regles.etat = true;btn.pxl20.etat = false;btn.pxl40.etat = false;
        btn.pxl60.etat = false;btn.pxl80.etat = false;btn.pxl100.etat = false;btn.pxl120.etat = false;

        background();

        int [][] regle = EcranGraphique.loadPNGFile("regle.png");
        EcranGraphique.drawImage(150,100,regle);
        btn.regles.posBouton.x = 150; btn.regles.posBouton.y = 100; btn.regles.tailleBouton.largeur = 200; btn.regles.tailleBouton.hauteur = 50;


        retour(btn);

        EcranGraphique.setColor(0, 0, 0);
        EcranGraphique.drawText(85, 180, EcranGraphique.COLABA8x13, "Vous devez deplacer la raquette avec ");
        EcranGraphique.drawText(80, 200, EcranGraphique.COLABA8x13, "la souris pour que la boule rebondisse");
        EcranGraphique.drawText(80, 220, EcranGraphique.COLABA8x13, "sur la raquette afin de casser toutes");
        EcranGraphique.drawText(180, 240, EcranGraphique.COLABA8x13, "les briques !");
        
        EcranGraphique.drawText(80, 280, EcranGraphique.COLABA8x13, "Le but est de casser toutes les briques");
        EcranGraphique.drawText(80, 300, EcranGraphique.COLABA8x13, "tout en essayant de faire le meilleur");
        EcranGraphique.drawText(180, 320, EcranGraphique.COLABA8x13, "temps possible !");
        EcranGraphique.drawText(360, 360, EcranGraphique.COLABA8x13, "Bon jeu !");
        EcranGraphique.flush();
    }

    /**
     * Quitter le programme.
     */
    public static void boutonQuitter() {
        EcranGraphique.exit();
    }

    /**
     * Permet de retourner au menu principale.
     *
     * @param ea  Parametres de l'ecran.
     * @param btn Differents boutons.
     * @param cb Proprietes du casse brique.
     */
    public static void boutonRetour(EcranAffichage ea, divBouton btn, JeuCasseBrique.CasseBrique cb) {
        EcranGraphique.clear();
        afficheMenu(ea, btn, cb);
    }
    
    /**
     * Permet d'acceder aux differentes pages selon le bouton clique.
     *
     * @param ea  Parametres de l'ecran.
     * @param btn Differents boutons.
     * @param x   Position x du bouton.
     * @param y   Position y du bouton.
     * @param cb Proprietes du casse brique.
     * @param jouer Partie en cours ou pas.
     * @return jouer Partie en cours ou pas.
     */
    public static boolean cliqueSouris(EcranAffichage ea, divBouton btn, int x, int y, JeuCasseBrique.CasseBrique cb, boolean jouer) {
    	/** Bouton jouer*/
        if (cliqueBouton(btn.jouer.posBouton.x, btn.jouer.posBouton.y, btn.jouer.tailleBouton.largeur, btn.jouer.tailleBouton.hauteur, x, y) == true && btn.jouer.etat == true) {
        	jouer = boutonJouer(btn, cb);
        } 
        /**Bouton reglage*/
        if (cliqueBouton(btn.reglages.posBouton.x, btn.reglages.posBouton.y, btn.reglages.tailleBouton.largeur, btn.reglages.tailleBouton.hauteur, x, y) == true && btn.reglages.etat == true) {
            EcranGraphique.clear();
            boutonReglages(ea, btn, x, y);
        } 
        /**Bouton regles*/
        if (cliqueBouton(btn.regles.posBouton.x, btn.regles.posBouton.y, btn.regles.tailleBouton.largeur, btn.regles.tailleBouton.hauteur, x, y) == true && btn.regles.etat == true) {
            EcranGraphique.clear();
            boutonRegles(ea, btn, x, y);
        } 
        /**Bouton retour*/
        if (cliqueBouton(btn.retour.posBouton.x, btn.retour.posBouton.y, btn.retour.tailleBouton.largeur, btn.retour.tailleBouton.hauteur, x, y) == true && btn.retour.etat == true) {
            boutonRetour(ea, btn, cb);
        } 
        /**Bouton retour lors de l'affichage des resultats*/
        if (cliqueBouton(btn.resultats.posBouton.x, btn.resultats.posBouton.y, btn.resultats.tailleBouton.largeur, btn.resultats.tailleBouton.hauteur, x, y) == true && btn.resultats.etat == true) {
        	return true;
        } 
        /**Bouton quitter*/
        if (cliqueBouton(btn.quitter.posBouton.x, btn.quitter.posBouton.y, btn.quitter.tailleBouton.largeur, btn.quitter.tailleBouton.hauteur, x, y) == true && btn.quitter.etat == true) {
            boutonQuitter();
        } 
        /**Choix de la largeur de la raquette : 20 pixels*/
        if (cliqueBouton(btn.pxl20.posBouton.x, btn.pxl20.posBouton.y, btn.pxl20.tailleBouton.largeur, btn.pxl20.tailleBouton.hauteur, x, y) == true && btn.pxl20.etat == true) {
            cb.raquette.largeur = 20;
            confirmation(ea, btn, x, y, cb);
        } 
        /**Choix de la largeur de la raquette : 40 pixels*/
        if (cliqueBouton(btn.pxl40.posBouton.x, btn.pxl40.posBouton.y, btn.pxl40.tailleBouton.largeur, btn.pxl40.tailleBouton.hauteur, x, y) == true && btn.pxl40.etat == true) {
            cb.raquette.largeur = 40;
            confirmation(ea, btn, x, y, cb);
        } 
        /**Choix de la largeur de la raquette : 60 pixels*/
        if (cliqueBouton(btn.pxl60.posBouton.x, btn.pxl60.posBouton.y, btn.pxl60.tailleBouton.largeur, btn.pxl60.tailleBouton.hauteur, x, y) == true && btn.pxl60.etat == true) {
            cb.raquette.largeur = 60;
            confirmation(ea, btn, x, y, cb);
        } 
        /**Choix de la largeur de la raquette : 80 pixels*/
        if (cliqueBouton(btn.pxl80.posBouton.x, btn.pxl80.posBouton.y, btn.pxl80.tailleBouton.largeur, btn.pxl80.tailleBouton.hauteur, x, y) == true && btn.pxl80.etat == true) {
            cb.raquette.largeur = 80;
            confirmation(ea, btn, x, y, cb);
        } 
        /**Choix de la largeur de la raquette : 100 pixels*/
        if (cliqueBouton(btn.pxl100.posBouton.x, btn.pxl100.posBouton.y, btn.pxl100.tailleBouton.largeur, btn.pxl100.tailleBouton.hauteur, x, y) == true && btn.pxl100.etat == true) {
            cb.raquette.largeur = 100;
            confirmation(ea, btn, x, y, cb);
        } 
        /**Choix de la largeur de la raquette : 120 pixels*/
        if (cliqueBouton(btn.pxl120.posBouton.x, btn.pxl120.posBouton.y, btn.pxl120.tailleBouton.largeur, btn.pxl120.tailleBouton.hauteur, x, y) == true && btn.pxl120.etat == true) {
            cb.raquette.largeur = 120;
            confirmation(ea, btn, x, y, cb);
        }
        return jouer;
    }

    /**
     * Affichage du menu principale.
     *
     * @param ea  Parametres de l'ecran.
     * @param btn Differents boutons.
     * @param cb Proprietes du jeu.
     */
    public static void afficheMenu(EcranAffichage ea, divBouton btn, JeuCasseBrique.CasseBrique cb) {
    	/**Activation - Desactivation des boutons*/
    	btn.resultats.etat = false;btn.reglages.etat = true;btn.retour.etat = false;btn.jouer.etat = true;
        btn.quitter.etat = true;btn.regles.etat = true;btn.pxl20.etat = false;btn.pxl40.etat = false;
        btn.pxl60.etat = false;btn.pxl80.etat = false;btn.pxl100.etat = false;btn.pxl120.etat = false;
        EcranGraphique.clear();

        background();

        int [][] titre = EcranGraphique.loadPNGFile("titre.png");
        EcranGraphique.drawImage(150,120,titre);

        int [][] jouer = EcranGraphique.loadPNGFile("jouer.png");
        EcranGraphique.drawImage(150,170,jouer);
        btn.jouer.posBouton.x = 150; btn.jouer.posBouton.y = 170; btn.jouer.tailleBouton.largeur = 200; btn.jouer.tailleBouton.hauteur = 50;
       
        int [][] reglage = EcranGraphique.loadPNGFile("reglage.png");
        EcranGraphique.drawImage(150,240,reglage);
        btn.reglages.posBouton.x = 150; btn.reglages.posBouton.y = 240; btn.reglages.tailleBouton.largeur = 200; btn.reglages.tailleBouton.hauteur = 50;
        
        int [][] regle = EcranGraphique.loadPNGFile("regle.png");
        EcranGraphique.drawImage(150,310,regle);
        btn.regles.posBouton.x = 150; btn.regles.posBouton.y = 310; btn.regles.tailleBouton.largeur = 200; btn.regles.tailleBouton.hauteur = 50;
        
        int [][] quitter = EcranGraphique.loadPNGFile("quitter.png");
        EcranGraphique.drawImage(150,380,quitter);
        btn.quitter.posBouton.x = 150; btn.quitter.posBouton.y = 380; btn.quitter.tailleBouton.largeur = 200; btn.quitter.tailleBouton.hauteur = 50;

        EcranGraphique.flush();
    }

    /**
     * Affichage du menu de fin de partie selon le resultat.
     *
     * @param partie  Victoire ou defaite.
     * @param cb Proprietes du jeu.
     */
    public static void end(boolean partie, JeuCasseBrique.CasseBrique cb) {
    	EcranGraphique.clear();
    	EcranAffichage ea = new EcranAffichage();
        divBouton btn = new divBouton();

        EcranGraphique.init(ea.coinX = 0, ea.coinY = 0, ea.largeurFenetre = 527, ea.hauteurFenetre = 677, ea.largeur
                = 500, ea.hauteur = 600, "Menu du jeu");
    	if (partie) {
        	victoire(ea, btn, cb);
        }
    	else if (!partie) {
        	defaite(ea, btn, cb);
        }
        boolean jouer = false;
        while (!jouer) {
            if (EcranGraphique.getMouseState() == 1) {
                int x = EcranGraphique.getMouseX();
                int y = EcranGraphique.getMouseY();
                jouer = cliqueSouris(ea, btn, x, y, cb, jouer);
            }
            EcranGraphique.flush();
        }
    }
    
    /**
     * Affichage du menu de debut de partie.
     *
     * @param cb Proprietes du jeu.
     */
    public static void start(JeuCasseBrique.CasseBrique cb) {
    	EcranGraphique.clear();
        EcranAffichage ea = new EcranAffichage();
        divBouton btn = new divBouton();
        
        cb.raquette.largeur = 60;
        EcranGraphique.init(ea.coinX = 0, ea.coinY = 0, ea.largeurFenetre = 527, ea.hauteurFenetre = 677, ea.largeur
                = 500, ea.hauteur = 600, "Menu du jeu");
        afficheMenu(ea, btn, cb);
        boolean jouer = false;
        while (!jouer) {
            if (EcranGraphique.getMouseState() == 1) {
                int x = EcranGraphique.getMouseX();
                int y = EcranGraphique.getMouseY();
                jouer = cliqueSouris(ea, btn, x, y, cb, jouer);
            }
            EcranGraphique.flush();
        }
    }
}
