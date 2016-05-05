/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.adorkable.acientdict.apis;

import android.os.Environment;

/**
 * Author:  liuqiang
 * Date:    2015/3/9.
 * Description:
 */
public class ApiConstants {

    public final static String SCHEME_HTTPS = "http://";
    public static final String HOST_NAME = "127.0.0.1";
    public final static String DOMAIN_NAME = SCHEME_HTTPS + HOST_NAME;

    public static final class Urls {

        public static final String DICT_INIT = DOMAIN_NAME + "/dictInit";
    }

}