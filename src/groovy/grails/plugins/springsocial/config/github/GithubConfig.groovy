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
package grails.plugins.springsocial.config.twitter

import grails.plugins.springsocial.twitter.SpringSocialGitHubUtils
import javax.inject.Inject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.social.connect.ConnectionFactoryLocator
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.support.ConnectionFactoryRegistry
import org.springframework.social.github.api.GitHub
import org.springframework.social.github.api.impl.GitHubTemplate
import org.springframework.social.github.connect.GitHubConnectionFactory

@Configuration
class GitHubConfig {
    @Inject
    ConnectionFactoryLocator connectionFactoryLocator
    @Inject
    ConnectionRepository connectionRepository

    @Bean
    String fooGitHub() {
        println "Configuring SpringSocial GitHub"
        def gitHubConfig = SpringSocialGitHubUtils.config.github
        def consumerKey = gitHubConfig.consumerKey
        def consumerSecret = gitHubConfig.consumerSecret
        ((ConnectionFactoryRegistry) connectionFactoryLocator).addConnectionFactory(new GitHubConnectionFactory(consumerKey, consumerSecret))
        "github"
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public GitHub gitHub() {
        def gitHub = connectionRepository.findPrimaryConnection(GitHub)
        gitHub != null ? gitHub.getApi() : new GitHubTemplate()
    }
}
