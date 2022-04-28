package lt.codeacademy.generic;

public class GenericBox<E> {
    private E e;

    public E getObject() {
        return e;
    }

    public void setObject(E e) {
        this.e = e;
    }
}
