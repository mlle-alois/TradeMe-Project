package kernel;


import kernel.exception.NoSuchEntityException;

public interface Repository<VOID, E> {
    VOID nextIdentity();

    E findById(VOID id) throws NoSuchEntityException;

    void add(E entity);

    void delete(VOID id);
}
