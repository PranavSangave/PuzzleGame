import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;


class Puzzle extends Frame implements ActionListener
{
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, ac;
	ArrayList<Integer> list;

	public Puzzle()
	{
		super("Puzzle");
		setLayout(new GridLayout(4,3));

		b1 = new Button();
		b2 = new Button();
		b3 = new Button();
		b4 = new Button();
		b5 = new Button();
		b6 = new Button();
		b7 = new Button();
		b8 = new Button();
		b9 = new Button();
		ac = new Button("Auto");


		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		ac.addActionListener(this);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(ac);

		int[][] arr = new int[3][3];
		list = new ArrayList<Integer>();


		for(int i=1; i<9; i++)
		{
			list.add(i);
		}

		Collections.shuffle(list);


		// Single array
		int[] a = new int[8];

		for(int i=0; i<8; i++)
		{
			a[i] = list.get(i);
		}

		// Cheking that the puzzle is solvable or not
		while((isSolvable(a)))
		{
			Collections.shuffle(list);
			for(int i=0; i<8; i++)
			{
				a[i] = list.get(i);
			}
		}


		Font f = new Font("Arial",Font.BOLD,20);

		b1.setLabel(""+list.get(0));
		b2.setLabel(""+list.get(1));
		b3.setLabel(""+list.get(2));
		b4.setLabel(""+list.get(3));
		b5.setLabel(""+list.get(4));
		b6.setLabel(""+list.get(5));
		b7.setLabel(""+list.get(6));
		b8.setLabel(""+list.get(7));


		b1.setFont(f);
		b2.setFont(f);
		b3.setFont(f);
		b4.setFont(f);
		b5.setFont(f);
		b6.setFont(f);
		b7.setFont(f);
		b8.setFont(f);
		b9.setFont(f);
		ac.setFont(f);

		Color g = new Color(250,200,36);
		Color bB = new Color(132,129,129);

		b1.setBackground(g);
		b2.setBackground(g);
		b3.setBackground(g);
		b4.setBackground(g);
		b5.setBackground(g);
		b6.setBackground(g);
		b7.setBackground(g);
		b8.setBackground(g);
		b9.setBackground(bB);

	}

	public boolean isSolvable(int[] ar)
	{
		int inv_cont = 0;
		for(int i=0; i<8; i++)
		{
			int inv = 0;
			for(int j=i+1; j<8; j++)
			{
				if(ar[i] > ar[j])
				{
					inv++;
				}
				inv_cont = inv_cont + inv;
			}
		}

		if(inv_cont % 2 == 0)
		{
			return true;
		}
		return false;
	}


	public boolean isWin()
	{
		if
		(
			b1.getLabel().equals("1") &&
			b2.getLabel().equals("2") &&
			b3.getLabel().equals("3") &&
			b4.getLabel().equals("4") &&
			b5.getLabel().equals("5") &&
			b6.getLabel().equals("6") &&
			b7.getLabel().equals("7") &&
			b8.getLabel().equals("8")
		)
		{
			WinFrame w1 = new WinFrame("Congratulations !!!");
			w1.setSize(500,150);
			w1.setVisible(true);
			return true;
		}
		else
		{
			return false;
		}
	}

