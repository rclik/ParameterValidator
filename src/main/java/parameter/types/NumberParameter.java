package parameter.types;

public class NumberParameter extends ParameterValueWrapper<Integer> implements MaxValidatorApplicable {
    NumberParameter(Integer value) {
        super(value);
    }

    @Override
    public int getParameterSize() {
        return this.value;
    }
}
