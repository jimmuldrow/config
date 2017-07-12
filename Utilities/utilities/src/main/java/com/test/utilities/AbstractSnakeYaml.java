package com.test.utilities;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import com.test.utilities.IOUtils;

@Component
public abstract class AbstractSnakeYaml {
	public IOUtils ioUtils = new IOUtils();
	public Yaml yaml = new Yaml();

	/*
	@SuppressWarnings("unchecked")
	public void exampleDemo(){
		
		Map<String, Map<String, List<List>>> values = (Map<String, Map<String, List<List>>>) yaml
				.load(ioUtils.getFileDataFromResources("message.yml"));		
		Map<String, List<List>> map1 = values.get("all_keys");
		List<List> list1 = map1.get("twobytwotable");
		List list2 = list1.get(2);	
		System.out.println("******** values = " + values);
		System.out.println("******** list2 = " + list2);
	}
	
	The above demo works with the message.yml file as follows:
	
all_keys:
  twobytwotable:   [ ['a1', 'a2'], 
  ['b1', 'b2'], 
  ['c1', 'c2'],   
  ['d1', 'd2'] ]	
	 */
}
