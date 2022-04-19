package com.tigrex.geo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author linus
 */
public abstract class BaseRetryTask<Q> implements Runnable {

    protected Q query;
    @Autowired
    protected RetryTemplate retryTemplate;

    /**
     * set query
     * @param query query
     * @return
     */
    abstract BaseRetryTask<Q> setQuery(Q query);
}
