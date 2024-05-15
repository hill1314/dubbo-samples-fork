/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.samples.client;

import java.io.IOException;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.bootstrap.builders.ReferenceBuilder;
import org.apache.dubbo.samples.api.GreetingsService;

/**
 * 客户端应用程序
 *
 * @author huleilei9
 * @date 2024/05/15
 */
public class ClientApplication {

    public static void main(String[] args) throws IOException {

        //客户端配置
        ReferenceConfig<GreetingsService> reference =
                ReferenceBuilder.<GreetingsService>newBuilder()
                .interfaceClass(GreetingsService.class)
                .url("tri://localhost:50052")
                .build();

        //启动客户端
        DubboBootstrap.getInstance().reference(reference).start();

        //获取客户端调用实例
        GreetingsService service = reference.get();

        //服务调用
        String message = service.sayHi("dubbo");
        System.out.println("Receive result ======> " + message);


        System.in.read();
        System.exit(0);
    }

}
