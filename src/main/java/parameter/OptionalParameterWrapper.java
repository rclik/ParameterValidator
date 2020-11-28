package parameter;

import parameter.validator.ParameterValidator;

import java.util.Map;

class OptionalParameterWrapper extends ParameterWrapper {
    public OptionalParameterWrapper(String parameterValue, Map<ParameterValidator, String> validators) {
        super(parameterValue, validators);
    }

    @Override
    void validateParameter() {
        if (this.parameterValue != null) {
            applyValidators();
        }
    }

    @Override
    String getValidParameterValue() {
        if (this.parameterValue == null) {
            return null;
        }

        return this.parameterValue.trim();
    }
}
