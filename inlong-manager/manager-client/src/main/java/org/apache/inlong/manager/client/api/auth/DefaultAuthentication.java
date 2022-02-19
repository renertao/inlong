/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.manager.client.api.auth;

import java.util.Map;
import lombok.Getter;
import org.apache.inlong.manager.client.api.util.AssertUtil;

public class DefaultAuthentication implements Authentication {

    public static final String USER_NAME = "user_name";

    public static final String PASSWORD = "password";

    @Getter
    private String userName;

    @Getter
    private String password;

    public DefaultAuthentication(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public AuthType getAuthType() {
        return AuthType.UNAME_PASSWD;
    }

    @Override
    public void configure(Map<String, String> properties) {
        AssertUtil.notEmpty(properties, "Properties should not be empty when init DefaultAuthentification");
        this.userName = properties.get(USER_NAME);
        this.password = properties.get(PASSWORD);
    }
}