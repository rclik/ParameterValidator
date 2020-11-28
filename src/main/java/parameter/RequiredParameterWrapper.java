package parameter;

import parameter.validator.ParameterValidator;

import java.util.Map;

class RequiredParameterWrapper extends ParameterWrapper {
    private final String requiredParameterFailedMessage;

    RequiredParameterWrapper(String parameterValue,
                             String requiredParameterFailedMessage,
                             Map<ParameterValidator, String> validators) {
        super(parameterValue, validators);
        this.requiredParameterFailedMessage = requiredParameterFailedMessage;
    }

    @Override
    void validateParameter() {
        if (this.parameterValue == null) {
            throw new IllegalArgumentException(requiredParameterFailedMessage);
        }

        applyValidators();
    }

    @Override
    String getValidParameterValue() {
        return this.parameterValue.trim();
    }
}
