package sortpom.parameter;

import sortpom.exception.FailureException;

import java.util.Arrays;

public enum VerifyFailOnType {
    XMLELEMENTS, LINES, STRICT;

    static VerifyFailOnType fromString(String verifyFailOn) {
        if (verifyFailOn == null) {
            throw new FailureException("verifyFailOn must be either xmlElements, lines or strict. Was: null");
        }
        return Arrays.stream(VerifyFailOnType.values())
                .filter(e -> e.toString().equalsIgnoreCase(verifyFailOn))
                .findAny()
                .orElseThrow(() -> new FailureException("verifyFailOn must be either xmlElements, lines or strict. Was: " + verifyFailOn));
    }
}