package com.netease.apache.common;

import java.util.HashSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Sets;

public class UtilsTest {
	public static void testCommonUtil(){
		Entity entity1 = new Entity("zhou",false, 30, "beijing");
		Entity entity2 = new Entity("zhou",false, 30, "beijing");
		System.out.println(entity1.hashCode() == entity2.hashCode());
		System.out.println(entity1.equals(entity2));
		System.out.println(entity1.toString());
		System.out.println(entity2.toString());
		HashSet<Entity> entities = Sets.newHashSet(entity1,entity2);
		System.out.println(entities.size());
		final String str = "zhoushao%sjun";
		System.out.println(str.format(str, "bei"));
		System.out.println(String.format(str, "BEIJING"));
	}
	
	public static void main(String[] args) {
		testCommonUtil();
		
		
	}
}
class Entity{
	
	private String   name;
	private boolean  sick;
	private int      age;
	private String   address;
	public Entity(String nameOutter, boolean sickOutter, int ageOutter, String addressOutter) {
		
		this.name = nameOutter;
		this.sick = sickOutter;
		this.age = ageOutter;
		this.address = addressOutter;
	}

	public Entity() {
	}
	
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,obj);
	}
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSick() {
		return sick;
	}
	public void setSick(boolean sick) {
		this.sick = sick;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}