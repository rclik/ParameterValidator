package parameter.types;

public abstract class ParameterValueWrapper<T> {
    protected final T value;

    ParameterValueWrapper(final T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }
}
