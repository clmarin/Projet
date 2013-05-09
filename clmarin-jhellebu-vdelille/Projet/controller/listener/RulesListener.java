package controller.listener;

import java.awt.event.*;

import view.*;

public class RulesListener implements ActionListener {
	
	private Interface inter;
	
	public RulesListener(Interface inter) {
		this.inter = inter;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		inter.changePanel("MENU");
	}

}