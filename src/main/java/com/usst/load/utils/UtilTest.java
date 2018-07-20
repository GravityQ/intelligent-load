package com.usst.load.utils;



import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * @author junlin.qi on 2018/7/19
 */
public class UtilTest {
	public static void main(String[] args) {
		List<String> names = Lists.newArrayList("John", null, "Jane", null, "Adam", "Tom");
		Collection<String> collection = Collections2.filter(names, Predicates.notNull());
		System.out.println(Arrays.toString(collection.toArray()));
	}
}
