package GoogleGuava;

import java.util.ArrayList;
import java.util.List;


import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class GuavaTest {
	 private static List<String> storeRoles = ImmutableList.of("AOrPa279");
	@SuppressWarnings("deprecation")
	public static void test()  throws  Exception{
		
		//[1]
		Objects.toStringHelper(GuavaTest.class);
		Objects.equal("a", "a");
		//[2]
		//Throwables.getStackTraceAsString(null);

		//[3]
		ArrayList<String> listFirst = new ArrayList<String>();
		ArrayList<String> listSecond = new ArrayList<String>();
		listFirst.add("a");
		listSecond.add("b");
		Iterable< String> rStrings = Iterables.concat(listFirst,listSecond);

		//[4]
		//String string = Preconditions.checkNotNull(null, "must not null");
		//Preconditions.checkArgument(listFirst.size()>2,"must > 2");
		
		//[5]
		java.util.List<String> conList = Constraints.constrainedList(new ArrayList<String>(), new Constraint<String>() {

			@Override
			public String checkElement(String paramE) {
				Preconditions.checkArgument(2>0,"zhousahojun");
				return paramE;
			}
			
		});
		conList.add("d");
		
		//[6]
		ArrayList<Entity> imumuList = new ArrayList<Entity>();
		imumuList.add(new Entity("zhou"));
		List<String> googleImmu = ImmutableList.of("ad");
		List<String> optionIds = ImmutableList.copyOf(new String[]{"a","b"});
		List<Entity> optionIds5 = ImmutableList.copyOf(imumuList);
		Entity entity = optionIds5.iterator().next();
		System.out.println(entity.name);
		entity.name ="lengjing";
		System.out.println(optionIds5.iterator().next().name);
		
		//[7]
		Lists.newArrayList();
		Lists.newLinkedList();
		Sets.newHashSet();
		Sets.newTreeSet();
		Maps.newHashMap();
		Maps.newLinkedHashMap();
		Maps.newTreeMap();
		Maps.newConcurrentMap();
		
		
	}
	public static void main(String[] args) {
		try {
			test();	
			GuavaTest test = new GuavaTest();
			GuavaTest test1 = new GuavaTest();
			System.out.println(test.getClass());
			System.out.println(test1.getClass());
			System.out.println(test.getClass() == test1.getClass());
			
			System.out.println(Integer.parseInt("ffff"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Entity{
	
	public String name;
	
	public Entity(String str) {
		this.name = str;
	}
	
	
	
}
