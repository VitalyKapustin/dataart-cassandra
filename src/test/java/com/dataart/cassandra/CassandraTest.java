package com.dataart.cassandra;

import com.dataart.cassandra.configuration.AppConfig;
import com.dataart.cassandra.configuration.CassandraConfig;
import com.dataart.cassandra.entity.User;
import com.dataart.cassandra.repository.UserRepository;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.WriteOptions;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vkapustin on 15.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, CassandraConfig.class})
public class CassandraTest {

    @Autowired
    private CassandraOperations cassandraOperations;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() {
        String cql = "select * from users";
        List<User> users = cassandraOperations.select(cql, User.class);
    }

    @Test
    public void test2() {
        String cql = "select * from users where lname = 'smith'";
        List<User> users = cassandraOperations.select(cql, User.class);
        WriteOptions writeOptions = new WriteOptions();
//        writeOptions.setConsistencyLevel();
    }

    @Test
    public void test3() {
        List<User> users = Lists.newArrayList(userRepository.findAll());
    }
}
