package com.bridjit.learning.learning.sof.q1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum DataEntryLogger {
	USER_CLASS{
		@Override
		List<DataEntry> log(Object o,String methodName) {
			List<DataEntry> userDataEntries = new ArrayList<DataEntry>();
			if( o instanceof User) {
				User toLog = (User) o;
				Optional<Method> oInvokedMethod = Arrays.asList(toLog.getClass().getMethods()).stream().filter((m) -> m.getName().equals(methodName)).findFirst();
				oInvokedMethod.ifPresent((invokedMethod)-> {
					for(Parameter p : invokedMethod.getParameters()) {
						System.out.println(p.getName());
						try {
							Field f = o.getClass().getDeclaredField(p.getName());
							f.setAccessible(true);
							userDataEntries.add(new DataEntry(p.getName(), Arrays.asList(""+f.get(o))));
						System.out.println(f.get(o));
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			return userDataEntries;
		}
	},
	GENERIC{
		@Override
		List<DataEntry> log(Object o,String methodName) {
			List<DataEntry> dataEntries = new ArrayList<DataEntry>();
			
				Optional<Method> oInvokedMethod = Arrays.asList(o.getClass().getMethods()).stream().filter((m) -> m.getName().equals(methodName)).findFirst();
				oInvokedMethod.ifPresent((invokedMethod)-> {
					for(Parameter p : invokedMethod.getParameters()) {
						System.out.println(p.getName());
						try {
							Field f = o.getClass().getDeclaredField(p.getName());
							f.setAccessible(true);
							dataEntries.add(new DataEntry(p.getName(), Arrays.asList(""+f.get(o))));
						System.out.println(f.get(o));
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			
			return dataEntries;
		}
	};
	
	abstract List<DataEntry> log(Object o,String methodName);
	
}
