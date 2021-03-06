/*
 * Copyright 2018 Paul Howes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package demo;

import demo.QueueServiceLoader;
import demo.spi.QueueServiceProvider;

public class App {
    public static void main(String[] args) {
        // Parse the optional implementation name from the command line.
        String name = null;

        if (args.length > 0) {
            name = args[0];
        }

        // Retrive a Queue implementation.
        QueueServiceProvider provider;

        if (name == null) {
            provider = QueueServiceLoader.load();
        }
        else {
            provider = QueueServiceLoader.loadByName(name);
        }

        // Output what was found.
        if (provider == null) {
            System.out.println("No queue implementation found");
        }
        else {
            System.out.printf("Found queue implementation %s\n", provider.name());
        }
    }
}
