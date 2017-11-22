package com.mobileread.ixtab.kindlelauncher.timer;

import com.mobileread.ixtab.kindlelauncher.timer.TimerAdapter;

public class KTimerAdapter extends TimerAdapter {

	public Object newTimer() {
		return new com.amazon.kindle.kindlet.util.Timer();
	}

	public Object newTimerTask(final Runnable runnable) {
		return new com.amazon.kindle.kindlet.util.TimerTask() {
			public void run() {
				runnable.run();
			}
		};
	}

	public void schedule(Object timerObject, Object timerTaskObject, long delay, long period) {
		com.amazon.kindle.kindlet.util.Timer timer = (com.amazon.kindle.kindlet.util.Timer) timerObject;
		com.amazon.kindle.kindlet.util.TimerTask timerTask = (com.amazon.kindle.kindlet.util.TimerTask) timerTaskObject;
		timer.schedule(timerTask, delay, period);
	}

	public void cancel(Object timerObject) {
		com.amazon.kindle.kindlet.util.Timer timer = (com.amazon.kindle.kindlet.util.Timer) timerObject;
		timer.cancel();
	}
}
