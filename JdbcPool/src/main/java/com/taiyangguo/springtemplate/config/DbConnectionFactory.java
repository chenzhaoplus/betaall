package com.taiyangguo.springtemplate.config;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbConnectionFactory implements PooledObjectFactory<PrestoJdbc> {

    @Autowired
    private PrestoJdbcProperties prop;

    @Override
    public PooledObject<PrestoJdbc> makeObject() throws Exception {
        return new DefaultPooledObject<>(new PrestoJdbc(prop));
    }

    @Override
    public void destroyObject(PooledObject<PrestoJdbc> p) throws Exception {
        p.getObject().setActive(false);
    }

    @Override
    public boolean validateObject(PooledObject<PrestoJdbc> p) {
        return p.getObject().getActive();
    }

    @Override
    public void activateObject(PooledObject<PrestoJdbc> p) throws Exception {
        p.getObject().setActive(true);
    }

    @Override
    public void passivateObject(PooledObject<PrestoJdbc> p) throws Exception {
        p.getObject().setActive(false);
    }
}
