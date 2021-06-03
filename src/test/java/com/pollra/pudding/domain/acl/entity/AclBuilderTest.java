package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.role.entity.Role;
import com.pollra.pudding.domain.role.entity.RoleFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AclBuilderTest {


    @Test
    public void test(){
        AclBuilder aclBuilder = new AclBuilder(RoleFactory.guestRole());
        Arrays.asList(
        )
    }
}