	//Functions to move numbers
	public void moveOne()
	{
		if(b2.getLabel().equals(""))
		{
			setColor(b2,b1);
			b2.setLabel(b1.getLabel());
			b1.setLabel("");
		}
		else if(b4.getLabel().equals(""))
		{
			setColor(b4,b1);
			b4.setLabel(b1.getLabel());
			b1.setLabel("");
		}
	}
	public void moveTwo()
	{
		if(b1.getLabel().equals(""))
		{
			setColor(b1,b2);
			b1.setLabel(b2.getLabel());
			b2.setLabel("");
		}
		else if(b3.getLabel().equals(""))
		{
			setColor(b3,b2);
			b3.setLabel(b2.getLabel());
			b2.setLabel("");
		}
		else if(b5.getLabel().equals(""))
		{
			setColor(b5,b2);
			b5.setLabel(b2.getLabel());
			b2.setLabel("");
		}
	}
	public void moveThree()
	{
		if(b2.getLabel().equals(""))
		{
			setColor(b2,b3);
			b2.setLabel(b3.getLabel());
			b3.setLabel("");
		}
		else if(b6.getLabel().equals(""))
		{
			setColor(b6,b3);
			b6.setLabel(b3.getLabel());
			b3.setLabel("");
		}
	}
	public void moveFour()
	{
		if(b1.getLabel().equals(""))
		{
			setColor(b1,b4);
			b1.setLabel(b4.getLabel());
			b4.setLabel("");
		}
		else if(b5.getLabel().equals(""))
		{
			setColor(b5,b4);
			b5.setLabel(b4.getLabel());
			b4.setLabel("");
		}
		else if(b7.getLabel().equals(""))
		{
			setColor(b7,b4);
			b7.setLabel(b4.getLabel());
			b4.setLabel("");
		}
	}
	public void moveFive()
	{
		if(b2.getLabel().equals(""))
		{
			setColor(b2,b5);
			b2.setLabel(b5.getLabel());
			b5.setLabel("");
		}
		else if(b6.getLabel().equals(""))
		{
			setColor(b6,b5);
			b6.setLabel(b5.getLabel());
			b5.setLabel("");
		}
		else if(b8.getLabel().equals(""))
		{
			setColor(b8,b5);
			b8.setLabel(b5.getLabel());
			b5.setLabel("");
		}
		else if(b4.getLabel().equals(""))
		{
			setColor(b4,b5);
			b4.setLabel(b5.getLabel());
			b5.setLabel("");
		}
	}
	public void moveSix()
	{
		if(b3.getLabel().equals(""))
		{
			setColor(b3,b6);
			b3.setLabel(b6.getLabel());
			b6.setLabel("");
		}
		else if(b5.getLabel().equals(""))
		{
			setColor(b5,b6);
			b5.setLabel(b6.getLabel());
			b6.setLabel("");
		}
		else if(b9.getLabel().equals(""))
		{
			setColor(b9,b6);
			b9.setLabel(b6.getLabel());
			b6.setLabel("");
		}
	}
	public void moveSeven()
	{
		if(b4.getLabel().equals(""))
		{
			setColor(b4,b7);
			b4.setLabel(b7.getLabel());
			b7.setLabel("");
		}
		else if(b8.getLabel().equals(""))
		{
			setColor(b8,b7);
			b8.setLabel(b7.getLabel());
			b7.setLabel("");
		}
	}
	public void moveEight()
	{
		if(b7.getLabel().equals(""))
		{
			setColor(b7,b8);
			b7.setLabel(b8.getLabel());
			b8.setLabel("");
		}
		else if(b5.getLabel().equals(""))
		{
			setColor(b5,b8);
			b5.setLabel(b8.getLabel());
			b8.setLabel("");
		}
		else if(b9.getLabel().equals(""))
		{
			setColor(b9,b8);
			b9.setLabel(b8.getLabel());
			b8.setLabel("");
		}
	}
	public void moveNine()
	{
		if(b6.getLabel().equals(""))
		{
			setColor(b6,b9);
			b6.setLabel(b9.getLabel());
			b9.setLabel("");
		}
		else if(b8.getLabel().equals(""))
		{
			setColor(b8,b9);
			b8.setLabel(b9.getLabel());
			b9.setLabel("");
		}
	}

