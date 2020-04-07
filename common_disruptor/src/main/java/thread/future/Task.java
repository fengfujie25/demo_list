package thread.future;

@FunctionalInterface
public interface Task<In, Out> {


    Out get(In input);
}
