package com.mobileread.ixtab.kindlelauncher;

import java.io.IOException;

import com.amazon.kindle.booklet.AbstractBooklet;

public class KualBooklet extends AbstractBooklet {
	
	public KualBooklet() {
		
			
			try {
				String[] cmd = new String[] {"/bin/sh", "/mnt/us/extensions/kterm/bin/kterm.sh"};
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				String[] cmd = new String[] {"/usr/bin/lipc-set-prop", "com.lab126.appmgrd", "stop", "app://com.mobileread.ixtab.kindlelauncher"};
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	
}
