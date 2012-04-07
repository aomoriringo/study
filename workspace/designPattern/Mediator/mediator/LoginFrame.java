package mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {

	private ColleagueCheckBox checkGuest;
	private ColleagueCheckBox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOK;
	private ColleagueButton buttonCancel;
	
	
	public LoginFrame(String title){
		super(title);
		setBackground(Color.lightGray);
		
		// ���C�A�E�g�}�l�[�W�����g����4*2�̃O���b�h�����
		setLayout(new GridLayout(4,2));
		
		// Colleague�����̐���
		createColleagues();
		
		// �z�u
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOK);
		add(buttonCancel);
		
		// �L��/�����̏����w��
		colleagueChanged();
		
		// �\��
		pack();
		show();
	}
	
	@Override
	public void createColleagues() {
		// ����
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckBox("Guest", g, true);
		checkLogin = new ColleagueCheckBox("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOK = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		// Mediator�̃Z�b�g
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOK.setMediator(this);
		buttonCancel.setMediator(this);
		
		// Listener�̃Z�b�g
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// Colleague����̒ʒm�ŊeColleague�̗L��/�����𔻒肷��
	@Override
	public void colleagueChanged() {
		// Guest���[�h
		if (checkGuest.getState()){
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOK.setColleagueEnabled(true);
		}
		// Login���[�h
		else{
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}

	}

	// textUser�܂���textPass�̕ύX��������
	// �eColleague�̗L��/�����𔻒肷��
	private void userpassChanged(){
		if(textUser.getText().length() > 0){
			textPass.setColleagueEnabled(true);
			buttonOK.setColleagueEnabled( (textPass.getText().length() > 0));
		}
		else{
			textPass.setColleagueEnabled(false);
			buttonOK.setColleagueEnabled(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
	}

}
