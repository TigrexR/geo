package com.tigrex.geo.task.callback;

import com.tigrex.geo.entity.bo.UserBO;
import com.tigrex.geo.entity.query.UserQuery;
import com.tigrex.geo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.stereotype.Component;

/**
 * @author linus
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserRetryCallback implements RetryCallback<String, Exception> {

    private UserQuery query;
    @Autowired
    private IUserService service;

    public UserRetryCallback setQuery(UserQuery query) {
        this.query = query;
        return this;
    }

    @Override
    public String doWithRetry(RetryContext retryContext) {
        UserBO user = service.getUser(query);
        System.out.println(Thread.currentThread().getName() + ":" + this.hashCode() + user.getCode());
        return user.getName();
    }
}
