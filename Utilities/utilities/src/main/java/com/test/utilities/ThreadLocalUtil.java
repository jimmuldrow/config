package com.test.utilities;

import org.springframework.stereotype.Component;

@Component
public class ThreadLocalUtil<T> {
	private ThreadLocal<T> threadLocal = new ThreadLocal<T>();
	
	public T getThreadLocal(){return threadLocal.get();}
	
	public void setThreadLocal(T t){threadLocal.set(t);}
	
	public void removeThreadLocal(){threadLocal.remove();}
}
