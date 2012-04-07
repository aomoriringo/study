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
		
		// レイアウトマネージャを使って4*2のグリッドを作る
		setLayout(new GridLayout(4,2));
		
		// Colleagueたちの生成
		createColleagues();
		
		// 配置
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOK);
		add(buttonCancel);
		
		// 有効/無効の初期指定
		colleagueChanged();
		
		// 表示
		pack();
		show();
	}
	
	@Override
	public void createColleagues() {
		// 生成
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckBox("Guest", g, true);
		checkLogin = new ColleagueCheckBox("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOK = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		// Mediatorのセット
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOK.setMediator(this);
		buttonCancel.setMediator(this);
		
		// Listenerのセット
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// Colleagueからの通知で各Colleagueの有効/無効を判定する
	@Override
	public void colleagueChanged() {
		// Guestモード
		if (checkGuest.getState()){
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOK.setColleagueEnabled(true);
		}
		// Loginモード
		else{
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}

	}

	// textUserまたはtextPassの変更があった
	// 各Colleagueの有効/無効を判定する
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
