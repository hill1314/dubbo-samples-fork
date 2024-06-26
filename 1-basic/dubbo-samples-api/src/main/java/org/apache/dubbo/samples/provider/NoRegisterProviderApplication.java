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

package org.apache.dubbo.samples.provider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.bootstrap.builders.ApplicationBuilder;
import org.apache.dubbo.config.bootstrap.builders.ProtocolBuilder;
import org.apache.dubbo.config.bootstrap.builders.ServiceBuilder;
import org.apache.dubbo.samples.api.GreetingsService;

/**
 * 提供者应用程序
 *
 * @author huleilei9
 * @date 2024/05/15
 */
public class NoRegisterProviderApplication {

    public static void main(String[] args) {

        //应用配置
        ApplicationConfig applicationConfig = ApplicationBuilder.newBuilder()
                .name("dubbo-samples-api")
                .logger("slf4j").build();

        //协议配置
        ProtocolConfig protocolConfig = ProtocolBuilder.newBuilder()
                .name("tri")
                .port(50052)
                .build();

        //服务配置
        ServiceConfig<Object> serviceConfig = ServiceBuilder.newBuilder()
                .interfaceClass(GreetingsService.class)
                .ref(new GreetingsServiceImpl())
                .build();

        //启动应用
        DubboBootstrap.getInstance()
                .application(applicationConfig)
                .protocol(protocolConfig)
                .service(serviceConfig)
                .start()
                .await();
    }
}