	// Positioning Functions
	public void fixOne()
	{
		// Positioning 1
		// When 1 is on 8th button and we have to shift it on do this...
		if(b8.getLabel().equals("1"))
		{
			// Shifting 8th place to 1st place (Empty Block Out - btn4) 6 5 8 7 4 5 2 1 4 5 2
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 1
		// When 1 is on 7th button and we have to shift it on do this... (Empty Block Out - btn2)
		if(b7.getLabel().equals("1"))
		{
			// Shifting 7th place to 1st place  8 5 2 1 4 7 8 5 2 1 4 5 2
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 1
		// When 1 is on 4th button and we have to shift it on do this... (Empty Block Out - btn2)
		if(b4.getLabel().equals("1"))
		{
			// Shifting 8th place to 1st place 6 3 2 1 4 5 2
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 1
		// When 1 is on 5th button and we have to shift it on do this... (Empty Block Out - btn2)
		if(b5.getLabel().equals("1"))
		{
			// 6 3 2 5 4 1 2
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 1
		// When 1 is on 6th button and we have to shift it on do this... (Empty Block Out - btn2)
		if(b6.getLabel().equals("1"))
		{
			// 8 7 4 5 6 3 2 5 4 1 2
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 1
		// When 1 is on 3rd button and we have to shift it on do this... (Empty Block Out - btn2)
		if(b3.getLabel().equals("1"))
		{
			// 6 5 2 3 6 5 4 1 2
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 1
		// When 1 is on 2nd button and we have to shift it on do this... (Empty Block Out - btn2)
		if(b2.getLabel().equals("1"))
		{
			// 8 7 4 1 2
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 1
		// When 1 is on 2nd button and we have to shift it on do this... (Empty Block Out - btn2)
		if(b1.getLabel().equals("1"))
		{
			// 8 5 2
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
	}

	public void fixThree()
	{
		// Positioning 3
		// When 3 is on 9th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b9.getLabel().equals("3"))
		{
			// 5 6 9 8 5 6 3 2 5
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 3
		// When 3 is on 8th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b8.getLabel().equals("3"))
		{
			// 5 8 9 6 3 2 5
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 3
		// When 3 is on 7th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b7.getLabel().equals("3"))
		{
			// 5 4 7 8 5 4 7 8 9 6 3 2 5
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 3
		// When 3 is on 4th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b4.getLabel().equals("3"))
		{
			// 5 4 7 8 9 6 3 2 5
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 3
		// When 3 is on 5th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b5.getLabel().equals("3"))
		{
			// 5
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 3
		// When 3 is on 6th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b6.getLabel().equals("3"))
		{
			// 5 6 3 2 5
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

		// Positioning 3
		// When 3 is on 3th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b3.getLabel().equals("3"))
		{
			// 3 6 5
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

	}

	public void fixTwoEx()
	{
		// Positioning 2 and 3 when 1 3 2 occurs
		// (Empty Block Out - btn5)
		if(b3.getLabel().equals("2"))
		{
			// 4 1 2 3 6 5 2 1 4 7  8 9 6 3 2 5
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveOne();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
	}

	public void fixTwoNormal()
	{
		// Positioning 2
		// When 2 is on 4th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b4.getLabel().equals("2"))
		{
			// 4 7 8 9 6 3 2 5
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b6.getLabel().equals("2"))
		{
			// 6 3 2 5
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b7.getLabel().equals("2"))
		{
			// 4 7 8 5 4 7 8 9 6 3 2 5
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b9.getLabel().equals("2"))
		{
			// 6 9 8 5 6 3 2 5
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b8.getLabel().equals("2"))
		{
			// 8 9 6 3 2 5
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveThree();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveTwo();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
	}

	public void fixSeven()
	{
		// Positioning 7
		// When 7 is on 6th button and we have to shift it on do this... (Empty Block Out - btn5)
		if(b6.getLabel().equals("7"))
		{
			//6 9 8 7 4 5
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b9.getLabel().equals("7"))
		{
			//4 7 8 9 6 5 8 7 4 5
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b8.getLabel().equals("7"))
		{
			//8 7 4 5
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b7.getLabel().equals("7"))
		{
			//4 7 8 5
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
	}

	public void fixFour()
	{
		// Positioning 4
		// When 4 is on 6th button and we have to shift it on do this... (Blank - btn6)
		if(b6.getLabel().equals("4"))
		{
			//6
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b9.getLabel().equals("4"))
		{
			//6 9 8 5 6
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b8.getLabel().equals("4"))
		{
			//8 9 6
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
	}

	public void fixFourEx()
	{
		if(b7.getLabel().equals("4"))
		{
			//8 7 4 5 8 9 6 5 4 7 8 5 6
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
	}

	public void fixSevenFour()
	{
			// 9 8 7 4 5
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSeven();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFour();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
	}

	public boolean checkEx()
	{
		if(b6.getLabel().equals("8") && b9.getLabel().equals("5") &&  b8.getLabel().equals("6"))
		{
			return true;
		}
		if(b6.getLabel().equals("5") && b9.getLabel().equals("6") &&  b8.getLabel().equals("8"))
		{
			return true;
		}
		if(b6.getLabel().equals("6") && b9.getLabel().equals("8") &&  b8.getLabel().equals("5"))
		{
			return true;
		}
		return false;
	}

	public void fixFiveSixEight()
	{
		if(b6.getLabel().equals("5"))
		{
			// 6 9
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b8.getLabel().equals("5"))
		{
			// 8 9
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}
		else if(b9.getLabel().equals("5"))
		{
			// 8 9 6 5 8 9
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveSix();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveFive();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveEight();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
			moveNine();
			try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
		}

	}

	// Method to set colors
	public void setColor(Button bG, Button bB)
	{
		bB.setBackground(new Color(132,129,129));
		bG.setBackground(new Color(250,200,36));
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();

		if(ob == b1)
		{
			if(b2.getLabel().equals(""))
			{
				setColor(b2,b1);
				b2.setLabel(b1.getLabel());
				b1.setLabel("");
			}
			else if(b4.getLabel().equals(""))
			{
				setColor(b4,b1);
				b4.setLabel(b1.getLabel());
				b1.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == b2)
		{
			if(b1.getLabel().equals(""))
			{
				setColor(b1,b2);
				b1.setLabel(b2.getLabel());
				b2.setLabel("");
			}
			else if(b3.getLabel().equals(""))
			{
				setColor(b3,b2);
				b3.setLabel(b2.getLabel());
				b2.setLabel("");
			}
			else if(b5.getLabel().equals(""))
			{
				setColor(b5,b2);
				b5.setLabel(b2.getLabel());
				b2.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == b3)
		{
			if(b2.getLabel().equals(""))
			{
				setColor(b2,b3);
				b2.setLabel(b3.getLabel());
				b3.setLabel("");
			}
			else if(b6.getLabel().equals(""))
			{
				setColor(b6,b3);
				b6.setLabel(b3.getLabel());
				b3.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == b4)
		{
			if(b1.getLabel().equals(""))
			{
				setColor(b1,b4);
				b1.setLabel(b4.getLabel());
				b4.setLabel("");
			}
			else if(b5.getLabel().equals(""))
			{
				setColor(b5,b4);
				b5.setLabel(b4.getLabel());
				b4.setLabel("");
			}
			else if(b7.getLabel().equals(""))
			{
				setColor(b7,b4);
				b7.setLabel(b4.getLabel());
				b4.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == b5)
		{
			if(b2.getLabel().equals(""))
			{
				setColor(b2,b5);
				b2.setLabel(b5.getLabel());
				b5.setLabel("");
			}
			else if(b6.getLabel().equals(""))
			{
				setColor(b6,b5);
				b6.setLabel(b5.getLabel());
				b5.setLabel("");
			}
			else if(b8.getLabel().equals(""))
			{
				setColor(b8,b5);
				b8.setLabel(b5.getLabel());
				b5.setLabel("");
			}
			else if(b4.getLabel().equals(""))
			{
				setColor(b4,b5);
				b4.setLabel(b5.getLabel());
				b5.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == b6)
		{
			if(b3.getLabel().equals(""))
			{
				setColor(b3,b6);
				b3.setLabel(b6.getLabel());
				b6.setLabel("");
			}
			else if(b5.getLabel().equals(""))
			{
				setColor(b5,b6);
				b5.setLabel(b6.getLabel());
				b6.setLabel("");
			}
			else if(b9.getLabel().equals(""))
			{
				setColor(b9,b6);
				b9.setLabel(b6.getLabel());
				b6.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == b7)
		{
			if(b4.getLabel().equals(""))
			{
				setColor(b4,b7);
				b4.setLabel(b7.getLabel());
				b7.setLabel("");
			}
			else if(b8.getLabel().equals(""))
			{
				setColor(b8,b7);
				b8.setLabel(b7.getLabel());
				b7.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == b8)
		{
			if(b7.getLabel().equals(""))
			{
				setColor(b7,b8);
				b7.setLabel(b8.getLabel());
				b8.setLabel("");
			}
			else if(b5.getLabel().equals(""))
			{
				setColor(b5,b8);
				b5.setLabel(b8.getLabel());
				b8.setLabel("");
			}
			else if(b9.getLabel().equals(""))
			{
				setColor(b9,b8);
				b9.setLabel(b8.getLabel());
				b8.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == b9)
		{
			if(b6.getLabel().equals(""))
			{
				setColor(b6,b9);
				b6.setLabel(b9.getLabel());
				b9.setLabel("");
			}
			else if(b8.getLabel().equals(""))
			{
				setColor(b8,b9);
				b8.setLabel(b9.getLabel());
				b9.setLabel("");
			}
			if(isWin())
			{
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				return;
			}
		}
		else if(ob == ac)
		{
			fixOne();
			fixThree();

			if(b3.getLabel().equals("2"))
			{
				fixTwoEx();
			}
			else
			{
				fixTwoNormal();
			}
			fixSeven();
			if(b7.getLabel().equals("4"))
			{
				fixFourEx();
			}
			else
			{
				fixFour();
			}

			fixSevenFour();

			if(checkEx())
			{
				fixFiveSixEight();
				Color g = new Color(36,250,100);
				b1.setBackground(g);
				b2.setBackground(g);
				b3.setBackground(g);
				b4.setBackground(g);
				b5.setBackground(g);
				b6.setBackground(g);
				b7.setBackground(g);
				b8.setBackground(g);
				b9.setBackground(g);
				WinFrame w1 = new WinFrame("Congratulations !!!");
				w1.setSize(500,150);
				w1.setVisible(true);
			}
			else
			{
				WinFrame w1 = new WinFrame("Better Luck Next Time !!!");
				w1.setSize(500,150);
				w1.setVisible(true);
			}

		}
	}

	public static void main(String ar[])
	{
		Puzzle p1 = new Puzzle();
		p1.setSize(400,400);
		p1.setVisible(true);
	}
}

class WinFrame extends Frame
{
	Label l1;
	public WinFrame(String s)
	{
		super("Congratulations...");
		setLayout(new FlowLayout());
		this.setBackground(new Color(132,129,129));
		l1 = new Label(s);
		l1.setFont(new Font("TimeRoman",Font.BOLD,24));
		l1.setForeground(new Color(255,255,255));
		add(l1);
	}
}