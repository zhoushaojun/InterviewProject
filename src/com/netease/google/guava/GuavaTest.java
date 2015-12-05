package com.netease.google.guava;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Table;
import com.google.common.collect.TreeMultimap;
import com.google.common.primitives.Ints;
public class GuavaTest {
    private static List<String> storeRoles = ImmutableList.of("AOrPa279");

    @SuppressWarnings("deprecation")
    public static void test() throws Exception {

        // [1]
        Objects.toStringHelper(GuavaTest.class);
        Objects.equal("a", "a");
        // [2]
        // Throwables.getStackTraceAsString(null);

        // [3]
        ArrayList<String> listFirst = new ArrayList<String>();
        ArrayList<String> listSecond = new ArrayList<String>();
        listFirst.add("a");
        listSecond.add("b");
        Iterable<String> rStrings = Iterables.concat(listFirst, listSecond);

        // [4]
        // String string = Preconditions.checkNotNull(null, "must not null");
        // Preconditions.checkArgument(listFirst.size()>2,"must > 2");

        // [5]
        java.util.List<String> conList = Constraints.constrainedList(new ArrayList<String>(), new Constraint<String>() {

            @Override
            public String checkElement(String paramE) {
                Preconditions.checkArgument(2 > 0, "zhousahojun");
                return paramE;
            }

        });
        conList.add("d");

        // [6]
        ArrayList<Entity> imumuList = new ArrayList<Entity>();
        imumuList.add(new Entity("zhou"));
        List<String> googleImmu = ImmutableList.of("ad");
        List<String> optionIds = ImmutableList.copyOf(new String[] {"a", "b"});
        List<Entity> optionIds5 = ImmutableList.copyOf(imumuList);
        Entity entity = optionIds5.iterator().next();
        System.out.println(entity.name);
        entity.name = "lengjing";
        System.out.println(optionIds5.iterator().next().name);

        // [7]
        Lists.newArrayList();
        Lists.newLinkedList();
        Sets.newHashSet();
        Sets.newTreeSet();
        Maps.newHashMap();
        Maps.newLinkedHashMap();
        Maps.newTreeMap();
        Maps.newConcurrentMap();


    }

