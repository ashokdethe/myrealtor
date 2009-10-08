
package com.myrealtor.domain;

import java.util.ArrayList;
import java.util.List;

import com.myrealtor.BasicTest;


public class SecurityQuestionTest {

	
	public static List<SecurityQuestion> insertDefault() {
		List<SecurityQuestion> list = new ArrayList<SecurityQuestion>();
		list.add(new SecurityQuestion("What's the name of your first pet?"));
		list.add(new SecurityQuestion("What's your mother maiden name?"));		
		list.add(new SecurityQuestion("Which city did you get your first job?"));
		list.add(new SecurityQuestion("Which city was your father born?"));
		list.add(new SecurityQuestion("Which city were you born?"));
		list.add(new SecurityQuestion("What's the name of your first teacher?"));		
		BasicTest.insert(list);		
		return list;
	}

}
