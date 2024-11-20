package com.app.myapp.model.payloads;

import jakarta.validation.Payload;

public class Severity {
    public interface Info extends Payload {
    }

    public interface Warning extends Payload {
    }

    public interface Error extends Payload {

    }
}
