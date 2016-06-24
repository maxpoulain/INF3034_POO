import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.dynamics.contacts.*;
import org.jbox2d.callbacks.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.*;
import java.io.*;

import fr.atis_lab.physicalworld.*;

public class Brick implements ContactListener, Serializable, KeyListener,
		ActionListener {

	private PhysicalWorld world;
	private Body ball, raquette, bloc1, bloc2, bloc3, bloc4, bloc5, bloc6,bloc7, bloc8, bloc9, bloc10, bloc11, bloc12, bloc130,bloc140, bloc150, bloc160, bloc170, bloc180, bloc190,bloc200, bloc210, bloc220, bloc230,bloc240,bloc250,bloc260,bloc270,bloc280,bloc290,bloc300,bloc310,bloc320,bloc330,bloc340,bloc350,bloc13;
	private DrawingPanel panel;
	private JFrame frame;
	private JButton NewGame;
	private JButton Historique;
	private JButton Commandes;
	private JButton Niveau1;
	private JButton Niveau2;
	private JPanel Boutons;
	private JLabel label;
	private int vie=4,cpt=0,cptspace=0,cptlevel=1,score=0;
	private boolean flagbrick=false,flagbottom=false,flagpause=true,flagreset=false;
	private Body name;
	

	public Brick() {
		world = new PhysicalWorld(new Vec2(0, 0), -38, 38, 0, 64, Color.GRAY);
		world.setContactListener(this);
		if(cptlevel==1){
			try {
				
				ball = world.addCircularObject(1.5f, BodyType.DYNAMIC,new Vec2(0, 7), 0, new Sprite("ball", 1, null,new ImageIcon("./img/pwrup-mushroom.png")));
				raquette = world.addRectangularObject(8f, 2.5f, BodyType.DYNAMIC,new Vec2(0, 4), 0, new Sprite("raquette", 2,null,new ImageIcon("./img/raquette.png")));
				bloc1 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-10, 60), 0, new Sprite("bloc1", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc2 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(10, 60), 0, new Sprite("bloc2", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc3 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-20, 54), 0, new Sprite("bloc3", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc4 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(20, 54), 0, new Sprite("bloc4", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc5 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-20, 48), 0, new Sprite("bloc5", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc6 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(20, 48), 0, new Sprite("bloc6", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc7 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-20, 42), 0, new Sprite("bloc7", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc8 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(20, 42), 0, new Sprite("bloc8", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc9 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-20, 36), 0, new Sprite("bloc9", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc10 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(20, 36), 0, new Sprite("bloc10", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc11 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-10, 30), 0, new Sprite("bloc11", 2,null,new ImageIcon("./img/bricksprite.png")));
				bloc12 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(10,30), 0, new Sprite("bloc12", 2,null,new ImageIcon("./img/bricksprite.png")));
				ball.m_invMass = 10000000;
				raquette.m_invMass = 1;
				bloc1.m_invMass = 1;
				bloc2.m_invMass = 1;
				bloc3.m_invMass = 1;
				bloc4.m_invMass = 1;
				bloc5.m_invMass = 1;
				bloc6.m_invMass = 1;
				bloc7.m_invMass = 1;
				bloc8.m_invMass = 1;
				bloc9.m_invMass = 1;
				bloc10.m_invMass = 1;
				bloc11.m_invMass = 1;
				bloc12.m_invMass = 1;
				bloc130 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick130", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc140 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick140", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc150 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick150", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc160 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick160", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc170 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick170", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc180 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick180", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc190 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick190", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc200 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick200", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc210 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick210", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc220 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick220", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc230 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick230", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc240 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick240", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc250 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick250", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc260 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick260", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc270 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick270", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc280 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick280", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc290 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick290", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc300 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick300", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc310 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick310", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc320 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick320", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc330 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick330", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc340 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick340", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc350 = world.addRectangularObject(7f, 3f, BodyType.STATIC,new Vec2(-60,70), 0, new Sprite("brick350", 2, null,new ImageIcon("./img/bricksprite.png")));
				bloc130.m_invMass = 1;
				bloc140.m_invMass = 1;
				bloc150.m_invMass = 1;
				bloc160.m_invMass = 1;
				bloc170.m_invMass = 1; 
				bloc180.m_invMass = 1; 
				bloc190.m_invMass = 1;
				bloc200.m_invMass = 1; 
				bloc210.m_invMass = 1; 
				bloc220.m_invMass = 1; 
				bloc230.m_invMass = 1;
				bloc240.m_invMass = 1;
				bloc250.m_invMass = 1;
				bloc260.m_invMass = 1;
				bloc270.m_invMass = 1;
				bloc280.m_invMass = 1;
				bloc290.m_invMass = 1;
				bloc300.m_invMass = 1;
				bloc310.m_invMass = 1;
				bloc320.m_invMass = 1;
				bloc330.m_invMass = 1;
				bloc340.m_invMass = 1;
				bloc350.m_invMass = 1;
				
				ball.getFixtureList().setRestitution(1.1f);
				ball.getFixtureList().setFriction(0);
	
			} catch (InvalidSpriteNameException ex) {
				ex.printStackTrace();
				System.exit(-1);
			}
		}

		this.panel = new DrawingPanel(world, new Dimension(1280, 750), 10f);
		this.panel.setBackGroundColor(Color.GRAY);
		this.panel.setBackGroundIcon(new ImageIcon("./img/fondbis.png"));
		this.panel.addKeyListener(this);

		frame = new JFrame("JBox2D GUI");
		frame.setMinimumSize(this.panel.getPreferredSize());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this.panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		this.panel.requestFocus();
		
		Boutons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel Temps = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        frame.add(Temps, BorderLayout.NORTH);


        NewGame = new JButton("NewGame");
        Boutons.add(NewGame);
        Historique = new JButton("Historique");
        Boutons.add(Historique);
        Commandes = new JButton("Commandes");
        Boutons.add(Commandes);
       /* Niveau1 = new JButton("Niveau1");
        Boutons.add(Niveau1);
        Niveau2 = new JButton("Niveau2");
        Boutons.add(Niveau2);*/


        frame.add(Boutons, BorderLayout.NORTH);

        NewGame.setActionCommand("reset");

        NewGame.addActionListener(this);
        Commandes.addActionListener(this);
        Historique.addActionListener(this);

        label = new JLabel("Vie : " +vie+"    Niveau " +cptlevel+"    Score :"+score );
        Boutons.add(label);
	}
	
	public void level2(){
		bloc130.setTransform(new Vec2(30,51),0);
		bloc140.setTransform(new Vec2(30,45), 0);
		bloc150.setTransform(new Vec2(-10, 57), 0);
		bloc160.setTransform(new Vec2(-10, 51), 0);
		bloc170.setTransform(new Vec2(-10, 45), 0);
		bloc180.setTransform(new Vec2(-10, 39), 0);
		bloc190.setTransform(new Vec2(-20, 54), 0);
		bloc200.setTransform(new Vec2(-20, 48), 0);
		bloc210.setTransform(new Vec2(-20, 42), 0);
		bloc220.setTransform(new Vec2(-30,51), 0);
		bloc230.setTransform(new Vec2(-30,45), 0);
		bloc240.setTransform(new Vec2(0, 60), 0);
		bloc250.setTransform(new Vec2(10, 57), 0);
		bloc260.setTransform(new Vec2(0, 54), 0);
		bloc270.setTransform(new Vec2(10, 51), 0);
		bloc280.setTransform(new Vec2(0, 48), 0);
		bloc290.setTransform(new Vec2(10, 45), 0);
		bloc300.setTransform(new Vec2(0, 42), 0);
		bloc310.setTransform(new Vec2(10, 39), 0);
		bloc320.setTransform(new Vec2(0, 36), 0);
		bloc330.setTransform(new Vec2(20, 54), 0);
		bloc340.setTransform(new Vec2(20, 48), 0);
		bloc350.setTransform(new Vec2(20, 42), 0); 
	}
	
	public void delete(){
		if(flagbrick==true){
			System.out.println("SUPPRIME BLOC");
			try {
				world.destroyObject(name);
			} catch (LockedWorldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cpt++;
			flagbrick=false;
		}		
	}
	public void restart(){
		ball.setTransform(new Vec2(0,7), 0);
		raquette.setTransform(new Vec2(0, 4),0);
		flagbottom=false;
		Random r = new Random();
		int flag =1+r.nextInt(3 - 1);
		System.out.println(flag);
		if(flag==1){
			ball.setLinearVelocity(new Vec2(35, 25));
		}
		/*if(flag==2){
			ball.setLinearVelocity(new Vec2(-10,45));
		}
		if(flag==3){
			ball.setLinearVelocity(new Vec2(18, 35));
		}*/
		if(flag==2){
			ball.setLinearVelocity(new Vec2(-35, 25));
		}
	}

	public void run() throws LockedWorldException {
		System.out.println("You may use the arrows of the keyboard !");
		try {
			float timeStep = 1 / 60.0f;
			int msSleep = Math.round(1000 * timeStep); 		
			panel.setCameraPosition(new Vec2(0, 32));
			world.setTimeStep(timeStep);;
			Random r = new Random();
			int flag =1+r.nextInt(3 - 1);
			System.out.println(flag);
			if(flag==1){
				ball.setLinearVelocity(new Vec2(35, 25));
			}
			if(flag==2){
				ball.setLinearVelocity(new Vec2(-35, 25));
			}
			while ((vie != 0) || (cpt!=23 && cptlevel==2)) { 
				if(flagpause==true){
					world.step();
				}
				if(flagbrick==true){
					delete();
				}
				if(flagbottom==true){
					restart();
					vie--;
					Boutons.remove(label);
					label = new JLabel("Vie : " +vie+"    Niveau " +cptlevel+"    Score :"+score );
			        Boutons.add(label);
				}
				if(flagreset==true){
					frame.dispose();
					new Brick().run();
				}
				if(cpt==12 && cptlevel==1){
				cptlevel++;
				vie++;
				Boutons.remove(label);
				label = new JLabel("Vie : " +vie+"    Niveau " +cptlevel+"    Score :"+score );
		        Boutons.add(label);
				cpt=0;
				level2();
				restart();
				}
				if(cpt==23){
					System.out.println("TERMINE");
					break;
				}
				Thread.sleep(msSleep); 
				this.panel.updateUI(); 
			}
			if(vie==0){
				JFrame framea = new JFrame("Perdu");

	            framea.setPreferredSize(new Dimension(300,300));

	            framea.setLayout(new BorderLayout());

	            JPanel scorea = new JPanel(new FlowLayout(FlowLayout.CENTER));
	            framea.add(scorea, BorderLayout.CENTER);

	            JLabel score33a = new JLabel("Vous avez PERDU, vous n'avez plus de vies !");

	            scorea.add(score33a);
	            framea.pack();
	            framea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            framea.setLocationRelativeTo(null);
	            framea.setVisible(true);
	            this.panel.requestFocus();
			}
			if(cpt==23 && cptlevel==2){
				JFrame framea = new JFrame("Gagne");
                
	            framea.setPreferredSize(new Dimension(500,500));

	            framea.setLayout(new BorderLayout());

	            JPanel scorea = new JPanel(new FlowLayout(FlowLayout.CENTER));
	            framea.add(scorea, BorderLayout.CENTER);

	            JLabel score33a = new JLabel("Vous avez Gagne, le jeu est termine !");
	            JLabel score33b = new JLabel("Merci d'avoir joue et a bientot pour de nouveaux niveaux !");

	            scorea.add(score33a);
	            scorea.add(score33b);
	            framea.pack();
	            framea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            framea.setLocationRelativeTo(null);
	            framea.setVisible(true);
	            this.panel.requestFocus();
			}
				

		} catch (InterruptedException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public void beginContact(Contact contact) {
		System.out.println("Objects are touching "+ Sprite.extractSprite(contact.getFixtureA().getBody()).getName()+ " "+ Sprite.extractSprite(contact.getFixtureB().getBody()).getName());
		if (Sprite.extractSprite(contact.getFixtureA().getBody()).getName().contains("bloc") || Sprite.extractSprite(contact.getFixtureA().getBody()).getName().contains("brick") ) {
			flagbrick=true;
			score=score+10;
			Boutons.remove(label);
			label = new JLabel("Vie : " +vie+"    Niveau " +cptlevel+"    Score :"+score );
	        Boutons.add(label);
			name = contact.getFixtureA().getBody();
		}
		if (Sprite.extractSprite(contact.getFixtureA().getBody()).getName() == "bottomWall") {
			flagbottom=true;
		}
		if(Sprite.extractSprite(contact.getFixtureA().getBody()).getName().contains("bloc") || Sprite.extractSprite(contact.getFixtureA().getBody()).getName().contains("raquette") || Sprite.extractSprite(contact.getFixtureA().getBody()).getName().contains("bottom")==false){
			System.out.println("velocity:"+ ball.getLinearVelocity());
			if(ball.getLinearVelocity().x <= 15 && ball.getLinearVelocity().x >= -15 ){
			System.out.println("OKI1");
			ball.setLinearVelocity(new Vec2(2*ball.getLinearVelocity().x,ball.getLinearVelocity().y));
			}
			if(ball.getLinearVelocity().y <= 15 && ball.getLinearVelocity().y >= -15){
				System.out.println("OKI2");
				ball.setLinearVelocity(new Vec2(ball.getLinearVelocity().x,2*ball.getLinearVelocity().y));
			}
			if(ball.getLinearVelocity().x >= 70 && ball.getLinearVelocity().x <= -70 ){
				System.out.println("OKI3");
				ball.setLinearVelocity(new Vec2(ball.getLinearVelocity().x/2,ball.getLinearVelocity().y));
				}
			if(ball.getLinearVelocity().y >= 70 && ball.getLinearVelocity().y <= -70){
				System.out.println("OKI4");
				ball.setLinearVelocity(new Vec2(ball.getLinearVelocity().x,ball.getLinearVelocity().y/2));
			}
		}
	}

	public void endContact(Contact contact) {
	}

	public void postSolve(Contact contact, ContactImpulse impulse) {
	}

	public void preSolve(Contact contact, Manifold oldManifold) {
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed " + e.getKeyCode());
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if(raquette.getPosition().x <= -32 ){
				raquette.setLinearVelocity(new Vec2(-15,0));
			}else{
				raquette.setLinearVelocity(new Vec2(-50,0));
			}
				
			break;
		case KeyEvent.VK_RIGHT:
			if(raquette.getPosition().x >= 32){
				raquette.setLinearVelocity(new Vec2(15,0));
			}else{
				raquette.setLinearVelocity(new Vec2(50,0));
			}
			break;
		case KeyEvent.VK_SPACE:
			cptspace++;
			if(cptspace==1){
			flagpause=false;
			}
			if(cptspace==2){
				flagpause=true;
				cptspace=0;
			}
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		raquette.setLinearVelocity(new Vec2(0,0));
	}

	public static void main(String[] args) throws LockedWorldException {
		new Brick().run();
	}

    public void actionPerformed(ActionEvent e) {


        JLabel label;

        switch(e.getActionCommand()) {

        case "reset":
        	flagreset=true;
        break;
        /*case "Niveau1":
        	cptlevel=1;
        break;
        case "Niveau2":
        	flaglevel=true;
        break;*/

        case "Commandes":

            JFrame frame4 = new JFrame("Commandes");

            frame4.setPreferredSize(new Dimension(1000,300));

            frame4.setLayout(new BorderLayout());

            JPanel score3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            frame4.add(score3, BorderLayout.CENTER);

            JLabel score33 = new JLabel("Les deplacements se font avec les fleches gauche et droite !");
            JLabel score50 = new JLabel("Vous pouvez faire pause en appuyant sur la barre espace et reprendre le jeu en reappuyant sur la barre espace !");

            score3.add(score33);
            score3.add(score50);
            frame4.pack();
            frame4.setVisible(true);

            this.panel.requestFocus();

       break;

       case "Historique":

            JFrame frame5 = new JFrame("Achetez notre jeu");

            frame5.setPreferredSize(new Dimension(700,500));

            frame5.setLayout(new BorderLayout());

            JPanel score4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            frame5.add(score4, BorderLayout.CENTER);

            JLabel score44 = new JLabel(" L'historique des parties sera disponible sur la version payante");

            score4.add(score44);
            frame5.pack();
            frame5.setVisible(true);

            this.panel.requestFocus();
      break;


        }
    }
}
