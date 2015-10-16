package com.dataart.cassandra.repository;

import com.dataart.cassandra.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

/**
 * Created by vkapustin on 15.10.2015.
 */
public interface UserRepository extends CassandraRepository<User> {
}