    public static void optioalTest() {
        GuavaTest test = new GuavaTest();
        Optional<Integer> possible = Optional.of(6);
        Optional<Integer> absentOpt = Optional.absent();
        Optional<GuavaTest> NullableOpt = Optional.fromNullable(test);
        Optional<Integer> NoNullableOpt = Optional.fromNullable(10);
        if (possible.isPresent()) {
            System.out.println("possible isPresent:" + possible.isPresent());
            System.out.println("possible value:" + possible.get());
        }
        if (absentOpt.isPresent()) {
            System.out.println("absentOpt isPresent:" + absentOpt.isPresent());;
        }
        if (NullableOpt.isPresent()) {
            System.out.println("fromNullableOpt isPresent:" + NullableOpt.isPresent());;
        }
        if (NoNullableOpt.isPresent()) {
            System.out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent());;
        }
    }

    public static void teststuScoreMultimap() {
        Multimap<String,StudentScore> scoreMultimap = ArrayListMultimap.create(); 
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("peida",studentScore);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
        
        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        StudentScore studentScore1=new StudentScore();
        studentScore1.CourseId=1034;
        studentScore1.score=67;
        studentScore.add(studentScore1);
        
        StudentScore studentScore2=new StudentScore();
        studentScore2.CourseId=1045;
        studentScore2.score=56;
        scoreMultimap.put("jerry",studentScore2);
        
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
        
        
        for(StudentScore stuScore : scoreMultimap.values()) {
            System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
        }
        
        scoreMultimap.remove("jerry",studentScore2); 
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("jerry"));
        
        scoreMultimap.put("harry",studentScore2);
        scoreMultimap.removeAll("harry");
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("harry"));
    }
    
    public static void setListMulitMapTest(){
        HashMultimap treeMultimap = HashMultimap.create();
        treeMultimap.put("wyp", "hao");
        treeMultimap.put("wyp", "hao");
        treeMultimap.put("wyp1", "hao");
        Set<Map.Entry> entries1 = treeMultimap.entries();
        System.out.println(entries1);
          
        ArrayListMultimap<String, String> arrayListMultimap =
            ArrayListMultimap.create();
        arrayListMultimap.put("wyp", "hao");
        arrayListMultimap.put("wyp", "hao");
        arrayListMultimap.put("wyp1", "hao");
        Collection<Map.Entry<String, String>> entries = arrayListMultimap.entries();
        System.out.println(entries);

    }
  
    
    public static void treeMuliOrdering(){
        TreeMultimap<Integer, ObjectTest> treeMultimap = TreeMultimap.create(Ordering.natural().reverse(), Ordering.from(new Comparator<ObjectTest>() {

            @Override
            public int compare(ObjectTest o1, ObjectTest o2) {
                return o2.age - o1.age;
            }
            
        }));
        treeMultimap.put(101, new ObjectTest(12));
        treeMultimap.put(101,new ObjectTest(14));
        treeMultimap.put(101,new ObjectTest(12));
        treeMultimap.put(109, new ObjectTest(15));
        treeMultimap.put(104, new ObjectTest(16));
        System.out.println(treeMultimap.size());
        System.err.println(treeMultimap.values().toString());
        Multiset<Integer> keys = treeMultimap.keys();
        for (Integer integer : keys.elementSet()) {
            System.out.println(integer);
        }

        
        System.out.println("==========");
        System.out.println(treeMultimap.keySet().size());
        NavigableMap<Integer, Collection<ObjectTest>> map = treeMultimap.asMap();
        for (Entry<Integer, Collection<ObjectTest>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (ObjectTest str : entry.getValue()) {
                System.out.println(str.age);
            }
            System.out.println("------------");
        }
    }
    public static void treeMuliMap(){
        TreeMultimap<Integer, String> treeMultimap = TreeMultimap.create(Ordering.natural().reverse(), Ordering.natural());
        treeMultimap.put(101, "wang5@163.com");
        treeMultimap.put(101, "wang2@163.com");
        treeMultimap.put(109, "wang3@163.com");
        treeMultimap.put(104, "wang@163.com");
        System.out.println(treeMultimap.size());
        System.err.println(treeMultimap.values().toString());
        Multiset<Integer> keys = treeMultimap.keys();
        for (Integer integer : keys.elementSet()) {
            System.out.println(integer);
        }
        NavigableSet<String> datSet = treeMultimap.get(101);
        System.out.println(datSet.toString());
        
        System.out.println("==========");
        System.out.println(treeMultimap.keySet().size());
        NavigableMap<Integer, Collection<String>> map = treeMultimap.asMap();
        for (Entry<Integer, Collection<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (String str : entry.getValue()) {
                System.out.println(str);
            }
            System.out.println("------------");
        }
    }
    
    public static void tableTest(){
        Table<String, Integer, String> aTable = HashBasedTable.create();  
        
        for (char a = 'A'; a <= 'C'; ++a) {  
            for (Integer b = 1; b <= 3; ++b) {   
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));  
            }  
        }  
   
        System.out.println(aTable.column(2));  
        System.out.println(aTable.row("B"));   
        System.out.println(aTable.get("B", 2));  

        System.out.println(aTable.contains("D", 1));   
        System.out.println(aTable.containsColumn(3));   
        System.out.println(aTable.containsRow("C"));  
        System.out.println(aTable.columnMap()); 
        System.out.println(aTable.rowMap());   

        System.out.println(aTable.remove("B", 3)); 
    }

    public void TestLoadingCache() throws Exception{
        LoadingCache<String,String> cahceBuilder=CacheBuilder
        .newBuilder()
        .build(new CacheLoader<String, String>(){
            @Override
            public String load(String key) throws Exception {        
                String strProValue="hello "+key+"!";                
                return strProValue;
            }
            
        });        
        System.out.println("jerry value:"+cahceBuilder.apply("jerry"));
        System.out.println("jerry value:"+cahceBuilder.get("jerry"));
        System.out.println("peida value:"+cahceBuilder.get("peida"));
        System.out.println("peida value:"+cahceBuilder.apply("peida"));
        System.out.println("lisa value:"+cahceBuilder.apply("lisa"));
        cahceBuilder.put("harry", "ssdded");
        System.out.println("harry value:"+cahceBuilder.get("harry"));
    }
    
    public static int[] toArray(List<? extends Number> collection) {
        ImmutableMap.of("1", "2");
        return null;
    }

    public static void main(String[] args) {
        // try {
        // test();
        // GuavaTest test = new GuavaTest();
        // GuavaTest test1 = new GuavaTest();
        // System.out.println(test.getClass());
        // System.out.println(test1.getClass());
        // System.out.println(test.getClass() == test1.getClass());
        //
        // System.out.println(Integer.parseInt("ffff"));
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
//        optioalTest();
//        ArrayList<String> str = new ArrayList<String>();
//
//        ArrayList<Float> num = new ArrayList<Float>();
//        toArray(num);
        
        //tableTest();
        treeMuliOrdering();
    }
}
class entity{
    int age;
    public entity(int age) {
        this.age =age;
    }
}

class My extends Ordering<entity>{

    public My() {
        // TODO Auto-generated constructor stub
    }
    public int compare(entity arg0, entity arg1) {
        return arg0.age - arg1.age;
    }
    
}
class Entity {

    public String name;

    public Entity(String str) {
        this.name = str;
    }
}
class StudentScore {
    int CourseId;
    int score;
}
