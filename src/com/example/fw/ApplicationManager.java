package com.example.fw;

import java.util.Properties;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;

public class ApplicationManager {
	
	private static ApplicationManager singleton;
	
	private Properties props;

	private FolderHelper folderHelper;

	private JFrameOperator mainFrame;

	private MenuHelper MenuHelper;
	
	public static ApplicationManager getInstance() {
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}
		
	public void stop() {
		getApplication().requestClose();
	}
	
	public void setProperties(Properties properties) {
		this.props = properties;
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
		
	}

	public FolderHelper getFolderHelper() {
		if (folderHelper == null) {
			folderHelper = new FolderHelper(this);
		}
		return folderHelper;
	}

	public JFrameOperator getApplication() {
		if (mainFrame == null) {
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				mainFrame = new JFrameOperator("jAddressBook");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mainFrame;
	}

	public MenuHelper getMenuHelper() {
		if (MenuHelper == null) {
			MenuHelper = new MenuHelper(this);
		}
		return MenuHelper;
	}
	
}
