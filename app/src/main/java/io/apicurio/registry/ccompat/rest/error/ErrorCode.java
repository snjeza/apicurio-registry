/*
 * Copyright 2021 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.registry.ccompat.rest.error;

public enum ErrorCode {

    SUBJECT_NOT_FOUND(40401), VERSION_NOT_FOUND(40402), SCHEMA_NOT_FOUND(40403), SUBJECT_SOFT_DELETED(40404), SUBJECT_NOT_SOFT_DELETED(40405), SCHEMA_VERSION_SOFT_DELETED(40406), SCHEMA_VERSION_NOT_SOFT_DELETED(40407), SUBJECT_COMPATIBILITY_NOT_CONFIGURED(40408), INVALID_SCHEMA(42201), INVALID_VERSION(42202), INVALID_COMPATIBILITY_LEVEL(42203), OPERATION_NOT_PERMITTED(42205), REFERENCE_EXISTS(42206), INVALID_SUBJECT(42208), SERVER_ERROR(50001), OPERATION_TIMEOUT(50002), FORWARDING_ERROR(50003);

    private final int value;

    private ErrorCode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
