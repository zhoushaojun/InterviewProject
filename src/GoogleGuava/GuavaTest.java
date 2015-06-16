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
		
	}
	public static void main(String[] args) {
		try {
			test();	
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
