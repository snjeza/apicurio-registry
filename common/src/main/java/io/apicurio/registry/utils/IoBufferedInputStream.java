/*
 * Copyright 2020 Red Hat
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

package io.apicurio.registry.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.BiConsumer;

/**
 * @author Ales Justin
 */
// TODO This does not work with com.fasterxml.jackson.databind.ObjectMapper.readTree(java.io.InputStream)
// because count = 0 at the end, even if there is valid data in buf. This causes the content handle to become empty.
// Needs more investigation, but io.apicurio.registry.content.StreamContentHandle.bytes() can be called as a workaround.
// I suspect it's caused by Jackson manipulating the stream in unusual ways (reset?).
public class IoBufferedInputStream extends BufferedInputStream {
    private final BiConsumer<byte[], Integer> onClose;

    public IoBufferedInputStream(InputStream in, BiConsumer<byte[], Integer> onClose) {
        super(in);
        this.onClose = onClose;
    }

    @Override
    public void close() throws IOException {
        onClose.accept(buf, count);
        super.close();
    }


}
