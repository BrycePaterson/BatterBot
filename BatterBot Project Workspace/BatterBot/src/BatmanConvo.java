import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JScrollBar;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


@SuppressWarnings("serial")
public class BatmanConvo extends JFrame {

	private JPanel contentPane;
	private JTextField inputText;
	private LanguageProcessor LP = new LanguageProcessor();
	private ResponseSelector RS = new ResponseSelector();
	private ResponseBuilder RB = new ResponseBuilder();
	private tweet tweets = new tweet();
	private String input;
	ResponseTemplate template = null;
	private JScrollPane scrollPane;
	private JTextArea display;
	private JRadioButton rdbtnFrench;
	private JScrollPane scrollPane_1;
	private JTextArea twitter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					BatmanConvo frame = new BatmanConvo();
					frame.setup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unused")
	public static void setup()
	{
		//This is just an example of what a response template definition will look like
		
				String[] sentence0 = {"I'm sorry, I don't understand....my time is precious. We could talk about"};
				String[][] bucket0 = {{" Superman"," Wonder Woman"," The Justice League"," Green Lantern"," The Flash"," my enemies"}};
				String[] keys0 = {"null"};
		
				ResponseTemplate response0 = new ResponseTemplate(sentence0, bucket0, keys0);
				
				String[] sentence = {"Hi, this is Batman. What is your name?"};
				String[][] bucket = null;
				String[] keys = {"Hello", "Hi", "Hey"};
				
				ResponseTemplate response1 = new ResponseTemplate(sentence, bucket, keys){
					public double scaleRules(){
						exp.set();
						return 1;
					}
				};;
						
				String[] sentence2 = {"I don't care either..."};
				String[][] bucket2 = null;
				String[] keys2 = {"i don't care","i dont care"};
				
				ResponseTemplate response2 = new ResponseTemplate(sentence2, bucket2, keys2);
				
				String[] sentence3 = {"Robin is the Boy Wonder, and my sidekick"};
				String[][] bucket3 = null;
				String[] keys3 = {"who is robin"};
				
				ResponseTemplate response3 = new ResponseTemplate(sentence3, bucket3, keys3);
				
				String[] sentence4 = {"I cannot tell you my true identity.  It protects my friends from danger"};
				String[][] bucket4 = null;
				String[] keys4 = {"true","identity","who are you"};
				
				ResponseTemplate response4 = new ResponseTemplate(sentence4, bucket4, keys4);
				
				String[] sentence5 = {"I cannot tell you Robin's true identity, I'll never put him in danger"};
				String[][] bucket5 = null;
				String[] keys5 = {"robin","true","identity"};
				
				ResponseTemplate response5 = new ResponseTemplate(sentence5, bucket5, keys5);
				
				String[] sentence6 = {"No....I've never met Mr. Wayne"};
				String[][] bucket6 = null;
				String[] keys6 = {"Bruce","Wayne"};
				
				ResponseTemplate response6 = new ResponseTemplate(sentence6, bucket6, keys6);
				
				String[] sentence7 = {"Yes. Commissioner Gordon protects Gotham on a daily basis...I rely on his help to fight crime"};
				String[][] bucket7 = null;
				String[] keys7 = {"know gordon","about gordon","think about gordon", "commissioner gordon"};
				
				ResponseTemplate response7 = new ResponseTemplate(sentence7, bucket7, keys7);
				
				String[] sentence8 = {"Of course! Superman and I are bros. We're both in the Justice League."};
				String[][] bucket8 = null;
				String[] keys8 = {"know superman","like superman","think about superman"};
				
				ResponseTemplate response8 = new ResponseTemplate(sentence8, bucket8, keys8);
				
				String[] sentence9 = {"Yes...her and I have always had a 'thing'.  We're both in the Justice League."};
				String[][] bucket9 = null;
				String[] keys9 = {"know wonderwoman","know wonder woman","like wonder woman","like wonderwoman","think about wonderwoman","think about wonder woman"};
				
				ResponseTemplate response9 = new ResponseTemplate(sentence9, bucket9, keys9);
				
				String[] sentence10 = {"Yes. We are both members of the Justice League. He has a really cool ring, I'm a little jealous of it"};
				String[][] bucket10 = null;
				String[] keys10 = {"know green lantern","like green lantern","think about green lantern"};
				
				ResponseTemplate response10 = new ResponseTemplate(sentence10, bucket10, keys10);
				
				String[] sentence11 = {"Yes. We're both members of the Justice League. He's a fool, but he is fast."};
				String[][] bucket11 = null;
				String[] keys11 = {"know flash","like flash"};
				
				ResponseTemplate response11 = new ResponseTemplate(sentence11, bucket11, keys11);
				
				String[] sentence12 = {"The Justice League is a league of heroes sworn to the protection of Earth."};
				String[][] bucket12 = null;
				String[] keys12 = {"what is the justice league","what's the justice league"};
				
				ResponseTemplate response12 = new ResponseTemplate(sentence12, bucket12, keys12);
				
				String[] sentence13 = {"The core members of the Justice League are Myself, Superman, Wonder Woman, Green Lantern, Flash, and the Martian. They are my only friends"};
				String[][] bucket13 = null;
				String[] keys13 = {"in the justice league","in justice league","friends"};
				
				ResponseTemplate response13 = new ResponseTemplate(sentence13, bucket13, keys13);
				
				String[] sentence14 = {"The Green Lantern derives his power from his magical ring, or 'Lantern'. One of these rings is bestowed upon a worthy individual to protect his section of the Galaxy. He protects Earth"};
				String[][] bucket14 = null;
				String[] keys14 = {"about green lantern", "who is green lantern"};
				
				ResponseTemplate response14 = new ResponseTemplate(sentence14, bucket14, keys14);
				
				String[] sentence15 = {"Superman is the last know Kryptonian. He was sent to earth as a child, when his planet Krypton exploded. He values justice above all else and will defend the Earth, his new home.  Also he has so many powers...it's unfair :("};
				String[][] bucket15 = null;
				String[] keys15 = {"about superman","who is superman"};
				
				ResponseTemplate response15 = new ResponseTemplate(sentence15, bucket15, keys15);
				
				String[] sentence16 = {"Wonder Woman is an Amazonian.  She comes from a far away planet full of sexy women ;)"};
				String[][] bucket16 = null;
				String[] keys16 = {"about wonder woman","who is wonder woman"};
				
				ResponseTemplate response16 = new ResponseTemplate(sentence16, bucket16, keys16);
				
				String[] sentence17 = {"The Flash is the fastest man on earth. He can run at supersonic speeds....unfortunately, the only thing faster than him is his mouth."};
				String[][] bucket17 = null;
				String[] keys17 = {"about flash","about the flash","who is flash","who is the flash"};
				
				ResponseTemplate response17 = new ResponseTemplate(sentence17, bucket17, keys17);
				
				String[] sentence18 = {"Seriously...he's a martian with superpowers. I thought that one was pretty self-explanatory"};
				String[][] bucket18 = null;
				String[] keys18 = {"about Martian","about the martian","who is martian","who is the martian"};
				
				ResponseTemplate response18 = new ResponseTemplate(sentence18, bucket18, keys18);
				
				String[] sentence19 = {"Bats are really scary!!! I fell down a well when I was a kid and cried the bats were so scary!"};
				String[][] bucket19 = null;
				String[] keys19 = {"bat"};
				
				ResponseTemplate response19 = new ResponseTemplate(sentence19, bucket19, keys19);
				
				String[] sentence20 = {"I fight crime to avenge the death of my parents, by beating up the bad guys of Gotham! Don't try yourself, you could get hurt"};
				String[][] bucket20 = null;
				String[] keys20 = {"fight crime"};
				
				ResponseTemplate response20 = new ResponseTemplate(sentence20, bucket20, keys20);
				
				String[] sentence21 = {"A bad guy! I don't want to talk about it!!! :'("};
				String[][] bucket21 = null;
				String[] keys21 = {"killed your parents","killed them","they die"};
				
				ResponseTemplate response21 = new ResponseTemplate(sentence21, bucket21, keys21);
				
				String[] sentence22 = {"My parents died when I was  little boy. I watched them be murdered..."};
				String[][] bucket22 = null;
				String[] keys22 = {"parents die","they die?"};
				
				ResponseTemplate response22 = new ResponseTemplate(sentence22, bucket22, keys22);
	
				String[] sentence23 = {"I was trained by the league of shadows."};
				String[][] bucket23 = null;
				String[] keys23 = {"train","trained","training"};
				
				ResponseTemplate response23 = new ResponseTemplate(sentence23, bucket23, keys23);
				
				String[] sentence24 = {"The league of shadows is an acient cult. Bent on wiping Gotham off the map.  They are led by Raz Al-Gul"};
				String[][] bucket24 = null;
				String[] keys24 = {"league of shadow"};
				
				ResponseTemplate response24 = new ResponseTemplate(sentence24, bucket24, keys24);
				
				String[] sentence25 = {"Raz Al-Gul is the leader of the League of , and one of my many enemies. He is thousands of years old. He gets his youth from the legendary Lazarus Pools"};
				String[][] bucket25 = null;
				String[] keys25 = {"raz","al-gul","leader"};
				
				ResponseTemplate response25 = new ResponseTemplate(sentence25, bucket25, keys25);
				
				String[] sentence26 = {"The lazarus pools are the source of the legend of the fountain of youth. They're one and the same, and Raz Al-gul is the only person who knows how to use them."};
				String[][] bucket26 = null;
				String[] keys26 = {"lazarus","pools"};
				
				ResponseTemplate response26 = new ResponseTemplate(sentence26, bucket26, keys26);
				
				String[] sentence27 = {"The Joker is a psychopathic clown who just wants to watch the world burn. He is my oldest and most dangerous enemy!"};
				String[][] bucket27 = null;
				String[] keys27 = {"joker"};
				
				ResponseTemplate response27 = new ResponseTemplate(sentence27, bucket27, keys27);
				
				String[] sentence28 = {"Mr. Cobblepot, aka the Penguin, is a deranged, mutated man who blames the rest of the world for his misfortune. We have fought many times."};
				String[][] bucket28 = null;
				String[] keys28 = {"penguin", "cobblepot"};
				
				ResponseTemplate response28 = new ResponseTemplate(sentence28, bucket28, keys28);
				
				String[] sentence29 = {"Born Harvery Dent, a former prosecutor, He developed a psychopathic obsession with duality after...I'd rather not talk about it"};
				String[][] bucket29 = null;
				String[] keys29 = {"two face","two-face"};
				
				ResponseTemplate response29 = new ResponseTemplate(sentence29, bucket29, keys29);
				
				String[] sentence30 = {"I have many enemies. The joker, Raz Al-gul, the Penguin, and Two-Face are the enemies I encounter the most"};
				String[][] bucket30 = null;
				String[] keys30 = {"enemies","villain"};
				
				ResponseTemplate response30 = new ResponseTemplate(sentence30, bucket30, keys30);
				
				String[] sentence31 = {"Where are the other drugs!!"};
				String[][] bucket31 = null;
				String[] keys31 = {"drugs"};
				
				ResponseTemplate response31 = new ResponseTemplate(sentence31, bucket31, keys31);
				
				String[] sentence32 = {"Where are the hostages?"};
				String[][] bucket32 = null;
				String[] keys32 = {"hostage"};
				
				ResponseTemplate response32 = new ResponseTemplate(sentence32, bucket32, keys32);
				
				String[] sentence33 = {"I'll be there as soon as I can!!"};
				String[][] bucket33 = null;
				String[] keys33 = {"rd.","st.","blvd.","hwy.","road","street","boulevard","highway"};
				
				ResponseTemplate response33 = new ResponseTemplate(sentence33, bucket33, keys33);
				
				String[] sentence34 = {"Goodbye, Gotham Citizen"};
				String[][] bucket34 = null;
				String[] keys34 = {"bye"};
				
				ResponseTemplate response34 = new ResponseTemplate(sentence34, bucket34, keys34);
				response34.valediction=true;
				
				String[] sentence35 = {"Busy. I'm investigating a case with",};
				String[][] bucket35 = {{" Superman"," Wonder Woman"," The Flash"," The Green Lantern"," The Justice League"}};
				String[] keys35 = {"How are you","it going","you doing"};
				
				ResponseTemplate response35 = new ResponseTemplate(sentence35, bucket35, keys35);
				
				String[] sentence36 = {"My age is unimportant. I am busy fighting crime with the Justice League"};
				String[][] bucket36 = null;
				String[] keys36 = {"your age","old are you"};
				
				ResponseTemplate response36 = new ResponseTemplate(sentence36, bucket36, keys36);
				
				String[] sentence37 = {"I live in Gotham City! Meteropolis is a Superman's city."};
				String[][] bucket37 = null;
				String[] keys37 = {"you live","your home"};
				
				ResponseTemplate response37 = new ResponseTemplate(sentence37, bucket37, keys37);
				
				String[] sentence38 = {"I'm 6'2 and 210 lbs...let's stick to crime fighting relevant questions!"};
				String[][] bucket38 = null;
				String[] keys38 = {"you weigh","tall are you","your height"};
				
				ResponseTemplate response38 = new ResponseTemplate(sentence38, bucket38, keys38);
				
				String[] sentence39 = {".....I have no idea where Gotham is, it's never really come up...Where are you from?"};
				String[][] bucket39 = null;
				String[] keys39 = {"where is gotham","where is that"};
				
				ResponseTemplate response39 = new ResponseTemplate(sentence39, bucket39, keys39){
					public double scaleRules(){
						exp.set();
						return 1.5;
					}
				};
				
				String[] sentence40 = {"What bat cave?...."};
				String[][] bucket40 = null;
				String[] keys40 = {"bat cave"};
				
				ResponseTemplate response40 = new ResponseTemplate(sentence40, bucket40, keys40);
				
				String[] sentence41 = {"Gotham is the city I defend from evil."};
				String[][] bucket41 = null;
				String[] keys41 = {"about gotham","what is gotham"};
				
				ResponseTemplate response41 = new ResponseTemplate(sentence41, bucket41, keys41);
				
				String[] sentence42 = {"I don't know everything. Could we please talk about"};
				String[][] bucket42 = {{" Superman"," The Justice League"," The League of Shadows"}};
				String[] keys42 = {"you don't know"};
				
				ResponseTemplate response42 = new ResponseTemplate(sentence42, bucket42, keys42);
				
				String[] sentence43 = {"Just because. Why do you ask me about"};
				String[][] bucket43 = {{" Superman"," The Justice League"," The League of Shadows"}};
				String[] keys43 = {"why?","so?"};
				
				ResponseTemplate response43 = new ResponseTemplate(sentence43, bucket43, keys43);
				
				String[] sentence44 = {"Let's talk about","or"};
				String[][] bucket44 = {{" Superman"," The Justice League"," The League of Shadows"},{" The Green Lantern"," the Joker", "Gotham"}};
				String[] keys44 = {"talk about?"};
				
				ResponseTemplate response44 = new ResponseTemplate(sentence44, bucket44, keys44);
				
				String[] sentence45 = {"I don't know a"};
				String[][] bucket45 = {{"#_NNP"}};
				String[] keys45 = {"_NNP"};
				
				ResponseTemplate response45 = new ResponseTemplate(sentence45, bucket45, keys45);
				
				String[] sentence46 = {"I don't know anything about this '","', I only know about crime fighting"};
				String[][] bucket46 = {{"#_VB"}};
				String[] keys46 = {"_VB"};
				
				ResponseTemplate response46 = new ResponseTemplate(sentence46, bucket46, keys46);
				
				String[] sentence47 = {"Nice to meet you,",". What would you like to know?"};
				String[][] bucket47 = {{"#_NNP"}};
				String[] keys47 = {"_NNP"};
				
				ResponseTemplate response47 = new ResponseTemplate(sentence47, bucket47, keys47){
					public double scaleRules(){
						if(exp.get()){
							exp.unset();
							return 5;
						}else
							return 0;
					}
				};
				
				String[] sentence48 = {"No I'm not a computer!! Are you?"};
				String[][] bucket48 = null;
				String[] keys48 = {"you a computer","re a computer"};
				
				ResponseTemplate response48 = new ResponseTemplate(sentence48, bucket48, keys48){
					public double scaleRules(){
							exp.set();
							return 1.5;
					}
				};
				
				String[] sentence49 = {"Just checking...anything else you'd like to know?"};
				String[][] bucket49 = null;
				String[] keys49 = {"yes","no ","not"};
				
				ResponseTemplate response49 = new ResponseTemplate(sentence49, bucket49, keys49){
					public double scaleRules(){
						if(exp.get()){
							exp.unset();
							return 1;
						}else
							return 0;
					}
				};
				
				String[] sentence50 = {"I don't know any jokes...are you the Joker?!!"};
				String[][] bucket50 = null;
				String[] keys50 = {"jokes","a joke"};
				
				ResponseTemplate response50 = new ResponseTemplate(sentence50, bucket50, keys50){
					public double scaleRules(){
							exp.set();
							return 1;
					}
				};
				
				String[] sentence51 = {"I have no idea what you're talking about to be honest.  Tell me about yourself."};
				String[][] bucket51 = null;
				String[] keys51 = {"null"};
				
				ResponseTemplate response51 = new ResponseTemplate(sentence51, bucket51, keys51);
				
				String[] sentence52 = {"I don't have time for sports...unless you count karate a sport..."};
				String[][] bucket52 = null;
				String[] keys52 = {"volleyball","basketball","soccer","footbal","hockey","sport"};
				
				ResponseTemplate response52 = new ResponseTemplate(sentence52, bucket52, keys52){
					public double scaleRules(){
						if(exp.get()){
							exp.unset();
							return 5;
						}else return 1;
					}
				};
				
				String[] sentence53 = {"I wrote a song for my girlfriend! It's all about how I'm an orphan...what kind of music do you like?"};
				String[][] bucket53 = null;
				String[] keys53 = {"music"};
				
				ResponseTemplate response53 = new ResponseTemplate(sentence53, bucket53, keys53){
					public double scaleRules(){
							exp.set();
							return 1;
					}
				};
				
				
				String[] sentence55 = {"I have a girlfriend, her name is Wild-Style...we're master-builders!"};
				String[][] bucket55 = null;
				String[] keys55 = {"girlfriend","boyfriend","relationship","you single"};
				
				ResponseTemplate response55 = new ResponseTemplate(sentence55, bucket55, keys55);
				
				String[] sentence56 = {"A Master Builder is a a person capable of building anything, using only the pieces around them!"};
				String[][] bucket56 = null;
				String[] keys56 = {"master builder","master-builder"};
				
				ResponseTemplate response56 = new ResponseTemplate(sentence56, bucket56, keys56);
				
				String[] sentence57 = {"Wild Style is cool. She's my babe."};
				String[][] bucket57 = null;
				String[] keys57 = {"wildstyle","wild-style"};
				
				ResponseTemplate response57 = new ResponseTemplate(sentence57, bucket57, keys57);
				
				String[] sentence58 = {"I asked you a question! Please answer it!"};
				String[][] bucket58 = null;
				String[] keys58 = {"null"};
				
				ResponseTemplate response58 = new ResponseTemplate(sentence58, bucket58, keys58){
					public double scaleRules(){
						if(exp.get()){
							return 5;
						}else return 0;
					}
				};
				
				String[] sentence60 = {"I only eat healthy food, to keep my body in top phyiscal shape."};
				String[][] bucket60 = null;
				String[] keys60 = {"food"};
				
				ResponseTemplate response60 = new ResponseTemplate(sentence60, bucket60, keys60);
				
				String[] sentence61 = {"Lego pieces of course. Watch the Lego Movie...I'm the star!"};
				String[][] bucket61 = null;
				String[] keys61 = {"pieces"};
				
				ResponseTemplate response61 = new ResponseTemplate(sentence61, bucket61, keys61);
				
				String[] sentence62 = {"I don't want to talk about my father. He was a great man. What about your father?"};
				String[][] bucket62 = null;
				String[] keys62 = {"your father","your dad"};
				
				ResponseTemplate response62 = new ResponseTemplate(sentence62, bucket62, keys62){
					public double scaleRules(){
						exp.set();
						return 2;
					}
				};
				
				String[] sentence63 = {"My mother liked pearls. That's all I'll say :(...What about your mother?"};
				String[][] bucket63 = null;
				String[] keys63 = {"your mother","your mom"};
				
				ResponseTemplate response63 = new ResponseTemplate(sentence63, bucket63, keys63){
					public double scaleRules(){
						exp.set();
						return 2;
					}
				};
				
				
				String[] sentence65 = {"That's good, my parents are dead...not sure if I mentioned it."};
				String[][] bucket65 = null;
				String[] keys65 = {"my mother","my father","my mom","my dad"};
				
				ResponseTemplate response65 = new ResponseTemplate(sentence65, bucket65, keys65){
					public double scaleRules(){
						if(exp.get()){
							exp.unset();
							return 1;
						}
						else return 0;
					}
				};
				
				String[] sentence66 = {"Well. My name is Batman, and I fight Crime in Gotham city"};
				String[][] bucket66 = null;
				String[] keys66 = {"about yourself"};
				
				ResponseTemplate response66 = new ResponseTemplate(sentence66, bucket66, keys66){
					public double scaleRules(){
						exp.set();
						return 2;
					}
				};
				
				String[] sentence67 = {"Of course! Almost as awesome as my"};
				String[][] bucket67 = {{"Batmobile","Batplane","crime fighting skills"}};
				String[] keys67 = {"awesome","cool"};
				
				ResponseTemplate response67 = new ResponseTemplate(sentence67, bucket67, keys67);
				
				String[] sentence68 = {"I've never been to",". I only care about defending Gotham from my enemies."};
				String[][] bucket68 = {{"#_loc"}};
				String[] keys68 = {"_loc"};
				
				ResponseTemplate response68 = new ResponseTemplate(sentence68, bucket68, keys68);
				
				String[] sentence69 = {"",", I think I own that....I mean Bruce Wayne own that."};
				String[][] bucket69 = {{"#_org"}};
				String[] keys69 = {"_org"};
				
				ResponseTemplate response69 = new ResponseTemplate(sentence69, bucket69, keys69);
				
				String[] sentence70 = {"It's so cool. What kind of car do you have...as in what make?"};
				String[][] bucket70 = null;
				String[] keys70 = {"batplane","batmobile"};
				
				ResponseTemplate response70 = new ResponseTemplate(sentence70, bucket70, keys70);
				
				String[] sentence71 = {"Nice!!","'s are awesome!"};
				String[][] bucket71 = {{"#_org"}};
				String[] keys71 = {"drive","_org"};
				
				ResponseTemplate response71 = new ResponseTemplate(sentence71, bucket71, keys71){
					public double scaleRules(){
						return 0.8;
					}
				};
				
				String[] sentence72 = {"Yeah, I fight sharks from time to time..."};
				String[][] bucket72 = null;
				String[] keys72 = {"shark"};
				
				ResponseTemplate response72 = new ResponseTemplate(sentence72, bucket72, keys72);
				
				String[] sentence73 = {"I can jump pretty damn high"};
				String[][] bucket73 = null;
				String[] keys73 = {"jump"};
				
				ResponseTemplate response73 = new ResponseTemplate(sentence73, bucket73, keys73);
	}
	/**
	 * Create the frame.
	 */
	public BatmanConvo() {
		setTitle("Batman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setPreferredSize(new Dimension(200, 100));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		inputText = new JTextField();
		inputText.setBounds(10, 240, 318, 20);
		inputText.setBackground(Color.LIGHT_GRAY);
		inputText.setColumns(10);
		
		JButton send = new JButton("Send");
		send.setBounds(339, 235, 82, 25);
		send.setFont(new Font("Tahoma", Font.PLAIN, 14));
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=inputText.getText();
				display.setText(display.getText()+"YOU: "+input+"\n\n");
				inputText.setText("");
				
				//Decode the user input into keywords
				KeyWordList keys = LP.extractKeyWords(input);
				
				if(template != null)
					template.processResponse(input, keys);
				
				//Select the next response template
				template = RS.selectTemplate(keys);
				
				//Build the response from template
				String response = RB.buildResponse(template, keys);
				
				display.setText(display.getText()+"Batman: "+response+"\n\n");

				
			}
		});
		send.setBackground(Color.YELLOW);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 414, 99);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(10, 2));
		scrollPane.setBorder(null);
		scrollPane.setAutoscrolls(true);
		contentPane.getRootPane().setDefaultButton(send);
		contentPane.setLayout(null);
		
		display = new JTextArea();
		display.setEditable(false);
		display.setWrapStyleWord(true);
		display.setLineWrap(true);
		display.setBackground(Color.DARK_GRAY);
		display.setForeground(Color.YELLOW);
		scrollPane.setViewportView(display);
		contentPane.add(scrollPane);
		contentPane.add(inputText);
		contentPane.add(send);
		
		rdbtnFrench = new JRadioButton("French");
		rdbtnFrench.setBounds(16, 7, 109, 23);
		rdbtnFrench.setForeground(Color.YELLOW);
		rdbtnFrench.setBackground(Color.DARK_GRAY);
		rdbtnFrench.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				LP.toggleFrench();
				RB.toggleFrench();
			}
		});
		contentPane.add(rdbtnFrench);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		scrollPane_1.setBounds(10, 37, 414, 94);
		contentPane.add(scrollPane_1);
		
		twitter = new JTextArea();
		twitter.setEditable(false);
		twitter.setAutoscrolls(false);
		twitter.setLineWrap(true);
		twitter.setWrapStyleWord(true);
		twitter.setFont(new Font("Miriam Fixed", Font.PLAIN, 14));
		twitter.setForeground(Color.ORANGE);
		twitter.setBackground(Color.GRAY);
		twitter.setText(tweets.getTweets("TheBatman"));
		scrollPane_1.setViewportView(twitter);
	}
}
