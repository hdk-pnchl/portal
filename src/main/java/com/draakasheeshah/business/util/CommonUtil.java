package com.draakasheeshah.business.util;

import java.util.concurrent.atomic.AtomicReference;

public class CommonUtil {
	protected static AtomicReference<Long> currentTime = new AtomicReference<>(System.currentTimeMillis());

	/**
	 * will fetch unique long value based on current time. to avoid duplicates,
	 * AtomicReference is used which provides volatile behaviour for counter.
	 */
	public static Long nextRegNo() {
		Long prev;
		Long next = System.currentTimeMillis();
		do {
			prev = currentTime.get();
			/*
			 * we need this, as its likely program executes so fast that, prev
			 * and next both might have the same value.
			 */
			next = next > prev ? next : prev + 1;
		}
		/*
		 * each time we fetch 1 new ID, we update its value in currentTime. And
		 * we take reference of it to make sure, we are threadsafe.
		 * 
		 * compareAndSet will provide a check against stale values. i.e. while
		 * updating currentTime's values, if existing copied value of
		 * currentTime isnt same as the current value of currentTime, some other
		 * thread already have taken the nextID.
		 */
		while (!currentTime.compareAndSet(prev, next));
		return next;
	}
}
