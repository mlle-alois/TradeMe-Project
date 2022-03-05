package general.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
