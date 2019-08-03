package io.pivotal.bookshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication.Locator;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.gemfire.transaction.config.EnableGemfireCacheTransactions;

import javax.transaction.Transactional;

@ClientCacheApplication(name = "GemFire Client", logLevel = "warn", locators = {
        @Locator(host = "localhost", port = 10334)
})
@EnablePdx
@ComponentScan(basePackages = "io.pivotal.bookshop.services")
@EnableGemfireRepositories(basePackages = "io.pivotal.bookshop.repositories")
@EnableEntityDefinedRegions(basePackages = "io.pivotal.bookshop.domain")
// TODO-12: Enable GemFire Repositories by scanning the repositories package

// TODO-13: Cause regions to be defined based on domain classes found in the domain package

// TODO-23: Add a configuration item to enable GemFire transactions to work with the Spring @Transacitonal annnotaiton

public class GemFireRepositoryConfig {


}
