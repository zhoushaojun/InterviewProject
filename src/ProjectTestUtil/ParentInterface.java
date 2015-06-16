package ProjectTestUtil;

public interface ParentInterface<T extends FanInterface> {

	public String myName(T t);
}
