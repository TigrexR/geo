package com.tigrex.geo.task;

import com.tigrex.geo.entity.query.UserQuery;
import com.tigrex.geo.factory.GeoContext;
import com.tigrex.geo.task.callback.UserRetryCallback;
import lombok.SneakyThrows;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * @author linus
 */
@Component(value = "userRetryTask")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserRetryTask extends BaseRetryTask<UserQuery> {

    @Override
    public UserRetryTask setQuery(UserQuery query) {
        this.query = query;
        return this;
    }

    @Override
    @SneakyThrows(Exception.class)
    public void run() {
        retryTemplate.execute(GeoContext.getContext().getBean(UserRetryCallback.class).setQuery(query));
    }
}
