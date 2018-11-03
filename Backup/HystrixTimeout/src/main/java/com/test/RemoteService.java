package com.test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class RemoteService<T> {
	public RemoteService(){		
	}
	
	private T result = null;
	private boolean apiTimedout = false;
	
	public T getResult() {
		return result;
	}
	
	public boolean getApiTimedout() {
		return apiTimedout;
	}
	
	public void remoteServiceStart(int millis, String groupName) {
		HystrixCommand.Setter config = HystrixCommand.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupName));
		HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
		commandProperties.withExecutionTimeoutInMilliseconds(millis);
		config.andCommandPropertiesDefaults(commandProperties);
		RemoteServiceCommand remoteServiceCommand = new RemoteServiceCommand(config);

		try {
			result = remoteServiceCommand.execute();
			apiTimedout = false;
		} catch (Exception e) {
			result = null;
			apiTimedout = true;
		}
	}
	
	class RemoteServiceCommand extends HystrixCommand<T> {
		public RemoteServiceCommand(Setter config) {
			super(config);
		}

		@SuppressWarnings("unchecked")
		@Override
		protected T run() {
			return (T) new RemoteAPI().someAPI();
		}
	}	
}
