/* Copyright 2011 the original author or authors.
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

grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()
        
        mavenRepo "http://maven.springframework.org/release"
        mavenRepo "http://maven.springframework.org/snapshot"
        mavenRepo "http://maven.springframework.org/milestone"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        //compile("org.springframework.social:spring-social-github:${springSocialVersion}") { transitive = false }
      def springSocialVersion = "1.0.0.RELEASE"

      compile("org.springframework.social:spring-social-core:${springSocialVersion}") { transitive = false }
      compile("org.springframework.social:spring-social-web:${springSocialVersion}") { transitive = false }

      compile("org.springframework.security:spring-security-crypto:3.1.0.RC3") { transitive = false }
      compile("javax.inject:javax.inject:1")
      compile 'org.codehaus.jackson:jackson-mapper-asl:1.8.5'
    }
    plugins {
        compile(":spring-social-core:0.1.29")
    }
}
