package io.pivotal.bookshop.function;

import java.math.BigDecimal;
import java.util.List;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.client.PoolManager;
import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;

public class FunctionExecutor {

    // TODO-05: Inspect the signature of this method
    public static BigDecimal callSumFunction(Region region, String fieldName) {
        // TODO-06: execute the function using the supplied 'fieldName' for the field and the supplied region to execute the function on
        Pool pool = PoolManager.find("DEFAULT");
        Execution execution = FunctionService.onServers(pool);

        execution.withCollector(new SummingResultCollector());
        execution.setArguments(fieldName);
        
        ResultCollector resultCollector = execution.execute("GenericSumFunction");
        List result = (List) resultCollector.getResult();


        // TODO-07: Get result and assert that the two orders total $93.95

        BigDecimal finalResult = (BigDecimal) result.get(0);
        return finalResult;

    }
}
